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
import ucan.edu.HistoricoMedico.entities.Medicamento;
import ucan.edu.HistoricoMedico.entities.Medicamento;
import ucan.edu.HistoricoMedico.https.utils.ResponseBody;
import ucan.edu.HistoricoMedico.services.implementados.MedicamentoServiceImpl;

/**
 *
 * @author creuma
 */
@RestController
@RequestMapping("/medicamento")
public class MedicamentoController extends BaseController {
    
    @Autowired
    MedicamentoServiceImpl medicamentoServiceImpl;
    
    @GetMapping
    public ResponseEntity<ResponseBody> findAll() {
        return this.ok("Medicamentos listados com sucesso.", this.medicamentoServiceImpl.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> findById(@PathVariable("id") Integer id){
        Optional<Medicamento> medicamento = this.medicamentoServiceImpl.findById(id);
        if ( medicamento.isPresent() )
            return this.ok("Medicamento encontrado com sucesso.", medicamento.get());
        return this.naoEncontrado("Medicamento não encontrado", null);
    }
    
    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody Medicamento medicamento) {
        return this.created("Medicamento adicionado com sucesso.", this.medicamentoServiceImpl.criar(medicamento) );
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Integer id) {
        return this.ok("Medicamento eliminado com sucesso.", this.medicamentoServiceImpl.eliminar(id) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Integer id, @RequestBody Medicamento medicamento) {
        return this.ok("Medicamento editado com sucesso.", (Medicamento) medicamentoServiceImpl.editar(id, medicamento));
    }

    
}
