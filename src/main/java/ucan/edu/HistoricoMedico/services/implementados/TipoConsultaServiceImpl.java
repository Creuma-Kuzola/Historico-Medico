/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.services.implementados;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucan.edu.HistoricoMedico.entities.TipoConsulta;
import ucan.edu.HistoricoMedico.entities.TipoSanguineo;
import ucan.edu.HistoricoMedico.repositories.TipoSanguineoRepository;
import ucan.edu.HistoricoMedico.services.TipoSanguineoService;

/**
 *
 * @author jussyleitecode
 */
@Service
public class TipoConsultaServiceImpl extends AbstractService<TipoConsulta, Integer> implements TipoSanguineoService<TipoConsulta, Integer>
{

    @Override
    public TipoConsulta salvar(TipoConsulta t)
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<TipoConsulta> encontrarPorId(TipoConsulta t)
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TipoConsulta> encontrarTodoTipoSanguineo()
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
