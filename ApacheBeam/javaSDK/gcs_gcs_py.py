import apache_beam as beam
from apache_beam.options.pipeline_options import PipelineOptions
import json
from apache_beam.io.gcp import gcsio

class ParseJSON(beam.DoFn):
    def process(self, element):
        json_data = json.loads(element)
        return [json_data]

class TransformData(beam.DoFn):
    def process(self, element):
        # Example transformations - modify as needed
        transformed = {
            'id': str(element.get('id', '')),
            'name': element.get('name', '').upper(),
            'date': element.get('date', ''),
            'value': float(element.get('value', 0))
        }
        return [transformed]

def run_pipeline():
    pipeline_options = PipelineOptions(
        runner='DataflowRunner',
        project='your-project-id',
        job_name='json-to-csv-job',
        temp_location='gs://your-bucket/temp',
        region='your-region'
    )

    with beam.Pipeline(options=pipeline_options) as pipeline:
        # Step 1: Load JSON file
        json_data = (pipeline 
            | 'Read JSON' >> beam.io.ReadFromText('gs://your-bucket/input/data.json'))

        # Step 2: Extract Data
        parsed_data = (json_data 
            | 'Parse JSON' >> beam.ParDo(ParseJSON()))

        # Step 3: Transform Data
        transformed_data = (parsed_data 
            | 'Transform Data' >> beam.ParDo(TransformData()))

        # Step 4: Save as CSV
        (transformed_data 
            | 'Dict To CSV' >> beam.Map(lambda x: ','.join([str(x[k]) for k in sorted(x.keys())]))
            | 'Write CSV' >> beam.io.WriteToText(
                'gs://your-bucket/output/result',
                file_name_suffix='.csv',
                header=','.join(['id', 'name', 'date', 'value'])
            ))

if __name__ == '__main__':
    run_pipeline()
