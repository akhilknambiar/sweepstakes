package com.akhil.sweepstakes.service;

import java.util.List;
import java.util.Set;

public interface SweepstakesGenerator {

    void generate();

    void fetchList();

    List<Integer> verify(Set<Integer> numbers);

}
