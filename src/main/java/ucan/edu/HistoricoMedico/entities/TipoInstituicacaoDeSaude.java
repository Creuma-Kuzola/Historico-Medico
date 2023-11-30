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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author creuma
 */
@Entity
@Table(name = "tipo_instituicacao_de_saude", catalog = "registo_medico", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TipoInstituicacaoDeSaude.findAll", query = "SELECT t FROM TipoInstituicacaoDeSaude t")})
public class TipoInstituicacaoDeSaude implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_tipo_instituicacao_de_saude", nullable = false)
    private Integer pkTipoInstituicacaoDeSaude;
    @Basic(optional = false)
    @Column(nullable = false, length = 2147483647)
    private String nome;
    @OneToMany(mappedBy = "fkInstituicaoDeSaudeMedico")
    private List<Consulta> consultaList;
    @OneToMany(mappedBy = "fkTipoInstituicaoDeSaude")
    private List<InstituicacaoDeSaude> instituicacaoDeSaudeList;

    public TipoInstituicacaoDeSaude() {
    }

    public TipoInstituicacaoDeSaude(Integer pkTipoInstituicacaoDeSaude) {
        this.pkTipoInstituicacaoDeSaude = pkTipoInstituicacaoDeSaude;
    }

    public TipoInstituicacaoDeSaude(Integer pkTipoInstituicacaoDeSaude, String nome) {
        this.pkTipoInstituicacaoDeSaude = pkTipoInstituicacaoDeSaude;
        this.nome = nome;
    }

    public Integer getPkTipoInstituicacaoDeSaude() {
        return pkTipoInstituicacaoDeSaude;
    }

    public void setPkTipoInstituicacaoDeSaude(Integer pkTipoInstituicacaoDeSaude) {
        this.pkTipoInstituicacaoDeSaude = pkTipoInstituicacaoDeSaude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Consulta> getConsultaList() {
        return consultaList;
    }

    public void setConsultaList(List<Consulta> consultaList) {
        this.consultaList = consultaList;
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
        hash += (pkTipoInstituicacaoDeSaude != null ? pkTipoInstituicacaoDeSaude.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoInstituicacaoDeSaude)) {
            return false;
        }
        TipoInstituicacaoDeSaude other = (TipoInstituicacaoDeSaude) object;
        if ((this.pkTipoInstituicacaoDeSaude == null && other.pkTipoInstituicacaoDeSaude != null) || (this.pkTipoInstituicacaoDeSaude != null && !this.pkTipoInstituicacaoDeSaude.equals(other.pkTipoInstituicacaoDeSaude))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucan.edu.HistoricoMedico.entities.TipoInstituicacaoDeSaude[ pkTipoInstituicacaoDeSaude=" + pkTipoInstituicacaoDeSaude + " ]";
    }
    
}
