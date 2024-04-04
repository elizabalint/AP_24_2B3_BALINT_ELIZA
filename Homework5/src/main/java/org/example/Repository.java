package org.example;
import java.util.Map;
import java.util.List;
import java.nio.file.*;
import java.util.HashMap;
import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

public class Repository {
    // variabila pentru path-ul directorului
    private String directory;
    //mapa pentru persoana si lista de documente atribuita
    private Map<Person, List<Document>> documents = new HashMap<>();
    //constructor
    public Repository(String directory) throws IOException {
        this.directory = directory;
        loadDocuments();

    }
    // metoda ce incarca documentele din directorul specificat. foloseste Files.walk() pentru a itera prin fisiere si directoare si afiseaza fiecare fisier/director gasit
    private void loadDocuments() {
        try {
            try (Stream<Path> paths = Files.walk(Paths.get(directory))) {
                paths.forEach(path -> {
                    if (Files.isRegularFile(path)) {
                        System.out.println("File: " + path.getFileName());
                    } else if (Files.isDirectory(path)) {
                        System.out.println("Directory: " + path.getFileName());
                    }
                });
            }
        } catch (IOException e) {
            // tratarea erorilor care pot aparea la deschiderea stream-ului
            e.printStackTrace();
        }
    }

    // default constructor
    public Repository() {
    }
    // adaugarea in mapa a persoanelor si listei de documente
    public void add(Person person, List<Document> personDocuments) {
        documents.put(person, personDocuments);
    }
    // getter pentru director
    public String getDirectory() {
        return directory;
    }
    // setter pentru diretctor
    public void setDirectory(String directory) {
        this.directory = directory;
    }
    // getter pentru mapa
    public Map<Person, List<Document>> getDocuments() {
        return documents;
    }
    // setter pentru mapa
    public void setDocuments(Map<Person, List<Document>> documents) {
        this.documents = documents;
    }
    // metoda equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Repository that)) return false;
        return Objects.equals(getDirectory(), that.getDirectory()) && Objects.equals(getDocuments(), that.getDocuments());
    }
    // metoda pentru hash
    @Override
    public int hashCode() {
        return Objects.hash(getDirectory(), getDocuments());
    }
    // toString pentru a afisa informatiile despre un Repository
    @Override
    public String toString() {
        return "Repository{" +
                "directory='" + directory + '\'' +
                ", documents=" + documents +
                '}';
    }
}

