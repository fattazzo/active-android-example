package com.gmail.fattazzo.activeandroidexample.db.structure;

import com.activeandroid.Model;
import com.gmail.fattazzo.activeandroidexample.db.models.library.Autore;
import com.gmail.fattazzo.activeandroidexample.db.models.library.Editore;
import com.gmail.fattazzo.activeandroidexample.db.models.library.Libro;

/**
 * @author fattazzo
 *         <p/>
 *         date: 21/03/18
 */
public class LibreriaDatabaseStructure implements DatabaseStructure {

    @Override
    public String getDatabaseName() {
        return "libreria";
    }

    @Override
    public Class<? extends Model>[] getModelClasses() {
        return new Class[]{Autore.class, Editore.class, Libro.class};
    }
}
