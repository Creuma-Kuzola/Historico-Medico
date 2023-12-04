/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.utils;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author creuma
 */


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PacienteCustom {
    
    private Integer pkPaciente;
    private String nomePaciente;
    private Date dataNascimento;
    private String numeroTelefone;
    private String profissao;
    //private String tipoSanguineo;
    //private String sexo;
    //private String estadoCivil;
    //private String localizacao;
    private String nomeItemAlergico;
    private String decricaoItemAlergico;
    private String nomeVacina;
    private Date dataVacina;
    
    private String nomeContactoEmergencia;
    //private String sexoContactoEmergencia;
    private String grauDeParentesco;
    private String numeroDeTelefoneContactoDeEmergencia;
    
    
}

