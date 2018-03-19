package com.gmail.fattazzo.activeandroidexample.activity.crud;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.TextView;

import com.gmail.fattazzo.activeandroidexample.R;
import com.gmail.fattazzo.activeandroidexample.db.models.Categoria;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * @author fattazzo
 *         <p/>
 *         date: 19/03/18
 */
@EViewGroup(R.layout.list_item_categoria)
public class CategoriaListItemView extends ConstraintLayout {

    @ViewById
    TextView codiceTV, descTV;

    public CategoriaListItemView(Context context) {
        super(context);
    }

    public CategoriaListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CategoriaListItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void bind(Categoria categoria) {
        codiceTV.setText(categoria.getCodice());
        descTV.setText(categoria.getNome());
    }
}
