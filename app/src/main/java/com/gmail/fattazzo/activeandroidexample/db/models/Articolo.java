package com.gmail.fattazzo.activeandroidexample.db.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

@Table(name = "articoli")
public class Articolo extends Model {

    @Column(name = "name", index = true)
    private String nome;

    @Column(name = "description")
    private String descrizione;

    @Column(name = "categoria_id", onDelete = Column.ForeignKeyAction.CASCADE)
    private Categoria categoria;

    public static List<Articolo> loadAll() {
        return new Select().from(Articolo.class).execute();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return nome + " - " + descrizione;
    }
}