package com.example;
import org.apache.beam.sdk.transforms.SimpleFunction;
public class SqaureElement extends SimpleFunction<Integer, Integer> {
    @Override
    public Integer apply(Integer element) {
        return element * element;
    }
}



