package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // generarea unei liste de persoane aleatorii
        List<Person> persons = randomGroup(10);
        // crearea unei LinkedList pentru soferi
        LinkedList<Person> listOfDrivers = new LinkedList<>();
        //crearea unui TreeSet pentru pasageri
        TreeSet<Person> listOfPassengers = new TreeSet<>();
        // filtrarea persoanelor care sunt soferi si adaugarea lor în lista de soferi
        var drivers = persons.stream()
                .filter(person -> person.driver)
                .collect(Collectors.toList());
        for (Person p : drivers) {
            listOfDrivers.add(p);
        }
        // sortarea listei de soferi dupa varsta
        List<Person> newSortedListDrivers = listOfDrivers.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());

        // filtrarea persoanelor care sunt pasageri ai adaugarea lor în TreeSet-ul de pasageri
        var passengers = persons.stream()
                .filter(person -> !person.driver)
                .collect(Collectors.toList());
        for (Person p : passengers) {
            listOfPassengers.add(p);
        }
        //afisare informatii despre soferi
        System.out.println("Drivers:");
        newSortedListDrivers.forEach(System.out::println);
        //afisare informatii despre pasageri
        System.out.println("Passengers:");
        listOfPassengers.forEach(System.out::println);
    }
    // generare lista de persoane aleatorii
    public static List<Person> randomGroup(int size) {
        Random random = new Random();
        List<Person> listOfPersons = new ArrayList<>();
        var persons = IntStream.rangeClosed(0, size)
                .mapToObj(i -> new Person("Person" + i, random.nextInt(15,90) ,random.nextBoolean()))
                .toArray(Person[]::new);
        for (Person s : persons) {
            listOfPersons.add(s);
        }
        return listOfPersons;
    }
}