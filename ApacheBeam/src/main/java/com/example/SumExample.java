package com.example;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.Sum;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
public class SumExample {
    public void execute(Pipeline pipeline){
        PCollection<Double> pc = pipeline.apply(Create.of(1.0, 2.0, 3.0, 4.0, 5.0));
        PCollection<Double> sum = pc.apply(Sum.doublesGlobally());
        sum.apply(ParDo.of(new PrintElement<Double>()));
    }
}
