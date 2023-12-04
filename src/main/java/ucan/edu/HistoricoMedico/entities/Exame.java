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

public class Exame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_exame", nullable = false)
    private Integer pkExame;
    @Column(length = 2147483647)
    private String nome;
    @Column(length = 2147483647)
    private String resultado;
    @Column(name = "data_exame")
    @Temporal(TemporalType.DATE)
    private Date dataExame;
    @OneToMany(mappedBy = "fkExame")
    @JsonIgnore
    private List<ExameConsulta> exameConsultaList;
 
}
