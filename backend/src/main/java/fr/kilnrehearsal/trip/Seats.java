package fr.kilnrehearsal.trip;

/** Places d'un trajet : réservées une à une, jamais au-delà de la capacité. */
public final class Seats {

    private final int capacity;
    private int booked;

    public Seats(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("capacity must be at least 1");
        }
        this.capacity = capacity;
    }

    public boolean book() {
        if (booked == capacity) {
            return false;
        }
        booked++;
        return true;
    }

    public int left() {
        return capacity - booked;
    }
}
