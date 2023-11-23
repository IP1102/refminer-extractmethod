package org.example;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class ExtractMethodContent {

    private final Git git;

    public ExtractMethodContent(String repositoryPath) throws Exception {

        this.git = Git.open(Paths.get(repositoryPath).toFile());

    }

    public void checkoutToCommit(String commitSHA) throws GitAPIException {
        git.checkout().setName(commitSHA).call();
    }

    public String extractMethodContent(String filePath, int startLine, int endLine) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder methodContent = new StringBuilder();
        String line;
        int lineNumber = 0;

        while ((line = reader.readLine()) != null) {
            lineNumber++;
            if (lineNumber >= startLine && lineNumber <= endLine) {
                methodContent.append(line).append("\n");
            }
        }

        reader.close();
        return methodContent.toString();
    }
}