public abstract class Attraction implements Comparable<Attraction> {
    private String name;
    //default constructor
    public Attraction() {
    }
    //getter pentru name
    public String getName() {
        return name;
    }
    //toString pentru a afisa informatii despre atractii
    @Override
    public String toString() {
        return "Attraction{" +
                "name='" + name + '\'' +
                '}';
    }
    //metoda pentru a compara 2 obiecte
    @Override
    public int compareTo(Attraction other) {
        if (this.name == null || other.name == null)
            return -1; //una dintre are nume
        else
            return this.name.compareTo(other.name);
    }


}
