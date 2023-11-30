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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Triagem.findAll", query = "SELECT t FROM Triagem t")})
public class Triagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_triagem", nullable = false)
    private Integer pkTriagem;
    @Basic(optional = false)
    @Column(nullable = false)
    private double peso;
    @Basic(optional = false)
    @Column(nullable = false)
    private double temperatura;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 17, scale = 17)
    private Double altura;
    @Column(name = "data_triagem")
    @Temporal(TemporalType.DATE)
    private Date dataTriagem;
    @JoinColumn(name = "fk_consulta", referencedColumnName = "pk_consulta")
    @ManyToOne
    private Consulta fkConsulta;

    public Triagem() {
    }

    public Triagem(Integer pkTriagem) {
        this.pkTriagem = pkTriagem;
    }

    public Triagem(Integer pkTriagem, double peso, double temperatura) {
        this.pkTriagem = pkTriagem;
        this.peso = peso;
        this.temperatura = temperatura;
    }

    public Integer getPkTriagem() {
        return pkTriagem;
    }

    public void setPkTriagem(Integer pkTriagem) {
        this.pkTriagem = pkTriagem;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Date getDataTriagem() {
        return dataTriagem;
    }

    public void setDataTriagem(Date dataTriagem) {
        this.dataTriagem = dataTriagem;
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
        hash += (pkTriagem != null ? pkTriagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Triagem)) {
            return false;
        }
        Triagem other = (Triagem) object;
        if ((this.pkTriagem == null && other.pkTriagem != null) || (this.pkTriagem != null && !this.pkTriagem.equals(other.pkTriagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucan.edu.HistoricoMedico.entities.Triagem[ pkTriagem=" + pkTriagem + " ]";
    }
    
}
