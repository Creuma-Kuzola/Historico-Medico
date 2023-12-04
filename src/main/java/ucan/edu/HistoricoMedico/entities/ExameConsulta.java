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
@Table(name = "exame_consulta", catalog = "registo_medico_josefina", schema = "public")

@Getter
@Setter
@ToString

public class ExameConsulta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_exame_consulta", nullable = false)
    private Integer pkExameConsulta;
    @JoinColumn(name = "fk_consulta", referencedColumnName = "pk_consulta")
    @ManyToOne
    private Consulta fkConsulta;
    @JoinColumn(name = "fk_exame", referencedColumnName = "pk_exame")
    @ManyToOne
    private Exame fkExame;
    
}
