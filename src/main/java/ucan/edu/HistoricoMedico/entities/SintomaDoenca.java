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
@Table(name = "sintoma_doenca", catalog = "registo_medico", schema = "public")
@NamedQueries({
    @NamedQuery(name = "SintomaDoenca.findAll", query = "SELECT s FROM SintomaDoenca s")})
public class SintomaDoenca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_sintoma_doenca", nullable = false)
    private Integer pkSintomaDoenca;
    @Column(length = 2147483647)
    private String descricão;
    @JoinColumn(name = "fk_consulta", referencedColumnName = "pk_consulta")
    @ManyToOne
    private Consulta fkConsulta;

    public SintomaDoenca() {
    }

    public SintomaDoenca(Integer pkSintomaDoenca) {
        this.pkSintomaDoenca = pkSintomaDoenca;
    }

    public Integer getPkSintomaDoenca() {
        return pkSintomaDoenca;
    }

    public void setPkSintomaDoenca(Integer pkSintomaDoenca) {
        this.pkSintomaDoenca = pkSintomaDoenca;
    }

    public String getDescricão() {
        return descricão;
    }

    public void setDescricão(String descricão) {
        this.descricão = descricão;
    }

    public Consulta getFkConsulta() {
        return fkConsulta;
    }

    public void setFkConsulta(Consulta fkConsulta) {
        this.fkConsulta = fkConsulta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkSintomaDoenca != null ? pkSintomaDoenca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SintomaDoenca)) {
            return false;
        }
        SintomaDoenca other = (SintomaDoenca) object;
        if ((this.pkSintomaDoenca == null && other.pkSintomaDoenca != null) || (this.pkSintomaDoenca != null && !this.pkSintomaDoenca.equals(other.pkSintomaDoenca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucan.edu.HistoricoMedico.entities.SintomaDoenca[ pkSintomaDoenca=" + pkSintomaDoenca + " ]";
    }
    
}
