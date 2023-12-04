/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ucan.edu.HistoricoMedico.services;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author jussyleitecode
 */
public interface ExameService<T, k>
{
    public T salvar(T t);
    
    public Optional<T> encontrarPorId(T t);
    
    public List<T> encontrarTodos();
}
