package app;

import java.io.*;

public class Storage implements IStorage {

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
                    if(parts.length >= 4){
                        for (int i = 2; i < parts.length; i+=2) {
                            String flightCode = parts[i].trim();
                            String homeCity = parts[i+1].trim();
                            flights.insiraNoFim(new Flights(homeCity, Integer.parseInt(flightCode)));
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
                    writer.write("," + flight.getCod() + "," + flight.getCityName());
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