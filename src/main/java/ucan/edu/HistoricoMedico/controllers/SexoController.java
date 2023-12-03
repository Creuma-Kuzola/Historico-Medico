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
import ucan.edu.HistoricoMedico.entities.Sexo;
import ucan.edu.HistoricoMedico.https.utils.ResponseBody;
import ucan.edu.HistoricoMedico.services.implementados.SexoServiceImpl;

/**
 *
 * @author creuma
 */
@RestController
@RequestMapping("/sexo")
public class SexoController extends BaseController {

    @Autowired
    SexoServiceImpl sexoServiceImpl;

    @GetMapping
    public ResponseEntity<ResponseBody> findAll() {
        return this.ok("Sexos listados com sucesso.", this.sexoServiceImpl.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> findById(@PathVariable("id") Integer id){
        Optional<Sexo> sexo = this.sexoServiceImpl.findById(id);
        if ( sexo.isPresent() )
            return this.ok("Sexo encontrado com sucesso.", sexo.get());
        return this.naoEncontrado("Sexo não encontrado", null);
    }
    
    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody Sexo sexo) {
        return this.created("Sexo adicionado com sucesso.", this.sexoServiceImpl.criar(sexo) );
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Integer id) {
        return this.ok("Sexo eliminado com sucesso.", this.sexoServiceImpl.eliminar(id) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Integer id, @RequestBody Sexo sexo) {
        return this.ok("Sexo editado com sucesso.", (Sexo) sexoServiceImpl.editar(id, sexo));
    }

}
