package com.gmail.fattazzo.activeandroidexample;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.activeandroid.serializer.BigDecimalSerializer;
import com.gmail.fattazzo.activeandroidexample.db.models.Articolo;
import com.gmail.fattazzo.activeandroidexample.db.models.Categoria;

import org.androidannotations.annotations.EApplication;

/**
 * @author fattazzo
 *         <p/>
 *         date: 19/03/18
 */
@EApplication
public class MyApplication extends Application {

    public void onCreate() {
        super.onCreate();
        initActiveAndroid();
    }

    private void initActiveAndroid() {
        Configuration dbConfiguration = new Configuration.Builder(this)
                .setDatabaseName("demodb")
                .setDatabaseVersion(1)
                .addModelClasses(Articolo.class, Categoria.class)
                .addTypeSerializer(BigDecimalSerializer.class)
                .create();
        ActiveAndroid.initialize(dbConfiguration);
    }
}
