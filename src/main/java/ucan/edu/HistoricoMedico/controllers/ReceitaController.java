/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ucan.edu.HistoricoMedico.entities.Receita;
import ucan.edu.HistoricoMedico.https.utils.ResponseBody;
import ucan.edu.HistoricoMedico.services.implementados.ReceitaServiceImpl;

/**
 *
 * @author creuma
 */
@RestController
@RequestMapping("/receita")
public class ReceitaController extends BaseController{
    
    @Autowired
    ReceitaServiceImpl receitaServiceImpl;
    
    @GetMapping
    public ResponseEntity<ResponseBody> findAll() {
        return this.ok("Receitas listados com sucesso.", this.receitaServiceImpl.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> findById(@PathVariable("id") Integer id){
        Optional<Receita> receita = this.receitaServiceImpl.findById(id);
        if ( receita.isPresent() )
            return this.ok("Receita encontrado com sucesso.", receita.get());
        return this.naoEncontrado("Receita não encontrado", null);
    }
    
    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody Receita receita) {
        return this.created("Receita adicionado com sucesso.", this.receitaServiceImpl.criar(receita) );
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Integer id) {
        return this.ok("Receita eliminado com sucesso.", this.receitaServiceImpl.eliminar(id) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Integer id, @RequestBody Receita receita) {
        return this.ok("Receita editado com sucesso.", (Receita) receitaServiceImpl.editar(id, receita));
    }

    
}
