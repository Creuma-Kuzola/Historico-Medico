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
    @NamedQuery(name = "Consulta.findAll", query = "SELECT c FROM Consulta c")})
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
    private List<ExameConsulta> exameConsultaList;
    @JoinColumn(name = "fk_paciente", referencedColumnName = "pk_paciente")
    @ManyToOne
    private Paciente fkPaciente;
    @JoinColumn(name = "fk_tipo_consulta", referencedColumnName = "pk_tipo_consulta")
    @ManyToOne
    private TipoConsulta fkTipoConsulta;
    @JoinColumn(name = "fk_instituicao_de_saude_medico", referencedColumnName = "pk_tipo_instituicacao_de_saude")
    @ManyToOne
    private TipoInstituicacaoDeSaude fkInstituicaoDeSaudeMedico;
    @OneToMany(mappedBy = "fkConsulta")
    private List<SintomaDoenca> sintomaDoencaList;
    @OneToMany(mappedBy = "fkConsulta")
    private List<Triagem> triagemList;
    @OneToMany(mappedBy = "fkConsulta")
    private List<Diagnostico> diagnosticoList;

    public Consulta() {
    }

    public Consulta(Integer pkConsulta) {
        this.pkConsulta = pkConsulta;
    }

    public Integer getPkConsulta() {
        return pkConsulta;
    }

    public void setPkConsulta(Integer pkConsulta) {
        this.pkConsulta = pkConsulta;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public List<ExameConsulta> getExameConsultaList() {
        return exameConsultaList;
    }

    public void setExameConsultaList(List<ExameConsulta> exameConsultaList) {
        this.exameConsultaList = exameConsultaList;
    }

    public Paciente getFkPaciente() {
        return fkPaciente;
    }

    public void setFkPaciente(Paciente fkPaciente) {
        this.fkPaciente = fkPaciente;
    }

    public TipoConsulta getFkTipoConsulta() {
        return fkTipoConsulta;
    }

    public void setFkTipoConsulta(TipoConsulta fkTipoConsulta) {
        this.fkTipoConsulta = fkTipoConsulta;
    }

    public TipoInstituicacaoDeSaude getFkInstituicaoDeSaudeMedico() {
        return fkInstituicaoDeSaudeMedico;
    }

    public void setFkInstituicaoDeSaudeMedico(TipoInstituicacaoDeSaude fkInstituicaoDeSaudeMedico) {
        this.fkInstituicaoDeSaudeMedico = fkInstituicaoDeSaudeMedico;
    }

    public List<SintomaDoenca> getSintomaDoencaList() {
        return sintomaDoencaList;
    }

    public void setSintomaDoencaList(List<SintomaDoenca> sintomaDoencaList) {
        this.sintomaDoencaList = sintomaDoencaList;
    }

    public List<Triagem> getTriagemList() {
        return triagemList;
    }

    public void setTriagemList(List<Triagem> triagemList) {
        this.triagemList = triagemList;
    }

    public List<Diagnostico> getDiagnosticoList() {
        return diagnosticoList;
    }

    public void setDiagnosticoList(List<Diagnostico> diagnosticoList) {
        this.diagnosticoList = diagnosticoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkConsulta != null ? pkConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
        if ((this.pkConsulta == null && other.pkConsulta != null) || (this.pkConsulta != null && !this.pkConsulta.equals(other.pkConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucan.edu.HistoricoMedico.entities.Consulta[ pkConsulta=" + pkConsulta + " ]";
    }
    
}
