package org.raf.lms.plugin.datamodel;

public class StudentTestInfo {

    private String ime;
    private String prezime;
    private int indeksBroj;
    private String indeksStudProgram;
    private int indeksGodinaUpisa;
    private String studijskaGrupa;
    private String grupaZadataka;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getIndeksBroj() {
        return indeksBroj;
    }

    public void setIndeksBroj(int indeksBroj) {
        this.indeksBroj = indeksBroj;
    }

    public String getIndeksStudProgram() {
        return indeksStudProgram;
    }

    public void setIndeksStudProgram(String indeksStudProgram) {
        this.indeksStudProgram = indeksStudProgram;
    }

    public int getIndeksGodinaUpisa() {
        return indeksGodinaUpisa;
    }

    public void setIndeksGodinaUpisa(int indeksGodinaUpisa) {
        this.indeksGodinaUpisa = indeksGodinaUpisa;
    }

    public String getStudijskaGrupa() {
        return studijskaGrupa;
    }

    public void setStudijskaGrupa(String studijskaGrupa) {
        this.studijskaGrupa = studijskaGrupa;
    }

    public String getGrupaZadataka() {
        return grupaZadataka;
    }

    public void setGrupaZadataka(String grupaZadataka) {
        this.grupaZadataka = grupaZadataka;
    }

    public String getIndeks(){
        return indeksStudProgram+"/"+indeksBroj+"-"+indeksGodinaUpisa;
    }
}
