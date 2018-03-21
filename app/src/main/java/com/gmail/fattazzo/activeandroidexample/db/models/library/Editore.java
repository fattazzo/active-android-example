package com.gmail.fattazzo.activeandroidexample.db.models.library;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * @author fattazzo
 *         <p/>
 *         date: 21/03/18
 */
@Table(name = "editori")
public class Editore extends Model {

    @Column
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
