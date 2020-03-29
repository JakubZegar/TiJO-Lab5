package pl.edu.pwsztar.domain.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.dto.CreateMovieDto;
import pl.edu.pwsztar.domain.entity.Movie;

@Component
public class MovieMapper implements Converter<CreateMovieDto,Movie> {

    private Converter<CreateMovieDto, Movie> movieCreateMovieDtoConverter = (CreateMovieDto createMovieDto) -> {
        Movie movie = new Movie();

        movie.setImage(createMovieDto.getImage());
        movie.setTitle(createMovieDto.getTitle());
        movie.setYear(createMovieDto.getYear());

        return movie;
    };

    @Override
    public Movie convert(CreateMovieDto createMovieDto) {
        return movieCreateMovieDtoConverter.convert(createMovieDto);

    }
}
