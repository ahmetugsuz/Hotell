package org.example;

import java.util.*;

public class Booking {
    public int romId;
    private int antSeng;
    private String dato;

    public Booking(int romId, int antSeng, String dato){
        this.romId = romId;
        this.antSeng = antSeng;
        this.dato = dato;
    }

    public int hentRomId(){
        return romId;
    }

    public String hentDato(){
        return dato;
    }



}
