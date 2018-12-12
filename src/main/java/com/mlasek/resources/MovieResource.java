package com.mlasek.resources;

import com.mlasek.api.MovieFilter;
import com.mlasek.core.Movie;
import com.mlasek.core.MovieGenre;
import com.mlasek.core.Role;
import com.mlasek.db.MovieRepository;
import io.dropwizard.jersey.jsr310.LocalDateParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {

    public MovieResource(MovieRepository repository) {
        this.repository = repository;
    }

    private MovieRepository repository;

    @GET
    public List<Movie> movie(
            @QueryParam("id") UUID id,
            @QueryParam("title") String title,
            @QueryParam("genre") MovieGenre genre,
            @QueryParam("performer") String performer,
            @QueryParam("role") Role role,
            @QueryParam("origin") String origin,
            @QueryParam("dateFrom") Optional<LocalDateParam> dateFrom,
            @QueryParam("dateTo") Optional<LocalDateParam> dateTo,
            @QueryParam("durationFrom") Integer durationFrom,
            @QueryParam("durationTo") Integer durationTo) {

        MovieFilter filter = MovieFilter.builder()
                .withDateFrom(dateFrom)
                .withDateTo(dateTo)
                .withGenre(genre)
                .withId(id)
                .withOrigin(origin)
                .withPerformer(performer)
                .withRole(role)
                .withTitle(title)
                .withDurationFrom(durationFrom)
                .withDurationTo(durationTo)
                .build();

        return repository.filter(filter);
    }

    @POST
    public Movie create(Movie movie) {
        return repository.save(movie);
    }

    @PUT
    @Path("{id}")
    public Movie update(@PathParam("id") UUID id, Movie movie) {
        return repository.update(id, movie)
                .orElseThrow(() ->
                        new WebApplicationException("Movie not found", 404));
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") UUID id) {
        repository.delete(id);
        return Response.ok().build();
    }
}
