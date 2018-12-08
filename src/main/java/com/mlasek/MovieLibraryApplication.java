package com.mlasek;

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
        // TODO: application initialization
    }

    @Override
    public void run(final MovieLibraryConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
