package produto.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import produto.model.Produto;
import produto.repository.ProdutoRepository;

import java.util.List;

@ApplicationScoped
public class ProdutoService {

    @Inject
    ProdutoRepository produtoRepository;

    @Transactional
    public Produto save(Produto produto) {
        produtoRepository.persist(produto);
        return produto;
    }

    @Transactional
    public List<Produto> findAll() {
        return produtoRepository.listAll();
    }

    @Transactional
    public Produto findById(Long id) {
        return produtoRepository.findById(id);
    }

    @Transactional
    public Produto putProduto(Long id, Produto produto) {
        Produto produtoEntity = produtoRepository.findById(id);
        produtoEntity.setNome(produto.getNome());
        produtoEntity.setPreco(produto.getPreco());
        return produtoRepository.getEntityManager().merge(produtoEntity);
    }

    @Transactional
    public Produto patchProduto(Long id, Produto produto) {
        Produto produtoEntity = produtoRepository.findById(id);
        if (produto.getNome() != null) {
            produtoEntity.setNome(produto.getNome());
        }
        if (produto.getPreco() != null) {
            produtoEntity.setPreco(produto.getPreco());
        }
        return produtoRepository.getEntityManager().merge(produtoEntity);
    }

    @Transactional
    public String delete(Long id) {
        produtoRepository.deleteById(id);
        return "Produto deletado com sucesso!";
    }

}
