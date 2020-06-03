package utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests de la clase Check de la implementación
 */
class CheckTest {

    @Test
    void isNullOrEmpty() {
        // Si la string es null
        String testNull = null;
        // Si la string está empty
        String testEmpty = "";
        // Si la string solo contiene espacios
        String testBlank = "      ";
        // Si la string solo contiene carácteres no printables (saltos de linea, tabulaciones, etc.
        String testInvisible=" \n\t\n    ";
        // Si es una string con valores
        String testOk = "Hola buenas tardes \n Qué tal?";
        assertTrue(Check.isNullOrEmpty(testNull));
        assertTrue(Check.isNullOrEmpty(testEmpty));
        assertTrue(Check.isNullOrEmpty(testBlank));
        assertTrue(Check.isNullOrEmpty(testInvisible));
        assertFalse(Check.isNullOrEmpty(testOk));
    }

    @Test
    void hasElements() {
        // Una lista sin inicializar:
        ArrayList<String> testNull = null;
        // Una lista empty:
        ArrayList<String> testEmpty = new ArrayList<>();
        // Una lista con valores:
        ArrayList<String> testOk = new ArrayList<>();
        testOk.add("patata");
        assertFalse(Check.hasElements(testNull));
        assertFalse(Check.hasElements(testEmpty));
        assertTrue(Check.hasElements(testOk));
    }

    @Test
    void isValidEmail() {
        // Email es null
        String testNull = null;
        // Email está empty
        String testEmpty = "";
        // Email formato erroneo
        String testBadFormatted1 = "hola";
        String testBadFormatted2 = "hola@ya";
        String testBadFormatted3 = "hola@.es";
        String testBadFormatted4 = "@aha.es";
        // Email formato correcto
        String testOk = "hoolla@aha.es";
        String testOkNumber = "hoolla23@aha.es";
        String testOkDotsDomain = "pgz2@alumnes.udl.cat";
        String testOkDotsName = "paula.gallucci@chatbotchocolate.com";
        String testOkDotsBoth = "paula.gallucci@test.testing.com";

        assertFalse(Check.isValidEmail(testNull));
        assertFalse(Check.isValidEmail(testEmpty));
        assertFalse(Check.isValidEmail(testBadFormatted1));
        assertFalse(Check.isValidEmail(testBadFormatted2));
        assertFalse(Check.isValidEmail(testBadFormatted3));
        assertFalse(Check.isValidEmail(testBadFormatted4));
        assertTrue(Check.isValidEmail(testOk));
        assertTrue(Check.isValidEmail(testOkNumber));
        assertTrue(Check.isValidEmail(testOkDotsDomain));
        assertTrue(Check.isValidEmail(testOkDotsName));
        assertTrue(Check.isValidEmail(testOkDotsBoth));
    }
}