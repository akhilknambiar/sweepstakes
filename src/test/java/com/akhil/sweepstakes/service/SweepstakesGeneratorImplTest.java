package com.akhil.sweepstakes.service;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class SweepstakesGeneratorImplTest {

    @Test
    public void verify() {

        SweepstakesGeneratorImpl sweepstakesGenerator = new SweepstakesGeneratorImpl(1, 39, 8);
        sweepstakesGenerator.generate();
        HashSet<Integer> fullSet = new HashSet<>();
        for (int i = 0; i <= 39; i++) {
            fullSet.add(i);
        }
        Assert.assertEquals(sweepstakesGenerator.verify(fullSet).size(), 8);

    }
}