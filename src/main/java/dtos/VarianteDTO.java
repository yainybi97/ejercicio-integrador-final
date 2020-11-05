package dtos;

/**
 * Creado por @author: YainyBi
 * el 1/11/20
 **/
public class VarianteDTO {

    private Integer precio;
    private Integer id;
    private String descripcion;

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
