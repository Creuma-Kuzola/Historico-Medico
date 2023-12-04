/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package ucan.edu.HistoricoMedico.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ucan.edu.HistoricoMedico.entities.CirurgiaMedico;
import ucan.edu.HistoricoMedico.entities.ReceitaMedicamento;

/**
 *
 * @author creuma
 */
public interface CirurgiaMedicoRepository extends JpaRepository<CirurgiaMedico, Integer> {
    
    @Query("SELECT cm FROM CirurgiaMedico cm WHERE cm.fkCirurgia.fkPaciente.pkPaciente = :fkPaciente")
    public List<CirurgiaMedico> findCirurgiaMedicoByPkPaciente(@Param("fkPaciente") Integer fkPaciente);
    
}
