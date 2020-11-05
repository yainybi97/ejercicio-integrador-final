package services.impl;

import daos.impl.AutoDAOImpl;
import dtos.*;
import exception.DAOException;
import exception.ServiceException;
import model.*;
import services.IAutoService;

import java.util.ArrayList;
import java.util.List;

/**
 * Creado por @author: YainyBi
 * el 1/11/20
 **/
public class AutoServiceImpl implements IAutoService {

    private AutoDAOImpl autoDAO;
    private AutoDTO auto;

    public AutoServiceImpl() {
        this.autoDAO = new AutoDAOImpl();


    }

    /**
     *
     * @return
     * @throws ServiceException
     */
    @Override
    public Integer calcularPrecioFinal() throws ServiceException {
        Integer total = 0;
        try {
            Integer precioOpcionales = calcularPrecioTotalDeOpcionales();
            Integer precioVariante = this.auto.getVariante().getPrecio();
            total = precioOpcionales + precioVariante;

        } catch (Exception ex) {
            throw new ServiceException("Error: Clase AutoService método calcularPrecioFinal" + ex.getCause());
        }
        return total;
    }

    /**
     *
     * @return
     * @throws ServiceException
     */
    @Override
    public Integer calcularPrecioTotalDeOpcionales() throws ServiceException {
        Integer precioTotal = 0;
        try {
            if (!this.auto.getOpcionales().isEmpty()) {
                for (int i = 0; i < this.auto.getOpcionales().size(); i++) {
                    precioTotal = precioTotal + this.auto.getOpcionales().get(i).getPrecio();
                }
            }

        } catch (Exception ex) {
            throw new ServiceException("Error: Clase AutoService método calcularPrecioTotalDeOpcionales" + ex.getCause());
        }

        return precioTotal;
    }

    /**
     *
     * @param opcionalesDTO
     * @throws ServiceException
     */
    @Override
    public void agregarOpcionales(List<OpcionDTO> opcionalesDTO) throws ServiceException {
        List<Opcion> opcionales = new ArrayList<>();
        for (int i = 0; i < opcionalesDTO.size(); i++) {
            opcionales.add(converter(opcionalesDTO.get(i)));
        }
        this.auto.setOpcionales(opcionales);

    }

    /**
     *
     * @param autoDTO
     * @throws DAOException
     */
    @Override
    public void agregar(AutoDTO autoDTO) throws DAOException {

        this.autoDAO.insert(converter(autoDTO));
    }

    /**
     *
     * @param idAutoDTO
     * @throws DAOException
     */
    @Override
    public void eliminar(Integer idAutoDTO) throws DAOException {
        this.autoDAO.delete(idAutoDTO);

    }


    /**
     *
     * @param autoDTO
     * @throws DAOException
     */
    @Override
    public void modificar(AutoDTO autoDTO) throws DAOException {
        this.autoDAO.update(converter(autoDTO));

    }


    /**
     *
     * @return
     * @throws DAOException
     */
    @Override
    public List<AutoDTO> ConsultarAutos() throws DAOException {
        List<AutoDTO> autosDTO = new ArrayList<>();
        List<Auto> autos = this.autoDAO.getAutos();
        System.out.println(autos.size());
        for (int i = 0; i < autos.size(); i++) {
            autosDTO.add(converter(autos.get(i)));
        }
        return autosDTO;
    }

    /**
     *
     * @param idAutoDTO
     * @return
     * @throws DAOException
     */
    @Override
    public Integer consultaPrecioPorAuto(Integer idAutoDTO) throws DAOException {
        Auto auto = this.autoDAO.getQuery(idAutoDTO);
        Integer precioAuto = auto.getPrecioFinal();
        return precioAuto;
    }

    /**
     *
     * @param idAutoDTO
     * @return
     * @throws DAOException
     */
    @Override
    public AutoDTO consultarAuto(Integer idAutoDTO) throws DAOException {
        Auto auto = this.autoDAO.getQuery(idAutoDTO);
        AutoDTO autoDTO = converter(auto);
        return autoDTO;
    }


    private Opcion converter(OpcionDTO opcionDto) {

        Opcion opcion = new Opcion();

        opcion.setId(opcionDto.getId());
        opcion.setDescripcion(opcionDto.getDescripcion());
        opcion.setPrecio(opcionDto.getPrecio());

        return opcion;
    }

    private Auto converter(AutoDTO autoDTO) {

        Auto auto = new Auto();

        auto.setPrecioFinal(autoDTO.getPrecioFinal());
        auto.setId(autoDTO.getId());
        auto.setNroOpciones(autoDTO.getOpcionales().size());
        auto.setOpcionales(autoDTO.getOpcionales());
        auto.setVariante(autoDTO.getVariante());
        return auto;


    }

    private AutoDTO converter(Auto auto) {

        AutoDTO autoDTO = new AutoDTO();
        autoDTO.setPrecioFinal(auto.getPrecioFinal());
        autoDTO.setId(auto.getId());
        autoDTO.setOpcionales(auto.getOpcionales());
        autoDTO.setNroOpciones(auto.getOpcionales().size());
        auto.setVariante(auto.getVariante());

        return autoDTO;
    }

    public AutoDAOImpl getAutoDAO() {
        return autoDAO;
    }

    public void setAutoDAO(AutoDAOImpl autoDAO) {
        this.autoDAO = autoDAO;
    }

    public AutoDTO getAuto() {
        return auto;
    }

    public void setAuto(AutoDTO auto) {
        this.auto = auto;
    }
}
