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
import ucan.edu.HistoricoMedico.entities.TipoConsulta;
import ucan.edu.HistoricoMedico.entities.TipoSanguineo;
import ucan.edu.HistoricoMedico.https.utils.ResponseBody;
import ucan.edu.HistoricoMedico.services.implementados.TipoConsultaServiceImpl;
import ucan.edu.HistoricoMedico.services.implementados.TipoSanguineoServiceImpl;

/**
 *
 * @author jussyleitecode
 */
@RestController
@RequestMapping("/tipoConsulta")
public class TipoConsultaController extends BaseController
{

    @Autowired
    TipoConsultaServiceImpl tipoConsultaServiceImpl;

    @GetMapping
    public ResponseEntity<ResponseBody> findAllConsulta()
    {
        List<TipoConsulta> lista = tipoConsultaServiceImpl.findAll();
        return this.ok("TipoConsulta encontrados com sucesso!", lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> obter(@PathVariable Integer id)
    {
        Optional<TipoConsulta> tipoConsulta = this.tipoConsultaServiceImpl.findById(id);
        if (tipoConsulta.isPresent())
        {
            return this.ok("TipoConsulta encontrado com sucesso.", tipoConsulta.get());
        }
        return this.naoEncontrado("TipoConsulta não encontrado", null);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody TipoConsulta tipoConsulta)
    {
        return this.created("TipoConsulta adicionado com sucesso.", this.tipoConsultaServiceImpl.criar(tipoConsulta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Integer id)
    {
        return this.ok("TipoConsulta eliminado com sucesso.", this.tipoConsultaServiceImpl.eliminar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Integer id, @RequestBody TipoConsulta tipoConsulta)
    {
        return this.ok("tipoSanguineo editado com sucesso.", (TipoConsulta) tipoConsultaServiceImpl.editar(id, tipoConsulta));
    }
}
