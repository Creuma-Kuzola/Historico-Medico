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
import org.springframework.web.servlet.function.EntityResponse;
import ucan.edu.HistoricoMedico.entities.Consulta;
import ucan.edu.HistoricoMedico.entities.Diagnostico;
import ucan.edu.HistoricoMedico.entities.Exame;
import ucan.edu.HistoricoMedico.entities.TipoSanguineo;
import ucan.edu.HistoricoMedico.https.utils.ResponseBody;
import ucan.edu.HistoricoMedico.services.implementados.ConsultaServiceImpl;
import ucan.edu.HistoricoMedico.services.implementados.DiagnosticoServiceImpl;
import ucan.edu.HistoricoMedico.services.implementados.ExameServiceImpl;
import ucan.edu.HistoricoMedico.services.implementados.TipoSanguineoServiceImpl;

/**
 *
 * @author jussyleitecode
 */
@RestController
@RequestMapping("/diagnostico")
public class DiagnosticoController extends BaseController
{

    @Autowired
    DiagnosticoServiceImpl diagnosticoServiceImpl;

    @GetMapping
    public ResponseEntity<ResponseBody> findAllExame()
    {
        List<Diagnostico> lista = diagnosticoServiceImpl.findAll();
        return this.ok("Diagnostico encontrados com sucesso!", lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> obter(@PathVariable Integer id)
    {
        Optional<Diagnostico> diagnostico = this.diagnosticoServiceImpl.findById(id);
        if (diagnostico.isPresent())
        {
            return this.ok("Diagnostico encontrado com sucesso.", diagnostico.get());
        }
        return this.naoEncontrado("Diagnostico não encontrado", null);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody Diagnostico diagnostico)
    {
        return this.created("Diagnostico adicionado com sucesso.", this.diagnosticoServiceImpl.criar(diagnostico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Integer id)
    {
        return this.ok("Diagnostico eliminado com sucesso.", this.diagnosticoServiceImpl.eliminar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Integer id, @RequestBody Diagnostico diagnostico)
    {
        return this.ok("Diagnostico editado com sucesso.", (Diagnostico) diagnosticoServiceImpl.editar(id, diagnostico));
    }
}
