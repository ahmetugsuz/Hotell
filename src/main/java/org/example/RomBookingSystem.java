package org.example;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class RomBookingSystem {
    private List<Booking> bookingList;
    private List<Rom> alleRom;
    public RomBookingSystem(List<Rom> registrerteRom){
        bookingList = new ArrayList<>();
        alleRom = registrerteRom; // Alle registrerte rom
    }

    public void bokRom(int romId, int antPersoner, String dato){
        boolean booket = false;
        for (Rom r : alleRom){
            if(r.id == romId){
                Booking book = new Booking(romId, antPersoner, dato);
                for(Booking b : bookingList){
                    if(book.hentRomId() == b.romId){ // sjekker om det tidligere er booket samme rom
                        if(b.hentDato().equals(book.hentDato())){ // sjekker paa om de er paa samme dato
                            throw new IllegalArgumentException("Denne datoen er fylt");
                        }
                    }
                }

                bookingList.add(book);
                booket = true;
            }
        }
        if(!booket){
            throw new IllegalArgumentException("Kunne ikke booke rom, sjekk om ID stemmer overens");
        }

    }

    public List<Booking> hentBooketListe(){
        return bookingList;
    }



    public Rom hentRom(int romId){
        Rom rom = null;

        for(Rom r : alleRom){
            if(r.id == romId){
                rom = r;
                break;
            }
        }
        if(rom == null){
            throw new IllegalArgumentException("Rommet fantes ikke, feil id");
        }

        return rom;
    }

    public int totalInntjening(int romId){

        int totalInntjening = 0;
        for(Booking b : bookingList){
            if(b.romId == romId){
                Rom rom = hentRom(romId); // finner ut hvem rom det er, slik at vi kan legge til pris
                totalInntjening += rom.pris; // legger til prisen paa rommet fra booking lista
            }
        }

        return totalInntjening;

    }

    public ArrayList<Rom> synkendeRekkefolge(){
        ArrayList<Rom> nyArr = new ArrayList<>();
        // Legger til alle rommene
        nyArr.addAll(alleRom);
        // Ser om det er rom med storre inntjening enn de andre
        for(int i = 0; i < nyArr.size(); i++){
            for(int j = 0; j < i; j++){
                Rom currentRom = nyArr.get(i);
                if(totalInntjening(nyArr.get(j).id) < totalInntjening(currentRom.id)){
                    nyArr.set(i, nyArr.get(j));
                    nyArr.set(j, currentRom);
                }
            }
        }

        return nyArr;

    }


    public int lengstePeriodeRomBooket(int romID){
        Rom rom = hentRom(romID);
        int lengstePeriode = 0;
        int telling = 0;
        for(Booking b : bookingList){
            if (b.hentRomId() == rom.id){ // om bookinga er paa den rom ID vi er ute etter
                telling++; // oker vi tellinga
            }else{ // hvis den blir avbrutt, altsaa kan en annen booking komme i veien
                if(telling > lengstePeriode) { // hvis denne tellinga var storre enn forrige
                    lengstePeriode = telling; // setter vi antall dagene og holder det
                }
                telling = 0;
            }
        }
        if(lengstePeriode == 0){ // hvis det var en gang telt og ikke avbrutt noen gang maa vi handtere det her
            lengstePeriode = telling;
        }

        return lengstePeriode;
    }


}
