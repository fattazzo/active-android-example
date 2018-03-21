package com.gmail.fattazzo.activeandroidexample.db.structure;

import com.activeandroid.Model;

import java.util.List;

/**
 * @author fattazzo
 *         <p/>
 *         date: 21/03/18
 */
public interface DatabaseStructure {

    String getDatabaseName();

    Class<? extends Model>[] getModelClasses();
}
