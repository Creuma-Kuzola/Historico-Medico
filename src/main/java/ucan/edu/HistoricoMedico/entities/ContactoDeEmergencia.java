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
@Table(name = "contacto_de_emergencia", catalog = "registo_medico_multiperfil", schema = "public")

@Getter
@Setter
@ToString

public class ContactoDeEmergencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_contacto_de_emergencia", nullable = false)
    private Integer pkContactoDeEmergencia;
    @Column(length = 2147483647)
    private String nome;
    @Column(name = "numero_telefone", length = 2147483647)
    private String numeroTelefone;
    @OneToMany(mappedBy = "fkContactoDeEmergencia")
    @JsonIgnore
    private List<ContactoDeEmergenciaPaciente> contactoDeEmergenciaPacienteList;
    @JoinColumn(name = "fk_sexo", referencedColumnName = "pk_sexo")
    @ManyToOne
    private Sexo fkSexo;    
}
