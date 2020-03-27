package pl.edu.pwsztar.service.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.dto.CreateMovieDto;
import pl.edu.pwsztar.domain.dto.MovieDto;
import pl.edu.pwsztar.domain.entity.Movie;
import pl.edu.pwsztar.domain.mapper.MovieListMapper;
import pl.edu.pwsztar.domain.mapper.MovieMapper;
import pl.edu.pwsztar.domain.repository.MovieRepository;
import pl.edu.pwsztar.service.MovieService;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);

    private final MovieRepository movieRepository;
    private final MovieListMapper movieListMapper;
    private final MovieMapper movieMapper;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository,
                            MovieListMapper movieListMapper,
                            MovieMapper movieMapper) {

        this.movieRepository = movieRepository;
        this.movieListMapper = movieListMapper;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDto> findAll() {
        List<Movie> movies = movieRepository.findAll();
        return movieListMapper.mapToDto(movies);
    }

    @Override
    public void creatMovie(CreateMovieDto createMovieDto) {
        Movie movie = movieMapper.mapToEntity(createMovieDto);
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Long movieId) {
        Optional<Long> id;
        movieRepository.deleteById(movieId);
    }

    @Override
    public Optional<Movie> checkIfMovieExists(Long movieID){
        return movieRepository.findById(movieID);
    }
}
