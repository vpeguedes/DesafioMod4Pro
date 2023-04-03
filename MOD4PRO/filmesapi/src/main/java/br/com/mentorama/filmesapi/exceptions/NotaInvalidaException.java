package br.com.mentorama.filmesapi.exceptions;

public class NotaInvalidaException extends RuntimeException{

    public NotaInvalidaException(String message) {
        super(message);
    }
}
