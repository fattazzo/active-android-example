package com.gmail.fattazzo.activeandroidexample.db.utils;

import com.gmail.fattazzo.activeandroidexample.db.structure.DatabaseStructure;
import com.gmail.fattazzo.activeandroidexample.db.structure.FilmDatabaseStructure;
import com.gmail.fattazzo.activeandroidexample.db.structure.LibreriaDatabaseStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fattazzo
 *         <p/>
 *         date: 21/03/18
 */
public class DatabaseStructureFactory {

    private static Map<String, DatabaseStructure> structures;

    static {
        DatabaseStructure libreria = new LibreriaDatabaseStructure();
        DatabaseStructure films = new FilmDatabaseStructure();

        structures = new HashMap<>();
        structures.put(libreria.getDatabaseName(), libreria);
        structures.put(films.getDatabaseName(), films);
    }

    public static DatabaseStructure getStructure(String databaseName) {
        return structures.get(databaseName);
    }
}
