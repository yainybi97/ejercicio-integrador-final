package services;

import dtos.VarianteDTO;
import exception.DAOException;
import model.Variante;

import java.util.List;

/**
 * Creado por @author: YainyBi
 * el 1/11/20
 **/
public interface IVarianteService {

    public List<VarianteDTO> consultarVariantes() throws DAOException;

    public Variante consultarVariante(Integer id) throws DAOException;
}
