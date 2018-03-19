package com.gmail.fattazzo.activeandroidexample.activity.crud;

import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import com.activeandroid.Model;
import com.afollestad.materialdialogs.MaterialDialog;
import com.github.clans.fab.FloatingActionMenu;
import com.gmail.fattazzo.activeandroidexample.R;
import com.gmail.fattazzo.activeandroidexample.db.models.Articolo;
import com.gmail.fattazzo.activeandroidexample.db.models.Categoria;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemLongClick;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EActivity(R.layout.activity_crud)
public class CrudActivity extends AppCompatActivity {

    @ViewById
    ExpandableListView entitiesView;

    @ViewById
    FloatingActionMenu fabMenu;

    private List<Categoria> categorie;
    private Map<Categoria, List<Articolo>> articoli;

    @AfterViews
    void initView() {
        loadDataFormDB();
    }

    @Background
    void loadDataFormDB() {
        articoli = new HashMap<>();
        categorie = Categoria.loadAll();
        for (Categoria categoria : categorie) {
            articoli.put(categoria, categoria.getArticoli());
        }
        bindUi();
    }

    @UiThread
    void bindUi() {
        CategorieArticoliListAdapter listAdapter = new CategorieArticoliListAdapter(this, categorie, articoli);

        entitiesView.setAdapter(listAdapter);

        for (int i = 0; i < listAdapter.getGroupCount(); i++)
            entitiesView.expandGroup(i);
    }

    @ItemLongClick
    void entitiesViewItemLongClicked(Object item) {
        new MaterialDialog.Builder(this)
                .icon(getResources().getDrawable(R.drawable.categoria))
                .title(item.toString())
                .content("Cancellare o modificare l'elemento selezionato?")
                .negativeText("Cancella").onNegative((dialog, witch) -> {
            ((Model) item).delete();
            loadDataFormDB();
        })
                .positiveText("Modifica").onPositive((dialog, which) -> {
            if (item instanceof Articolo) {
                editArticolo((Articolo) item);
            } else {
                editCategoria((Categoria) item);
            }
        }).show();
    }

    @Click
    void addCategoriaFabClicked() {
        fabMenu.close(true);
        editCategoria(new Categoria());
    }

    @Click
    void addArticoloFabClicked() {
        fabMenu.close(true);
        editArticolo(new Articolo());
    }

    private void editCategoria(Categoria categoria) {
        CategoriaView categoriaView = CategoriaView_.build(this);
        categoriaView.bind(categoria);

        String title = categoria.getId() == null ? "Nuova categoria" : categoria.toString();

        new MaterialDialog.Builder(this)
                .icon(getResources().getDrawable(R.drawable.categoria))
                .title(title)
                .customView(categoriaView, false)
                .negativeText(android.R.string.cancel)
                .positiveText(android.R.string.ok).onPositive((dialog, which) -> {

            ((CategoriaView) dialog.getCustomView()).getCategoria().save();
            loadDataFormDB();
        }).show();
    }

    private void editArticolo(Articolo articolo) {
        ArticoloView articoloView = ArticoloView_.build(this);
        articoloView.bind(articolo);

        String title = articolo.getId() == null ? "Nuova articolo" : articolo.toString();

        new MaterialDialog.Builder(this)
                .icon(getResources().getDrawable(R.drawable.articolo))
                .title(title)
                .customView(articoloView, false)
                .negativeText(android.R.string.cancel)
                .positiveText(android.R.string.ok).onPositive((dialog, which) -> {

            ((ArticoloView) dialog.getCustomView()).getArticolo().save();
            loadDataFormDB();
        }).show();
    }
}
