import java.util.Objects;

public abstract class Pair <T,U>{
    private T first;
    private U second;
    //constructor cu variabilele de tip T si U
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
    //default constructor
    public Pair() {
    }
    //getter pentru first
    public T getFirst() {
        return first;
    }
    //setter pentru fisrt
    public void setFirst(T first) {
        this.first = first;
    }
    //getter pentru second
    public U getSecond() {
        return second;
    }
    // setter pentru second
    public void setSecond(U second) {
        this.second = second;
    }
    //toString pentru a afisa perechea
    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
    // metoda equals pentru a compara 2 obiecte de tip Pair
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair<?, ?> pair)) return false;
        return Objects.equals(getFirst(), pair.getFirst()) && Objects.equals(getSecond(), pair.getSecond());
    }
    //hash code pentru Pair
    @Override
    public int hashCode() {
        return Objects.hash(getFirst(), getSecond());
    }
}

