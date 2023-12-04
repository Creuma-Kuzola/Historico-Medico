/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author creuma
 */
@Entity
@Table(name = "receita_medicamento", catalog = "registo_medico_josefina", schema = "public")

@Getter
@Setter
@ToString

public class ReceitaMedicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_receita_medicamento", nullable = false)
    private Integer pkReceitaMedicamento;
    @Column(name = "dosagem_medicamento", length = 2147483647)
    private String dosagemMedicamento;
    @Column(name = "concentracao_medicamento", length = 2147483647)
    private String concentracaoMedicamento;
    @Column(name = "horario_ingestao_medicamento", length = 2147483647)
    private String horarioIngestaoMedicamento;
    @Column(name = "duracao_ingestao_medicamento", length = 2147483647)
    private String duracaoIngestaoMedicamento;
    @JoinColumn(name = "fk_medicamento", referencedColumnName = "pk_medicamento")
    @ManyToOne
    private Medicamento fkMedicamento;
    @JoinColumn(name = "fk_receita", referencedColumnName = "pk_receita")
    @ManyToOne
    private Receita fkReceita;
   
}
