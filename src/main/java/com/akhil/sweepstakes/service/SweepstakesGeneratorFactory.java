package com.akhil.sweepstakes.service;

public class SweepstakesGeneratorFactory {

    public static SweepstakesGenerator getSweepstakesGenerator() {
        return new SweepstakesGeneratorImpl(1, 39, 8);
    }
}
