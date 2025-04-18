package com.example;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.Combine;
import org.apache.beam.sdk.transforms.MapElements;

public class CombinersExample {
    public void execute(Pipeline pipeline, String filePath) {
        pipeline.apply(TextIO.read().from(filePath))
                .apply("Converting to Integer :", MapElements.via(new ConvertToInteger()))
                .apply("Calculate sum :", Combine.globally(new ComputeSum()))
                .apply("Printing Element :", ParDo.of(new PrintElement<Integer>()));
    }

}

