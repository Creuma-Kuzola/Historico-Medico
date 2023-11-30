/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.entities;

import java.io.Serializable;
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

/**
 *
 * @author creuma
 */
@Entity
@Table(name = "exame_consulta", catalog = "registo_medico", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ExameConsulta.findAll", query = "SELECT e FROM ExameConsulta e")})
public class ExameConsulta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_exame_consulta", nullable = false)
    private Integer pkExameConsulta;
    @JoinColumn(name = "fk_consulta", referencedColumnName = "pk_consulta")
    @ManyToOne
    private Consulta fkConsulta;
    @JoinColumn(name = "fk_diagnostico", referencedColumnName = "pk_diagnostico")
    @ManyToOne
    private Diagnostico fkDiagnostico;
    @JoinColumn(name = "fk_exame", referencedColumnName = "pk_exame")
    @ManyToOne
    private Exame fkExame;

    public ExameConsulta() {
    }

    public ExameConsulta(Integer pkExameConsulta) {
        this.pkExameConsulta = pkExameConsulta;
    }

    public Integer getPkExameConsulta() {
        return pkExameConsulta;
    }

    public void setPkExameConsulta(Integer pkExameConsulta) {
        this.pkExameConsulta = pkExameConsulta;
    }

    public Consulta getFkConsulta() {
        return fkConsulta;
    }

    public void setFkConsulta(Consulta fkConsulta) {
        this.fkConsulta = fkConsulta;
    }

    public Diagnostico getFkDiagnostico() {
        return fkDiagnostico;
    }

    public void setFkDiagnostico(Diagnostico fkDiagnostico) {
        this.fkDiagnostico = fkDiagnostico;
    }

    public Exame getFkExame() {
        return fkExame;
    }

    public void setFkExame(Exame fkExame) {
        this.fkExame = fkExame;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkExameConsulta != null ? pkExameConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExameConsulta)) {
            return false;
        }
        ExameConsulta other = (ExameConsulta) object;
        if ((this.pkExameConsulta == null && other.pkExameConsulta != null) || (this.pkExameConsulta != null && !this.pkExameConsulta.equals(other.pkExameConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucan.edu.HistoricoMedico.entities.ExameConsulta[ pkExameConsulta=" + pkExameConsulta + " ]";
    }
    
}
