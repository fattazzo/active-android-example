package com.gmail.fattazzo.activeandroidexample.activity.crud;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.gmail.fattazzo.activeandroidexample.R;
import com.gmail.fattazzo.activeandroidexample.db.models.Articolo;
import com.gmail.fattazzo.activeandroidexample.db.models.Categoria;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.util.List;

/**
 * @author fattazzo
 *         <p/>
 *         date: 19/03/18
 */
@EViewGroup(R.layout.item_articolo)
public class ArticoloView extends ConstraintLayout {

    @ViewById
    EditText nomeET, descET;

    @ViewById
    Spinner categoriaSpinner;

    private Articolo articolo;

    public ArticoloView(Context context) {
        super(context);
    }

    public ArticoloView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ArticoloView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void bind(Articolo articolo) {
        this.articolo = articolo;

        nomeET.setText(articolo.getNome());
        descET.setText(articolo.getDescrizione());

        List<Categoria> categorie = Categoria.loadAll();
        ArrayAdapter<Categoria> spinnerArrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item,
                categorie.toArray(new Categoria[categorie.size()]));
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        categoriaSpinner.setAdapter(spinnerArrayAdapter);
        if (!categorie.isEmpty()) {
            categoriaSpinner.setSelection(categorie.indexOf(articolo.getCategoria()));
        }
    }

    public Articolo getArticolo() {
        articolo.setNome(nomeET.getText().toString());
        articolo.setDescrizione(descET.getText().toString());
        articolo.setCategoria((Categoria) categoriaSpinner.getSelectedItem());
        return articolo;
    }
}
