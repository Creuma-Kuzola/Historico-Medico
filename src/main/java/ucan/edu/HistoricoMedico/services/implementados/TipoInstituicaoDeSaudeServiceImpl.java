/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.services.implementados;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucan.edu.HistoricoMedico.entities.TipoInstituicacaoDeSaude;
import ucan.edu.HistoricoMedico.entities.TipoSanguineo;
import ucan.edu.HistoricoMedico.repositories.TipoInstituicaoDeSaudeRepository;
import ucan.edu.HistoricoMedico.repositories.TipoSanguineoRepository;
import ucan.edu.HistoricoMedico.services.TipoSanguineoService;

/**
 *
 * @author jussyleitecode
 */
@Service
public class TipoInstituicaoDeSaudeServiceImpl extends AbstractService<TipoInstituicacaoDeSaude, Integer> implements TipoSanguineoService<TipoInstituicacaoDeSaude, Integer>
{
    
    @Autowired
    TipoInstituicaoDeSaudeRepository tipoInstituicaoDeSaudeRepository;
            
    @Override
    public TipoInstituicacaoDeSaude salvar(TipoInstituicacaoDeSaude t)
    {
        return super.criar(t);
    }

    @Override
    public Optional<TipoInstituicacaoDeSaude> encontrarPorId(TipoInstituicacaoDeSaude t)
    {
        return super.findById(t.getPkTipoInstituicacaoDeSaude());
    }

    @Override
    public List<TipoInstituicacaoDeSaude> encontrarTodoTipoSanguineo()
    {
        return super.findAll();
    }

}
