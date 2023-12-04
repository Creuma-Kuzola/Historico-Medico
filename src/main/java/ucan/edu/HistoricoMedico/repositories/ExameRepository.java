/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ucan.edu.HistoricoMedico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ucan.edu.HistoricoMedico.entities.Exame;

/**
 *
 * @author jussyleitecode
 */
public interface ExameRepository extends JpaRepository<Exame, Integer>
{
    
}
