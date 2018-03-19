package com.gmail.fattazzo.activeandroidexample.activity.crud;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.EditText;

import com.gmail.fattazzo.activeandroidexample.R;
import com.gmail.fattazzo.activeandroidexample.db.models.Categoria;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * @author fattazzo
 *         <p/>
 *         date: 19/03/18
 */
@EViewGroup(R.layout.item_categoria)
public class CategoriaView extends ConstraintLayout {

    @ViewById
    EditText codiceET, nomeET;

    private Categoria categoria;

    public CategoriaView(Context context) {
        super(context);
    }

    public CategoriaView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CategoriaView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void bind(@NonNull Categoria categoria) {
        this.categoria = categoria;
        codiceET.setText(categoria.getCodice());
        nomeET.setText(categoria.getNome());
    }

    public @NonNull Categoria getCategoria() {
        categoria.setCodice(codiceET.getText().toString());
        categoria.setNome(nomeET.getText().toString());
        return categoria;
    }
}
