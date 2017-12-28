package commons;

public class PairIntString {
    private int first;
    private String second;

    public PairIntString(int first, String second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PairIntString that = (PairIntString) o;

        if (first != that.first) return false;
        return second.equals(that.second);
    }

    @Override
    public int hashCode() {
        int result = first;
        result = 31 * result + second.hashCode();
        return result;
    }
}
