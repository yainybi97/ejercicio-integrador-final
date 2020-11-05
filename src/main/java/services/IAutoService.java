package services;

import dtos.*;
import exception.DAOException;
import exception.ServiceException;


import java.util.List;

/**
 * Creado por @author: YainyBi
 * el 1/11/20
 **/
public interface IAutoService {

    public Integer calcularPrecioFinal() throws ServiceException;

    public Integer calcularPrecioTotalDeOpcionales() throws ServiceException;

    public void agregarOpcionales(List<OpcionDTO> opcionalesDTO) throws ServiceException;

    public void eliminar(Integer idAutoDTO) throws DAOException;

    public void modificar(AutoDTO autoDTO) throws DAOException;

    public List<AutoDTO> ConsultarAutos() throws DAOException;

    public Integer consultaPrecioPorAuto(Integer idAutoDTO) throws DAOException;

    public AutoDTO consultarAuto(Integer idAutoDTO) throws DAOException;

    public void agregar(AutoDTO autoDTO) throws DAOException;

}
