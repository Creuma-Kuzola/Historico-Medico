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

/**
 *
 * @author creuma
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaExameCustom {
    
    private Integer ConsultaExameCunstom;
    private Date dataConsulta;
    private String tipoConsulta;
    private String consulta;

    //Exames
    private String resultado;
    private String nome;
    private Date data_exame;
    
    //sintoma_doenca
    private String sintomaDoenca;
    
}
