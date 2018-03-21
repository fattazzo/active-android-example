package com.gmail.fattazzo.activeandroidexample.db.models.library;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * @author fattazzo
 *         <p/>
 *         date: 21/03/18
 */
@Table(name = "autori")
public class Autore extends Model {

    @Column
    private String nome;

    @Column
    private String cognome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
}
