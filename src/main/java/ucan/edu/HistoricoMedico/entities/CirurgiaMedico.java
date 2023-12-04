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
@Table(name = "cirurgia_medico", catalog = "registo_medico_josefina", schema = "public")

@ToString
@Getter
@Setter

public class CirurgiaMedico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_cirurgia_medico", nullable = false)
    private Integer pkCirurgiaMedico;
    @JoinColumn(name = "fk_cirurgia", referencedColumnName = "pk_cirurgia")
    @ManyToOne
    private Cirurgia fkCirurgia;
    @JoinColumn(name = "fk_medico", referencedColumnName = "pk_medico")
    @ManyToOne
    private Medico fkMedico;
    
}
