/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.entities;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jussyleitecode
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(catalog = "registo_medico", schema = "public")
@NamedQueries(
        {
            @NamedQuery(name = "Triagem.findAll", query = "SELECT t FROM Triagem t"),
            @NamedQuery(name = "Triagem.findByPkTriagem", query = "SELECT t FROM Triagem t WHERE t.pkTriagem = :pkTriagem"),
            @NamedQuery(name = "Triagem.findByPeso", query = "SELECT t FROM Triagem t WHERE t.peso = :peso"),
            @NamedQuery(name = "Triagem.findByTemperatura", query = "SELECT t FROM Triagem t WHERE t.temperatura = :temperatura"),
            @NamedQuery(name = "Triagem.findByAltura", query = "SELECT t FROM Triagem t WHERE t.altura = :altura"),
            @NamedQuery(name = "Triagem.findByDataTriagem", query = "SELECT t FROM Triagem t WHERE t.dataTriagem = :dataTriagem")
        })
public class Triagem implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_triagem", nullable = false)
    private Integer pkTriagem;
    @Basic(optional = false)
    @Column(nullable = false)
    private double peso;
    @Basic(optional = false)
    @Column(nullable = false)
    private double temperatura;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column
    private Double altura;
    @Column(name = "data_triagem")
    @Temporal(TemporalType.DATE)
    private Date dataTriagem;
    @JoinColumn(name = "fk_consulta", referencedColumnName = "pk_consulta")
    @ManyToOne
    private Consulta fkConsulta;

}
