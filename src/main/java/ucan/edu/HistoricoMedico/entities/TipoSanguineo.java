/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
@Table(name = "tipo_sanguineo", catalog = "registo_medico_josefina", schema = "public")
@Getter
@Setter
@ToString

public class TipoSanguineo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_tipo_sanguineo", nullable = false)
    private Integer pkTipoSanguineo;
    @Basic(optional = false)
    @Column(nullable = false, length = 2147483647)
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkTipoSanguineo")
    @JsonIgnore
    private List<Paciente> pacienteList;
    
}
