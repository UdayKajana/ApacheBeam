package com.example;

import org.apache.beam.sdk.transforms.Combine;

public class ComputeSum extends Combine.CombineFn<Integer, Integer, Integer> {
    @Override
    public Integer createAccumulator() {
        return 0;
    }

    @Override
    public Integer addInput(Integer accumulator, Integer input) {
        return accumulator + input;  
    }

    @Override
    public Integer mergeAccumulators(Iterable<Integer> accumulators) {
        int sum = 0;
        for (int acc : accumulators) {
            sum += acc;
        }
        return sum;
    }

    @Override
    public Integer extractOutput(Integer accumulator) {
        return accumulator;
    }
}
