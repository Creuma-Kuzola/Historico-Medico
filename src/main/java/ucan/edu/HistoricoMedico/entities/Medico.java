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
@Table(catalog = "registo_medico", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m")})
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_medico", nullable = false)
    private Integer pkMedico;
    @Basic(optional = false)
    @Column(nullable = false, length = 2147483647)
    private String nome;
    @Basic(optional = false)
    @Column(name = "numero_telefone", nullable = false, length = 2147483647)
    private String numeroTelefone;
    @Column(name = "numero_ordem")
    private Integer numeroOrdem;
    @JoinColumn(name = "fk_sexo", referencedColumnName = "pk_sexo")
    @ManyToOne
    private Sexo fkSexo;

    public Medico() {
    }

    public Medico(Integer pkMedico) {
        this.pkMedico = pkMedico;
    }

    public Medico(Integer pkMedico, String nome, String numeroTelefone) {
        this.pkMedico = pkMedico;
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
    }

    public Integer getPkMedico() {
        return pkMedico;
    }

    public void setPkMedico(Integer pkMedico) {
        this.pkMedico = pkMedico;
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

    public Integer getNumeroOrdem() {
        return numeroOrdem;
    }

    public void setNumeroOrdem(Integer numeroOrdem) {
        this.numeroOrdem = numeroOrdem;
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
        hash += (pkMedico != null ? pkMedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.pkMedico == null && other.pkMedico != null) || (this.pkMedico != null && !this.pkMedico.equals(other.pkMedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucan.edu.HistoricoMedico.entities.Medico[ pkMedico=" + pkMedico + " ]";
    }
    
}
