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
import ucan.edu.HistoricoMedico.entities.TipoSanguineo;
import ucan.edu.HistoricoMedico.https.utils.ResponseBody;
import ucan.edu.HistoricoMedico.services.implementados.ConsultaServiceImpl;
import ucan.edu.HistoricoMedico.services.implementados.ExameServiceImpl;
import ucan.edu.HistoricoMedico.services.implementados.TipoSanguineoServiceImpl;

/**
 *
 * @author jussyleitecode
 */
@RestController
@RequestMapping("/consulta")
public class ConsultaController extends BaseController
{

    @Autowired
    ConsultaServiceImpl ConsultaServiceImpl;

    @GetMapping
    public ResponseEntity<ResponseBody> findAllExame()
    {
        List<Consulta> lista = ConsultaServiceImpl.findAll();
        return this.ok("Consulta encontrados com sucesso!", lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> obter(@PathVariable Integer id)
    {
        Optional<Consulta> consulta = this.ConsultaServiceImpl.findById(id);
        if (consulta.isPresent())
        {
            return this.ok("Consulta encontrado com sucesso.", consulta.get());
        }
        return this.naoEncontrado("Consulta não encontrado", null);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody Consulta consulta)
    {
        return this.created("Consulta adicionado com sucesso.", this.ConsultaServiceImpl.criar(consulta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Integer id)
    {
        return this.ok("Consulta eliminado com sucesso.", this.ConsultaServiceImpl.eliminar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Integer id, @RequestBody Consulta consulta)
    {
        return this.ok("Consulta editado com sucesso.", (Consulta) ConsultaServiceImpl.editar(id, consulta));
    }
}
