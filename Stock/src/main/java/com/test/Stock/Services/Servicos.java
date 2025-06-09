package com.test.Stock.Services;

import com.test.Stock.Product.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Servicos {

    private static final Map<Long, Produto> cadastro = new HashMap<>();

    public Produto cadastrar(Produto produto){
        long proximoId = cadastro.keySet().size() + 1L;
        produto.setId(proximoId);
        cadastro.put(proximoId, produto);
        return produto;

        }

    public Produto atualizar(Produto produto, long produtoId){
        if(cadastro.containsKey(produtoId)){
        produto.setId(produtoId);
        cadastro.put(produtoId, produto);
            return produto;
            }
            return null;
        }
        public Produto getById(long produtoId){
            return cadastro.get(produtoId);
        }
        public List<Produto> getAll(){
            return new ArrayList<>(cadastro.values());
        }

        public String delete(long produtoId){
            cadastro.remove(produtoId);
            return "DELETED";
        }

        public Map<Long, Produto> getCadastro() {
        return cadastro;
    }

}

