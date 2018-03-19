package com.gmail.fattazzo.activeandroidexample.activity.performance;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.TextView;

import com.gmail.fattazzo.activeandroidexample.R;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author fattazzo
 *         <p/>
 *         date: 19/03/18
 */
@EViewGroup(R.layout.performance_view)
public class PerformanceView extends ConstraintLayout {

    @ViewById
    TextView nInsertTV, multTransIntervalTV, singleTransIntervalTV;

    public PerformanceView(Context context) {
        super(context);
    }

    public PerformanceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PerformanceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void bind(int nInsert, BigDecimal multiTransMillisec, BigDecimal singleTransMillisec) {
        nInsertTV.setText("Numero insert: " + nInsert);

        DecimalFormat format = new DecimalFormat("#,##0.000 s");
        multTransIntervalTV.setText(format.format(multiTransMillisec.divide(new BigDecimal(1000))));
        singleTransIntervalTV.setText(format.format(singleTransMillisec.divide(new BigDecimal(1000))));
    }
}
