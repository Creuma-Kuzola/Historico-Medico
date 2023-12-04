/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.services.implementados;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucan.edu.HistoricoMedico.entities.ExameConsulta;
import ucan.edu.HistoricoMedico.entities.TipoSanguineo;
import ucan.edu.HistoricoMedico.entities.Triagem;
import ucan.edu.HistoricoMedico.repositories.TipoSanguineoRepository;
import ucan.edu.HistoricoMedico.services.ExameConsultaService;
import ucan.edu.HistoricoMedico.services.TipoSanguineoService;
import ucan.edu.HistoricoMedico.services.TriagemService;

/**
 *
 * @author jussyleitecode
 */
@Service
public class ExameConsultaServiceImpl extends AbstractService<ExameConsulta, Integer> implements ExameConsultaService<ExameConsulta, Integer>
{

}
