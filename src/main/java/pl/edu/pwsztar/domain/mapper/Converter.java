package pl.edu.pwsztar.domain.mapper;

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
