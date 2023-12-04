/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.services.implementados;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ucan.edu.HistoricoMedico.entities.Cirurgia;
import ucan.edu.HistoricoMedico.entities.CirurgiaMedico;
import ucan.edu.HistoricoMedico.entities.Triagem;
import ucan.edu.HistoricoMedico.repositories.CirurgiaMedicoRepository;
import ucan.edu.HistoricoMedico.services.CirurgiaMedicoService;
import ucan.edu.HistoricoMedico.services.CirurgiaService;
import ucan.edu.HistoricoMedico.utils.CirurgiaCustom;

/**
 *
 * @author creuma
 */
public class CirurgiaMedicoServiceImpl extends AbstractService<CirurgiaMedico, Integer> implements CirurgiaMedicoService<CirurgiaCustom, Integer> {

    @Autowired
    CirurgiaMedicoRepository cirurgiaMedicoRepository;

    @Override
    public List<CirurgiaCustom> findCirurgiaMedicoByPkPaciente(Integer k) {

        List<CirurgiaMedico> lista = cirurgiaMedicoRepository.findCirurgiaMedicoByPkPaciente(k);
        List<CirurgiaCustom> listaFinal = new ArrayList<>();

        if (!lista.isEmpty()) {

            for (CirurgiaMedico cm : lista) {

                CirurgiaCustom cirurgiaCustom = new CirurgiaCustom();
                cirurgiaCustom.setDataCirurgia(cm.getFkCirurgia().getDataCirurgia());
                cirurgiaCustom.setDescricao(cm.getFkCirurgia().getDescricao());
                cirurgiaCustom.setDuracaoCirugia(cm.getFkCirurgia().getDuracaoCirurgia());
                cirurgiaCustom.setNomeMedico(cm.getFkMedico().getNome());
                cirurgiaCustom.setNumeroDeOrdemMedico(cm.getFkMedico().getNumeroOrdem());
                cirurgiaCustom.setSexoMedico(cm.getFkMedico().getFkSexo().getDesignacao());

                listaFinal.add(cirurgiaCustom);
            }
            return listaFinal;
        }
        
        return listaFinal;
    }

}
