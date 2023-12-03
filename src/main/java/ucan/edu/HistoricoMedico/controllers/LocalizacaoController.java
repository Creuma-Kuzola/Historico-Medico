/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ucan.edu.HistoricoMedico.entities.Localizacao;
import ucan.edu.HistoricoMedico.https.utils.ResponseBody;
import ucan.edu.HistoricoMedico.services.LocalizacaoService;
import ucan.edu.HistoricoMedico.services.implementados.LocalizacaoServiceImpl;


/**
 *
 * @author jussyleitecode
 */
@RestController
@RequestMapping("/localizacao")
public class LocalizacaoController extends BaseController
{

    @Autowired
    LocalizacaoServiceImpl localzaccaoServiceImpl;
   
    @GetMapping 
    public ResponseEntity<ResponseBody> carregarTodasLocalizacao()
    {
        List<Localizacao> lista = localzaccaoServiceImpl.findAllLocalicao();
        return this.ok("Pacientes Listados com sucesso.", localzaccaoServiceImpl.findAllLocalicao());
    }

}
