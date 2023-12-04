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
@Table(catalog = "registo_medico_josefina", schema = "public")

@Getter
@Setter
@ToString

public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_paciente", nullable = false)
    private Integer pkPaciente;
    @Basic(optional = false)
    @Column(nullable = false, length = 2147483647)
    private String nome;
    @Basic(optional = false)
    @Column(name = "data_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Basic(optional = false)
    @Column(name = "numero_telefone", nullable = false, length = 2147483647)
    private String numeroTelefone;
    @Column(length = 2147483647)
    private String profissao;
    @OneToMany(mappedBy = "fkPaciente")
    @JsonIgnore
    private List<Receita> receitaList;
    @OneToMany(mappedBy = "fkPaciente")
    @JsonIgnore
    private List<Vacina> vacinaList;
    @OneToMany(mappedBy = "fkPaciente")
    @JsonIgnore
    private List<Cirurgia> cirurgiaList;
    @OneToMany(mappedBy = "fkPaciente")
    @JsonIgnore
    private List<ContactoDeEmergenciaPaciente> contactoDeEmergenciaPacienteList;
    @OneToMany(mappedBy = "fkPaciente")
    @JsonIgnore
    private List<ItemAlergico> itemAlergicoList;
    @JoinColumn(name = "fk_estado_civil", referencedColumnName = "pk_estado_civil")
    @ManyToOne
    private EstadoCivil fkEstadoCivil;
    @JoinColumn(name = "fk_localizacao", referencedColumnName = "pk_localizacao")
    @ManyToOne
    private Localizacao fkLocalizacao;
    @JoinColumn(name = "fk_sexo", referencedColumnName = "pk_sexo", nullable = false)
    @ManyToOne(optional = false)
    private Sexo fkSexo;
    @JoinColumn(name = "fk_tipo_sanguineo", referencedColumnName = "pk_tipo_sanguineo", nullable = false)
    @ManyToOne(optional = false)
    private TipoSanguineo fkTipoSanguineo;
    @OneToMany(mappedBy = "fkPaciente")
    @JsonIgnore
    private List<Consulta> consultaList;
    
}
