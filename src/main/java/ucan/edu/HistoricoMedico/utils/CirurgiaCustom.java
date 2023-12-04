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

public class CirurgiaCustom {
    
   private Date dataCirurgia;
   private String duracaoCirugia;
   private String duracaoCirurgia;
   private String descricao;
   
   private String nomeMedico;
   private String numeroDeTelefoneMedico;
   private Integer numeroDeOrdemMedico;
   private String sexoMedico;
}
