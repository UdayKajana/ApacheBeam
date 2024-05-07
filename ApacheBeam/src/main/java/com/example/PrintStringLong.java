package com.example;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.transforms.DoFn;

public class PrintStringLong extends DoFn<KV<String, Long>, Void> {
    @ProcessElement
    public void processElement(@Element KV<String, Long> element) {
        String key = element.getKey();
        Long count = element.getValue();
        System.out.println("Key: " + key + ", Count: " + count);
    }
}
