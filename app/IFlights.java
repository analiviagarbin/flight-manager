package app;

public interface IFlights {
    String getCityName();
    int getCod();
    String toString();
    boolean equals(Object obj);
    int hashCode();
    Flights clone();
}