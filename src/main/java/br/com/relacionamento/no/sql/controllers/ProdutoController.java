package br.com.relacionamento.no.sql.controllers;

import br.com.relacionamento.no.sql.models.Produto;
import br.com.relacionamento.no.sql.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable String id) {
        return produtoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        Produto savedProduto = produtoRepository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable String id, @RequestBody Produto produto) {
        if (!produtoRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        produto.setId(id);
        Produto updatedProduto = produtoRepository.save(produto);
        return ResponseEntity.ok(updatedProduto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        produtoRepository.deleteById(id);
    }

    @GetMapping("/pageable")
    public Page<Produto> getAllPage(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    @GetMapping("/category/{categoryId}")
    public List<Produto> getProductByCategoryId(@PathVariable String categoryId) {
        return produtoRepository.findByCategoriaId(categoryId);
    }

    @GetMapping("/identifier/{productIdentifier}")
    public ResponseEntity<Produto> findByProductIdentifier(@PathVariable String productIdentifier) {
        return produtoRepository.findByProductIdentifier(productIdentifier)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
