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
import ucan.edu.HistoricoMedico.entities.Medico;
import ucan.edu.HistoricoMedico.https.utils.ResponseBody;
import ucan.edu.HistoricoMedico.services.implementados.MedicoServiceImpl;

/**
 *
 * @author creuma
 */
@RestController
@RequestMapping("/medico")
public class MedicoController extends BaseController{
    
    @Autowired
    MedicoServiceImpl medicoServiceImpl;
    
    @GetMapping
    public ResponseEntity<ResponseBody> findAll() {
        return this.ok("Medicos listados com sucesso.", this.medicoServiceImpl.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> findById(@PathVariable("id") Integer id){
        Optional<Medico> medico = this.medicoServiceImpl.findById(id);
        if ( medico.isPresent() )
            return this.ok("Medico encontrado com sucesso.", medico.get());
        return this.naoEncontrado("Medico não encontrado", null);
    }
    
    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody Medico medico) {
        return this.created("Medico adicionado com sucesso.", this.medicoServiceImpl.criar(medico) );
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Integer id) {
        return this.ok("Medico eliminado com sucesso.", this.medicoServiceImpl.eliminar(id) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Integer id, @RequestBody Medico medico) {
        return this.ok("Paciente editado com sucesso.", (Medico) medicoServiceImpl.editar(id, medico));
    }

    
}
