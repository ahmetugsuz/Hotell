package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomRegistreringTest {
    @Test
    void tredjeRomLagtTilGirIDTre(){
        RomRegistrering romReg = new RomRegistrering();
        romReg.registrerRom(3, "Businessuite", 300);
        romReg.registrerRom(3, "Businessuite", 300);
        romReg.registrerRom(3, "Businessuite", 300);
        assertEquals(3, romReg.hentLista().get(2).hentId());
    }

    @Test
    void feilTypeKasterException(){
        RomRegistrering romReg = new RomRegistrering();
        assertThrows(IllegalArgumentException.class, () -> {romReg.registrerRom(1, "blabla", 600);});
    }

}