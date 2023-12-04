/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.services.implementados;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucan.edu.HistoricoMedico.entities.ExameConsulta;
import ucan.edu.HistoricoMedico.entities.TipoSanguineo;
import ucan.edu.HistoricoMedico.entities.Triagem;
import ucan.edu.HistoricoMedico.repositories.ExameConsultaRepository;
import ucan.edu.HistoricoMedico.repositories.TipoSanguineoRepository;
import ucan.edu.HistoricoMedico.services.ExameConsultaService;
import ucan.edu.HistoricoMedico.services.TipoSanguineoService;
import ucan.edu.HistoricoMedico.services.TriagemService;
import ucan.edu.HistoricoMedico.utils.ConsultaExameCustom;

/**
 *
 * @author jussyleitecode
 */
@Service
public class ExameConsultaServiceImpl extends AbstractService<ExameConsulta, Integer> implements ExameConsultaService<ConsultaExameCustom, Integer>
{

    @Autowired
    ExameConsultaRepository exameConsultaRepository;

    @Override
    public List<ConsultaExameCustom> carrergaraExameConsultaByPaciente(Integer k)
    {
        List<ExameConsulta> l = exameConsultaRepository.findExameConsultByPaciente(k);

        List<ConsultaExameCustom> consultaExameCunstomLista = new ArrayList<>();

        ConsultaExameCustom consultaExameCunstom = new ConsultaExameCustom();

        for (ExameConsulta lista : l)
        {
            consultaExameCunstom.setDataConsulta(lista.getFkConsulta().getDataConsulta());

            consultaExameCunstom.setTipoConsulta(lista.getFkConsulta().getFkTipoConsulta().getDesignacao());
            consultaExameCunstom.setNome(lista.getFkExame().getNome());
            consultaExameCunstom.setData_exame(lista.getFkExame().getDataExame());

            consultaExameCunstomLista.add(consultaExameCunstom);
        }
        return consultaExameCunstomLista;
    }
}
