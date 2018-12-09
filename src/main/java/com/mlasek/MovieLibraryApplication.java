package com.mlasek;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mlasek.db.DummyMovieRepository;
import com.mlasek.db.MovieRepository;
import com.mlasek.resources.MovieResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MovieLibraryApplication extends Application<MovieLibraryConfiguration> {

    public static void main(final String[] args) throws Exception {
        new MovieLibraryApplication().run(args);
    }

    @Override
    public String getName() {
        return "movieLibrary";
    }

    @Override
    public void initialize(final Bootstrap<MovieLibraryConfiguration> bootstrap) {
       bootstrap.getObjectMapper().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
       bootstrap.getObjectMapper().registerModule(new JavaTimeModule());
    }

    @Override
    public void run(final MovieLibraryConfiguration configuration,
                    final Environment environment) {
        MovieRepository repository = new DummyMovieRepository();
        final MovieResource resource = new MovieResource(repository);
        environment.jersey().register(resource);
    }

}
