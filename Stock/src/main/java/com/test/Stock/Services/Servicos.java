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
    private static final Map<Long, Produto> guardados = new HashMap<>();
    Produto produto;

        public Produto cadastrar(Produto produto){
        long proximoId = cadastro.keySet().size() + 1L;
        produto.setId(proximoId);
        cadastro.put(proximoId, produto);
        return produto;
        }
        public Produto atualizar(Produto produto, Long produtoId){
        if(cadastro.containsKey(produtoId)){
        produto.setId(produtoId);
        cadastro.put(produtoId, produto);
            return produto;
            }
            return null;
        }
        public String armazenar(){
            guardados.putAll(cadastro);
            guardados.get(cadastro.values());
            cadastro.clear();
            return "ITENS ENVIADOS PARA A LISTA GUARDADOS";
        }
        public String armazenarId(Long produtoId){
            produto = cadastro.get(produtoId);
            guardados.put(produtoId, produto);
            cadastro.remove(produtoId);
            return "ITEM ARMAZENADO NA LISTA GUARDADOS";
        }
        public List<Produto> armazenados(Produto produto){
        return new ArrayList<>(guardados.values());
        }
        public Produto getById(Long produtoId){
            return cadastro.get(produtoId);
        }
        public List<Produto> getAll(){
            return new ArrayList<>(cadastro.values());
        }
        public String delete(Long produtoId){
            cadastro.remove(produtoId);
            return "DELETED";
        }
        public Map<Long, Produto> getGuardados(){
            return guardados;
        }
}

