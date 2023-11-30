/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author creuma
 */
@Entity
@Table(catalog = "registo_medico", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Medicamento.findAll", query = "SELECT m FROM Medicamento m")})
public class Medicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_medicamento", nullable = false)
    private Integer pkMedicamento;
    @Basic(optional = false)
    @Column(nullable = false, length = 2147483647)
    private String nome;
    @Basic(optional = false)
    @Column(nullable = false)
    private double preco;
    @Basic(optional = false)
    @Column(nullable = false, length = 2147483647)
    private String descricao;
    @Column(name = "data_fabricacao")
    @Temporal(TemporalType.DATE)
    private Date dataFabricacao;
    @Column(name = "data_expiracao")
    @Temporal(TemporalType.DATE)
    private Date dataExpiracao;

    public Medicamento() {
    }

    public Medicamento(Integer pkMedicamento) {
        this.pkMedicamento = pkMedicamento;
    }

    public Medicamento(Integer pkMedicamento, String nome, double preco, String descricao) {
        this.pkMedicamento = pkMedicamento;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public Integer getPkMedicamento() {
        return pkMedicamento;
    }

    public void setPkMedicamento(Integer pkMedicamento) {
        this.pkMedicamento = pkMedicamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public Date getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(Date dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkMedicamento != null ? pkMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamento)) {
            return false;
        }
        Medicamento other = (Medicamento) object;
        if ((this.pkMedicamento == null && other.pkMedicamento != null) || (this.pkMedicamento != null && !this.pkMedicamento.equals(other.pkMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucan.edu.HistoricoMedico.entities.Medicamento[ pkMedicamento=" + pkMedicamento + " ]";
    }
    
}
