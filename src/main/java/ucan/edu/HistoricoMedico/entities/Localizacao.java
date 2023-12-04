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
@Table(catalog = "registo_medico_josefina", schema = "public")

@Getter
@Setter
@ToString

public class Localizacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pk_localizacao", nullable = false, length = 2147483647)
    private String pkLocalizacao;
    @Basic(optional = false)
    @Column(nullable = false, length = 2147483647)
    private String designaco;
    @OneToMany(mappedBy = "fkLocalizacaoPai")
    @JsonIgnore
    private List<Localizacao> localizacaoList;
    @JoinColumn(name = "fk_localizacao_pai", referencedColumnName = "pk_localizacao")
    @ManyToOne
    private Localizacao fkLocalizacaoPai;
    @OneToMany(mappedBy = "fkLocalizacao")
    @JsonIgnore
    private List<Paciente> pacienteList;
    
}
