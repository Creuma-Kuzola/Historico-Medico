/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "tipo_sanguineo", catalog = "registo_medico", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TipoSanguineo.findAll", query = "SELECT t FROM TipoSanguineo t")})
public class TipoSanguineo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_tipo_sanguineo", nullable = false)
    private Integer pkTipoSanguineo;
    @Basic(optional = false)
    @Column(nullable = false, length = 2147483647)
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkTipoSanguineo")
    private List<Paciente> pacienteList;

    public TipoSanguineo() {
    }

    public TipoSanguineo(Integer pkTipoSanguineo) {
        this.pkTipoSanguineo = pkTipoSanguineo;
    }

    public TipoSanguineo(Integer pkTipoSanguineo, String nome) {
        this.pkTipoSanguineo = pkTipoSanguineo;
        this.nome = nome;
    }

    public Integer getPkTipoSanguineo() {
        return pkTipoSanguineo;
    }

    public void setPkTipoSanguineo(Integer pkTipoSanguineo) {
        this.pkTipoSanguineo = pkTipoSanguineo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkTipoSanguineo != null ? pkTipoSanguineo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoSanguineo)) {
            return false;
        }
        TipoSanguineo other = (TipoSanguineo) object;
        if ((this.pkTipoSanguineo == null && other.pkTipoSanguineo != null) || (this.pkTipoSanguineo != null && !this.pkTipoSanguineo.equals(other.pkTipoSanguineo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucan.edu.HistoricoMedico.entities.TipoSanguineo[ pkTipoSanguineo=" + pkTipoSanguineo + " ]";
    }
    
}
