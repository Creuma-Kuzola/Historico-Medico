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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author creuma
 */
@Entity
@Table(name = "cirurgia_medico", catalog = "registo_medico", schema = "public")
@NamedQueries({
    @NamedQuery(name = "CirurgiaMedico.findAll", query = "SELECT c FROM CirurgiaMedico c")})
public class CirurgiaMedico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_cirurgia_medico", nullable = false)
    private Integer pkCirurgiaMedico;
    @Column(name = "fk_medico")
    private Integer fkMedico;
    @Column(name = "fk_cirurgia")
    private Integer fkCirurgia;
    @Column(name = "fk_instituicao_de_saude")
    private Integer fkInstituicaoDeSaude;

    public CirurgiaMedico() {
    }

    public CirurgiaMedico(Integer pkCirurgiaMedico) {
        this.pkCirurgiaMedico = pkCirurgiaMedico;
    }

    public Integer getPkCirurgiaMedico() {
        return pkCirurgiaMedico;
    }

    public void setPkCirurgiaMedico(Integer pkCirurgiaMedico) {
        this.pkCirurgiaMedico = pkCirurgiaMedico;
    }

    public Integer getFkMedico() {
        return fkMedico;
    }

    public void setFkMedico(Integer fkMedico) {
        this.fkMedico = fkMedico;
    }

    public Integer getFkCirurgia() {
        return fkCirurgia;
    }

    public void setFkCirurgia(Integer fkCirurgia) {
        this.fkCirurgia = fkCirurgia;
    }

    public Integer getFkInstituicaoDeSaude() {
        return fkInstituicaoDeSaude;
    }

    public void setFkInstituicaoDeSaude(Integer fkInstituicaoDeSaude) {
        this.fkInstituicaoDeSaude = fkInstituicaoDeSaude;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkCirurgiaMedico != null ? pkCirurgiaMedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CirurgiaMedico)) {
            return false;
        }
        CirurgiaMedico other = (CirurgiaMedico) object;
        if ((this.pkCirurgiaMedico == null && other.pkCirurgiaMedico != null) || (this.pkCirurgiaMedico != null && !this.pkCirurgiaMedico.equals(other.pkCirurgiaMedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucan.edu.HistoricoMedico.entities.CirurgiaMedico[ pkCirurgiaMedico=" + pkCirurgiaMedico + " ]";
    }
    
}
