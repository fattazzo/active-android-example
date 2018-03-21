package com.gmail.fattazzo.activeandroidexample.db.utils;

import android.content.Context;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.gmail.fattazzo.activeandroidexample.db.structure.DatabaseStructure;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * @author fattazzo
 *         <p/>
 *         date: 21/03/18
 */
@EBean(scope = EBean.Scope.Singleton)
public class DatabaseUtils {

    @RootContext
    Context context;

    public void use(String databaseName) {

        DatabaseStructure structure = DatabaseStructureFactory.getStructure(databaseName);

        if (structure != null) {
            ActiveAndroid.dispose();
            Configuration dbConfiguration = new Configuration.Builder(context)
                    .setDatabaseName(structure.getDatabaseName())
                    .addModelClasses(structure.getModelClasses())
                    .create();
            ActiveAndroid.initialize(dbConfiguration);
        }
    }
}
