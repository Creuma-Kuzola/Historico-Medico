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
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_consulta", nullable = false)
    private Integer pkConsulta;
    @Column(name = "data_consulta")
    @Temporal(TemporalType.DATE)
    private Date dataConsulta;
    @OneToMany(mappedBy = "fkConsulta")
    @JsonIgnore
    private List<Receita> receitaList;
    @OneToMany(mappedBy = "fkConsulta")
    @JsonIgnore
    private List<SintomaDoenca> sintomaDoencaList;
    @OneToMany(mappedBy = "fkConsulta")
    @JsonIgnore
    private List<Triagem> triagemList;
    @OneToMany(mappedBy = "fkConsulta")
    @JsonIgnore
    private List<ExameConsulta> exameConsultaList;
    @OneToMany(mappedBy = "fkConsulta")
    @JsonIgnore
    private List<Diagnostico> diagnosticoList;
    @JoinColumn(name = "fk_medico", referencedColumnName = "pk_medico")
    @ManyToOne
    private Medico fkMedico;
    @JoinColumn(name = "fk_paciente", referencedColumnName = "pk_paciente")
    @ManyToOne
    private Paciente fkPaciente;
    @JoinColumn(name = "fk_tipo_consulta", referencedColumnName = "pk_tipo_consulta")
    @ManyToOne
    private TipoConsulta fkTipoConsulta;
    
}
