package br.com.mentorama.filmesapi.services;

import br.com.mentorama.filmesapi.models.Movies;

import java.util.List;

public interface IMoviesService {
    List<Movies> findAll(String movie);
    Movies findById(Integer id);
    void updadeMovie(final Movies movie);
    void deleteMovie(Integer id);
    Integer addMovie(final Movies movie);
}
