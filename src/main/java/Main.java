/**
 * Creado por @author: YainyBi
 * el 16/10/20
 **/

import daos.impl.*;
import dtos.AutoDTO;
import dtos.OpcionDTO;
import model.*;
import services.impl.AutoServiceImpl;
import services.impl.OpcionServiceImpl;
import services.impl.VarianteServiceImpl;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        /*--------------------------------------------------------------------*/
        /*                 objetos DAO                                */
        /*--------------------------------------------------------------------*/



        /*--------------------------------------------------------------------*/
        /*               Variantes  Pruebas                                  */
        /*--------------------------------------------------------------------*/



        /*--------------------------------------------------------------------*/
        /*                      Opciones Prueba                */
        /*--------------------------------------------------------------------*/




        /*--------------------------------------------------------------------*/
        /*                     Auto Prueba                            */
        /*--------------------------------------------------------------------*/
/*
        Auto auto = new Auto(var2, 5);
        auto.agregarOpcion(op1);
        auto.calcularPrecioFinal();



        Auto nuevo = new Auto(variImpl.getQuery(2));
        nuevo.agregarOpcion(opcImpl.getQuery(2));
        nuevo.agregarOpcion(opcImpl.getQuery(3));
*/

        // PRUEBA AGG//
       /* Auto auto1 = new Auto();
        auto1.agregarOpcion(opcImpl.getQuery(4));
        auto1.agregarOpcion(opcImpl.getQuery(5));
        auto1.calcularPrecioFinal();

*/
        // PRUEBA MODIFI //
       // Auto auto1M = new Auto(variImpl.getQuery(3), 6);



   /*     Auto auto5 = new Auto();
        auto5.setVariante(variImpl.getQuery(2));
        auto5.agregarOpcion(opcImpl.getQuery(4));
        auto5.calcularPrecioFinal();

        Auto auto5M = new Auto();
        auto5M.setVariante(variImpl.getQuery(3));
        auto5M.agregarOpcion(opcImpl.getQuery(5));
        auto5M.calcularPrecioFinal();
        auto5M.setId(6);
*/

        /*--------------------------------------------------------------------*/
        /*                                  ELIMINAR                        */
        /*--------------------------------------------------------------------*/
        //autoImpl.delete(5);






        /*--------------------------------------------------------------------*/
        /*                                     AGREGAR                     */
        /*--------------------------------------------------------------------*/
        //autoImpl.insert(auto1);
       // autoImpl.insert(auto5);





        /*--------------------------------------------------------------------*/
        /*                                   Modificar                    */
        /*--------------------------------------------------------------------*/
        //autoImpl.update(auto1M);
       // autoImpl.update(auto5M);


        /*--------------------------------------------------------------------*/
        /*                        Imprimir Variante AUto Opciones         */
        /*--------------------------------------------------------------------*/

        //variImpl.imprimirVariantes(variImpl.getVariantes());

        //opcImpl.imprimirOpcions(opcImpl.getOpcions());

      //  autoImpl.imprimirAutos(autoImpl.getAutos());





        //Auto auto3 = autoImpl.getQuery(6);

        //variImpl.getQuery(2);
        //System.out.println( variImpl.getQuery(2).getDescripcion());

        //Opcion prue = opcImpl.getQuery(4);
        //System.out.println(prue.getDescripcion());


/*--------------------------------------------------------------------*/
/*                                PRUEBAS                             */
/*--------------------------------------------------------------------*/









        //autoImpl.insert(nuevo);

        //autoImpl.imprimirAutos(autoImpl.getAutos());

        //autoImpl.insert(auto);


        //Auto auto2 = autoImpl.getQuery(2);




       //autoImpl.delete(1);




       //variImpl.insert(var1);

       //variImpl.update(var2);

       //variImpl.delete(29);


       //variImpl.imprimirVariante(variImpl.getQuery(29));

       //variImpl.imprimirVariantes(variImpl.getVariantes());
       //AccesoConexion.closeConnection(variImpl.getConn());




       //opcImpl.imprimirOpcion(opcImpl.getQuery(11));

       //opcImpl.update(op2);

       //opcImpl.insert(op1);

       //opcImpl.delete(6);

       //opcImpl.imprimirOpcions(opcImpl.getOpcions());
/*

        AutoServiceImpl autoService = new AutoServiceImpl();
        VarianteServiceImpl varienteService = new VarianteServiceImpl();
        OpcionServiceImpl opcionService = new OpcionServiceImpl();



        AutoDTO autoDTOact = new AutoDTO();
        autoService.setAuto(autoDTOact);


        autoDTOact.setId(6);
        autoDTOact.setVariante(varienteService.consultarVariante(1));
        autoDTOact.setPrecioFinal(autoService.calcularPrecioFinal());

        //solo le voy actualizar la variante




        this.autoService.modificar(autoDTOact);

*/


    }
}