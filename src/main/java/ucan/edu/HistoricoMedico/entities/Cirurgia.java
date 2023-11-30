/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author creuma
 */

@Getter
@Setter
@ToString
@Entity
@Table(catalog = "registo_medico", schema = "public")

public class Cirurgia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_cirurgia", nullable = false)
    private Integer pkCirurgia;
    
    @Column(name = "data_cirurgia")
    @Temporal(TemporalType.DATE)
    private Date dataCirurgia;
    
    @Column(name = "duracao_cirurgia", length = 2147483647)
    private String duracaoCirurgia;
    
    @Column(length = 2147483647)
    private String descricao;
    
    @JoinColumn(name = "fk_instituicao_de_saude", referencedColumnName = "pk_instituicacao_de_saude")
    @ManyToOne
    private InstituicacaoDeSaude fkInstituicaoDeSaude;
    
    @JoinColumn(name = "fk_paciente", referencedColumnName = "pk_paciente")
    @ManyToOne
    private Paciente fkPaciente;

    
}
