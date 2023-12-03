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
@Table(catalog = "registo_medico_multiperfil", schema = "public")

@Getter
@Setter
@ToString
public class Receita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_receita", nullable = false)
    private Integer pkReceita;
    @Column(name = "data_receita")
    @Temporal(TemporalType.DATE)
    private Date dataReceita;
    @Column(name = "duracao_receita", length = 2147483647)
    private String duracaoReceita;
    @Column(name = "data_controle")
    @Temporal(TemporalType.DATE)
    private Date dataControle;
    @OneToMany(mappedBy = "fkReceita")
    @JsonIgnore
    private List<ReceitaMedicamento> receitaMedicamentoList;
    
}
