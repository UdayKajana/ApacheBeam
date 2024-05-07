package com.example;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.io.TextIO;

public class MapExample {
    public void execute(Pipeline pipeline, String filePath) {
        pipeline.apply("Reading File : ", TextIO.read().from(filePath))
                .apply("Convering to String :", MapElements.via(new ConvertToInteger()))
                .apply("Sqaring :", MapElements.via(new SqaureElement()))
                .apply("printing :", ParDo.of(new PrintElement<Integer>()));
    }

    public void execute(Pipeline pipeline) {
    }
}
