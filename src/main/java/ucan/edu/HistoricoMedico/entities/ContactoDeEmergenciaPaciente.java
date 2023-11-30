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
@Table(name = "contacto_de_emergencia_paciente", catalog = "registo_medico", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ContactoDeEmergenciaPaciente.findAll", query = "SELECT c FROM ContactoDeEmergenciaPaciente c")})
public class ContactoDeEmergenciaPaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_contacto_de_emergencia_paciente", nullable = false)
    private Integer pkContactoDeEmergenciaPaciente;
    @JoinColumn(name = "fk_contacto_de_emergencia", referencedColumnName = "pk_contacto_de_emergencia")
    @ManyToOne
    private ContactoDeEmergencia fkContactoDeEmergencia;
    @JoinColumn(name = "fk_grau_de_parentesco", referencedColumnName = "pk_grau_de_parentesco")
    @ManyToOne
    private GrauDeParentesco fkGrauDeParentesco;
    @JoinColumn(name = "fk_paciente", referencedColumnName = "pk_paciente")
    @ManyToOne
    private Paciente fkPaciente;

    public ContactoDeEmergenciaPaciente() {
    }

    public ContactoDeEmergenciaPaciente(Integer pkContactoDeEmergenciaPaciente) {
        this.pkContactoDeEmergenciaPaciente = pkContactoDeEmergenciaPaciente;
    }

    public Integer getPkContactoDeEmergenciaPaciente() {
        return pkContactoDeEmergenciaPaciente;
    }

    public void setPkContactoDeEmergenciaPaciente(Integer pkContactoDeEmergenciaPaciente) {
        this.pkContactoDeEmergenciaPaciente = pkContactoDeEmergenciaPaciente;
    }

    public ContactoDeEmergencia getFkContactoDeEmergencia() {
        return fkContactoDeEmergencia;
    }

    public void setFkContactoDeEmergencia(ContactoDeEmergencia fkContactoDeEmergencia) {
        this.fkContactoDeEmergencia = fkContactoDeEmergencia;
    }

    public GrauDeParentesco getFkGrauDeParentesco() {
        return fkGrauDeParentesco;
    }

    public void setFkGrauDeParentesco(GrauDeParentesco fkGrauDeParentesco) {
        this.fkGrauDeParentesco = fkGrauDeParentesco;
    }

    public Paciente getFkPaciente() {
        return fkPaciente;
    }

    public void setFkPaciente(Paciente fkPaciente) {
        this.fkPaciente = fkPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkContactoDeEmergenciaPaciente != null ? pkContactoDeEmergenciaPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactoDeEmergenciaPaciente)) {
            return false;
        }
        ContactoDeEmergenciaPaciente other = (ContactoDeEmergenciaPaciente) object;
        if ((this.pkContactoDeEmergenciaPaciente == null && other.pkContactoDeEmergenciaPaciente != null) || (this.pkContactoDeEmergenciaPaciente != null && !this.pkContactoDeEmergenciaPaciente.equals(other.pkContactoDeEmergenciaPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucan.edu.HistoricoMedico.entities.ContactoDeEmergenciaPaciente[ pkContactoDeEmergenciaPaciente=" + pkContactoDeEmergenciaPaciente + " ]";
    }
    
}
