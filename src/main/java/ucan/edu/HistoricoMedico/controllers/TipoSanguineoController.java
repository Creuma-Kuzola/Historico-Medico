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
import ucan.edu.HistoricoMedico.entities.TipoSanguineo;
import ucan.edu.HistoricoMedico.https.utils.ResponseBody;
import ucan.edu.HistoricoMedico.services.implementados.TipoSanguineoServiceImpl;

/**
 *
 * @author jussyleitecode
 */
@RestController
@RequestMapping("/tipoSanguineo")
public class TipoSanguineoController extends BaseController
{

    @Autowired
    TipoSanguineoServiceImpl tipoSanguineoServiceImpl;

    @GetMapping
    public ResponseEntity<ResponseBody> findAllTipoSanguineo()
    {
        List<TipoSanguineo> lista = tipoSanguineoServiceImpl.findAll();
        return this.ok("Tipo sanguineo encontrados com sucesso!", lista);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> obter(@PathVariable Integer id) 
    {
        Optional<TipoSanguineo> tipoSanguineo = this.tipoSanguineoServiceImpl.findById(id);
        if ( tipoSanguineo.isPresent() )
            return this.ok("tipoSanguineo encontrado com sucesso.", tipoSanguineo.get());
        return this.naoEncontrado("tipoSanguineo não encontrado", null);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody TipoSanguineo tipoSanguineo) {
        return this.created("tipoSanguineo adicionado com sucesso.", this.tipoSanguineoServiceImpl.criar(tipoSanguineo) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Integer id) {
        return this.ok("tipoSanguineo eliminado com sucesso.", this.tipoSanguineoServiceImpl.eliminar(id) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Integer id, @RequestBody TipoSanguineo tipoSanguineo) {
        return this.ok("tipoSanguineo editado com sucesso.", (TipoSanguineo) tipoSanguineoServiceImpl.editar(id, tipoSanguineo));
    }
}
