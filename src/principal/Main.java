package principal;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static principal.Clientes.altaCliente;
import static principal.Utilidades.*;
import static principal.Utilidades.transformarAObjeto;


public class Main {

    public static List<Clientes> listaClientes = new ArrayList<>();

    public static void main(String[] args) {
	// write your code here

        Utilidades uti = new Utilidades();


          listaClientes.add(new Clientes("David", "Perea", "32541H", 5, "direccion1")) ;
          listaClientes.add( new Clientes("Juan", "Alberto", "25244B", 8, "direccion2"));
          listaClientes.add( new Clientes("Javier", "Sequera", "12345U", 4, "direccion3"));
          listaClientes.add(transformarAObjeto("Fernando,Juan,12342J,9,direccion4"));
          File fichero;
          File fichero2;
          File fichero3;
        try {
            fichero=new File("Clientes.txt");
            fichero2=new File("Modificaciones.txt");
            fichero3=new File("Bajas.txt");
            //consultarElementoPorApellidos(fichero,"Perea");
            //System.out.println(buscarElementoPorApellido(fichero, "Sequera"));
            //consultarElementoPorCif(fichero, "2524B");
            //System.out.println(buscarElementoPorCif(fichero, "2524B"));
            //insertarModificacionCliente(fichero2, listaClientes.get(1));
            //realizarModificaciones(fichero, fichero2);
            //insertarBajaCliente(fichero3, listaClientes.get(0));
            //realizarBajas(fichero, fichero3);
            altaClienteOrdenado(fichero, transformarAObjeto("Laura,Gonzalez,28452J,1,direccion5"));


            Collections.sort(listaClientes);
            ordenarFichero(fichero);
        }catch (Exception e){
            System.out.println("Error");
        }

    }
}
