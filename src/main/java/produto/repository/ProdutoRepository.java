package produto.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import produto.model.Produto;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto> {

}
