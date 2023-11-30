/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.entities;

import java.io.Serializable;
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

/**
 *
 * @author creuma
 */
@Entity
@Table(name = "instituicacao_de_saude", catalog = "registo_medico", schema = "public")
@NamedQueries({
    @NamedQuery(name = "InstituicacaoDeSaude.findAll", query = "SELECT i FROM InstituicacaoDeSaude i")})
public class InstituicacaoDeSaude implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_instituicacao_de_saude", nullable = false)
    private Integer pkInstituicacaoDeSaude;
    @Basic(optional = false)
    @Column(nullable = false, length = 2147483647)
    private String nome;
    @OneToMany(mappedBy = "fkInstituicaoDeSaude")
    private List<Cirurgia> cirurgiaList;
    @JoinColumn(name = "fk_localizacao", referencedColumnName = "pk_localizacao")
    @ManyToOne
    private Localizacao fkLocalizacao;
    @JoinColumn(name = "fk_tipo_instituicao_de_saude", referencedColumnName = "pk_tipo_instituicacao_de_saude")
    @ManyToOne
    private TipoInstituicacaoDeSaude fkTipoInstituicaoDeSaude;
    @OneToMany(mappedBy = "fkInstituicaoDeSaude")
    private List<Diagnostico> diagnosticoList;

    public InstituicacaoDeSaude() {
    }

    public InstituicacaoDeSaude(Integer pkInstituicacaoDeSaude) {
        this.pkInstituicacaoDeSaude = pkInstituicacaoDeSaude;
    }

    public InstituicacaoDeSaude(Integer pkInstituicacaoDeSaude, String nome) {
        this.pkInstituicacaoDeSaude = pkInstituicacaoDeSaude;
        this.nome = nome;
    }

    public Integer getPkInstituicacaoDeSaude() {
        return pkInstituicacaoDeSaude;
    }

    public void setPkInstituicacaoDeSaude(Integer pkInstituicacaoDeSaude) {
        this.pkInstituicacaoDeSaude = pkInstituicacaoDeSaude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Cirurgia> getCirurgiaList() {
        return cirurgiaList;
    }

    public void setCirurgiaList(List<Cirurgia> cirurgiaList) {
        this.cirurgiaList = cirurgiaList;
    }

    public Localizacao getFkLocalizacao() {
        return fkLocalizacao;
    }

    public void setFkLocalizacao(Localizacao fkLocalizacao) {
        this.fkLocalizacao = fkLocalizacao;
    }

    public TipoInstituicacaoDeSaude getFkTipoInstituicaoDeSaude() {
        return fkTipoInstituicaoDeSaude;
    }

    public void setFkTipoInstituicaoDeSaude(TipoInstituicacaoDeSaude fkTipoInstituicaoDeSaude) {
        this.fkTipoInstituicaoDeSaude = fkTipoInstituicaoDeSaude;
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
        hash += (pkInstituicacaoDeSaude != null ? pkInstituicacaoDeSaude.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstituicacaoDeSaude)) {
            return false;
        }
        InstituicacaoDeSaude other = (InstituicacaoDeSaude) object;
        if ((this.pkInstituicacaoDeSaude == null && other.pkInstituicacaoDeSaude != null) || (this.pkInstituicacaoDeSaude != null && !this.pkInstituicacaoDeSaude.equals(other.pkInstituicacaoDeSaude))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucan.edu.HistoricoMedico.entities.InstituicacaoDeSaude[ pkInstituicacaoDeSaude=" + pkInstituicacaoDeSaude + " ]";
    }
    
}
