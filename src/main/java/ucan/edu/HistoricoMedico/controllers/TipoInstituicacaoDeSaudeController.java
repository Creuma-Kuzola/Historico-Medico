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
import ucan.edu.HistoricoMedico.entities.TipoInstituicacaoDeSaude;
import ucan.edu.HistoricoMedico.https.utils.ResponseBody;
import ucan.edu.HistoricoMedico.services.implementados.TipoInstituicaoDeSaudeServiceImpl;

/**
 *
 * @author jussyleitecode
 */
@RestController
@RequestMapping("/tipoInstituicacaoDeSaude")
public class TipoInstituicacaoDeSaudeController extends BaseController
{

    @Autowired
    TipoInstituicaoDeSaudeServiceImpl tipoInstituicaoDeSaudeServiceImpl;

    @GetMapping
    public ResponseEntity<ResponseBody> findAllTipoSanguineo()
    {
        List<TipoInstituicacaoDeSaude> lista = tipoInstituicaoDeSaudeServiceImpl.findAll();
        return this.ok("Tipo instituição encontrada com sucesso!", lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> obter(@PathVariable Integer id)
    {
        Optional<TipoInstituicacaoDeSaude> tipoInstituicacaoDeSaude = this.tipoInstituicaoDeSaudeServiceImpl.findById(id);
        if (tipoInstituicacaoDeSaude.isPresent())
        {
            return this.ok("TipoInstituicacaoDeSaude encontrado com sucesso.", tipoInstituicacaoDeSaude.get());
        }
        return this.naoEncontrado("TipoInstituicacaoDeSaude não encontrado", null);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody TipoInstituicacaoDeSaude tipoInstituicacaoDeSaude)
    {
        return this.created("TipoInstituicacaoDeSaude adicionada com sucesso.", this.tipoInstituicaoDeSaudeServiceImpl.criar(tipoInstituicacaoDeSaude));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Integer id)
    {
        return this.ok("TipoInstituicacaoDeSaude eliminado com sucesso.", this.tipoInstituicaoDeSaudeServiceImpl.eliminar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Integer id, @RequestBody TipoInstituicacaoDeSaude tipoInstituicacaoDeSaude)
    {
        return this.ok("TipoInstituicacaoDeSaude editado com sucesso.", (TipoInstituicacaoDeSaude) tipoInstituicaoDeSaudeServiceImpl.editar(id, tipoInstituicacaoDeSaude));
    }
}
