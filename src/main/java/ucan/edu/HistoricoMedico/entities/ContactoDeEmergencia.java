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
@Table(name = "contacto_de_emergencia", catalog = "registo_medico", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ContactoDeEmergencia.findAll", query = "SELECT c FROM ContactoDeEmergencia c")})
public class ContactoDeEmergencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_contacto_de_emergencia", nullable = false)
    private Integer pkContactoDeEmergencia;
    @Column(length = 2147483647)
    private String nome;
    @Column(name = "numero_telefone", length = 2147483647)
    private String numeroTelefone;
    @OneToMany(mappedBy = "fkContactoDeEmergencia")
    private List<ContactoDeEmergenciaPaciente> contactoDeEmergenciaPacienteList;
    @JoinColumn(name = "fk_sexo", referencedColumnName = "pk_sexo")
    @ManyToOne
    private Sexo fkSexo;

    public ContactoDeEmergencia() {
    }

    public ContactoDeEmergencia(Integer pkContactoDeEmergencia) {
        this.pkContactoDeEmergencia = pkContactoDeEmergencia;
    }

    public Integer getPkContactoDeEmergencia() {
        return pkContactoDeEmergencia;
    }

    public void setPkContactoDeEmergencia(Integer pkContactoDeEmergencia) {
        this.pkContactoDeEmergencia = pkContactoDeEmergencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public List<ContactoDeEmergenciaPaciente> getContactoDeEmergenciaPacienteList() {
        return contactoDeEmergenciaPacienteList;
    }

    public void setContactoDeEmergenciaPacienteList(List<ContactoDeEmergenciaPaciente> contactoDeEmergenciaPacienteList) {
        this.contactoDeEmergenciaPacienteList = contactoDeEmergenciaPacienteList;
    }

    public Sexo getFkSexo() {
        return fkSexo;
    }

    public void setFkSexo(Sexo fkSexo) {
        this.fkSexo = fkSexo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkContactoDeEmergencia != null ? pkContactoDeEmergencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactoDeEmergencia)) {
            return false;
        }
        ContactoDeEmergencia other = (ContactoDeEmergencia) object;
        if ((this.pkContactoDeEmergencia == null && other.pkContactoDeEmergencia != null) || (this.pkContactoDeEmergencia != null && !this.pkContactoDeEmergencia.equals(other.pkContactoDeEmergencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucan.edu.HistoricoMedico.entities.ContactoDeEmergencia[ pkContactoDeEmergencia=" + pkContactoDeEmergencia + " ]";
    }
    
}
