package com.test.Stock.API;

import com.test.Stock.Product.Produto;
import com.test.Stock.Services.Servicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


//Controlador
@Controller
@RequestMapping(value = "/stock", produces = MediaType.APPLICATION_JSON_VALUE)
public class API {

    //Objetos
    @Autowired
    private Servicos servicos;

    //METODOS POST
    @PostMapping
    @ResponseBody
    public Produto postar(@RequestBody Produto cadastrar){
        return servicos.cadastrar(cadastrar);
    }

    //METODOS GET
    @GetMapping
    @ResponseBody
    public List<Produto> getAll(){
        return servicos.getAll();
    }
    @GetMapping("/ID/{produtoId}")
    @ResponseBody
    public Produto porId(@PathVariable("produtoId") Long produtoId,
                         @RequestBody Produto produto){
        return servicos.getById(produtoId);
    }
    @GetMapping("/guardados")
    @ResponseBody
    public List<Produto> armazenados(Produto produtoId){
        return servicos.armazenados(produtoId);
    }
    //METODOS PUT
    @PutMapping("/{produtoId}")
    @ResponseBody
    public Produto atualizar(@PathVariable("produtoId") Long produtoId,
                             @RequestBody Produto produto){
        return servicos.atualizar(produto, produtoId);
    }
    @PutMapping("/enviar")
    @ResponseBody
    public String enviar(){
        return servicos.armazenar();
    }
    @PutMapping("/enviar/{produtoId}")
    @ResponseBody
    public String enviarId(@PathVariable Long produtoId){
        return servicos.armazenarId(produtoId);
    }
    //METODOS DELETE
    @DeleteMapping("/{produtoId}")
    @ResponseBody
    public String deletar(@PathVariable("produtoId") Long produtoId){
        return servicos.delete(produtoId);
    }
    //Controller da página HTML
    @Controller
    public class PaginaController{
        @GetMapping("/index")
        public String index(){
            return "index";
        }
    }
}
