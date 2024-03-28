package org.example;
import java.io.IOException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String args[]) throws InvalidRepositoryException, IOException {
        Main app = new Main();
        app.testRepo();
    }


    private void testRepo() throws IOException, InvalidRepositoryException {
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