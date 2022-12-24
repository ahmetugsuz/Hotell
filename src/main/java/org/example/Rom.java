package org.example;


public class Rom {

    int antSeng;
    int pris;
    String type;
    int id;
    public Rom(int romId, int antSeng, String type, int prisPerDag){
        this.id = romId;
        this.antSeng = antSeng;
        this.pris = prisPerDag;
        this.type = type;
    }

    public int hentId(){
        return id;
    }


}
