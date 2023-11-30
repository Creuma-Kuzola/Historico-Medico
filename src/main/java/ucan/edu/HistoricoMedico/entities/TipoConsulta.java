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
@Table(name = "tipo_consulta", catalog = "registo_medico", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TipoConsulta.findAll", query = "SELECT t FROM TipoConsulta t")})
public class TipoConsulta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_tipo_consulta", nullable = false)
    private Integer pkTipoConsulta;
    @Column(length = 2147483647)
    private String designacao;
    @OneToMany(mappedBy = "fkTipoConsulta")
    private List<Consulta> consultaList;

    public TipoConsulta() {
    }

    public TipoConsulta(Integer pkTipoConsulta) {
        this.pkTipoConsulta = pkTipoConsulta;
    }

    public Integer getPkTipoConsulta() {
        return pkTipoConsulta;
    }

    public void setPkTipoConsulta(Integer pkTipoConsulta) {
        this.pkTipoConsulta = pkTipoConsulta;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public List<Consulta> getConsultaList() {
        return consultaList;
    }

    public void setConsultaList(List<Consulta> consultaList) {
        this.consultaList = consultaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkTipoConsulta != null ? pkTipoConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoConsulta)) {
            return false;
        }
        TipoConsulta other = (TipoConsulta) object;
        if ((this.pkTipoConsulta == null && other.pkTipoConsulta != null) || (this.pkTipoConsulta != null && !this.pkTipoConsulta.equals(other.pkTipoConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucan.edu.HistoricoMedico.entities.TipoConsulta[ pkTipoConsulta=" + pkTipoConsulta + " ]";
    }
    
}
