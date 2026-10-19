package fr.kilnrehearsal.trip;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SeatsTest {

    @Test
    void booksUntilFull() {
        var seats = new Seats(2);
        assertTrue(seats.book());
        assertTrue(seats.book());
        assertFalse(seats.book());
        assertEquals(0, seats.left());
    }

    @Test
    void emptyTripIsRejected() {
        assertThrows(IllegalArgumentException.class, () -> new Seats(0));
    }
}
