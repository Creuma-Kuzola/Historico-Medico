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
import ucan.edu.HistoricoMedico.entities.ContactoDeEmergenciaPaciente;
import ucan.edu.HistoricoMedico.https.utils.ResponseBody;
import ucan.edu.HistoricoMedico.services.implementados.ContactoDeEmergenciaPacienteServiceImpl;

/**
 *
 * @author creuma
 */
@RestController
@RequestMapping("/contactoDeEmergenciaPaciente")
public class ContactoDeEmergenciaPacienteController extends BaseController{
    
    @Autowired
    ContactoDeEmergenciaPacienteServiceImpl contactoDeEmergenciaPacienteServiceImpl;
    
    @GetMapping
    public ResponseEntity<ResponseBody> findAll() {
        return this.ok("Contactos de Emergência listados com sucesso.", this.contactoDeEmergenciaPacienteServiceImpl.findAll());
    }
    
    @GetMapping("/findAll/{fkPaciente}")
    public ResponseEntity<ResponseBody> findContactoDeEmergenciaPacienteByPkPaciente(@PathVariable("fkPaciente") Integer fkPaciente) {
        return this.ok("Contactos de Emergência listados com sucesso.", this.contactoDeEmergenciaPacienteServiceImpl.findContactoEmergenciaPacienteByPkPaciente(fkPaciente));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> findById(@PathVariable("id") Integer id){
        Optional<ContactoDeEmergenciaPaciente> contactoDeEmergencia = this.contactoDeEmergenciaPacienteServiceImpl.findById(id);
        if ( contactoDeEmergencia.isPresent() )
            return this.ok("Contacto de Emergência Paciente encontrado com sucesso.", contactoDeEmergencia.get());
        return this.naoEncontrado("Contacto de Emergência Paciente não encontrado", null);
    }
    
    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody ContactoDeEmergenciaPaciente contactoDeEmergenciaPaciente) {
        return this.created("Contacto de Emergência Paciente adicionado com sucesso.", this.contactoDeEmergenciaPacienteServiceImpl.criar(contactoDeEmergenciaPaciente) );
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Integer id) {
        return this.ok("Contacto de Emergência Paciente eliminado com sucesso.", this.contactoDeEmergenciaPacienteServiceImpl.eliminar(id) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Integer id, @RequestBody ContactoDeEmergenciaPaciente contactoDeEmergenciaPaciente) {
        return this.ok("Contacto de Emergência Paciente editado com sucesso.", (ContactoDeEmergenciaPaciente) contactoDeEmergenciaPacienteServiceImpl.editar(id, contactoDeEmergenciaPaciente));
    }

}
