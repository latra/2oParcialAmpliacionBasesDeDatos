package builders;

import exceptions.EmailBuilderException;
import models.Email;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailBuilderTest {
    EmailBuilder emailBuilderError;
    EmailBuilder emailBuilderOk;
    EmailBuilder emailBuilderOk2;

    @BeforeEach
    void init() {
        emailBuilderError = Email.builder();
        emailBuilderOk = Email.builder();
        emailBuilderOk2 = Email.builder();
    }

    @Test
    void from() {
        try {
            emailBuilderOk.from("pgz2@alumnes.udl.cat");
            assertThrows(EmailBuilderException.class, () -> emailBuilderOk.from("pgz2@alumnes.udl.cat"));
            assertThrows(EmailBuilderException.class, () -> emailBuilderError.from(""));
            assertThrows(EmailBuilderException.class, () -> emailBuilderError.from("fdssdfsd"));
            assertThrows(EmailBuilderException.class, () -> emailBuilderError.from("   "));
        } catch (Exception ebe) {
            fail();
        }
    }

    @Test
    void to() {
        try {
            emailBuilderOk.to("pgz2@alumnes.udl.cat");
            emailBuilderOk.to("jmg@udl.cat");
            assertThrows(EmailBuilderException.class, () -> emailBuilderError.to(""));
            assertThrows(EmailBuilderException.class, () -> emailBuilderError.to("fdssdfsd"));
            assertThrows(EmailBuilderException.class, () -> emailBuilderError.to("   "));
        } catch (Exception ebe) {
            fail();
        }
    }

    @Test
    void subject() {
        try {
            emailBuilderOk.subject("Hola que tal estás");
            assertThrows(EmailBuilderException.class, () -> emailBuilderOk.subject("Hola que tal estás"));
            assertThrows(EmailBuilderException.class, () -> emailBuilderError.subject(""));
            assertThrows(EmailBuilderException.class, () -> emailBuilderError.subject("             "));
            assertThrows(EmailBuilderException.class, () -> emailBuilderError.subject("\n\n\t"));
            // Test con un subject de más de 998 caracteres
            assertThrows(EmailBuilderException.class, () -> emailBuilderError.subject("Debido a las características del problema planteado, a la vista queda que es necesario aplicar algún patrón a la hora de la construcción del objeto (siendo esta, por tanto, la intención de la implementación). \n" +
                    "Utilizando como referencia los patrones definidos en el libro Design Patterns, se pueden distinguir cinco tipos de patrones aplicables a la intención de construcción:\n" +
                    "•\tBuilder\n" +
                    "•\tFactory Method\n" +
                    "•\tAbstract Factory\n" +
                    "•\tPrototype\n" +
                    "•\tMemento\n" +
                    "De estas opciones aplicables a la fase que se desea desarrollar, el que permite una solución más afín a los requisitos del programa es, claramente, el patrón Builder, dado que dicho patrón está pensado para permitir almacenar las diversas partes del objeto y, cuando esté finalizado, construir dicho objeto, dando la posibilidad a almacenar las partes de forma desordenada e independiente, tal y como se requiere a la hora de construir el email mencionado en la definición del enunciado.\n" +
                    "Por lo tanto, dicho patrón permitirá guardar los datos individualmente, detectar si alguno de los parámetros es erróneo y, si fuese así, indicar dónde está el problema.\n"));
        } catch (Exception ebe) {
            fail();
        }
    }

    @Test
    void body() {
        try {
            emailBuilderOk.body("Hola que tal estás");
            assertEquals("Hola que tal estás", emailBuilderOk.body);
            emailBuilderOk2.body("Debido a las características del problema planteado, a la vista queda que es necesario aplicar algún patrón a la hora de la construcción del objeto (siendo esta, por tanto, la intención de la implementación). \n" +
                    "Utilizando como referencia los patrones definidos en el libro Design Patterns, se pueden distinguir cinco tipos de patrones aplicables a la intención de construcción:\n" +
                    "•\tBuilder\n" +
                    "•\tFactory Method\n" +
                    "•\tAbstract Factory\n" +
                    "•\tPrototype\n" +
                    "•\tMemento\n" +
                    "De estas opciones aplicables a la fase que se desea desarrollar, el que permite una solución más afín a los requisitos del programa es, claramente, el patrón Builder, dado que dicho patrón está pensado para permitir almacenar las diversas partes del objeto y, cuando esté finalizado, construir dicho objeto, dando la posibilidad a almacenar las partes de forma desordenada e independiente, tal y como se requiere a la hora de construir el email mencionado en la definición del enunciado.\n" +
                    "Por lo tanto, dicho patrón permitirá guardar los datos individualmente, detectar si alguno de los parámetros es erróneo y, si fuese así, indicar dónde está el problema.\n");


            assertEquals("Debido a las características del problema planteado, a la vista queda que es necesario aplicar algún patrón a la hora de la construcción del objeto (siendo esta, por tanto, la intención de la implementación). \n" +
                            "Utilizando como referencia los patrones definidos en el libro Design Patterns, se pueden distinguir cinco tipos de patrones aplicables a la intención de construcción:\n" +
                            "•\tBuilder\n" +
                            "•\tFactory Method\n" +
                            "•\tAbstract Factory\n" +
                            "•\tPrototype\n" +
                            "•\tMemento\n" +
                            "De estas opciones aplicables a la fase que se desea desarrollar, el que permite una solución más afín a los requisitos del programa es, claramente, el patrón Builder, dado que dicho patrón está pensado para permitir almacenar las diversas partes del objeto y, cuando esté finalizado, construir dicho objeto, dando la posibilidad a almacenar las partes de forma desordenada e independiente, tal y como se requiere a la hora de construir el email mencionado en la definición del enunciado.\n" +
                            "Por lo tanto, dicho patrón permitirá guardar los datos individualmente, detectar si alguno de los parámetros es erróneo y, si fuese así, indicar dónde está el problema.\n"
                    , emailBuilderOk2.body);
            assertThrows(EmailBuilderException.class, () -> emailBuilderOk.from("Hola que tal estás"));
            assertThrows(EmailBuilderException.class, () -> emailBuilderError.from(""));
            assertThrows(EmailBuilderException.class, () -> emailBuilderError.from("             "));
            assertThrows(EmailBuilderException.class, () -> emailBuilderError.from("\n\n\t"));
        } catch (Exception ebe) {
            fail();
        }
    }

    @Test
    void ccTo() {
        try {
            emailBuilderOk.ccTo("pgz2@alumnes.udl.cat");
            emailBuilderOk.ccTo("jmg@udl.cat");
            assertThrows(EmailBuilderException.class, () -> emailBuilderError.ccTo(""));
            assertThrows(EmailBuilderException.class, () -> emailBuilderError.ccTo("fdssdfsd"));
            assertThrows(EmailBuilderException.class, () -> emailBuilderError.ccTo("   "));
        } catch (Exception ebe) {
            fail();
        }
    }

    @Test
    void make() {
        try {
            Email.builder()
                    .from("juanmanuel.gimeno@udl.cat")
                    .to("xyz@alumnes.udl.cat")
                    .to("pqr@alumnes.udl.cat")
                    .subject("Copias en los exámenes presenciales")
                    .body("<strong>Ya sabíais las consecuencias " +
                            "de copiar ...</strong>")
                    .ccTo("capest.inf@eps.udl.cat")
                    .make();
            Email.builder()
                    .from("juanmanuel.gimeno@udl.cat")
                    .to("xyz@alumnes.udl.cat")
                    .to("pqr@alumnes.udl.cat")
                    .subject("Copias en los exámenes presenciales")
                    .body("<strong>Ya sabíais las consecuencias " +
                            "de copiar ...</strong>")
                    .make();
            assertThrows(EmailBuilderException.class, () -> Email.builder()
                    .to("xyz@alumnes.udl.cat")
                    .to("pqr@alumnes.udl.cat")
                    .subject("Copias en los exámenes presenciales")
                    .body("<strong>Ya sabíais las consecuencias " +
                            "de copiar ...</strong>")
                    .make());
            assertThrows(EmailBuilderException.class, () -> Email.builder()
                    .from("juanmanuel.gimeno@udl.cat")
                    .subject("Copias en los exámenes presenciales")
                    .body("<strong>Ya sabíais las consecuencias " +
                            "de copiar ...</strong>")
                    .make());
            assertThrows(EmailBuilderException.class, () -> Email.builder()
                    .from("juanmanuel.gimeno@udl.cat")
                    .to("xyz@alumnes.udl.cat")
                    .to("pqr@alumnes.udl.cat")
                    .body("<strong>Ya sabíais las consecuencias " +
                            "de copiar ...</strong>")
                    .ccTo("capest.inf@eps.udl.cat")
                    .make());
            assertThrows(EmailBuilderException.class, () -> Email.builder()
                    .from("juanmanuel.gimeno@udl.cat")
                    .to("xyz@alumnes.udl.cat")
                    .to("pqr@alumnes.udl.cat")
                    .subject("Copias en los exámenes presenciales")
                    .ccTo("capest.inf@eps.udl.cat")
                    .make());

        } catch (Exception ex) {
            fail();
        }
    }

}