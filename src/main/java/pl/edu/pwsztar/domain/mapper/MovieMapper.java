package pl.edu.pwsztar.domain.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.dto.CreateMovieDto;
import pl.edu.pwsztar.domain.entity.Movie;

@Component
public class MovieMapper {

    private Converter<CreateMovieDto, Movie> movieCreateMovieDtoConverter = (CreateMovieDto createMovieDto) -> {
        Movie movie = new Movie();

        movie.setImage(createMovieDto.getImage());
        movie.setTitle(createMovieDto.getTitle());
        movie.setYear(createMovieDto.getYear());

        return movie;
    };

    public Movie mapToEntity(CreateMovieDto createMovieDto) {
        return movieCreateMovieDtoConverter.convert(createMovieDto);
    }
}
