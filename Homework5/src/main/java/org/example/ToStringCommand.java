package org.example;

public class ToStringCommand {
    public static String ToString(Repository repository) {
        return "Repository{" +
                "directory='" + repository.getDirectory() + '\'' +
                ", person and documents=" + repository.getDocuments() +
                '}';
    }
}
