package com.example;
import java.util.List;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.Top;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
public class TopExample {
    public void execute(Pipeline pipeline) {
        PCollection<Integer> input = pipeline.apply(Create.of(1, 2, 3, 4, 5, 6));
        PCollection<List<Integer>> result = input.apply(Top.largest(3));
        result.apply(ParDo.of(new PrintElement<List<Integer>>()));
    }
}
