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
import ucan.edu.HistoricoMedico.entities.GrauDeParentesco;
import ucan.edu.HistoricoMedico.https.utils.ResponseBody;
import ucan.edu.HistoricoMedico.services.implementados.GrauDeParentescoServiceImpl;

/**
 *
 * @author creuma
 */
@RestController
@RequestMapping("/grauDeParentesco")
public class GrauDeParentescoController extends BaseController{
    
    @Autowired
    GrauDeParentescoServiceImpl grauDeParentescoServiceImpl;
    
    @GetMapping
    public ResponseEntity<ResponseBody> findAll() {
        return this.ok("Graus de Parentesco listados com sucesso.", this.grauDeParentescoServiceImpl.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> findById(@PathVariable("id") Integer id){
        Optional<GrauDeParentesco> grauDeParentesco = this.grauDeParentescoServiceImpl.findById(id);
        if ( grauDeParentesco.isPresent() )
            return this.ok("Grau de Parentesco encontrado com sucesso.", grauDeParentesco.get());
        return this.naoEncontrado("Grau de Parentesco não encontrado", null);
    }
    
    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody GrauDeParentesco grauDeParentesco) {
        return this.created("Grau de Parentesco adicionado com sucesso.", this.grauDeParentescoServiceImpl.criar(grauDeParentesco) );
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Integer id) {
        return this.ok("Grau de Parentesco eliminado com sucesso.", this.grauDeParentescoServiceImpl.eliminar(id) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Integer id, @RequestBody GrauDeParentesco grauDeParentesco) {
        return this.ok("Grau de Parentesco editado com sucesso.", (GrauDeParentesco) grauDeParentescoServiceImpl.editar(id, grauDeParentesco));
    }

    
}
