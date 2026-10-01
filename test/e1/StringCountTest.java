package e1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCountTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void countWords(String test1) {
    }

    @Test
    void testCountWords(String test) {

        String test1 = ""; //Vacío
        String test2 = "        "; //Lleno de espacios
        String test3 = null; //Nulo
        String test4 = "  "; //Tabulación
        String test5 = "hola  mario"; //Tabulación entre palabras

        assertEquals(0,StringCount.countWords(test1));
        assertEquals(0,StringCount.countWords(test2));
        assertEquals(0,StringCount.countWords(test3));
        assertEquals(0,StringCount.countWords(test4));
        assertEquals(2,StringCount.countWords(test5));


    }

    @Test
    void countChar(String test,char c) {

        String test1 = ""; //Vacío
        String test2 = "        "; //Lleno de espacios
        String test3 = null; //Nulo
        String test4 = "Mario"; //Caso Normal
        String test5 = "María"; //

        assertEquals(0,StringCount.countChar(test1, 'x'));
        assertEquals(0,StringCount.countChar(test2, 'x'));
        assertEquals(0,StringCount.countChar(test3, 'x'));
        assertEquals(5,StringCount.countChar(test4, 'M'));
        assertEquals(5,StringCount.countChar(test5, 'í'));
    }

    @Test
    void countCharIgnoringCase() {

        String test1 = ""; //Vacío
        String test2 = "        "; //Lleno de espacios
        String test3 = null; //Nulo
        String test4 = "Mario";

        assertEquals(0,StringCount.countCharIgnoringCase(test1, 'x'));
        assertEquals(0,StringCount.countCharIgnoringCase(test2, 'x'));
        assertEquals(0,StringCount.countCharIgnoringCase(test3, 'x'));
        assertEquals(0,StringCount.countCharIgnoringCase(test4, 'M'));
        assertEquals(0,StringCount.countCharIgnoringCase(test4, 'a'));
        assertEquals(0,StringCount.countCharIgnoringCase(test4, 'm'));


    }
    @Test
    void isPasswordSafe(){

        String test1 = "HolaMundo8";
        String test2 = "HolaMundo"; //Mayor que 8 sin dígito
        String test3 = "holamundo"; //Mayor que 8 sin mayusculas
        String test4 = "Hola"; //Menor que 8
        String test5 = "HOLAMUNDO"; //Mayor que 8 en mayusculas
        String test6 = "HolaMundo8."; //Caracter especial

        assertEquals(false,StringCount.isPasswordSafe(test1));
        assertEquals(false,StringCount.isPasswordSafe(test2));
        assertEquals(false,StringCount.isPasswordSafe(test3));
        assertEquals(false,StringCount.isPasswordSafe(test4));
        assertEquals(false,StringCount.isPasswordSafe(test5));
        assertEquals(true,StringCount.isPasswordSafe(test6));




    }
}
