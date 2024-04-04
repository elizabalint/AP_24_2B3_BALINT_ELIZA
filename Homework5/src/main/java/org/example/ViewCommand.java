package org.example;

import freemarker.template.TemplateException;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command<Void, String>{

    //deschide un document
    @Override
    public void handleCommand(Void aVoid, String path) throws IOException, TemplateException {
        File document = new File(path);
        Desktop desktop = Desktop.getDesktop();
        //verifica daca se poate deschide un fisier
        if (desktop.isSupported(Desktop.Action.OPEN)) {
            desktop.open(document);
        }
    }
}
