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
@Table(name = "grau_de_parentesco", catalog = "registo_medico_multiperfil", schema = "public")

@Getter
@Setter
@ToString

public class GrauDeParentesco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_grau_de_parentesco", nullable = false)
    private Integer pkGrauDeParentesco;
    
    @Column(nullable = false, length = 2147483647)
    private String nome;
    @OneToMany(mappedBy = "fkGrauDeParentesco")
    @JsonIgnore
    private List<ContactoDeEmergenciaPaciente> contactoDeEmergenciaPacienteList;
}
