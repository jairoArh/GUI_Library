package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllBookTest {
    private ControllBook controll;

    @Test
    void addBook() {
        controll = new ControllBook();
        assertTrue( controll.addBook(42,"It",(short)323,"23/11/1980","837464"));
        assertFalse( controll.addBook(42,"It",(short)323,"23/11/1980","837464"));
        assertFalse( controll.addBook(10,"La Melancolia",(short)655,"12/01/2000","8464"));
    }

    @Test
    void findBookById() {
        controll = new ControllBook();
        assertNull ( controll.findBookById(34));
        assertTrue( controll.addBook(42,"It",(short)323,"23/11/1980","837464"));
        assertNotNull( controll.findBookById( 42 ));
        assertEquals(5,controll.findBookById(42).length);
        assertEquals("42",controll.findBookById(42)[0]);
    }
}