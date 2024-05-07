package com.example;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.Latest;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.WithTimestamps;
import org.apache.beam.sdk.values.PCollection;
import org.joda.time.Duration;
import org.joda.time.Instant;

public class LatestExample {
    public void execute(Pipeline pipeline) {
        Instant baseInstant = Instant.now().minus(Duration.standardSeconds(10));
        PCollection<Integer> numbers = pipeline.apply(Create.of(5, 4, 3, 2, 1));

        // Add Timestamps for elements based on elements values. Largest element will be
        // the latest.
        PCollection<Integer> withTimestamps = numbers.apply(
                WithTimestamps.of(duration -> baseInstant.plus(Duration.standardSeconds(duration))));

        // Get the latest element from collection without timestamps. It will vary from
        // run to run
        PCollection<Integer> latest = numbers.apply(Latest.globally());

        // Get the latest element from collection with timestamps. Should always be 5
        PCollection<Integer> latestTimestamped = withTimestamps.apply(Latest.globally());
        // [END main_section]
        latest.apply(ParDo.of(new PrintElement<Integer>()));
        latestTimestamped.apply( ParDo.of(new PrintElement<Integer>()));
    }
}
