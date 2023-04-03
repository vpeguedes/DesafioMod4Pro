package br.com.mentorama.filmesapi.controlers;


import br.com.mentorama.filmesapi.models.Movies;
import br.com.mentorama.filmesapi.services.IMoviesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filmesapi")
public class MoviesController {

    private final List<Movies> movies;

    private final IMoviesService moviesService;

    public MoviesController(IMoviesService moviesService) {
        this.moviesService = moviesService;
        this.movies = new ArrayList<>();
    }

    @GetMapping
    public List<Movies> findAll(@RequestParam(required = false) String movie) {
        return moviesService.findAll(movie);
    }

    @GetMapping("/{id}")
    public Movies findById(@PathVariable("id") Integer id) {
        return moviesService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Integer> addMovie(@RequestBody final Movies movie) {
        Integer id = moviesService.addMovie(movie);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateMovie(@RequestBody final Movies movie) {
        moviesService.updadeMovie(movie);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovie(@PathVariable("id") Integer id) {
        moviesService.deleteMovie(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
