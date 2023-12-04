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
@Table(name = "contacto_de_emergencia_paciente", catalog = "registo_medico_josefina", schema = "public")

@Getter
@Setter
@ToString

public class ContactoDeEmergenciaPaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_contacto_de_emergencia_paciente", nullable = false)
    private Integer pkContactoDeEmergenciaPaciente;
    @JoinColumn(name = "fk_contacto_de_emergencia", referencedColumnName = "pk_contacto_de_emergencia")
    @ManyToOne
    private ContactoDeEmergencia fkContactoDeEmergencia;
    @JoinColumn(name = "fk_grau_de_parentesco", referencedColumnName = "pk_grau_de_parentesco")
    @ManyToOne
    private GrauDeParentesco fkGrauDeParentesco;
    @JoinColumn(name = "fk_paciente", referencedColumnName = "pk_paciente")
    @ManyToOne
    private Paciente fkPaciente;
    
}
