/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package ucan.edu.HistoricoMedico.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucan.edu.HistoricoMedico.entities.ContactoDeEmergenciaPaciente;
import ucan.edu.HistoricoMedico.entities.ReceitaMedicamento;

/**
 *
 * @author creuma
 */
@Repository
public interface ContactoDeEmergenciaPacienteRepository extends JpaRepository<ContactoDeEmergenciaPaciente, Integer> {
    
     @Query("SELECT cep FROM ContactoDeEmergenciaPaciente cep WHERE cep.fkPaciente.pkPaciente = :fkPaciente")
    public List<ContactoDeEmergenciaPaciente> findContactoDeEmergenciaPacienteByPkPaciente(@Param("fkPaciente") Integer fkPaciente);
}
