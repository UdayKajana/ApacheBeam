package com.example;
import org.apache.beam.sdk.Pipeline;

public class Administrator {
    public static void main(String[] args) throws Exception {
        Pipeline pipeline = Pipeline.create();
        //new MapExample().execute(pipeline, "/workspace/practice/apache_beam/ApacheBeam/src/resources/input_map.txt");
        //new CombinersExample().execute(pipeline,  "/workspace/practice/apache_beam/ApacheBeam/src/resources/input_map.txt");
        //new CountExmple().executeGlobally(pipeline);
        //new CountExmple().executePerKey(pipeline);
        //new DistinctExample().distinctWords(pipeline);
        //new DistinctExample().distinctIntegers(pipeline);
        //new LatestExample().execute(pipeline);
        //new MaxExample().execute(pipeline);
        //new MeanExample().execute(pipeline);
        //new MinExample().execute(pipeline);
        //new SumExample().execute(pipeline);
        //new TopExample().execute(pipeline);
        pipeline.run().waitUntilFinish();
    }
}