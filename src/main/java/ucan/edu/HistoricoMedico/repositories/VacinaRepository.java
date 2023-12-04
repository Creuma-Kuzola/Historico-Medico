/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ucan.edu.HistoricoMedico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ucan.edu.HistoricoMedico.entities.TipoSanguineo;
import ucan.edu.HistoricoMedico.entities.Triagem;
import ucan.edu.HistoricoMedico.entities.Vacina;

/**
 *
 * @author jussyleitecode
 */
public interface VacinaRepository extends JpaRepository<Vacina, Integer>
{
    
}
