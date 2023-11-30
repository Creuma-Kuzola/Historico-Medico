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
@Table(catalog = "registo_medico", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Sexo.findAll", query = "SELECT s FROM Sexo s")})
public class Sexo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_sexo", nullable = false)
    private Integer pkSexo;
    @Basic(optional = false)
    @Column(nullable = false, length = 2147483647)
    private String designacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkSexo")
    private List<Paciente> pacienteList;
    @OneToMany(mappedBy = "fkSexo")
    private List<ContactoDeEmergencia> contactoDeEmergenciaList;
    @OneToMany(mappedBy = "fkSexo")
    private List<Medico> medicoList;

    public Sexo() {
    }

    public Sexo(Integer pkSexo) {
        this.pkSexo = pkSexo;
    }

    public Sexo(Integer pkSexo, String designacao) {
        this.pkSexo = pkSexo;
        this.designacao = designacao;
    }

    public Integer getPkSexo() {
        return pkSexo;
    }

    public void setPkSexo(Integer pkSexo) {
        this.pkSexo = pkSexo;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    public List<ContactoDeEmergencia> getContactoDeEmergenciaList() {
        return contactoDeEmergenciaList;
    }

    public void setContactoDeEmergenciaList(List<ContactoDeEmergencia> contactoDeEmergenciaList) {
        this.contactoDeEmergenciaList = contactoDeEmergenciaList;
    }

    public List<Medico> getMedicoList() {
        return medicoList;
    }

    public void setMedicoList(List<Medico> medicoList) {
        this.medicoList = medicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkSexo != null ? pkSexo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sexo)) {
            return false;
        }
        Sexo other = (Sexo) object;
        if ((this.pkSexo == null && other.pkSexo != null) || (this.pkSexo != null && !this.pkSexo.equals(other.pkSexo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucan.edu.HistoricoMedico.entities.Sexo[ pkSexo=" + pkSexo + " ]";
    }
    
}
