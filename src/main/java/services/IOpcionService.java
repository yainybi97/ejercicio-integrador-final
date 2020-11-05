package services;

import dtos.OpcionDTO;
import exception.DAOException;

import java.util.List;

/**
 * Creado por @author: YainyBi
 * el 1/11/20
 **/
public interface IOpcionService {

    public List<OpcionDTO>ConsultarOpcionales() throws DAOException;

    public OpcionDTO consultarOpcion(Integer id) throws DAOException;
}
