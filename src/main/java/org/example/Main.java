package org.example;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Hello world!");

        ExtractMethodExtractor extractMethodExtractor = new ExtractMethodExtractor(
                "https://github.com/danilofes/refactoring-toy-example.git");
        extractMethodExtractor.identifyRefactoringInstances().generateSamples();

    }
}