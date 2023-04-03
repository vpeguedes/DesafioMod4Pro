package br.com.mentorama.filmesapi.repositories;

import br.com.mentorama.filmesapi.exceptions.FilmeDuplicadoException;
import br.com.mentorama.filmesapi.models.Movies;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MoviesRepository {

    private final List<Movies> movies;

    public MoviesRepository() {
        this.movies = new ArrayList<>();
    }

    public int count() {
        return movies.size();
    }

    public List<Movies> findAll() {
        return movies;
    }

    public List<Movies> findAll(final String movie) {
        return movies.stream()
                .filter(mvs -> mvs.getNomeFilme().contains(movie))
                .collect(Collectors.toList());
    }

    public Movies findById(Integer id) {
        return movies.stream()
                .filter(mvs -> mvs.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addMovie(Movies movie) {
        filmeDuplicado(movie);
        this.movies.add(movie);
    }

    public void updateMovie(final Movies movie) {
        Movies alteraDados = movies.stream()
                .filter(mvs -> mvs.getId().equals(movie.getId()))
                .findFirst()
                .orElse(null);
        alteraDados.setNomeFilme(movie.getNomeFilme());
        alteraDados.setNomeDiretor(movie.getNomeDiretor());
        alteraDados.setAnoFilme(movie.getAnoFilme());
        alteraDados.setNotaFilme(movie.getNotaFilme());
        filmeDuplicado(movie);
    }

    public void deleteMovie(Integer id) {
        movies.removeIf(mvs -> mvs.getId().equals(id));
    }

    private void filmeDuplicado(Movies movie) {
        Boolean tituloRepetido = movies.stream()
                .anyMatch(mvs -> mvs.getNomeFilme().equals(movie.getNomeFilme()));
        Boolean diretorRepetido = movies.stream()
                .anyMatch(mvs -> mvs.getNomeDiretor().equals(movie.getNomeDiretor()));

        if (tituloRepetido && diretorRepetido) {
            throw new FilmeDuplicadoException("Este titulo já existe");
        }
    }
}
