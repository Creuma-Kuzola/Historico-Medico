/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ucan.edu.HistoricoMedico.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ucan.edu.HistoricoMedico.entities.ExameConsulta;
import ucan.edu.HistoricoMedico.entities.Triagem;

/**
 *
 * @author jussyleitecode
 */
public interface ExameConsultaRepository extends JpaRepository<ExameConsulta, Integer> {

    @Query("SELECT ec FROM  ExameConsulta ec WHERE ec.fkConsulta.fkPaciente.pkPaciente = :fkPaciente")
    public List<ExameConsulta> findExameConsultByPaciente(@Param("fkPaciente") Integer fkPaciente);

}
