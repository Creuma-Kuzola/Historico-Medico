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
import ucan.edu.HistoricoMedico.entities.Paciente;
import ucan.edu.HistoricoMedico.entities.TipoSanguineo;
import ucan.edu.HistoricoMedico.repositories.TipoSanguineoRepository;
import ucan.edu.HistoricoMedico.services.PacienteService;
import ucan.edu.HistoricoMedico.services.TipoSanguineoService;
import ucan.edu.HistoricoMedico.utils.ConsultaExameCustom;
import ucan.edu.HistoricoMedico.utils.HistoricoMedico;
import ucan.edu.HistoricoMedico.utils.PacienteCustom;
import ucan.edu.HistoricoMedico.utils.ReceitaConsultaCustom;

/**
 *
 * @author jussyleitecode
 */
@Service
public class PacienteServiceImpl extends AbstractService<Paciente, Integer> implements PacienteService<HistoricoMedico, Integer> {

    @Autowired
    ReceitaMedicamentoServiceImpl receitaMedicamentoServiceImpl;

    @Autowired
    ContactoDeEmergenciaPacienteServiceImpl contactoDeEmergenciaPacienteServiceImpl;

    @Autowired
    ExameConsultaServiceImpl exameConsultaServiceImpl;

    @Override
    public HistoricoMedico findHistoricoMedicoDeUmPaciente(Integer k) {

        List<ConsultaExameCustom> listaDeConsultaExameCustom = exameConsultaServiceImpl.carrergaraExameConsultaByPaciente(k);
        List<PacienteCustom> listaDePacienteCustom = contactoDeEmergenciaPacienteServiceImpl.findContactoEmergenciaPacienteByPkPaciente(k);
        List<ReceitaConsultaCustom> listaReceitaConsultaCustom = receitaMedicamentoServiceImpl.findReceitaByPkPaciente(k);

        HistoricoMedico historicoMedico = new HistoricoMedico();
        historicoMedico.setListaDeConsultaExameCustom(listaDeConsultaExameCustom);
        historicoMedico.setListaDePacienteCustom(listaDePacienteCustom);
        historicoMedico.setListaReceitaConsultaCustom(listaReceitaConsultaCustom);

        return historicoMedico;
    }

}
