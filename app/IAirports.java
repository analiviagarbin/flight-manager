package app;

public interface IAirports {
    String getCity();
    void setCity(String name) throws Exception;
    String getAirportCod();
    void setAirportCod(String code) throws Exception;
    ListaEncadeadaDesordenadaSemRepeticao<Flights> getFlights();
    void addFlight(String cityName, int numFlight) throws Exception;
    void removeFlight(String destination, int num) throws Exception;
    int hashCode();
    boolean equals(Object obj);
    Object clone();
}