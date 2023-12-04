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
@Table(name = "item_alergico", catalog = "registo_medico_josefina", schema = "public")

@Getter
@Setter
@ToString

public class ItemAlergico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_item_alergico", nullable = false)
    private Integer pkItemAlergico;
    @Basic(optional = false)
    @Column(nullable = false, length = 2147483647)
    private String nome;
    @Basic(optional = false)
    @Column(nullable = false, length = 2147483647)
    private String descricao;
    @JoinColumn(name = "fk_paciente", referencedColumnName = "pk_paciente")
    @ManyToOne
    private Paciente fkPaciente;
    
}
