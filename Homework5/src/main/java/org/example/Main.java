package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import freemarker.template.TemplateException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String args[]) throws InvalidRepositoryException, IOException, TemplateException {
        Main app = new Main();
        app.testRepo();
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.print("Introdu comanda (view/report/export) si path/repository: ");
                // citirea din terminal gen
                String input = console.readLine();
                String[] parts = input.split(" ");
                String command = parts[0];
                String path;
                if (parts.length > 1) {
                    path = parts[1];
                } else {
                    path = null;
                }

                String commandLower = command.toLowerCase();
                if (commandLower.equals("view")) {
                    if (path != null) {
                        new ViewCommand().handleCommand(null, path);
                    } else {
                        System.out.println("Nu a fost dat un path");
                    }
                } else if (commandLower.equals("report")) {
                    Person person2 = new Person(2, "Person2");
                    // crearea unei insante de tip Repository cu un path dat
                    var repo2 = new Repository("C:/Users/eliza/Desktop/Facultate/An3/Sem 2/PA/Laborator/Compulsory5/lab5");
                    // crearea documentelor
                    var document3 = new Document("document3");
                    var document4 = new Document("document4");
                    repo2.add(person2, List.of(document3, document4));
                    new ReportCommand().handleCommand(repo2, path);
                } else if (commandLower.equals("export")) {
                    Repository repo = new Repository();
                    Person person3 = new Person(3, "Person3");
                    // crearea unei insante de tip Repository cu un path dat
                    var repo3 = new Repository("C:/Users/eliza/Desktop/Facultate/An3/Sem 2/PA/Laborator/Compulsory5/lab5");
                    // crearea documentelor
                    var document5 = new Document("document5");
                    var document6 = new Document("document6");
                    repo3.add(person3, List.of(document5, document6));
                    new ExportCommand().handleCommand(repo3, path);
                } else {
                    System.out.println("Comanda necunoscuta");


            }
            } catch (IOException | TemplateException e) {
                e.printStackTrace();
            }
        }

    }


    private void testRepo() throws IOException, InvalidRepositoryException, TemplateException {
        // crearea unei instalnte de tip persoana
        Person person1 = new Person(1,"Person1");
        // crearea unei insante de tip Repository cu un path dat
        var repo = new Repository("C:/Users/eliza/Desktop/Facultate/An3/Sem 2/PA/Laborator/Compulsory5/lab5");
        // crearea documentelor
        var document1 = new Document("document1" );
        var document2 = new Document("document2");

        //System.out.println(person1);
        //System.out.println(repo);
        // crearea unui RepositoryService
        var service = new RepositoryService();
        var repo1 = new Repository();
        // adaugarea intr-un repository o mapa cu persoana si lista de documente
        repo1.add(person1, List.of(document1, document2));
        // exportarea repositorului intr-un fisier json
        service.export(repo1,"C:/Users/eliza/Desktop/Facultate/An3/Sem 2/PA/Laborator/Compulsory5/person1.json");
        System.out.println(repo1);
        //service.read("C:/Users/eliza/Desktop/Facultate/An3/Sem 2/PA/Laborator/Compulsory4/Compulsory5/person1.json");
    }
}