package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RomBookingSystemTest {

    @Test
    void bookeRomLeggerTilIBookingLista() {
        RomRegistrering romReg = new RomRegistrering();
        romReg.registrerRom(3, "Businessuite", 300);
        RomBookingSystem book = new RomBookingSystem(romReg.hentLista());
        book.bokRom(1, 2, "12.12.22");
        assertEquals(1, book.hentBooketListe().size());
    }

    @Test
    void toBookingPaaSammeRomOgDatoKasterException(){
        RomRegistrering romReg = new RomRegistrering();
        romReg.registrerRom(3, "Businessuite", 300);
        RomBookingSystem book = new RomBookingSystem(romReg.hentLista());
        book.bokRom(1, 2, "20.12.22");

        assertThrows(IllegalArgumentException.class, () -> {
            book.bokRom(1, 2, "20.12.22");
        });
    }

    @Test
    void totalInntjeningGirTohundre(){
        RomRegistrering romReg = new RomRegistrering();
        romReg.registrerRom(3, "Businessuite", 100);
        RomBookingSystem book = new RomBookingSystem(romReg.hentLista());
        book.bokRom(1, 2, "20.12.22");
        book.bokRom(1, 2, "21.12.22");
        assertEquals(200, book.totalInntjening(1));
    }

    @Test
    void TreForskjelligeBookingReturnererSynkendeArrayFraPris(){
        RomRegistrering romReg = new RomRegistrering();
        romReg.registrerRom(3, "Businessuite", 300);
        romReg.registrerRom(3, "Businessuite", 500);
        romReg.registrerRom(3, "Businessuite", 100);
        RomBookingSystem book = new RomBookingSystem(romReg.hentLista());
        book.bokRom(1, 2, "20.12.22");
        book.bokRom(2, 2, "21.12.22");
        book.bokRom(3, 2, "22.12.22");
        book.bokRom(3, 2, "23.12.22");
        ArrayList<Rom> forventetArray = new ArrayList<>(
                Arrays.asList(book.hentRom(2), book.hentRom(1), book.hentRom(3))
        );
        assertEquals(forventetArray ,book.synkendeRekkefolge());
    }

    @Test
    void fireBookingerGirLengstePeriodeFire(){
        RomRegistrering romReg = new RomRegistrering();
        romReg.registrerRom(3, "Businessuite", 300);
        romReg.registrerRom(3, "Businessuite", 500);
        romReg.registrerRom(3, "Businessuite", 100);
        RomBookingSystem book = new RomBookingSystem(romReg.hentLista());
        book.bokRom(1, 2, "20.12.22");
        book.bokRom(2, 2, "21.12.22");
        book.bokRom(3, 2, "20.12.22");
        book.bokRom(3, 2, "25.12.22");
        book.bokRom(3, 2, "26.12.22");
        book.bokRom(3, 2, "27.12.22");
        book.bokRom(1, 2, "27.12.22");
        book.bokRom(3, 2, "28.12.22");
        book.bokRom(3, 2, "29.12.22");
        assertEquals(4, book.lengstePeriodeRomBooket(3));
        assertNotEquals(2, book.lengstePeriodeRomBooket(3));

    }

}