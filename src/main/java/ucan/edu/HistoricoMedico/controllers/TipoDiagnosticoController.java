/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.controllers;

import java.util.List;
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
import ucan.edu.HistoricoMedico.entities.TipoDiagnostico;
import ucan.edu.HistoricoMedico.https.utils.ResponseBody;
import ucan.edu.HistoricoMedico.services.implementados.TipoDiagnosticoServiceImpl;

/**
 *
 * @author jussyleitecode
 */
@RestController
@RequestMapping("/tipoDiagnostico")
public class TipoDiagnosticoController extends BaseController
{

    @Autowired
    TipoDiagnosticoServiceImpl tipoDiagnosticoServiceImpl;

    @GetMapping
    public ResponseEntity<ResponseBody> findAllTipoSanguineo()
    {
        List<TipoDiagnostico> lista = tipoDiagnosticoServiceImpl.findAll();
        return this.ok("Tipo diagnostico encontrados com sucesso!", lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> obter(@PathVariable Integer id)
    {
        Optional<TipoDiagnostico> tipoDiagnostico = this.tipoDiagnosticoServiceImpl.findById(id);
        if (tipoDiagnostico.isPresent())
        {
            return this.ok("TipoDiagnostico encontrado com sucesso.", tipoDiagnostico.get());
        }
        return this.naoEncontrado("TipoDiagnostico não encontrado", null);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody TipoDiagnostico tipoDiagnostico)
    {
        return this.created("TipoDiagnostico adicionado com sucesso.", this.tipoDiagnosticoServiceImpl.criar(tipoDiagnostico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Integer id)
    {
        return this.ok("TipoDiagnostico eliminado com sucesso.", this.tipoDiagnosticoServiceImpl.eliminar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Integer id, @RequestBody TipoDiagnostico TipoDiagnostico)
    {
        return this.ok("tipoSanguineo editado com sucesso.", (TipoDiagnostico) tipoDiagnosticoServiceImpl.editar(id, TipoDiagnostico));
    }
}
