/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.services.implementados;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucan.edu.HistoricoMedico.entities.Localizacao;
import ucan.edu.HistoricoMedico.repositories.LocalizacaoRepository;
import ucan.edu.HistoricoMedico.services.LocalizacaoService;

/**
 *
 * @author jussyleitecode
 */

@Service
public class LocalizacaoServiceImpl extends AbstractService<Localizacao, String> implements LocalizacaoService<Localizacao, String>
{

    @Autowired
    LocalizacaoRepository localizacaoRepository;
    
    @Override
    public List<Localizacao> findAllLocalicao()
    {
       return localizacaoRepository.findAll();
    }
    
}
