/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author creuma
 */
@Entity
@Table(catalog = "registo_medico", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Vacina.findAll", query = "SELECT v FROM Vacina v")})
public class Vacina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_vacina", nullable = false)
    private Integer pkVacina;
    @Basic(optional = false)
    @Column(nullable = false, length = 2147483647)
    private String nome;
    @Basic(optional = false)
    @Column(name = "data_vacina", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataVacina;
    @JoinColumn(name = "fk_paciente", referencedColumnName = "pk_paciente")
    @ManyToOne
    private Paciente fkPaciente;

    public Vacina() {
    }

    public Vacina(Integer pkVacina) {
        this.pkVacina = pkVacina;
    }

    public Vacina(Integer pkVacina, String nome, Date dataVacina) {
        this.pkVacina = pkVacina;
        this.nome = nome;
        this.dataVacina = dataVacina;
    }

    public Integer getPkVacina() {
        return pkVacina;
    }

    public void setPkVacina(Integer pkVacina) {
        this.pkVacina = pkVacina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataVacina() {
        return dataVacina;
    }

    public void setDataVacina(Date dataVacina) {
        this.dataVacina = dataVacina;
    }

    public Paciente getFkPaciente() {
        return fkPaciente;
    }

    public void setFkPaciente(Paciente fkPaciente) {
        this.fkPaciente = fkPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkVacina != null ? pkVacina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacina)) {
            return false;
        }
        Vacina other = (Vacina) object;
        if ((this.pkVacina == null && other.pkVacina != null) || (this.pkVacina != null && !this.pkVacina.equals(other.pkVacina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucan.edu.HistoricoMedico.entities.Vacina[ pkVacina=" + pkVacina + " ]";
    }
    
}
