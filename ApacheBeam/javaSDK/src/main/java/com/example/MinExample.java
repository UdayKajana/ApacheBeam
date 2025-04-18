package com.example;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.Min;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
public class MinExample {
    public void execute(Pipeline pipeline) {
        PCollection<Double> pc = pipeline.apply(Create.of(1.0, 2.0, 3.0, 4.0, 5.0));
        PCollection<Double> min = pc.apply(Min.globally());
        min.apply(ParDo.of(new PrintElement<Double>()));
    }
}
