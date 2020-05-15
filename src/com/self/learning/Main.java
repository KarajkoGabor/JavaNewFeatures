package com.self.learning;

import java.io.IOException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Java12Features java12Features = new Java12Features();
        Java14Features java14Features = new Java14Features();

        java12Features.mismatchFeatureDemo();

        IntStream.of(15,150,1500,15000,150000).forEach(java12Features::compactNumberFormatDemo);

        java12Features.teeingDemo();

        java12Features.stringMethodsDemos();

        Stream.of("Mon", "Sat", "nothing", "").forEach(java14Features::swtichDemo);

        Stream.of(ExampleEnums.ONE, ExampleEnums.SOME_OTHER_SOMETHING).forEach(java14Features::swtichExhaustiveDemo);

        java14Features.nPEMessageDemo();

        java14Features.recordDemo();

        java14Features.instanceOfDemo();

    }
}
