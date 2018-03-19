package com.gmail.fattazzo.activeandroidexample.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Cache;
import com.activeandroid.TableInfo;
import com.gmail.fattazzo.activeandroidexample.R;
import com.gmail.fattazzo.activeandroidexample.activity.crud.CrudActivity_;
import com.gmail.fattazzo.activeandroidexample.activity.performance.PerformanceActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    TextView dbNameTV, dbVersionTV, dbModelsTV;

    @AfterViews
    void initViews() {

        dbNameTV.setText(StringUtils.substringAfterLast(ActiveAndroid.getDatabase().getPath(), File.separator));
        dbVersionTV.setText(String.valueOf(ActiveAndroid.getDatabase().getVersion()));

        StringBuilder models = new StringBuilder();
        for (TableInfo tableInfo : Cache.getTableInfos()) {
            models.append(tableInfo.getTableName()).append("\n");
        }
        dbModelsTV.setText(models.toString());
    }

    @Click
    void crudActivityButtonClicked() {
        CrudActivity_.intent(this).start();
    }

    @Click
    void performanceButtonClicked() {
        PerformanceActivity_.intent(this).start();
    }
}
