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
import ucan.edu.HistoricoMedico.entities.ItemAlergico;
import ucan.edu.HistoricoMedico.https.utils.ResponseBody;
import ucan.edu.HistoricoMedico.services.implementados.ItemAlergicoServiceImpl;

/**
 *
 * @author jussyleitecode
 */
@RestController
@RequestMapping("/itemAlergico")
public class ItemAlergicoController extends BaseController
{
    @Autowired
    ItemAlergicoServiceImpl itemAlergicoServiceImpl;

    @GetMapping
    public ResponseEntity<ResponseBody> findAllExame()
    {
        List<ItemAlergico> lista = itemAlergicoServiceImpl.findAll();
        return this.ok("ItemAlergico encontrados com sucesso!", lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> obter(@PathVariable Integer id)
    {
        Optional<ItemAlergico> itemAlergico = this.itemAlergicoServiceImpl.findById(id);
        if (itemAlergico.isPresent())
        {
            return this.ok("ItemAlergico encontrado com sucesso.", itemAlergico.get());
        }
        return this.naoEncontrado("ItemAlergico não encontrado", null);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody ItemAlergico itemAlergico)
    {
        return this.created("ItemAlergico adicionado com sucesso.", this.itemAlergicoServiceImpl.criar(itemAlergico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Integer id)
    {
        return this.ok("ItemAlergico eliminado com sucesso.", this.itemAlergicoServiceImpl.eliminar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Integer id, @RequestBody ItemAlergico itemAlergico)
    {
        return this.ok("Cirurgia editado com sucesso.", (ItemAlergico) itemAlergicoServiceImpl.editar(id, itemAlergico));
    }
}
