package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Problem {
    //lista pentru sofer
    LinkedList<Person> listOfDrivers = new LinkedList<>();
    //TreeSet pentru pasageri
    TreeSet<Person> listOfPassengers = new TreeSet<>();
    //pentru soferi o mapa cu numele lor si toate orasele prin care trec
    Map<Person, List<Destination>> soferiSiDestinatiileLor = new HashMap<>();
    //mapa pentru toate persoanele si destinatia
    Map<Person, Destination> toatePersoaneleSiDestinatia = new HashMap<>();

    //adaugare in mapa soferii si destinatiile prin care trec
    public void addsoferiSiDestinatiileLor(Person p, List<Destination> d)
    {
        soferiSiDestinatiileLor.put(p,d);
    }
    // adaugare in mapa persoana si destinatia
    public void addtoatePersoaneleSiDestinatia(Person p, Destination d)
    {
        toatePersoaneleSiDestinatia.put(p,d);
    }
    //algoritmul greedy
    public Map<Destination, Pair<Person,Person>> greedy(List <Person> listaDrivers, TreeSet <Person> listaPassengers)
    {
        // o mapa unde stocam destinatia, si o pereche de contine soferul si pasagerul
        Map<Destination, Pair<Person,Person>> destinatieSoderPasager = new HashMap<>();
        // punem intr-o lista toti soferii si pasagerii
        List<Person> allPersons = Stream.concat(listaDrivers.stream(), listaPassengers.stream())
                .collect(Collectors.toList());
        // parcurgem lista cu soferi si pasageri
        for(Person p:allPersons)
        {
            // daca persoana este sofer, parcurgem mapa cu toate persoanele si cautam o persoana care sa nu fie sofer si sa treaca prin aceeasi destinatie
            if (p.driver) {
                toatePersoaneleSiDestinatia.entrySet().stream()
                        .filter(entry -> !entry.getKey().equals(p) && !entry.getKey().driver && entry.getValue().equals(toatePersoaneleSiDestinatia.get(p)))
                        .map(Map.Entry::getKey)
                        .forEach(passenger -> {
                            ImmutablePair<Person, Person> pair = new ImmutablePair<>(p, passenger);
                            destinatieSoderPasager.put(toatePersoaneleSiDestinatia.get(p), pair);
                        });
            } else {
                // daca persoana nu este sofer, trecem doar prin mapa cu soferi si destinatii si cautam un sofer care are acelasi drum cu pasagerul
                soferiSiDestinatiileLor.entrySet().stream()
                        .filter(entry -> entry.getValue().equals(toatePersoaneleSiDestinatia.get(p)))
                        .map(Map.Entry::getKey)
                        .forEach(driver -> {
                            ImmutablePair<Person, Person> pair = new ImmutablePair<>(driver, p);
                            destinatieSoderPasager.put(toatePersoaneleSiDestinatia.get(p), pair);
                        });
            }
        }
        return destinatieSoderPasager;
    }

}

