package daos;
import exception.DAOException;
import model.Opcion;
import java.util.List;

/**
 * Creado por @author: YainyBi
 * el 24/10/20
 **/
public interface IOpcionDAO {

    public void insert(Opcion opcion) throws DAOException;
    public void update(Opcion opcion) throws DAOException;
    public void delete(Integer id) throws DAOException;
    public Opcion getQuery(Integer id) throws DAOException;
    public List<Opcion> getOpcions() throws DAOException;


}
