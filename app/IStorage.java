package app;

import java.io.IOException;

public interface IStorage {
    static ListaEncadeadaDesordenadaSemRepeticao<Airports> readAirportsFromFile(String filePath) throws IOException {
        return null;
    }

    static void saveAirportsToFile(String filePath, ListaEncadeadaDesordenadaSemRepeticao<Airports> listaAirports) throws Exception {}
}