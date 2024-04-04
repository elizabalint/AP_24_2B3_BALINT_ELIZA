package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class RepositoryService {
    // metoda pentru exportul unui repository intr-un fifiser json
    public void export(Repository repo, String path)
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                repo);
    }
    // metoda pentru citirea unui repository dintr-un fisier json
        public Repository read(String path)
            throws InvalidRepositoryException,IOException  {
            ObjectMapper objectMapper = new ObjectMapper();
            Repository repository = objectMapper.readValue(new File(path), Repository.class);
            return repository;
        }

}

