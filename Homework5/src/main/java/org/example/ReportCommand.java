package org.example;

import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class ReportCommand implements Command<Repository, String>{

    //creeaza un raport HTML cu elementele repository ului
    @Override
    public void handleCommand(Repository repository, String path)throws IOException, TemplateException {
        Configuration configuration = new Configuration();
        //calea de unde ia template-ul pentru repository
        configuration.setDirectoryForTemplateLoading(new File(path));
        configuration.setDefaultEncoding("UTF-8");

        Map<String,Object> input = new HashMap<>();
        //pune in html elem repository ului
        input.put("repository",ToStringCommand.ToString(repository));
        Template template = configuration.getTemplate("temp1.html");
        input.put("documents", repository);

        Writer scrie = new OutputStreamWriter(System.out);

        template.process(input, scrie);

        File outputHtmlFile = new File(path, "report.html");
        try (Writer fileWriter = new FileWriter(outputHtmlFile)) {
            template.process(input, fileWriter);
        } catch (TemplateException e) {
            System.out.println("Error in generating output..");
        }
        // seschiderea fisierului HTML in browser
        Desktop.getDesktop().open(outputHtmlFile);
    }
}
