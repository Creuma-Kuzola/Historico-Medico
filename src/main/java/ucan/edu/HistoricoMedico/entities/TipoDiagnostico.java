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
@Table(name = "tipo_diagnostico", catalog = "registo_medico", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TipoDiagnostico.findAll", query = "SELECT t FROM TipoDiagnostico t")})
public class TipoDiagnostico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_tipo_diagnostico", nullable = false)
    private Integer pkTipoDiagnostico;
    @Basic(optional = false)
    @Column(nullable = false, length = 2147483647)
    private String nome;
    @OneToMany(mappedBy = "fkTipoDiagnostico")
    private List<Diagnostico> diagnosticoList;

    public TipoDiagnostico() {
    }

    public TipoDiagnostico(Integer pkTipoDiagnostico) {
        this.pkTipoDiagnostico = pkTipoDiagnostico;
    }

    public TipoDiagnostico(Integer pkTipoDiagnostico, String nome) {
        this.pkTipoDiagnostico = pkTipoDiagnostico;
        this.nome = nome;
    }

    public Integer getPkTipoDiagnostico() {
        return pkTipoDiagnostico;
    }

    public void setPkTipoDiagnostico(Integer pkTipoDiagnostico) {
        this.pkTipoDiagnostico = pkTipoDiagnostico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        hash += (pkTipoDiagnostico != null ? pkTipoDiagnostico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDiagnostico)) {
            return false;
        }
        TipoDiagnostico other = (TipoDiagnostico) object;
        if ((this.pkTipoDiagnostico == null && other.pkTipoDiagnostico != null) || (this.pkTipoDiagnostico != null && !this.pkTipoDiagnostico.equals(other.pkTipoDiagnostico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucan.edu.HistoricoMedico.entities.TipoDiagnostico[ pkTipoDiagnostico=" + pkTipoDiagnostico + " ]";
    }
    
}
