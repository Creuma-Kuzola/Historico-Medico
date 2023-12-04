/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
    @OneToMany(mappedBy = "fkCirurgia")
    @JsonIgnore
    private List<CirurgiaMedico> cirurgiaMedicoList;
    @JoinColumn(name = "fk_paciente", referencedColumnName = "pk_paciente")
    @ManyToOne
    private Paciente fkPaciente;
  
}
