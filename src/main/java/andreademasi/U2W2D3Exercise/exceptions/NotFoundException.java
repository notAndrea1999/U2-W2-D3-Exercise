package andreademasi.U2W2D3Exercise.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(long id) {
        super("Elemento con id " + id + " non trovato!");
    }
}
