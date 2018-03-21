package com.gmail.fattazzo.activeandroidexample.db.models.library;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * @author fattazzo
 *         <p/>
 *         date: 21/03/18
 */
@Table(name = "libri")
public class Libro extends Model {

    @Column
    private String titolo;

    @Column(name = "autore_id")
    private Autore autore;

    @Column(name = "editore_id")
    private Editore editore;

    @Column
    private Integer anno;

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Autore getAutore() {
        return autore;
    }

    public void setAutore(Autore autore) {
        this.autore = autore;
    }

    public Editore getEditore() {
        return editore;
    }

    public void setEditore(Editore editore) {
        this.editore = editore;
    }

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }
}
