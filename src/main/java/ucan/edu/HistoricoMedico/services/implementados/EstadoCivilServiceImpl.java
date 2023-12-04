/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.services.implementados;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucan.edu.HistoricoMedico.entities.EstadoCivil;
import ucan.edu.HistoricoMedico.entities.TipoSanguineo;
import ucan.edu.HistoricoMedico.repositories.TipoSanguineoRepository;
import ucan.edu.HistoricoMedico.services.EstadoCivilService;
import ucan.edu.HistoricoMedico.services.TipoSanguineoService;

/**
 *
 * @author jussyleitecode
 */
@Service
public class EstadoCivilServiceImpl extends AbstractService<EstadoCivil, Integer> implements EstadoCivilService<EstadoCivil, Integer>
{

}
