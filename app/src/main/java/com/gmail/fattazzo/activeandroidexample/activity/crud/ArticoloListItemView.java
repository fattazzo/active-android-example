package com.gmail.fattazzo.activeandroidexample.activity.crud;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.TextView;

import com.gmail.fattazzo.activeandroidexample.R;
import com.gmail.fattazzo.activeandroidexample.db.models.Articolo;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * @author fattazzo
 *         <p/>
 *         date: 19/03/18
 */
@EViewGroup(R.layout.list_item_articolo)
public class ArticoloListItemView extends ConstraintLayout {

    @ViewById
    TextView nomeTV, descTV;

    public ArticoloListItemView(Context context) {
        super(context);
    }

    public ArticoloListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ArticoloListItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void bind(Articolo articolo) {
        nomeTV.setText(articolo.getNome());
        descTV.setText(articolo.getDescrizione());
    }
}
