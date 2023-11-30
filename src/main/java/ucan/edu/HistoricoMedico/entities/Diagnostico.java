/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
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
    @NamedQuery(name = "Diagnostico.findAll", query = "SELECT d FROM Diagnostico d")})
public class Diagnostico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_diagnostico", nullable = false)
    private Integer pkDiagnostico;
    @Basic(optional = false)
    @Column(nullable = false, length = 2147483647)
    private String descricao;
    @Basic(optional = false)
    @Column(name = "data_diagnostico", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataDiagnostico;
    @OneToMany(mappedBy = "fkDiagnostico")
    private List<ExameConsulta> exameConsultaList;
    @JoinColumn(name = "fk_consulta", referencedColumnName = "pk_consulta")
    @ManyToOne
    private Consulta fkConsulta;
    @JoinColumn(name = "fk_instituicao_de_saude", referencedColumnName = "pk_instituicacao_de_saude")
    @ManyToOne
    private InstituicacaoDeSaude fkInstituicaoDeSaude;
    @JoinColumn(name = "fk_tipo_diagnostico", referencedColumnName = "pk_tipo_diagnostico")
    @ManyToOne
    private TipoDiagnostico fkTipoDiagnostico;

    public Diagnostico() {
    }

    public Diagnostico(Integer pkDiagnostico) {
        this.pkDiagnostico = pkDiagnostico;
    }

    public Diagnostico(Integer pkDiagnostico, String descricao, Date dataDiagnostico) {
        this.pkDiagnostico = pkDiagnostico;
        this.descricao = descricao;
        this.dataDiagnostico = dataDiagnostico;
    }

    public Integer getPkDiagnostico() {
        return pkDiagnostico;
    }

    public void setPkDiagnostico(Integer pkDiagnostico) {
        this.pkDiagnostico = pkDiagnostico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataDiagnostico() {
        return dataDiagnostico;
    }

    public void setDataDiagnostico(Date dataDiagnostico) {
        this.dataDiagnostico = dataDiagnostico;
    }

    public List<ExameConsulta> getExameConsultaList() {
        return exameConsultaList;
    }

    public void setExameConsultaList(List<ExameConsulta> exameConsultaList) {
        this.exameConsultaList = exameConsultaList;
    }

    public Consulta getFkConsulta() {
        return fkConsulta;
    }

    public void setFkConsulta(Consulta fkConsulta) {
        this.fkConsulta = fkConsulta;
    }

    public InstituicacaoDeSaude getFkInstituicaoDeSaude() {
        return fkInstituicaoDeSaude;
    }

    public void setFkInstituicaoDeSaude(InstituicacaoDeSaude fkInstituicaoDeSaude) {
        this.fkInstituicaoDeSaude = fkInstituicaoDeSaude;
    }

    public TipoDiagnostico getFkTipoDiagnostico() {
        return fkTipoDiagnostico;
    }

    public void setFkTipoDiagnostico(TipoDiagnostico fkTipoDiagnostico) {
        this.fkTipoDiagnostico = fkTipoDiagnostico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkDiagnostico != null ? pkDiagnostico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnostico)) {
            return false;
        }
        Diagnostico other = (Diagnostico) object;
        if ((this.pkDiagnostico == null && other.pkDiagnostico != null) || (this.pkDiagnostico != null && !this.pkDiagnostico.equals(other.pkDiagnostico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucan.edu.HistoricoMedico.entities.Diagnostico[ pkDiagnostico=" + pkDiagnostico + " ]";
    }
    
}
