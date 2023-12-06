package org.example;

public class Main {
    public static void main(String[] args) throws Exception {

        if (args.length < 2) {
            System.out.println("Please provide a repository URL and  as an argument.");
            System.exit(1);
        }
        String repoUrl = args[0];
        String outputFilePath = args[1];

        ExtractMethodExtractor extractMethodExtractor = new ExtractMethodExtractor(repoUrl);
        extractMethodExtractor.identifyRefactoringInstances().generateSamples(outputFilePath);

    }
}