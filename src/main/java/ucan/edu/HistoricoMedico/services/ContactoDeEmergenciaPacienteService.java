/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ucan.edu.HistoricoMedico.services;

import java.util.List;

/**
 *
 * @author creuma
 */
public interface ContactoDeEmergenciaPacienteService <T, K> {
    
    public List<T> findContactoEmergenciaPacienteByPkPaciente(K k);
}
