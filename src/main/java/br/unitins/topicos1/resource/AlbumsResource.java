package br.unitins.topicos1.resource;

import java.util.List;
import br.unitins.topicos1.model.Album;
import br.unitins.topicos1.repository.AlbumRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.transaction.Transactional;


@Path("/albums")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlbumsResource{

    @Inject
    AlbumRepository repository;

    @GET
    public List<Album> findAll() {
        return repository.listAll();
    }

    @GET
    @Path("/{id}")
    public Album findById(@PathParam("id") Long id) {
        return repository.findById(id);
    }

    
    @GET
    @Path("/search/nome/{nome}")
    public List<Album> findByName(@PathParam("nome") String nome) {
        return repository.findByName(nome);
    }

    @POST
    @Transactional
    public Album insert(Album album) {
        Album novoAlbum = new Album();
        novoAlbum.setNome(album.getNome());
        novoAlbum.setPreco(album.getPreco());
        novoAlbum.setPublicador(album.getPublicador());
        novoAlbum.setGravadora(album.getGravadora());

        repository.persist(novoAlbum);
        return novoAlbum;
    }

    @GET
    @Path("/count")
    public long count(){
        return repository.count();
    }

    @DELETE
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Album album) {
        Album entity = repository.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.setNome(album.getNome());
        entity.setPreco(album.getPreco());
        entity.setPublicador(album.getPublicador());
        entity.setGravadora(album.getGravadora());
        repository.persist(entity);
        return Response.ok(entity).build();
    }

}
