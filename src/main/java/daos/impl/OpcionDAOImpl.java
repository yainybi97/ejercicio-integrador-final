package daos.impl;
import daos.IOpcionDAO;
import exception.DAOException;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Creado por @author: YainyBi
 * el 24/10/20
 **/


public class OpcionDAOImpl implements IOpcionDAO {

    private Connection conn = AccesoConexion.getConnection();


    /**
     *
     * @param opcion
     * @throws DAOException
     */
    @Override
    public void insert(Opcion opcion) throws DAOException {
        PreparedStatement sentencia = null;
        String consulta = "INSERT INTO Opcion  VALUES (null, ?, ?)";
        try {

            sentencia = this.conn.prepareStatement(consulta , PreparedStatement.RETURN_GENERATED_KEYS);
            sentencia.setString(1, opcion.getDescripcion());
            sentencia.setInt(2, opcion.getPrecio());


            int resultado = sentencia.executeUpdate();
            System.out.println(isInsert(resultado));

            ResultSet rs = sentencia.getGeneratedKeys();
            while (rs.next()) {
                int claveAsignada = rs.getInt(1);
                opcion.setId(claveAsignada);
            }

            rs.close();
            sentencia.close();

        } catch (Exception ex) {
            throw new DAOException("Error: Clase OpcionDAOImpl, método insert" + ex.getCause());
        }
    }


    /**
     *
     * @param opcion
     * @throws DAOException
     */
    @Override
    public void update(Opcion opcion) throws DAOException {
        PreparedStatement sentencia = null;
        String consulta = "UPDATE Opcion SET Descripcion = ?, Precio = ? WHERE Id = ?";

        try {
            sentencia = this.conn.prepareStatement(consulta);
            sentencia.setString(1, opcion.getDescripcion());
            sentencia.setInt(2, opcion.getPrecio());
            sentencia.setInt(3, opcion.getId());

            int resultado = sentencia.executeUpdate();
            System.out.println(isUpdate(resultado));

            sentencia.close();
        } catch (Exception ex) {
            throw new DAOException("Error: Clase OpcionDAOImple, método update" + ex.getCause());
        }
    }

    /**
     *
     * @param id
     * @throws DAOException
     */
    @Override
    public void delete(Integer id) throws DAOException {
        String consulta = "DELETE FROM Opcion  WHERE Id =" + id;

        try {
            PreparedStatement sentencia = this.conn.prepareStatement(consulta);

            int resultado = sentencia.executeUpdate(consulta);
            System.out.println(isDelete(resultado));
            sentencia.close();

        } catch (Exception ex) {
            throw new DAOException("Error: Clase OpcionDAOImple, método delete" + ex.getCause());
        }
    }

    /**
     *
     * @param id
     * @return
     * @throws DAOException
     */
    @Override
    public Opcion getQuery(Integer id) throws DAOException {
        Opcion opcion = null;
        String consulta = "SELECT * FROM Opcion WHERE Id = " + id;
        try {

            PreparedStatement sentencia = this.conn.prepareStatement(consulta);
            ResultSet rs = sentencia.executeQuery(consulta);

            if (rs.next()) {
                //opcion = new Opcion(rs.getString("Descripcion"), rs.getInt("Precio"), rs.getInt("Id"));
                opcion = new Opcion();
                opcion.setId(rs.getInt("Id"));
                opcion.setDescripcion(rs.getString("Descripcion"));
                opcion.setPrecio(rs.getInt("Precio"));

            }

        } catch (Exception ex) {
            throw new DAOException("Error: Clase OpcionteDAOImple, método getQuery" + ex.getCause());
        }
        return opcion;
    }

    /**
     *
     * @return
     * @throws DAOException
     */
    @Override
    public List<Opcion> getOpcions() throws DAOException {
        String consultar = "SELECT * FROM Opcion ORDER BY ID";
        List<Opcion> opcions = new ArrayList<>();

        try {
            Statement sentencia = this.conn.createStatement();
            ResultSet rs = sentencia.executeQuery(consultar);

            while (rs.next()) {
                //Opcion opcion = new Opcion(rs.getString("Descripcion"), rs.getInt("Precio"), rs.getInt("Id"));
                Opcion opcion = new Opcion();
                opcion.setId(rs.getInt("Id"));
                opcion.setDescripcion(rs.getString("Descripcion"));
                opcion.setPrecio(rs.getInt("Precio"));

                opcions.add(opcion);
            }
            rs.close();
            sentencia.close();

        }catch (Exception ex) {
            throw new DAOException("Error: Clase OpcionDAOImple, método getOpcions" + ex.getCause());
        }
        return opcions;
    }



    private String isDelete(int resultado) {
        return (resultado > 0)? "ELIMINADO" : "NO ELIMINADO";
    }

    private String isInsert(int resultado) {
        return (resultado > 0)? "INSERTADO" : "NO INSERTADO";
    }

    private String isUpdate(int resultado) {
        return (resultado > 0)? "MODIFICADO" : "NO MODIFICADO";
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void imprimirOpcions(List<Opcion> opcions) {
        for (Opcion opcion: opcions) {
            System.out.println("Id \t" + opcion.getId() + " Descrip \t" + opcion.getDescripcion() + " $\t" + opcion.getPrecio());
        }
    }

    public void imprimirOpcion(Opcion opcion) {
        System.out.println("Id \t" + opcion.getId() + " Descrip \t" + opcion.getDescripcion() + " $\t" + opcion.getPrecio());
    }

}
