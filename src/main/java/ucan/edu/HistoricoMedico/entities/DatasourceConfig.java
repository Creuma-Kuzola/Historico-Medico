/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author creuma
 */
@Entity

@Table(name = "datasource_config", catalog = "registo_medico_datasource", schema = "public")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

@Getter
@Setter
@ToString

public class DatasourceConfig implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_datasource_config", nullable = false)
    private Integer pkDatasourceConfig;
    @Basic(optional = false)
    @Column(name = "nome_instituicao_saude", nullable = false, length = 2147483647)
    private String nomeInstituicaoSaude;
    @Basic(optional = false)
    @Column(name = "tenant_id", nullable = false, length = 2147483647)
    private String tenantId;
    @Basic(optional = false)
    @Column(nullable = false, length = 2147483647)
    private String username;
    @Basic(optional = false)
    @Column(nullable = false, length = 2147483647)
    private String password;
    @Basic(optional = false)
    @Column(nullable = false, length = 2147483647)
    private String url;
    @Basic(optional = false)
    @Column(name = "driver_class_name", nullable = false, length = 2147483647)
    private String driverClassName;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean initialize;

}
