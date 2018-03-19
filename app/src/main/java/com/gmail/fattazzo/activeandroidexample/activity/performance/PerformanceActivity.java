package com.gmail.fattazzo.activeandroidexample.activity.performance;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.activeandroid.ActiveAndroid;
import com.gmail.fattazzo.activeandroidexample.R;
import com.gmail.fattazzo.activeandroidexample.db.models.Articolo;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.IntArrayRes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@EActivity(R.layout.activity_performance)
public class PerformanceActivity extends AppCompatActivity {

    @ViewById
    LinearLayout resultPanel;

    @ViewById
    ProgressBar progressBar;

    @IntArrayRes
    int[] builkInsertSize;

    private Date multTransStartTime = null;
    private Date multTransEndTime = null;

    private Date singleTransStartTime = null;
    private Date singleTransEndTime = null;

    private List<Articolo> articoli = null;

    private int currentInsertIdx = 0;

    @AfterViews
    void initView() {

    }

    @Click
    void startButtonClicked() {
        resultPanel.removeAllViews();

        startTest();
    }

    private void startTest() {
        createModels(builkInsertSize[currentInsertIdx]);

        ActiveAndroid.execSQL("delete from articoli");
        ActiveAndroid.execSQL("delete from categorie");

        multipleTransactionsInsert();
    }

    private void multipleTransactionsInsert() {
        progressBar.setVisibility(View.VISIBLE);
        multTransStartTime = Calendar.getInstance().getTime();
        performMultipleTransactionsInsert();
    }

    @Background
    void performMultipleTransactionsInsert() {
        for (Articolo articolo : articoli) {
            articolo.save();
        }
        multipleTransactionUpdateUi();
    }

    @UiThread
    void multipleTransactionUpdateUi() {
        multTransEndTime = Calendar.getInstance().getTime();

        singleTransactionInsert();
    }

    private void singleTransactionInsert() {
        singleTransStartTime = Calendar.getInstance().getTime();
        performSingleTransactionInsert();
    }

    @Background
    void performSingleTransactionInsert() {
        ActiveAndroid.beginTransaction();
        try {
            for (Articolo articolo : articoli) {
                articolo.save();
            }
            ActiveAndroid.setTransactionSuccessful();
        } finally {
            ActiveAndroid.endTransaction();
        }
        singleTransactionUpdateUi();
    }

    @UiThread
    void singleTransactionUpdateUi() {
        singleTransEndTime = Calendar.getInstance().getTime();
        addResultView();

        progressBar.setVisibility(View.GONE);
        currentInsertIdx++;

        if (builkInsertSize.length > currentInsertIdx) {
            startTest();
        } else {
            currentInsertIdx = 0;
        }
    }

    private void addResultView() {
        BigDecimal multiInterval = BigDecimal.valueOf(multTransEndTime.getTime() - multTransStartTime.getTime());
        BigDecimal singleInterval = BigDecimal.valueOf(singleTransEndTime.getTime() - singleTransStartTime.getTime());

        PerformanceView performanceView = PerformanceView_.build(this);
        performanceView.bind(builkInsertSize[currentInsertIdx], multiInterval, singleInterval);

        resultPanel.addView(performanceView);

    }

    private void createModels(int size) {
        articoli = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            Articolo articolo = new Articolo();
            articolo.setNome("A" + i);
            articolo.setDescrizione("Articolo " + 1);
            articoli.add(articolo);
        }
    }
}
