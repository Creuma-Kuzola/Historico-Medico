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
import ucan.edu.HistoricoMedico.entities.Exame;
import ucan.edu.HistoricoMedico.entities.ExameConsulta;
import ucan.edu.HistoricoMedico.entities.TipoSanguineo;
import ucan.edu.HistoricoMedico.https.utils.ResponseBody;
import ucan.edu.HistoricoMedico.services.implementados.ConsultaServiceImpl;
import ucan.edu.HistoricoMedico.services.implementados.ExameConsultaServiceImpl;
import ucan.edu.HistoricoMedico.services.implementados.ExameServiceImpl;
import ucan.edu.HistoricoMedico.services.implementados.TipoSanguineoServiceImpl;

/**
 *
 * @author jussyleitecode
 */
@RestController
@RequestMapping("/exameConsulta")
public class ExameConsultaController extends BaseController
{

    @Autowired
    ExameConsultaServiceImpl exameConsultaServiceImpl;

    @GetMapping
    public ResponseEntity<ResponseBody> findAllExame()
    {
        List<ExameConsulta> lista = exameConsultaServiceImpl.findAll();
        return this.ok("ExameConsulta encontrados com sucesso!", lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> obter(@PathVariable Integer id)
    {
        Optional<ExameConsulta> consulta = this.exameConsultaServiceImpl.findById(id);
        if (consulta.isPresent())
        {
            return this.ok("ExameConsulta encontrado com sucesso.", consulta.get());
        }
        return this.naoEncontrado("ExameConsulta não encontrado", null);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody ExameConsulta exameConsulta)
    {
        return this.created("ExameConsulta adicionado com sucesso.", this.exameConsultaServiceImpl.criar(exameConsulta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Integer id)
    {
        return this.ok("ExameConsulta eliminado com sucesso.", this.exameConsultaServiceImpl.eliminar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Integer id, @RequestBody ExameConsulta exameConsulta)
    {
        return this.ok("ExameConsulta editado com sucesso.", (ExameConsulta) exameConsultaServiceImpl.editar(id, exameConsulta));
    }
}
