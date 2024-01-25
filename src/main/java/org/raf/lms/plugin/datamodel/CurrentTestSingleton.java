package org.raf.lms.plugin.datamodel;

public class CurrentTestSingleton {

    private StudentTestInfo studentTestInfo;

    private static CurrentTestSingleton instance;

    private CurrentTestSingleton(){

    }
    public static CurrentTestSingleton getInstance(){
        if(instance==null)
            instance = new CurrentTestSingleton();
        return instance;
    }

    public void setStudentTestInfo(String ime, String prezime, String indeksBroj,
                                   String indeksStudProgram, String indeksGodinaUpisa, String studijskaGrupa,
                                   String grupaZdataka){
        studentTestInfo = new StudentTestInfo();
        studentTestInfo.setIme(ime);
        studentTestInfo.setPrezime(prezime);
        studentTestInfo.setIndeksBroj(Integer.parseInt(indeksBroj));
        studentTestInfo.setIndeksStudProgram(indeksStudProgram);
        studentTestInfo.setIndeksGodinaUpisa(Integer.parseInt(indeksGodinaUpisa));
        studentTestInfo.setStudijskaGrupa(studijskaGrupa);
        studentTestInfo.setGrupaZadataka(grupaZdataka);
    }

    public StudentTestInfo getStudentTestInfo(){
        return studentTestInfo;
    }
}
