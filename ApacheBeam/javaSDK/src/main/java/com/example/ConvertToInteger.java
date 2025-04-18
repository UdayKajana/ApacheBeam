package com.example;
import org.apache.beam.sdk.transforms.SimpleFunction;
public class ConvertToInteger extends SimpleFunction<String, Integer> {
    @Override
    public Integer apply(String element) {
        return Integer.valueOf(element);
    }
}

