package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
        RomRegistrering nyReg = new RomRegistrering();
        System.out.println("Registrering: ");
        nyReg.registrerRom(3, "Businessuite", 500);
        nyReg.registrerRom(1, "Bryllupssuite", 700);
        nyReg.registrerRom(1, "Bryllupssuite", 1700);
        nyReg.registrerRom(1, "Lavprisrom", 200);

        List<Rom> romL = nyReg.hentLista();
        for(Rom rom : romL){
            System.out.println("Id: " + rom.id + " Ant seng " + rom.antSeng + " pris paa rom "+ rom.pris);
        }
        System.out.println();
        System.out.println("Booking av Rom: ");
        RomBookingSystem book = new RomBookingSystem(romL);
        book.bokRom(1, 3, "12.12.22");
        book.bokRom(2, 2, "13.12.22");
        book.bokRom(2, 1, "15.12.22");
        book.bokRom(3, 2, "17.12.22");
        book.bokRom(4, 2, "18.12.22");
        book.bokRom(4, 1, "19.12.22");
        book.bokRom(4, 3, "20.12.22");
        book.bokRom(2, 3, "12.01.23");
        book.bokRom(2, 3, "13.01.23");
        book.bokRom(2, 2, "15.01.23");
        book.bokRom(1, 4, "16.01.23");
        book.bokRom(2, 2, "20.01.23");
        for(Booking b : book.hentBooketListe()){
            System.out.println("Booket rom ID: " + b.romId + " paa datoen "+ b.hentDato());
        }

        System.out.println();
        System.out.println("Alle rom sortert etter intjening");
        ArrayList<Rom> liste = book.synkendeRekkefolge();
        for(Rom r : liste){
            System.out.println("Rom id: "+r.id+ " med inntjening "+ book.totalInntjening(r.id));
        }

        System.out.println();
        System.out.println("");
        int lengstePeriode = book.lengstePeriodeRomBooket(2);
        System.out.println("Lengste perioden booket for rom med ID: " + 2 +", er "+lengstePeriode+ " antall dager");


    }
}