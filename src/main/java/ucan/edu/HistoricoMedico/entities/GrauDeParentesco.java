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
@Table(name = "grau_de_parentesco", catalog = "registo_medico", schema = "public")
@NamedQueries({
    @NamedQuery(name = "GrauDeParentesco.findAll", query = "SELECT g FROM GrauDeParentesco g")})
public class GrauDeParentesco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_grau_de_parentesco", nullable = false)
    private Integer pkGrauDeParentesco;
    @Basic(optional = false)
    @Column(nullable = false, length = 2147483647)
    private String nome;
    @OneToMany(mappedBy = "fkGrauDeParentesco")
    private List<ContactoDeEmergenciaPaciente> contactoDeEmergenciaPacienteList;

    public GrauDeParentesco() {
    }

    public GrauDeParentesco(Integer pkGrauDeParentesco) {
        this.pkGrauDeParentesco = pkGrauDeParentesco;
    }

    public GrauDeParentesco(Integer pkGrauDeParentesco, String nome) {
        this.pkGrauDeParentesco = pkGrauDeParentesco;
        this.nome = nome;
    }

    public Integer getPkGrauDeParentesco() {
        return pkGrauDeParentesco;
    }

    public void setPkGrauDeParentesco(Integer pkGrauDeParentesco) {
        this.pkGrauDeParentesco = pkGrauDeParentesco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ContactoDeEmergenciaPaciente> getContactoDeEmergenciaPacienteList() {
        return contactoDeEmergenciaPacienteList;
    }

    public void setContactoDeEmergenciaPacienteList(List<ContactoDeEmergenciaPaciente> contactoDeEmergenciaPacienteList) {
        this.contactoDeEmergenciaPacienteList = contactoDeEmergenciaPacienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkGrauDeParentesco != null ? pkGrauDeParentesco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrauDeParentesco)) {
            return false;
        }
        GrauDeParentesco other = (GrauDeParentesco) object;
        if ((this.pkGrauDeParentesco == null && other.pkGrauDeParentesco != null) || (this.pkGrauDeParentesco != null && !this.pkGrauDeParentesco.equals(other.pkGrauDeParentesco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucan.edu.HistoricoMedico.entities.GrauDeParentesco[ pkGrauDeParentesco=" + pkGrauDeParentesco + " ]";
    }
    
}
