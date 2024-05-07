package com.example;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.GroupByKey;
import org.apache.beam.sdk.values.KV;

public class CombinePerKeyExample {
    public void execute(Pipeline pipeline) {
        pipeline.apply(
                Create.of(
                        KV.of("a", "apple"),
                        KV.of("a", "avocado"),
                        KV.of("b", "banana"),
                        KV.of("c", "cherry")))
                .apply(GroupByKey.create());
                //.apply("printing...", ParDo.of(new PrintStringLong()))
    }
}
