package org.example.models;

public class Author {
    private int id;
    private String name;

    public Author(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Author() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
