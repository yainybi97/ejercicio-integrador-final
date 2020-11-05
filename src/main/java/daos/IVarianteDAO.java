package daos;
import exception.DAOException;
import model.Opcion;
import model.Variante;

import java.util.List;

/**
 * Creado por @author: YainyBi
 * el 24/10/20
 **/
public interface IVarianteDAO {

    public void insert(Variante variante) throws DAOException;
    public void update(Variante variante) throws DAOException;
    public void delete(Integer id) throws DAOException;
    public Variante getQuery(Integer id) throws DAOException;
    public List<Variante> getVariantes() throws DAOException;



}
