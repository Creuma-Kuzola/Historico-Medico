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
import ucan.edu.HistoricoMedico.entities.Cirurgia;
import ucan.edu.HistoricoMedico.entities.Consulta;
import ucan.edu.HistoricoMedico.https.utils.ResponseBody;
import ucan.edu.HistoricoMedico.services.implementados.CirurgiaServiceImpl;
import ucan.edu.HistoricoMedico.services.implementados.ConsultaServiceImpl;

/**
 *
 * @author jussyleitecode
 */
@RestController
@RequestMapping("/cirurgia")
public class CirurgiaController extends BaseController
{
    @Autowired
    CirurgiaServiceImpl cirurgiaServiceImpl;

    @GetMapping
    public ResponseEntity<ResponseBody> findAllExame()
    {
        List<Cirurgia> lista = cirurgiaServiceImpl.findAll();
        return this.ok("Cirurgia encontrados com sucesso!", lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> obter(@PathVariable Integer id)
    {
        Optional<Cirurgia> consulta = this.cirurgiaServiceImpl.findById(id);
        if (consulta.isPresent())
        {
            return this.ok("Cirurgia encontrado com sucesso.", consulta.get());
        }
        return this.naoEncontrado("Cirurgia não encontrado", null);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody Cirurgia cirurgia)
    {
        return this.created("Cirurgia adicionado com sucesso.", this.cirurgiaServiceImpl.criar(cirurgia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Integer id)
    {
        return this.ok("Cirurgia eliminado com sucesso.", this.cirurgiaServiceImpl.eliminar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Integer id, @RequestBody Cirurgia cirurgia)
    {
        return this.ok("Cirurgia editado com sucesso.", (Cirurgia) cirurgiaServiceImpl.editar(id, cirurgia));
    }
}
