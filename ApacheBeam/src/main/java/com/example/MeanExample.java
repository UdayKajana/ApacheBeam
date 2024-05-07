package com.example;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.Mean;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;

public class MeanExample {
    public void execute(Pipeline pipeline){
        PCollection<Double> pc = pipeline.apply(Create.of(1.0, 2.0, 3.0, 4.0, 5.0));
        PCollection<Double> mean = pc.apply(Mean.globally());
        mean.apply(ParDo.of(new PrintElement<Double>()));
    }
    
}
