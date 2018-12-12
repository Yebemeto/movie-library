package com.mlasek.db;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mlasek.api.MovieFilter;
import com.mlasek.core.Movie;
import com.mlasek.core.MovieGenre;
import com.mlasek.core.Role;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

public class MovieRepositoryTest {

    private static final UUID MOCKED_MOVIE_UUID= UUID.fromString("e8a753e6-fbc7-11e8-8eb2-f2801f1b9fd1");
    private MovieRepository repository;

    @Before
    public void setup(){
        try {
            repository = new DummyMovieRepository(initializeDummyData());
        } catch (IOException e) {
            throw new RuntimeException("dummy data missing or unreadable", e);
        }
    }

    @Test
    public void testFullFilter(){
        MovieFilter filter = MovieFilter.builder()
                .withDateFrom(LocalDate.of(1972, Month.MARCH, 14))
                .withDateTo(LocalDate.of(1972, Month.MARCH, 14))
                .withDurationFrom(175)
                .withDurationTo(175)
                .withGenre(MovieGenre.CRIME)
                .withId(MOCKED_MOVIE_UUID)
                .withOrigin("USA")
                .withPerformer("Mario Puzo")
                .withRole(Role.SCREENWRITER)
                .withTitle("The Godfather")
                .build();
        List<Movie> resultList = repository.filter(filter);
        assertThat(resultList.size()).isEqualTo(1);
        Movie result = resultList.get(0);
        assertThat(result.getCountryOfOrigin()).isEqualTo("USA");
        assertThat(result.getDuration()).isEqualTo(175);
        assertThat(result.getGenres()).contains(MovieGenre.CRIME);
        assertThat(result.getReleaseDate()).isEqualTo(LocalDate.of(1972, Month.MARCH, 14));
        assertThat(result.getPerformers())
                .anyMatch(performance -> performance.getRole()
                        .equals(Role.SCREENWRITER)&&
                        performance.getPerformerName().equals("Mario Puzo"));
        assertThat(result.getTitle()).isEqualTo("The Godfather");
        assertThat(result.getId()).isEqualTo(MOCKED_MOVIE_UUID);
    }

    @Test
    public void testEmptyFilter(){
        MovieFilter filter = MovieFilter.builder().build();
        assertThat(repository.filter(filter).size()).isEqualTo(repository.findAll().size());
    }

    @Test
    public void testPerformerFilter(){
        MovieFilter roleOnlyFilter = MovieFilter.builder().withRole(Role.SCREENWRITER).build();
        MovieFilter personOnlyFilter = MovieFilter.builder().withPerformer("Mario Puzo").build();
        MovieFilter personRoleFilter = MovieFilter.builder().withPerformer("Mario Puzo").withRole(Role.ACTOR).build();
        assertThat(repository.filter(roleOnlyFilter).size()).isEqualTo(repository.findAll().size());
        assertThat(repository.filter(personOnlyFilter).size()).isEqualTo(1);
        assertThat(repository.filter(personRoleFilter).size()).isEqualTo(0);
    }

    private List<Movie> initializeDummyData() throws IOException {
        String json = fixture("fixtures/starting_dummy_data.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        CollectionType type = mapper
                .getTypeFactory()
                .constructCollectionType(List.class, Movie.class);
        return mapper.readValue(json,type);
    }
}
