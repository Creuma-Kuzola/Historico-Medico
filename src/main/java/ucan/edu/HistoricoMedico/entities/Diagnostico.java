/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.entities;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author creuma
 */
@Entity
@Table(catalog = "registo_medico_josefina", schema = "public")

@Getter
@Setter
@ToString

public class Diagnostico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_diagnostico", nullable = false)
    private Integer pkDiagnostico;
    @Basic(optional = false)
    @Column(nullable = false, length = 2147483647)
    private String descricao;
    @Basic(optional = false)
    @Column(name = "data_diagnostico", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataDiagnostico;
    @JoinColumn(name = "fk_consulta", referencedColumnName = "pk_consulta")
    @ManyToOne
    private Consulta fkConsulta;
    @JoinColumn(name = "fk_tipo_diagnostico", referencedColumnName = "pk_tipo_diagnostico")
    @ManyToOne
    private TipoDiagnostico fkTipoDiagnostico;

}
