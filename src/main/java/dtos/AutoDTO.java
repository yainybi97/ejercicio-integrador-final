package dtos;

import model.Opcion;
import model.Variante;
import java.util.ArrayList;
import java.util.List;

/**
 * Creado por @author: YainyBi
 * el 1/11/20
 **/
public class AutoDTO {

    private Integer id;
    private Integer precioFinal;
    private Variante variante;
    private List<Opcion> opcionales;
    private Integer nroOpciones;


    public AutoDTO() {
        this.opcionales = new ArrayList<>();
        this.precioFinal = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(Integer precioFinal) {
        this.precioFinal = precioFinal;
    }

    public Variante getVariante() {
        return variante;
    }

    public void setVariante(Variante variante) {
        this.variante = variante;
    }

    public List<Opcion> getOpcionales() {
        return opcionales;
    }

    public void setOpcionales(List<Opcion> opcionales) {
        this.opcionales = opcionales;
    }

    public Integer getNroOpciones() {
        return nroOpciones;
    }

    public void setNroOpciones(Integer nroOpciones) {
        this.nroOpciones = nroOpciones;
    }



}
