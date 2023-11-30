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
@Table(name = "receita_medicamento", catalog = "registo_medico", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ReceitaMedicamento.findAll", query = "SELECT r FROM ReceitaMedicamento r")})
public class ReceitaMedicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_receita_medicamento", nullable = false)
    private Integer pkReceitaMedicamento;
    @Column(name = "fk_receita")
    private Integer fkReceita;
    @Column(name = "fk_medicamento")
    private Integer fkMedicamento;
    @Column(name = "dosagem_medicamento", length = 2147483647)
    private String dosagemMedicamento;
    @Column(name = "concentracao_medicamento", length = 2147483647)
    private String concentracaoMedicamento;
    @Column(name = "horario_ingestao_medicamento", length = 2147483647)
    private String horarioIngestaoMedicamento;
    @Column(name = "duracao_ingestao_medicamento", length = 2147483647)
    private String duracaoIngestaoMedicamento;

    public ReceitaMedicamento() {
    }

    public ReceitaMedicamento(Integer pkReceitaMedicamento) {
        this.pkReceitaMedicamento = pkReceitaMedicamento;
    }

    public Integer getPkReceitaMedicamento() {
        return pkReceitaMedicamento;
    }

    public void setPkReceitaMedicamento(Integer pkReceitaMedicamento) {
        this.pkReceitaMedicamento = pkReceitaMedicamento;
    }

    public Integer getFkReceita() {
        return fkReceita;
    }

    public void setFkReceita(Integer fkReceita) {
        this.fkReceita = fkReceita;
    }

    public Integer getFkMedicamento() {
        return fkMedicamento;
    }

    public void setFkMedicamento(Integer fkMedicamento) {
        this.fkMedicamento = fkMedicamento;
    }

    public String getDosagemMedicamento() {
        return dosagemMedicamento;
    }

    public void setDosagemMedicamento(String dosagemMedicamento) {
        this.dosagemMedicamento = dosagemMedicamento;
    }

    public String getConcentracaoMedicamento() {
        return concentracaoMedicamento;
    }

    public void setConcentracaoMedicamento(String concentracaoMedicamento) {
        this.concentracaoMedicamento = concentracaoMedicamento;
    }

    public String getHorarioIngestaoMedicamento() {
        return horarioIngestaoMedicamento;
    }

    public void setHorarioIngestaoMedicamento(String horarioIngestaoMedicamento) {
        this.horarioIngestaoMedicamento = horarioIngestaoMedicamento;
    }

    public String getDuracaoIngestaoMedicamento() {
        return duracaoIngestaoMedicamento;
    }

    public void setDuracaoIngestaoMedicamento(String duracaoIngestaoMedicamento) {
        this.duracaoIngestaoMedicamento = duracaoIngestaoMedicamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkReceitaMedicamento != null ? pkReceitaMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReceitaMedicamento)) {
            return false;
        }
        ReceitaMedicamento other = (ReceitaMedicamento) object;
        if ((this.pkReceitaMedicamento == null && other.pkReceitaMedicamento != null) || (this.pkReceitaMedicamento != null && !this.pkReceitaMedicamento.equals(other.pkReceitaMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucan.edu.HistoricoMedico.entities.ReceitaMedicamento[ pkReceitaMedicamento=" + pkReceitaMedicamento + " ]";
    }
    
}
