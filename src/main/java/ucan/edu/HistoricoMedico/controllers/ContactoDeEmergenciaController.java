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
import ucan.edu.HistoricoMedico.entities.ContactoDeEmergencia;
import ucan.edu.HistoricoMedico.https.utils.ResponseBody;
import ucan.edu.HistoricoMedico.services.implementados.ContactoDeEmergenciaServiceImpl;

/**
 *
 * @author creuma
 */
@RestController
@RequestMapping("/contactoDeEmergencia")
public class ContactoDeEmergenciaController extends BaseController{
    
    @Autowired
    ContactoDeEmergenciaServiceImpl contactoDeEmergenciaServiceImpl;
    
    @GetMapping
    public ResponseEntity<ResponseBody> findAll() {
        return this.ok("Contactos de Emergência listados com sucesso.", this.contactoDeEmergenciaServiceImpl.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> findById(@PathVariable("id") Integer id){
        Optional<ContactoDeEmergencia> contactoDeEmergencia = this.contactoDeEmergenciaServiceImpl.findById(id);
        if ( contactoDeEmergencia.isPresent() )
            return this.ok("Contacto de Emergência encontrado com sucesso.", contactoDeEmergencia.get());
        return this.naoEncontrado("Contacto de Emergência não encontrado", null);
    }
    
    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody ContactoDeEmergencia contactoDeEmergencia) {
        return this.created("Contacto de Emergência adicionado com sucesso.", this.contactoDeEmergenciaServiceImpl.criar(contactoDeEmergencia) );
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Integer id) {
        return this.ok("Contacto de Emergência eliminado com sucesso.", this.contactoDeEmergenciaServiceImpl.eliminar(id) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Integer id, @RequestBody ContactoDeEmergencia contactoDeEmergencia) {
        return this.ok("Contacto de Emergência editado com sucesso.", (ContactoDeEmergencia) contactoDeEmergenciaServiceImpl.editar(id, contactoDeEmergencia));
    }

}
