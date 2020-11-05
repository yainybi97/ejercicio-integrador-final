package services.impl;

import daos.IVarianteDAO;
import daos.impl.VarianteDAOImpl;
import dtos.VarianteDTO;
import exception.DAOException;
import model.Variante;
import services.IVarianteService;


import java.util.ArrayList;
import java.util.List;

/**
 * Creado por @author: YainyBi
 * el 1/11/20
 **/
public class VarianteServiceImpl implements IVarianteService {

    private VarianteDTO varianteDTO;
    private VarianteDAOImpl varianteDAO;



    public VarianteServiceImpl() {
        this.varianteDAO = new VarianteDAOImpl();
    }


    /**
     *
     * @param id
     * @return
     * @throws DAOException
     */
    @Override
    public Variante consultarVariante(Integer id) throws DAOException {

        Variante variante = this.varianteDAO.getQuery(id);
        return variante;

    }


    /**
     *
     * @return
     * @throws DAOException
     */
    @Override
    public List<VarianteDTO> consultarVariantes() throws DAOException {
        List<VarianteDTO> varianteDTO = new ArrayList<>();

        List<Variante> variante =  this.varianteDAO.getVariantes();

        for(int i = 0; i < variante.size(); i++) {
            varianteDTO.add(converter(variante.get(i)));
        }
        return varianteDTO;
    }

    private VarianteDTO converter(Variante variante) {

        VarianteDTO varianteDTO = new VarianteDTO();
        varianteDTO.setId(variante.getId());
        varianteDTO.setDescripcion(variante.getDescripcion());
        varianteDTO.setPrecio(variante.getPrecio());

        return varianteDTO;
    }

    private Variante converter(VarianteDTO varianteDTO) {

        Variante variante = new Variante();
        variante.setId(varianteDTO.getId());
        variante.setDescripcion(varianteDTO.getDescripcion());
        variante.setPrecio(varianteDTO.getPrecio());
        return variante;
    }


    public VarianteDTO getVarianteDTO() {
        return varianteDTO;
    }

    public void setVarianteDTO(VarianteDTO varianteDTO) {
        this.varianteDTO = varianteDTO;
    }

    public VarianteDAOImpl getVarianteDAO() {
        return varianteDAO;
    }

    public void setVarianteDAO(VarianteDAOImpl varianteDAO) {
        this.varianteDAO = varianteDAO;
    }
}
