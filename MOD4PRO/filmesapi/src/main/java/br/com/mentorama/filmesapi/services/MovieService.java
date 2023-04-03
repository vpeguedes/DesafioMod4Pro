package br.com.mentorama.filmesapi.services;

import br.com.mentorama.filmesapi.exceptions.NotaInvalidaException;
import br.com.mentorama.filmesapi.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.mentorama.filmesapi.models.Movies;

import java.util.List;

@Service
public class MovieService implements IMoviesService {

    @Autowired
    private MoviesRepository moviesRepository;

    public List<Movies> findAll(String movie) {
        if(movie != null) {
            return moviesRepository.findAll(movie);
        }
        return moviesRepository.findAll();
    }

    public Movies findById(Integer id) {
        return moviesRepository.findById(id);
    }

    public void updadeMovie(final Movies movie) {
        intervaloNota(movie);
        moviesRepository.updateMovie(movie);
    }

    public Integer addMovie(final Movies movie) {
        if(movie.getId() == null) {
            movie.setId(moviesRepository.count() + 1);
        }
        intervaloNota(movie);
        moviesRepository.addMovie(movie);
        return movie.getId();
    }

    public void deleteMovie(Integer id) {
        moviesRepository.deleteMovie(id);
    }

    public void intervaloNota(Movies movie) {
        if(movie.getNotaFilme() < 1 || movie.getNotaFilme() > 5) {
            throw new NotaInvalidaException("NOTA_INVALIDA");
        }
    }
}
