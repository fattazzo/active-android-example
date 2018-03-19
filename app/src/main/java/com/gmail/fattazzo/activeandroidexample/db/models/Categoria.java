package com.gmail.fattazzo.activeandroidexample.db.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

@Table(name = "categorie")
public class Categoria extends Model {

    @Column(name = "code", indexGroups = {"category_idx"})
    private String codice;

    @Column(name = "name", indexGroups = {"category_idx"})
    private String nome;

    public static List<Categoria> loadAll() {
        return new Select().from(Categoria.class).orderBy("code").execute();
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Articolo> getArticoli() {
        return getMany(Articolo.class, "categoria_id");
    }

    @Override
    public String toString() {
        return codice + " - " + nome;
    }
}