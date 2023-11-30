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
    @NamedQuery(name = "Receita.findAll", query = "SELECT r FROM Receita r")})
public class Receita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_receita", nullable = false)
    private Integer pkReceita;
    @Column(name = "data_receita")
    @Temporal(TemporalType.DATE)
    private Date dataReceita;
    @Column(name = "fk_consulta")
    private Integer fkConsulta;
    @Column(name = "fk_paciente")
    private Integer fkPaciente;
    @Column(name = "fk_instituicao_de_saude_medico")
    private Integer fkInstituicaoDeSaudeMedico;
    @Column(name = "duracao_receita", length = 2147483647)
    private String duracaoReceita;
    @Column(name = "data_controle")
    @Temporal(TemporalType.DATE)
    private Date dataControle;

    public Receita() {
    }

    public Receita(Integer pkReceita) {
        this.pkReceita = pkReceita;
    }

    public Integer getPkReceita() {
        return pkReceita;
    }

    public void setPkReceita(Integer pkReceita) {
        this.pkReceita = pkReceita;
    }

    public Date getDataReceita() {
        return dataReceita;
    }

    public void setDataReceita(Date dataReceita) {
        this.dataReceita = dataReceita;
    }

    public Integer getFkConsulta() {
        return fkConsulta;
    }

    public void setFkConsulta(Integer fkConsulta) {
        this.fkConsulta = fkConsulta;
    }

    public Integer getFkPaciente() {
        return fkPaciente;
    }

    public void setFkPaciente(Integer fkPaciente) {
        this.fkPaciente = fkPaciente;
    }

    public Integer getFkInstituicaoDeSaudeMedico() {
        return fkInstituicaoDeSaudeMedico;
    }

    public void setFkInstituicaoDeSaudeMedico(Integer fkInstituicaoDeSaudeMedico) {
        this.fkInstituicaoDeSaudeMedico = fkInstituicaoDeSaudeMedico;
    }

    public String getDuracaoReceita() {
        return duracaoReceita;
    }

    public void setDuracaoReceita(String duracaoReceita) {
        this.duracaoReceita = duracaoReceita;
    }

    public Date getDataControle() {
        return dataControle;
    }

    public void setDataControle(Date dataControle) {
        this.dataControle = dataControle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkReceita != null ? pkReceita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receita)) {
            return false;
        }
        Receita other = (Receita) object;
        if ((this.pkReceita == null && other.pkReceita != null) || (this.pkReceita != null && !this.pkReceita.equals(other.pkReceita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucan.edu.HistoricoMedico.entities.Receita[ pkReceita=" + pkReceita + " ]";
    }
    
}
