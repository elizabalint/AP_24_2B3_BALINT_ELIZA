package org.example;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.tuple.Pair;

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
        // crearea unei LinkedList pentru destinatii
        LinkedList<Destination> listOfDestinations = new LinkedList<>();
        //crearea unui TreeSet pentru pasageri
        TreeSet<Person> listOfPassengers = new TreeSet<>();
        // crearea unei instante a problemei
        Problem problema = new Problem();
        Faker faker = new Faker();

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
        //generare lista de destinatii aleatorii cu un Faker
        var destinations = IntStream.rangeClosed(0, 5)
                .mapToObj(i -> new Destination(faker.address().city()) )
                .toArray(Destination[]::new);
        for (Destination d : destinations) {
        listOfDestinations.add(d);}
        //afisare lista de destinatii
        listOfDestinations.forEach(System.out::println);
        // atribuirea de destinatii soferilor
        for(Person p : listOfDrivers)
        {
            //fiecare sofer trece prin mai multe orase, am "calculat" numarul de orase prin care trece soferul cu un random
            Random random = new Random();
            int nr = random.nextInt(1,listOfDestinations.size()-1);
            while(nr>0) {
                //am ales o destinatie aleatorie

                int index = random.nextInt(listOfDestinations.size());
                Destination destination = listOfDestinations.get(index);
                // verificam daca destinatia a mai fost asignata soferului sau nu aceasta persoana
                if (!problema.soferiSiDestinatiileLor.containsValue(destination) && !problema.soferiSiDestinatiileLor.containsValue(p)) {
                    // verificam daca cheia p exista deja in mapa
                    if (problema.soferiSiDestinatiileLor.containsKey(p)) {
                        List<Destination> existingDestinations = problema.soferiSiDestinatiileLor.get(p);
                        existingDestinations.add(destination);
                        problema.soferiSiDestinatiileLor.put(p, existingDestinations);
                    } else {
                        // daca cheia p nu exista, cream o noua lista si adaugam destinatia in acea lista
                        List<Destination> newDestinationList = new ArrayList<>();
                        newDestinationList.add(destination);
                        problema.soferiSiDestinatiileLor.put(p, newDestinationList);
                    }
                    nr--;
                }
            }
        }
        //afisam destinatiile pentru soferi
        System.out.println("Destinatii pentru soferi:");
        for (Map.Entry<Person, List<Destination>> entry : problema.soferiSiDestinatiileLor.entrySet())
        {
            Person persoana = entry.getKey();
            List<Destination> destinatii = entry.getValue();
            System.out.println("Persoana: " + persoana.getName() + ", Destinatii:" +destinatii);

        }
        // atribuire destinatii pentru toate persoanele
        for (Person person :persons)
        {
        Random random = new Random();
        int index = 0;
        if(person.driver)
        {
            List<Destination> dest = problema.soferiSiDestinatiileLor.get(person);
            if (dest != null && !dest.isEmpty()) {
                index = random.nextInt(dest.size());
                problema.toatePersoaneleSiDestinatia.put(person, dest.get(index));
            }
        }
        else
        {
            index = random.nextInt(listOfDestinations.size());
            problema.toatePersoaneleSiDestinatia.put(person, listOfDestinations.get(index));}
        }
        // afisare destinatii pentru toate persoanele
        System.out.println("Destinatii toate persoanele:");
        for (Map.Entry<Person, Destination> entry : problema.toatePersoaneleSiDestinatia.entrySet())
        {
            Person persoana = entry.getKey();
            Destination destinatii = entry.getValue();
            System.out.println("Persoana: " + persoana.getName() + "-> Destinatie:" +destinatii.getName());

        }

        System.out.println("REZOLVARE GREEDY");
        Map<Destination, Pair<Person, Person>> pairDPDMap = problema.greedy(listOfDrivers, listOfPassengers);
        // afisare rezolvarea greedy
        for (Map.Entry<Destination, Pair<Person, Person>> entry : pairDPDMap.entrySet()) {
            Destination destination = entry.getKey();
            Pair<Person, Person> driverPassengerPair = entry.getValue();
            Person driver = driverPassengerPair.getLeft();
            Person passenger = driverPassengerPair.getRight();

            System.out.println("Destinație: " + destination.getName());
            System.out.println("  Șofer: " + driver.getName() + ", Vârstă: " + driver.getAge());
            System.out.println("  Pasager: " + passenger.getName() + ", Vârstă: " + passenger.getAge());
        }
    }
    static Faker faker = new Faker();
    // generare lista de persoane aleatorii
    public static List<Person> randomGroup(int size) {
        Random random = new Random();
        List<Person> listOfPersons = new ArrayList<>();
        var persons = IntStream.rangeClosed(0, size)
                .mapToObj(i -> new Person(faker.name().fullName(), random.nextInt(15,90) ,random.nextBoolean()))
                .toArray(Person[]::new);
        for (Person s : persons) {
            listOfPersons.add(s);
        }
        return listOfPersons;
    }
}