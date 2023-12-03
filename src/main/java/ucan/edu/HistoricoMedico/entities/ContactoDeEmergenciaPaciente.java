/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@Table(name = "contacto_de_emergencia_paciente", catalog = "registo_medico_multiperfil", schema = "public")

@Getter
@Setter
@ToString

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactoDeEmergenciaPaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "pk_contacto_de_emergencia_paciente", nullable = false)
    private Integer pkContactoDeEmergenciaPaciente;
    @JoinColumn(name = "fk_contacto_de_emergencia", referencedColumnName = "pk_contacto_de_emergencia")
    @ManyToOne
    private ContactoDeEmergencia fkContactoDeEmergencia;
    @JoinColumn(name = "fk_grau_de_parentesco", referencedColumnName = "pk_grau_de_parentesco")
    @ManyToOne
    private GrauDeParentesco fkGrauDeParentesco;
    
}
