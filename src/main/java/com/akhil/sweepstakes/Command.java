package com.akhil.sweepstakes;

import java.util.HashSet;
import java.util.Set;

import com.akhil.sweepstakes.service.SweepstakesGenerator;
import com.akhil.sweepstakes.service.SweepstakesGeneratorFactory;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class Command {

    @ShellMethod(value = "Generate Sweepstakes", key = "generate")
    public void generateSweepstakes() {

        System.out.println("Generating Sweepstakes");

        SweepstakesGenerator sweepstakesGenerator = SweepstakesGeneratorFactory.getSweepstakesGenerator();
        sweepstakesGenerator.generate();

        System.out.println("\nGeneration completed");
    }

    @ShellMethod(value = "Fetch Generated Sweepstakes", key = "fetch")
    public void fetchGeneratedSweepstakes() {

        System.out.println("Fetching Sweepstakes");

        SweepstakesGenerator sweepstakesGenerator = SweepstakesGeneratorFactory.getSweepstakesGenerator();
        sweepstakesGenerator.fetchList();

    }

    @ShellMethod(value = "Validate Sweepstakes", key = "validate")
    public void validateSweepstakes(@ShellOption(arity = 8) int[] numbers) {

        System.out.println("Matching Numbers");

        Set<Integer> luckySet = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            luckySet.add(numbers[i]);
        }
        if (luckySet.size() < 8) {
            System.out.println("Please enter unique numbers");
            return;
        }

        SweepstakesGenerator sweepstakesGenerator = SweepstakesGeneratorFactory.getSweepstakesGenerator();
        sweepstakesGenerator.verify(luckySet).forEach(System.out::println);
        System.out.println();
    }
}
