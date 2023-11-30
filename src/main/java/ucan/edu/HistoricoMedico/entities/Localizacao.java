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
@Table(catalog = "registo_medico", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Localizacao.findAll", query = "SELECT l FROM Localizacao l")})
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
    private List<Localizacao> localizacaoList;
    @JoinColumn(name = "fk_localizacao_pai", referencedColumnName = "pk_localizacao")
    @ManyToOne
    private Localizacao fkLocalizacaoPai;
    @OneToMany(mappedBy = "fkLocalizacao")
    private List<InstituicacaoDeSaude> instituicacaoDeSaudeList;

    public Localizacao() {
    }

    public Localizacao(String pkLocalizacao) {
        this.pkLocalizacao = pkLocalizacao;
    }

    public Localizacao(String pkLocalizacao, String designaco) {
        this.pkLocalizacao = pkLocalizacao;
        this.designaco = designaco;
    }

    public String getPkLocalizacao() {
        return pkLocalizacao;
    }

    public void setPkLocalizacao(String pkLocalizacao) {
        this.pkLocalizacao = pkLocalizacao;
    }

    public String getDesignaco() {
        return designaco;
    }

    public void setDesignaco(String designaco) {
        this.designaco = designaco;
    }

    public List<Localizacao> getLocalizacaoList() {
        return localizacaoList;
    }

    public void setLocalizacaoList(List<Localizacao> localizacaoList) {
        this.localizacaoList = localizacaoList;
    }

    public Localizacao getFkLocalizacaoPai() {
        return fkLocalizacaoPai;
    }

    public void setFkLocalizacaoPai(Localizacao fkLocalizacaoPai) {
        this.fkLocalizacaoPai = fkLocalizacaoPai;
    }

    public List<InstituicacaoDeSaude> getInstituicacaoDeSaudeList() {
        return instituicacaoDeSaudeList;
    }

    public void setInstituicacaoDeSaudeList(List<InstituicacaoDeSaude> instituicacaoDeSaudeList) {
        this.instituicacaoDeSaudeList = instituicacaoDeSaudeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkLocalizacao != null ? pkLocalizacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localizacao)) {
            return false;
        }
        Localizacao other = (Localizacao) object;
        if ((this.pkLocalizacao == null && other.pkLocalizacao != null) || (this.pkLocalizacao != null && !this.pkLocalizacao.equals(other.pkLocalizacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucan.edu.HistoricoMedico.entities.Localizacao[ pkLocalizacao=" + pkLocalizacao + " ]";
    }
    
}
