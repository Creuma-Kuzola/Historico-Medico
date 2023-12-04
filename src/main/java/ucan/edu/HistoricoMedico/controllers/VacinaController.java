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
import ucan.edu.HistoricoMedico.entities.Cirurgia;
import ucan.edu.HistoricoMedico.entities.Consulta;
import ucan.edu.HistoricoMedico.entities.Vacina;
import ucan.edu.HistoricoMedico.https.utils.ResponseBody;
import ucan.edu.HistoricoMedico.services.implementados.CirurgiaServiceImpl;
import ucan.edu.HistoricoMedico.services.implementados.ConsultaServiceImpl;
import ucan.edu.HistoricoMedico.services.implementados.VacinaServiceImpl;

/**
 *
 * @author jussyleitecode
 */
@RestController
@RequestMapping("/vacina")
public class VacinaController extends BaseController
{
    @Autowired
    VacinaServiceImpl vacinaServiceImpl;

    @GetMapping
    public ResponseEntity<ResponseBody> findAllExame()
    {
        List<Vacina> lista = vacinaServiceImpl.findAll();
        return this.ok("Vacina encontradas com sucesso!", lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> obter(@PathVariable Integer id)
    {
        Optional<Vacina> consulta = this.vacinaServiceImpl.findById(id);
        if (consulta.isPresent())
        {
            return this.ok("Vacina encontrada com sucesso.", consulta.get());
        }
        return this.naoEncontrado("Vacina não encontrado", null);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody Vacina vacina)
    {
        return this.created("Vacina adicionada com sucesso.", this.vacinaServiceImpl.criar(vacina));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Integer id)
    {
        return this.ok("Vacina eliminada com sucesso.", this.vacinaServiceImpl.eliminar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Integer id, @RequestBody Vacina vacina)
    {
        return this.ok("Vacina editado com sucesso.", (Vacina) vacinaServiceImpl.editar(id, vacina));
    }
}
