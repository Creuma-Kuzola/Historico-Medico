/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package ucan.edu.HistoricoMedico.repositories;

import java.lang.annotation.Native;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucan.edu.HistoricoMedico.entities.Receita;
import ucan.edu.HistoricoMedico.entities.ReceitaMedicamento;
import ucan.edu.HistoricoMedico.utils.ReceitaConsultaConstum;

/**
 *
 * @author creuma
 */
@Repository
public interface ReceitaMedicamentoRepository extends JpaRepository<ReceitaMedicamento, Integer> {

    @Query("SELECT rm FROM ReceitaMedicamento rm WHERE rm.fkReceita.fkPaciente.pkPaciente = :fkPaciente")
    public List<ReceitaMedicamento> encontrarReceitaPaciente(@Param("fkPaciente") Integer fkPaciente);
}
