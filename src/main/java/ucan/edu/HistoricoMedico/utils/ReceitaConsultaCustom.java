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
public class ReceitaConsultaCustom {

    private Integer pkReceita;
    private Date dataReceita;
    private String duracaoReceita;
    private Date dataControle;
    private Date dataConsulta;
    private String dosagemMedicamento;
    private String concentracaoMedicamento;
    private String horarioIngestaoMedicamento;
    private String duracaoIngestaoMedicamento;
    private String nomeMedicamento;
    private double precoMedicamento;
    private String descricaoMedicamento;
    private Date dataExpiracaoMedicamento;
    private Date dataFabricacaoMedicamento;

}
