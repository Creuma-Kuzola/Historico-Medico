/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.utils;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author creuma
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoMedico {
    
    private List<PacienteCustom> listaDePacienteCustom;
    private List<ConsultaExameCustom> listaDeConsultaExameCustom;
    private List<ReceitaConsultaCustom> listaReceitaConsultaCustom;
}
