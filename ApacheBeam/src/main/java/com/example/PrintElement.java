package com.example;
import org.apache.beam.sdk.transforms.DoFn;
public class PrintElement<T> extends DoFn<T, Void> {
    @DoFn.ProcessElement
    public void processElement(@DoFn.Element T element) {
        System.out.println(element);
    }
}

