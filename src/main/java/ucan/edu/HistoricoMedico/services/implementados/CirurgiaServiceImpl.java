/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucan.edu.HistoricoMedico.services.implementados;

import org.springframework.stereotype.Service;
import ucan.edu.HistoricoMedico.entities.Cirurgia;
import ucan.edu.HistoricoMedico.entities.Triagem;
import ucan.edu.HistoricoMedico.services.CirurgiaService;


/**
 *
 * @author jussyleitecode
 */
@Service
public class CirurgiaServiceImpl extends AbstractService<Cirurgia, Integer> implements CirurgiaService<Triagem, Integer>
{

}
