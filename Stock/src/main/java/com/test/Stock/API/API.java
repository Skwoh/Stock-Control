package com.test.Stock.API;

import com.test.Stock.Product.Produto;
import com.test.Stock.Services.Servicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/stock", produces = MediaType.APPLICATION_JSON_VALUE)
public class API {
    @Autowired
    private Servicos servicos;

    @PostMapping
    @ResponseBody
    public Produto criar(@RequestBody Produto cadastrar){
        return servicos.cadastrar(cadastrar);
    }

    @PutMapping("{produtoId}")
    @ResponseBody
    public Produto atualizar(@PathVariable("produtoId") Long produtoId,
                             @RequestBody Produto produto){
        return servicos.atualizar(produto, produtoId);
    }

    @GetMapping
    @ResponseBody
    public List<Produto> getAll(){
        return servicos.getAll();
    }

    @DeleteMapping("/{produtoId}")
    @ResponseBody
    public String deletar(@PathVariable("produtoId") Long produtoId){
        return servicos.delete(produtoId);
    }
}
