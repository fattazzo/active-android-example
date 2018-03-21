package com.gmail.fattazzo.activeandroidexample.db.models.film;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * @author fattazzo
 *         <p/>
 *         date: 21/03/18
 */
@Table(name = "films")
public class Film extends Model {

    @Column
    private String title;

    @Column
    private Integer anno;

    @Column(name = "genere_id")
    private Genere genere;

    @Column(name = "regista_id")
    private Regista regista;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public Regista getRegista() {
        return regista;
    }

    public void setRegista(Regista regista) {
        this.regista = regista;
    }
}
