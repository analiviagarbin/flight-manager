package app;

import java.io.*;

public class Storage implements IStorage {

    /**
     * Reads Airports data from a file and returns a list of Airports.
     * @param filePath The path of the file to read from.
     * @return A list of Airports read from the file.
     * @throws IOException If an I/O error occurs.
     */
    public static ListaEncadeadaDesordenadaSemRepeticao<Airports> readAirportsFromFile(String filePath) throws IOException {
        ListaEncadeadaDesordenadaSemRepeticao<Airports> listaAirports = new ListaEncadeadaDesordenadaSemRepeticao<Airports>();
        BufferedReader reader = null;

        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }

            reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String city = parts[0].trim();
                    String airportCod = parts[1].trim();

                    ListaEncadeadaDesordenadaSemRepeticao<Flights> flights = new ListaEncadeadaDesordenadaSemRepeticao<Flights>();
                    if(parts.length >= 7){
                        for (int i = 2; i < parts.length; i+=5) {
                            String cityName = parts[i].trim();
                            int cod = Integer.parseInt(parts[i+1].trim());
                            String departureTime = parts[i+2].trim();
                            String arrivalTime = parts[i+3].trim();
                            int passengerCount = Integer.parseInt(parts[i+4].trim());
                            flights.insiraNoFim(new Flights(cityName, cod, departureTime, arrivalTime, passengerCount));
                        }
                    }


                    listaAirports.insiraNoFim(new Airports(city, airportCod, flights));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        return listaAirports;
    }

    /**
     * Writes a list of Airports to a file.
     * @param filePath The path of the file to write to.
     * @param listaAirports The list of Airports to write to the file.
     * @throws Exception If an error occurs.
     */
    public static void saveAirportsToFile(String filePath, ListaEncadeadaDesordenadaSemRepeticao<Airports> listaAirports) throws Exception {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(filePath));

            for (int i = 0; i < listaAirports.getQtd(); i++) {
                Airports airport = listaAirports.get(i);
                writer.write(airport.getCity() + "," + airport.getAirportCod());

                ListaEncadeadaDesordenadaSemRepeticao<Flights> flights = airport.getFlights();
                for (int j = 0; j < flights.getQtd(); j++) {
                    Flights flight = flights.get(j);
                    writer.write("," + flight.getCityName() + "," + flight.getCod() + "," + flight.getDepartureTime() + "," + flight.getArrivalTime() + "," + flight.getPassengerCount());

                }

                writer.newLine();
            }
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}