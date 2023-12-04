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
import ucan.edu.HistoricoMedico.entities.Exame;
import ucan.edu.HistoricoMedico.entities.TipoSanguineo;
import ucan.edu.HistoricoMedico.https.utils.ResponseBody;
import ucan.edu.HistoricoMedico.services.implementados.ExameServiceImpl;
import ucan.edu.HistoricoMedico.services.implementados.TipoSanguineoServiceImpl;

/**
 *
 * @author jussyleitecode
 */
@RestController
@RequestMapping("/exame")
public class ExameController extends BaseController
{

    @Autowired
    ExameServiceImpl exameServiceImpl;

    @GetMapping
    public ResponseEntity<ResponseBody> findAllExame()
    {
        List<Exame> lista = exameServiceImpl.findAll();
        return this.ok("Exame encontrados com sucesso!", lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> obter(@PathVariable Integer id)
    {
        Optional<Exame> exame = this.exameServiceImpl.findById(id);
        if (exame.isPresent())
        {
            return this.ok("Exame encontrado com sucesso.", exame.get());
        }
        return this.naoEncontrado("Exame não encontrado", null);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody Exame exame)
    {
        return this.created("Exame adicionado com sucesso.", this.exameServiceImpl.criar(exame));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Integer id)
    {
        return this.ok("Exame eliminado com sucesso.", this.exameServiceImpl.eliminar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Integer id, @RequestBody Exame exame)
    {
        return this.ok("Exame editado com sucesso.", (Exame) exameServiceImpl.editar(id, exame));
    }
}
