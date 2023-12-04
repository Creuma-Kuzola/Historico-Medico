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
import ucan.edu.HistoricoMedico.entities.SintomaDoenca;
import ucan.edu.HistoricoMedico.https.utils.ResponseBody;
import ucan.edu.HistoricoMedico.services.implementados.SintomaDoencaServiceImpl;

/**
 *
 * @author jussyleitecode
 */
@RestController
@RequestMapping("/sintomaDoenca")
public class SintomaDoencaController extends BaseController
{

    @Autowired
    SintomaDoencaServiceImpl sintomaDoencaServiceImpl;

    @GetMapping
    public ResponseEntity<ResponseBody> findAllExame()
    {
        List<SintomaDoenca> lista = sintomaDoencaServiceImpl.findAll();
        return this.ok("SintomaDoenca encontrados com sucesso!", lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> obter(@PathVariable Integer id)
    {
        Optional<SintomaDoenca> sintomaDoenca = this.sintomaDoencaServiceImpl.findById(id);
        if (sintomaDoenca.isPresent())
        {
            return this.ok("SintomaDoenca encontrado com sucesso.", sintomaDoenca.get());
        }
        return this.naoEncontrado("SintomaDoenca não encontrado", null);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody SintomaDoenca sintomaDoenca)
    {
        return this.created("SintomaDoenca adicionado com sucesso.", this.sintomaDoencaServiceImpl.criar(sintomaDoenca));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Integer id)
    {
        return this.ok("SintomaDoenca eliminado com sucesso.", this.sintomaDoencaServiceImpl.eliminar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Integer id, @RequestBody SintomaDoenca sintomaDoenca)
    {
        return this.ok("SintomaDoenca editado com sucesso.", (SintomaDoenca) sintomaDoencaServiceImpl.editar(id, sintomaDoenca));
    }
}
