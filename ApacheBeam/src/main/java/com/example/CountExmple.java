package com.example;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.transforms.Count;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.ParDo;

public class CountExmple {

    public void executeGlobally(Pipeline pipeline) {
        pipeline.apply(Create.of(1.0, 2.0, 3.0, 4.0, 5.0))
                .apply(Count.globally())
                .apply(ParDo.of(new PrintElement<Long>()));
    }

    public void executePerKey(Pipeline pipeline) {
        pipeline.apply(Create.of(
                KV.of("a", 1),
                KV.of("a", 2),
                KV.of("b", 3),
                KV.of("b", 4),
                KV.of("b", 5)))
                .apply(Count.perKey())
                .apply("Count per Key :", ParDo.of(new PrintStringLong()));
    }

}