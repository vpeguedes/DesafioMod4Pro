package br.com.mentorama.filmesapi.exceptions;

public class FilmeDuplicadoException extends RuntimeException{

    public FilmeDuplicadoException(String message) {
        super(message);
    }
}
