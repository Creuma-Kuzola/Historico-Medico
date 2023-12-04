/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.services.implementados;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucan.edu.HistoricoMedico.entities.Receita;
import ucan.edu.HistoricoMedico.entities.ReceitaMedicamento;
import ucan.edu.HistoricoMedico.entities.Sexo;
import ucan.edu.HistoricoMedico.repositories.ReceitaMedicamentoRepository;
import ucan.edu.HistoricoMedico.services.ReceitaMedicamentoService;
import ucan.edu.HistoricoMedico.utils.ReceitaConsultaConstum;

/**
 *
 * @author creuma
 */
@Service
public class ReceitaMedicamentoServiceImpl extends AbstractService<ReceitaMedicamento, Integer> implements ReceitaMedicamentoService<ReceitaConsultaConstum, Integer> {

    @Autowired
    ReceitaMedicamentoRepository receitaMedicamentoRepository;

    @Override
    public List<ReceitaConsultaConstum> findReceitaByPkPaciente(Integer k) {

        List<ReceitaMedicamento> lista = receitaMedicamentoRepository
                .encontrarReceitaPaciente(k);

        List<ReceitaConsultaConstum> listaFinal = new ArrayList<>();
        if (!lista.isEmpty()) {
            for (ReceitaMedicamento r : lista) {
                ReceitaConsultaConstum receitaConsultaConstum = new ReceitaConsultaConstum();

                receitaConsultaConstum.setPkReceita(r.getFkReceita().getPkReceita());
                receitaConsultaConstum.setDataReceita(r.getFkReceita().getDataReceita());
                receitaConsultaConstum.setDuracaoReceita(r.getFkReceita().getDuracaoReceita());

                receitaConsultaConstum.setDataControle(r.getFkReceita().getDataControle());
                receitaConsultaConstum.setDataConsulta(r.getFkReceita().getFkConsulta().getDataConsulta());

                receitaConsultaConstum.setDosagemMedicamento(r.getDosagemMedicamento());
                receitaConsultaConstum.setConcentracaoMedicamento(r.getConcentracaoMedicamento());
                receitaConsultaConstum.setHorarioIngestaoMedicamento(r.getHorarioIngestaoMedicamento());
                receitaConsultaConstum.setDuracaoIngestaoMedicamento(r.getDuracaoIngestaoMedicamento());
                
                receitaConsultaConstum.setNomeMedicamento(r.getFkMedicamento().getNome());
                receitaConsultaConstum.setPrecoMedicamento(r.getFkMedicamento().getPreco());
                receitaConsultaConstum.setDescricaoMedicamento(r.getFkMedicamento().getDescricao());
                
                receitaConsultaConstum.setDataExpiracaoMedicamento(r.getFkMedicamento().getDataExpiracao());
                receitaConsultaConstum.setDataFabricacaoMedicamento(r.getFkMedicamento().getDataFabricacao());
                listaFinal.add(receitaConsultaConstum);
            }
            return listaFinal;
        }

        return listaFinal;
    }

}
