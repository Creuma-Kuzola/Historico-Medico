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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author creuma
 */
@Entity
@Table(name = "item_alergico", catalog = "registo_medico", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ItemAlergico.findAll", query = "SELECT i FROM ItemAlergico i")})
public class ItemAlergico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_item_alergico", nullable = false)
    private Integer pkItemAlergico;
    @Basic(optional = false)
    @Column(nullable = false, length = 2147483647)
    private String nome;
    @Basic(optional = false)
    @Column(nullable = false, length = 2147483647)
    private String descricao;
    @Column(name = "fk_paciente")
    private Integer fkPaciente;

    public ItemAlergico() {
    }

    public ItemAlergico(Integer pkItemAlergico) {
        this.pkItemAlergico = pkItemAlergico;
    }

    public ItemAlergico(Integer pkItemAlergico, String nome, String descricao) {
        this.pkItemAlergico = pkItemAlergico;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getPkItemAlergico() {
        return pkItemAlergico;
    }

    public void setPkItemAlergico(Integer pkItemAlergico) {
        this.pkItemAlergico = pkItemAlergico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getFkPaciente() {
        return fkPaciente;
    }

    public void setFkPaciente(Integer fkPaciente) {
        this.fkPaciente = fkPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkItemAlergico != null ? pkItemAlergico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemAlergico)) {
            return false;
        }
        ItemAlergico other = (ItemAlergico) object;
        if ((this.pkItemAlergico == null && other.pkItemAlergico != null) || (this.pkItemAlergico != null && !this.pkItemAlergico.equals(other.pkItemAlergico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucan.edu.HistoricoMedico.entities.ItemAlergico[ pkItemAlergico=" + pkItemAlergico + " ]";
    }
    
}
