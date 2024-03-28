package org.example;

public class Person implements Comparable<Person>{
    //variabila pentru numele persoanei
    private String name;
    //variabila pentru varsta persoanei
    private int age;
    //variabila booleana pentru a stabili daca persoana este sofer sau pasager
    protected boolean driver;
    //constructor cu toate variabilele
    public Person(String name, int age, boolean driver) {
        this.name = name;
        this.age = age;
        this.driver = driver;
    }
    //getter pentru nume
    public String getName() {
        return name;
    }
    //setter pentru nume
    public void setName(String name) {
        this.name = name;
    }
    //getter pentru varsta
    public int getAge() {
        return age;
    }
    //setter pentru vasrta
    public void setAge(int age) {
        this.age = age;
    }
    //getter pentru sofer
    public boolean isDriver() {
        return driver;
    }
    //setter pentru sofer
    public void setDriver(boolean driver) {
        this.driver = driver;
    }
    //toString pentru afisarea detaliilor despre persoaan
    @Override
    public String toString() {
        String driverStatus = (driver) ? "driver" : "passenger";
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", type=" + driverStatus +
                '}';
    }
    //compara 2 persoane dupa nume
    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}
