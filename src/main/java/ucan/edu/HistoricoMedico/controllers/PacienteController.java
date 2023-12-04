/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
import ucan.edu.HistoricoMedico.entities.Paciente;
import ucan.edu.HistoricoMedico.https.utils.ResponseBody;
import ucan.edu.HistoricoMedico.services.implementados.PacienteServiceImpl;
/**
 *
 * @author jussyleitecode
 */
@RestController
@RequestMapping("/paciente")
public class PacienteController extends BaseController
{

    @Autowired
    PacienteServiceImpl pacienteServiceImpl;

    @GetMapping
    public ResponseEntity<ResponseBody> findAllExame()
    {
        List<Paciente> lista = pacienteServiceImpl.findAll();
        return this.ok("Paciente encontrados com sucesso!", lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> obter(@PathVariable Integer id)
    {
        Optional<Paciente> exame = this.pacienteServiceImpl.findById(id);
        if (exame.isPresent())
        {
            return this.ok("Paciente encontrado com sucesso.", exame.get());
        }
        return this.naoEncontrado("Paciente não encontrado", null);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody Paciente paciente)
    {
        return this.created("Paciente adicionado com sucesso.", this.pacienteServiceImpl.criar(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Integer id)
    {
        return this.ok("Paciente eliminado com sucesso.", this.pacienteServiceImpl.eliminar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Integer id, @RequestBody Paciente paciente)
    {
        return this.ok("Exame editado com sucesso.", (Paciente) pacienteServiceImpl.editar(id, paciente));
    }
}
