/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author creuma
 */
@Entity
@Table(catalog = "registo_medico", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Exame.findAll", query = "SELECT e FROM Exame e")})
public class Exame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_exame", nullable = false)
    private Integer pkExame;
    @Column(length = 2147483647)
    private String nome;
    @Column(length = 2147483647)
    private String resultado;
    @Column(name = "data_exame")
    @Temporal(TemporalType.DATE)
    private Date dataExame;
    @OneToMany(mappedBy = "fkExame")
    private List<ExameConsulta> exameConsultaList;

    public Exame() {
    }

    public Exame(Integer pkExame) {
        this.pkExame = pkExame;
    }

    public Integer getPkExame() {
        return pkExame;
    }

    public void setPkExame(Integer pkExame) {
        this.pkExame = pkExame;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Date getDataExame() {
        return dataExame;
    }

    public void setDataExame(Date dataExame) {
        this.dataExame = dataExame;
    }

    public List<ExameConsulta> getExameConsultaList() {
        return exameConsultaList;
    }

    public void setExameConsultaList(List<ExameConsulta> exameConsultaList) {
        this.exameConsultaList = exameConsultaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkExame != null ? pkExame.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exame)) {
            return false;
        }
        Exame other = (Exame) object;
        if ((this.pkExame == null && other.pkExame != null) || (this.pkExame != null && !this.pkExame.equals(other.pkExame))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucan.edu.HistoricoMedico.entities.Exame[ pkExame=" + pkExame + " ]";
    }
    
}
