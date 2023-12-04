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
@Table(name = "sintoma_doenca", catalog = "registo_medico_josefina", schema = "public")


@Getter
@Setter
@ToString

public class SintomaDoenca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_sintoma_doenca", nullable = false)
    private Integer pkSintomaDoenca;
    @Column(length = 2147483647)
    private String descricao;
    @JoinColumn(name = "fk_consulta", referencedColumnName = "pk_consulta")
    @ManyToOne
    private Consulta fkConsulta;
}
