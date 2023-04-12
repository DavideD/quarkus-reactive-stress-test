package de.turing85;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.reactive.mutiny.Mutiny;

import io.smallrye.mutiny.Uni;

@Path("animals")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AnimalResource {
  @Inject
  Mutiny.SessionFactory sf;

  @GET
  public Uni<List<Animal>> listAll() {
    return sf.withSession( session -> session.createQuery( "From Animal", Animal.class )
            .getResultList() );
  }

  @GET
  @Path("{id}")
  public Uni<Animal> getById(@PathParam("id") long id) {
    return sf.withSession( session -> session.find( Animal.class, id ) );
  }

  @POST
  public Uni<Animal> create(Animal animal) {
    return sf.withTransaction( session -> session.persist( animal ) ).map( unused -> animal );
  }
}
