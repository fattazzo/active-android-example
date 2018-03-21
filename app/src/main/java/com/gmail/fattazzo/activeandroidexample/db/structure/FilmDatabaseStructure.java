package com.gmail.fattazzo.activeandroidexample.db.structure;

import com.activeandroid.Model;
import com.gmail.fattazzo.activeandroidexample.db.models.film.Film;
import com.gmail.fattazzo.activeandroidexample.db.models.film.Genere;
import com.gmail.fattazzo.activeandroidexample.db.models.film.Regista;

/**
 * @author fattazzo
 *         <p/>
 *         date: 21/03/18
 */
public class FilmDatabaseStructure implements DatabaseStructure {

    @Override
    public String getDatabaseName() {
        return "films";
    }

    @Override
    public Class<? extends Model>[] getModelClasses() {
        return new Class[]{Film.class, Genere.class, Regista.class};
    }
}
