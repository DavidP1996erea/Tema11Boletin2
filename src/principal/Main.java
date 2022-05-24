package principal;

import java.io.File;

import static principal.Clientes.altaCliente;
import static principal.Utilidades.*;


public class Main {

    public static void main(String[] args) {
	// write your code here

        Utilidades uti = new Utilidades();

          Clientes clientes1 = new Clientes("David", "Perea", "1024f", 5, "direccion1");
          Clientes clientes2 = new Clientes("Juan", "Alberto", "2524B", 8, "direccion2");
          Clientes clientes3 = new Clientes("Javier", "Sequera", "32541H", 4, "direccion3");

          File fichero;
          File fichero2;

        try {
            fichero=new File("Clientes.txt");
            fichero2=new File("Modificaciones.txt");
            //consultarElementoPorApellidos(fichero,"Perea");
            //System.out.println(buscarElementoPorApellido(fichero, "Sequera"));
            //consultarElementoPorCif(fichero, "2524B");
            //System.out.println(buscarElementoPorCif(fichero, "2524B"));
            //insertarModificacionCliente(fichero2, clientes3);
            realizarModificaciones(fichero, fichero2);
        }catch (Exception e){
            System.out.println("Error");
        }

    }
}
