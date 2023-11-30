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
@Table(name = "intituicao_de_saude_medico", catalog = "registo_medico", schema = "public")
@NamedQueries({
    @NamedQuery(name = "IntituicaoDeSaudeMedico.findAll", query = "SELECT i FROM IntituicaoDeSaudeMedico i")})
public class IntituicaoDeSaudeMedico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_instituicao_de_saude_medico", nullable = false)
    private Integer pkInstituicaoDeSaudeMedico;
    @Basic(optional = false)
    @Column(name = "fk_medico", nullable = false)
    private int fkMedico;
    @Basic(optional = false)
    @Column(name = "fk_instituicao_de_saude", nullable = false)
    private int fkInstituicaoDeSaude;
    @Column(name = "data_adesao")
    @Temporal(TemporalType.DATE)
    private Date dataAdesao;

    public IntituicaoDeSaudeMedico() {
    }

    public IntituicaoDeSaudeMedico(Integer pkInstituicaoDeSaudeMedico) {
        this.pkInstituicaoDeSaudeMedico = pkInstituicaoDeSaudeMedico;
    }

    public IntituicaoDeSaudeMedico(Integer pkInstituicaoDeSaudeMedico, int fkMedico, int fkInstituicaoDeSaude) {
        this.pkInstituicaoDeSaudeMedico = pkInstituicaoDeSaudeMedico;
        this.fkMedico = fkMedico;
        this.fkInstituicaoDeSaude = fkInstituicaoDeSaude;
    }

    public Integer getPkInstituicaoDeSaudeMedico() {
        return pkInstituicaoDeSaudeMedico;
    }

    public void setPkInstituicaoDeSaudeMedico(Integer pkInstituicaoDeSaudeMedico) {
        this.pkInstituicaoDeSaudeMedico = pkInstituicaoDeSaudeMedico;
    }

    public int getFkMedico() {
        return fkMedico;
    }

    public void setFkMedico(int fkMedico) {
        this.fkMedico = fkMedico;
    }

    public int getFkInstituicaoDeSaude() {
        return fkInstituicaoDeSaude;
    }

    public void setFkInstituicaoDeSaude(int fkInstituicaoDeSaude) {
        this.fkInstituicaoDeSaude = fkInstituicaoDeSaude;
    }

    public Date getDataAdesao() {
        return dataAdesao;
    }

    public void setDataAdesao(Date dataAdesao) {
        this.dataAdesao = dataAdesao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkInstituicaoDeSaudeMedico != null ? pkInstituicaoDeSaudeMedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IntituicaoDeSaudeMedico)) {
            return false;
        }
        IntituicaoDeSaudeMedico other = (IntituicaoDeSaudeMedico) object;
        if ((this.pkInstituicaoDeSaudeMedico == null && other.pkInstituicaoDeSaudeMedico != null) || (this.pkInstituicaoDeSaudeMedico != null && !this.pkInstituicaoDeSaudeMedico.equals(other.pkInstituicaoDeSaudeMedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucan.edu.HistoricoMedico.entities.IntituicaoDeSaudeMedico[ pkInstituicaoDeSaudeMedico=" + pkInstituicaoDeSaudeMedico + " ]";
    }
    
}
