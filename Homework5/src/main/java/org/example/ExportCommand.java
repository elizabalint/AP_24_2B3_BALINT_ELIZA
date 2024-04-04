package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ExportCommand implements Command<Repository, String> {

    // metoda pentru exportul unui repository intr-un fifiser json
    @Override
    public void handleCommand(Repository repo, String path)
            throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                repo);
    }
}
