package daos;
import exception.DAOException;
import model.Auto;
import model.Variante;

import java.util.List;

/**
 * Creado por @author: YainyBi
 * el 24/10/20
 **/
public interface IAutoDAO {

    public void insert(Auto auto) throws DAOException;
    public void update(Auto auto) throws DAOException;
    public void delete(Integer id) throws DAOException;
    public Auto getQuery(Integer id) throws DAOException;
    public List<Auto>imprimirAutos(List<Auto> autos) throws DAOException;
    public List<Auto> getAutos() throws DAOException;

}
