package produto.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import produto.service.ProdutoService;
import java.util.List;
import produto.model.Produto;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoController {

    @Inject
    ProdutoService produtoService;

    @GET
    public List<Produto> findAll() {
        return produtoService.findAll();
    }

    @GET
    @Path("/{id}")
    public Produto findById(Long id) {
        return produtoService.findById(id);
    }

    @POST
    public Produto save(Produto produto) {
        return produtoService.save(produto);
    }

    @DELETE
    @Path("/{id}")
    public String delete(Long id) {
        return produtoService.delete(id);
    }

    @PUT
    @Path("/{id}")
    public Produto putProduto(Long id, Produto produto) {
        return produtoService.putProduto(id, produto);
    }

    @PATCH
    @Path("/{id}")
    public Produto patchProduto(Long id, Produto produto) {
        return produtoService.patchProduto(id, produto);
    }
}
