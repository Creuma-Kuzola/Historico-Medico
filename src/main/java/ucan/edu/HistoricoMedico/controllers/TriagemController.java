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
import org.springframework.web.servlet.function.EntityResponse;
import ucan.edu.HistoricoMedico.entities.Consulta;
import ucan.edu.HistoricoMedico.entities.Exame;
import ucan.edu.HistoricoMedico.entities.TipoSanguineo;
import ucan.edu.HistoricoMedico.entities.Triagem;
import ucan.edu.HistoricoMedico.https.utils.ResponseBody;
import ucan.edu.HistoricoMedico.services.implementados.ConsultaServiceImpl;
import ucan.edu.HistoricoMedico.services.implementados.ExameServiceImpl;
import ucan.edu.HistoricoMedico.services.implementados.TipoSanguineoServiceImpl;
import ucan.edu.HistoricoMedico.services.implementados.TriagemServiceImpl;

/**
 *
 * @author jussyleitecode
 */
@RestController
@RequestMapping("/triagem")
public class TriagemController extends BaseController
{

    @Autowired
    TriagemServiceImpl triagemServiceImpl;

    @GetMapping
    public ResponseEntity<ResponseBody> findAllExame()
    {
        List<Triagem> lista = triagemServiceImpl.findAll();
        return this.ok("Triagem encontrados com sucesso!", lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> obter(@PathVariable Integer id)
    {
        Optional<Triagem> triagem = this.triagemServiceImpl.findById(id);
        if (triagem.isPresent())
        {
            return this.ok("Triagem encontrado com sucesso.", triagem.get());
        }
        return this.naoEncontrado("Triagem não encontrado", null);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody Triagem triagem)
    {
        return this.created("Triagem adicionada com sucesso.", this.triagemServiceImpl.criar(triagem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Integer id)
    {
        return this.ok("Triagem eliminado com sucesso.", this.triagemServiceImpl.eliminar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Integer id, @RequestBody Triagem triagem)
    {
        return this.ok("Triagem editado com sucesso.", (Triagem) triagemServiceImpl.editar(id, triagem));
    }
}
