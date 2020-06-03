package utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextsTest {
    Texts texts = new Texts();
    @Test
    void getText() {
        assertEquals( "Undefined message", texts.getText("DINOSAUR"));
        assertEquals( "Email subject can not be empty", texts.getText("ErrorEmptySubject"));
    }
}