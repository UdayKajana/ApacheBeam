package com.example;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.coders.StringUtf8Coder;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.Distinct;
import org.apache.beam.sdk.transforms.ParDo;

import java.util.List;
import java.util.Arrays;

public class DistinctExample {
    public void distinctWords(Pipeline pipeline) {
        String[] WORDS_ARRAY = new String[] { "hi", "hi", "sue", "sue", "bob" };
        List<String> WORDS = Arrays.asList(WORDS_ARRAY);

        pipeline.apply(Create.of(WORDS)).setCoder(StringUtf8Coder.of())
                .apply(Distinct.create())
                .apply("Distinct words :", ParDo.of(new PrintElement<String>()));
    }

    public void distinctIntegers(Pipeline pipeline) {
        pipeline.apply(Create.of(1, 1, 2, 2, 3, 4, 4, 5, 5))
                .apply(Distinct.create())
                .apply("Printing...", ParDo.of(new PrintElement<Integer>()));
    }
}
