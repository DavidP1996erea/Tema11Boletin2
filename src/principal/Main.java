package principal;

import java.io.File;
import java.util.*;

import static principal.Clientes.altaCliente;
import static principal.Utilidades.*;
import static principal.Utilidades.transformarAObjeto;


public class Main {

    public static List<Clientes> listaClientes = new ArrayList<>();

    public static void main(String[] args) {
        // write your code here

        Scanner sc = new Scanner(System.in);

        listaClientes.add(new Clientes("David", "Perea", "32541H", 5, "direccion1"));
        listaClientes.add(new Clientes("Juan", "Alberto", "25244B", 8, "direccion2"));
        listaClientes.add(new Clientes("Javier", "Sequera", "12345U", 4, "direccion3"));
        listaClientes.add(transformarAObjeto("Fernando,Juan,12342J,9,direccion4"));
        File fichero;
        File fichero2;
        File fichero3;
        int opcion;

        opcion = sc.nextInt();
        while (opcion != 0) {

            try {
                fichero = new File("Clientes.txt");
                fichero2 = new File("Modificaciones.txt");
                fichero3 = new File("Bajas.txt");


                switch (opcion) {

                    case 1:
                        consultarElementoPorApellidos(fichero, "Perea");
                        break;
                    case 2:
                        System.out.println(buscarElementoPorApellido(fichero, "Sequera"));
                        break;
                    case 3:
                        consultarElementoPorCif(fichero, "2524B");
                        break;
                    case 4:
                        System.out.println(buscarElementoPorCif(fichero, "2524B"));
                        break;
                    case 5:
                        insertarModificacionCliente(fichero2, listaClientes.get(1));
                        break;
                    case 6:
                        realizarModificaciones(fichero, fichero2);
                        break;
                    case 7:
                        insertarBajaCliente(fichero3, listaClientes.get(0));
                        break;
                    case 8:
                        realizarBajas(fichero, fichero3);
                        break;
                    case 9:
                        altaClienteOrdenado(fichero, transformarAObjeto("Laura,Gonzalez,28452J,1,direccion5"));
                        break;
                    case 10:
                        listaClientes.add(transformarAObjeto("Juan,dejame,25244B,8,direccion2"));
                        break;
                    case 11:
                        modificarElemento(fichero, "Juan,Alberto,25244B,8,direccion2", listaClientes.get(5));
                        break;
                    case 12:
                        bajaElemento(fichero, "Laura,Gonzalez,28452J,1,direccion5");
                        break;
                    case 13:
                        altaClienteOrdenado(fichero, new Clientes("Juan", "Alberto", "85244B", 8, "direccion2"));
                        break;
                    default:
                        System.out.println("Introduce un número del 1 al 12");
                        break;

                }
                Collections.sort(listaClientes);
                ordenarFichero(fichero);

                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error");
            }
        }
    }
}
