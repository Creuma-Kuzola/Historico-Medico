/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.services.implementados;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucan.edu.HistoricoMedico.entities.TipoSanguineo;
import ucan.edu.HistoricoMedico.repositories.TipoSanguineoRepository;
import ucan.edu.HistoricoMedico.services.TipoSanguineoService;

/**
 *
 * @author jussyleitecode
 */
@Service
public class TipoSanguineoServiceImpl extends AbstractService<TipoSanguineo, Integer> implements TipoSanguineoService<TipoSanguineo, Integer>
{

    @Autowired
    TipoSanguineoRepository tipoSanguineoRepository;

    @Override
    public TipoSanguineo salvar(TipoSanguineo t)
    {
        return super.criar(t);
    }

    @Override
    public Optional<TipoSanguineo> encontrarPorId(TipoSanguineo t)
    {
        return super.findById(t.getPkTipoSanguineo());
    }

    @Override
    public List<TipoSanguineo> encontrarTodoTipoSanguineo()
    {
        return super.findAll();
    }

}
