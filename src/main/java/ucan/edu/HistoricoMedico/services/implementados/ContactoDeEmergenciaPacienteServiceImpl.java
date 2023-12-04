/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.services.implementados;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucan.edu.HistoricoMedico.entities.ContactoDeEmergenciaPaciente;
import ucan.edu.HistoricoMedico.entities.Sexo;
import ucan.edu.HistoricoMedico.repositories.ContactoDeEmergenciaPacienteRepository;
import ucan.edu.HistoricoMedico.repositories.ContactoDeEmergenciaRepository;
import ucan.edu.HistoricoMedico.services.ContactoDeEmergenciaPacienteService;
import ucan.edu.HistoricoMedico.utils.PacienteCustom;

/**
 *
 * @author creuma
 */
@Service
public class ContactoDeEmergenciaPacienteServiceImpl extends AbstractService<ContactoDeEmergenciaPaciente, Integer> 
        implements ContactoDeEmergenciaPacienteService<PacienteCustom, Integer>{

    @Autowired
    ContactoDeEmergenciaPacienteRepository contactoDeEmergenciaPacienteRepository;
    
    @Override
    public List<PacienteCustom> findContactoEmergenciaPacienteByPkPaciente(Integer k) {
            
        List<ContactoDeEmergenciaPaciente> lista = contactoDeEmergenciaPacienteRepository.findContactoDeEmergenciaPacienteByPkPaciente(k);
        List<PacienteCustom> listaFinal = new ArrayList<>();
        
        if(!lista.isEmpty()){
        
            for (ContactoDeEmergenciaPaciente cep : lista) {
                
                PacienteCustom pacienteCustom = new PacienteCustom();
                pacienteCustom.setPkPaciente(cep.getFkPaciente().getPkPaciente());
                pacienteCustom.setNomePaciente(cep.getFkPaciente().getNome());
                pacienteCustom.setDataNascimento(cep.getFkPaciente().getDataNascimento());
                pacienteCustom.setNumeroTelefone(cep.getFkPaciente().getNumeroTelefone());
                pacienteCustom.setProfissao(cep.getFkPaciente().getProfissao());
                //pacienteCustom.setTipoSanguineo(cep.getFkPaciente().getFkTipoSanguineo().getNome());
                //pacienteCustom.setSexo(cep.getFkPaciente().getFkSexo().getDesignacao());
                //pacienteCustom.setEstadoCivil(cep.getFkPaciente().getFkEstadoCivil().getDesignacao());
                //pacienteCustom.setLocalizacao(cep.getFkPaciente().getFkLocalizacao().getDesignaco());
           
                pacienteCustom.setNomeContactoEmergencia(cep.getFkContactoDeEmergencia().getNome());
                //pacienteCustom.setSexoContactoEmergencia(cep.getFkContactoDeEmergencia().getFkSexo().getDesignacao());
                pacienteCustom.setGrauDeParentesco(cep.getFkGrauDeParentesco().getNome());

                pacienteCustom.setNumeroDeTelefoneContactoDeEmergencia(cep.getFkContactoDeEmergencia().getNumeroTelefone());
                
                listaFinal.add(pacienteCustom);
            }
            return listaFinal;
        }
        
        return listaFinal;
    }
    
}
