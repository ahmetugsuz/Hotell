package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RomRegistrering {
    private static long id = 0;
    private List<Rom> romListe;
    private int romId;
    private List<String> romTypeList = new ArrayList<>(
            Arrays.asList("Bryllupssuite", "Businessuite", "Kvalitetsrom", "Lavprisrom")
    );
    public RomRegistrering(){
        romListe = new ArrayList<>();
        romId = 1;
    }

    public void registrerRom(int antSeng, String romType, int prisPerDag){
        if (!romTypeList.contains(romType)){
            throw new IllegalArgumentException("Denne rom typen er ikke gyldig");
        }
        Rom nyttRom = new Rom(romId, antSeng, romType, prisPerDag);
        romListe.add(nyttRom);
        romId++;
    }

    public List<Rom> hentLista(){
        return romListe;
    }






}
