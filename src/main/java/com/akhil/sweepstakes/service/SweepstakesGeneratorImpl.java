package com.akhil.sweepstakes.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class SweepstakesGeneratorImpl implements SweepstakesGenerator {

    private static Set<Integer> sweepstakesResult = new HashSet<>();

    private int min;
    private int max;
    private int count;

    @Override
    public void generate() {
        sweepstakesResult.clear();
        while (sweepstakesResult.size() < count) {
            new Random().ints(min, max).findFirst().ifPresent(random -> {
                sweepstakesResult.add(random);
            });
        }
    }

    @Override
    public void fetchList() {
        sweepstakesResult.forEach(System.out::println);
    }

    @Override
    public List<Integer> verify(Set<Integer> numbers) {
        List<Integer> validNumbers = new ArrayList<>();
        numbers.forEach(
                number -> {
                    if (sweepstakesResult.contains(number))
                        validNumbers.add(number);
                }
        );
        return validNumbers;
    }

    SweepstakesGeneratorImpl(int min, int max, int count) {
        this.min = min;
        this.max = max;
        this.count = count;
    }
}