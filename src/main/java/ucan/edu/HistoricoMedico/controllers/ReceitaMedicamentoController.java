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
import ucan.edu.HistoricoMedico.entities.ReceitaMedicamento;
import ucan.edu.HistoricoMedico.entities.ReceitaMedicamento;
import ucan.edu.HistoricoMedico.https.utils.ResponseBody;
import ucan.edu.HistoricoMedico.services.implementados.ReceitaMedicamentoServiceImpl;

/**
 *
 * @author creuma
 */
@RestController
@RequestMapping("/receitaMedicamento")
public class ReceitaMedicamentoController extends BaseController {

    @Autowired
    ReceitaMedicamentoServiceImpl receitaMedicamentoServiceImpl;

    @GetMapping("/findAll/{fkPaciente}")
    public ResponseEntity<ResponseBody> findAllReceitasByPaciente(@PathVariable("fkPaciente") Integer fkPaciente) {
        return this.ok("ReceitaMedicamentos listados com sucesso.", this.receitaMedicamentoServiceImpl.findReceitaByPkPaciente(2));
    }

    @GetMapping
    public ResponseEntity<ResponseBody> findAll() {
        return this.ok("ReceitaMedicamentos listados com sucesso.", this.receitaMedicamentoServiceImpl.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> findById(@PathVariable("id") Integer id) {
        Optional<ReceitaMedicamento> receitaMedicamento = this.receitaMedicamentoServiceImpl.findById(id);
        if (receitaMedicamento.isPresent()) {
            return this.ok("ReceitaMedicamento encontrado com sucesso.", receitaMedicamento.get());
        }
        return this.naoEncontrado("ReceitaMedicamento não encontrado", null);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody ReceitaMedicamento ReceitaMedicamento) {
        return this.created("ReceitaMedicamento adicionado com sucesso.", this.receitaMedicamentoServiceImpl.criar(ReceitaMedicamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Integer id) {
        return this.ok("ReceitaMedicamento eliminado com sucesso.", this.receitaMedicamentoServiceImpl.eliminar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Integer id, @RequestBody ReceitaMedicamento ReceitaMedicamento) {
        return this.ok("ReceitaMedicamento editado com sucesso.", (ReceitaMedicamento) receitaMedicamentoServiceImpl.editar(id, ReceitaMedicamento));
    }

}
