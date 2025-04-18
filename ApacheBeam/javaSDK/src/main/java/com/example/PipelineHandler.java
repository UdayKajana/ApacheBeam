package com.example;

import org.apache.beam.sdk.Pipeline;

public class PipelineHandler {
    public PipelineHandler() {
        pipeline = Pipeline.create();
        String message = pipeline+ " is created!";
        String formatedMessage = "*".repeat(message.length()+4) +"\n* "+message+ " *\n" +"*".repeat(message.length()+4);
        System.out.println(formatedMessage);
    }

    Pipeline pipeline = null;

    public Pipeline getPipeline() {
        return this.pipeline;
    }
}