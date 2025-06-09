package com.test.Stock.Warehouse;

import com.test.Stock.Product.Produto;
import com.test.Stock.Services.Servicos;

import java.util.HashMap;
import java.util.Map;

public class Armazem {

    private static final Map<Long, Produto> guardados = new HashMap<>();
    private static final String resposta = "ARMAZEM VAZIO";

    public void Armazenar(Servicos cadastrar){
        guardados.putAll(cadastrar.getCadastro());
    }

    public Map<Long, Produto> getGuardados(){
        return guardados;
    }

    public void MostrarArmazem(){
        if(guardados.isEmpty()){
            System.out.println("ARMAZÉM VAZIO");
        } else {
            guardados.forEach((id, produto) -> {
                System.out.println("ID: " + produto.getId() +
                                    "NOME: " + produto.getNome() +
                                    "CATEGORIA: " + produto.getCategoria() +
                                    "QUANTIDADE: " + produto.getQuantidade());
            });
        }
    }
}
