package services.impl;
import daos.impl.OpcionDAOImpl;
import dtos.OpcionDTO;
import exception.DAOException;
import model.Opcion;
import services.IOpcionService;

import java.util.ArrayList;
import java.util.List;

/**
 * Creado por @author: YainyBi
 * el 1/11/20
 **/
public class OpcionServiceImpl implements IOpcionService {

    private OpcionDTO opcionDTO;
    private OpcionDAOImpl opcionDAO;

    public OpcionServiceImpl() {
        this.opcionDTO = new OpcionDTO();
        this.opcionDAO = new OpcionDAOImpl();
    }


    /**
     *
     * @return
     * @throws DAOException
     */

    @Override
    public List<OpcionDTO> ConsultarOpcionales() throws DAOException {

        List<OpcionDTO> opcionalesDTO = new ArrayList<>();

        List<Opcion> opcion =  this.opcionDAO.getOpcions();

        for(int i = 0; i < opcion.size(); i++) {
            opcionalesDTO.add(converter(opcion.get(i)));
        }
        return opcionalesDTO;
    }


    /**
     *
     * @param id
     * @return
     * @throws DAOException
     */
    @Override
    public OpcionDTO consultarOpcion(Integer id) throws DAOException {

        OpcionDTO opcionDTO = converter(this.opcionDAO.getQuery(id));
        return opcionDTO;

    }

    private OpcionDTO converter(Opcion opcion) {

       OpcionDTO opcionDTO = new OpcionDTO();

       opcionDTO.setId(opcion.getId());
       opcionDTO.setDescripcion(opcion.getDescripcion());
       opcionDTO.setPrecio(opcion.getPrecio());

       return opcionDTO;
    }

    public OpcionDTO getOpcionDTO() {
        return opcionDTO;
    }

    public void setOpcionDTO(OpcionDTO opcionDTO) {
        this.opcionDTO = opcionDTO;
    }

    public OpcionDAOImpl getOpcionDAO() {
        return opcionDAO;
    }

    public void setOpcionDAO(OpcionDAOImpl opcionDAO) {
        this.opcionDAO = opcionDAO;
    }
}
