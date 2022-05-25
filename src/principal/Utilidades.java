package principal;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import static principal.Clientes.altaCliente;
import static principal.Main.listaClientes;

public class Utilidades {

    /**
     * Este método busca en un fichero que se le introduce por parámetro un cierto registro mirando su apellido, que
     * también será un parámetro de entrada. Para buscarlo se hará uso del Scanner donde se le introducirá un fichero
     * tipo lectura. Mientras haya algo que leer, el scanner recorerá el fichero registro a registro, que se guardarán
     * en una variable. Esta variable tipo String se le hará un Split para dividir su contenido, de esta forma se puede
     * coger fácilmente el apellido del registro y compararlo con el apellido de entrada. Cuando lo encuentra lo muestra
     * por pantalla.
     *
     * @param fichero
     * @param apellidos
     */


    public static void consultarElementoPorApellidos(File fichero, String apellidos) {
        Scanner sc = null;
        String codigo;
        String[] parte;

        try {

            sc = new Scanner(new FileReader(fichero));

            while (sc.hasNextLine()) {

                codigo = sc.nextLine();
                parte = codigo.split(",");

                if (apellidos.equals(parte[1])) {
                    System.out.println(codigo);
                }
            }


        } catch (IOException e) {
            System.out.println(e);
        } finally {
            sc.close();

        }
    }

    /**
     * Este método hace lo mismo que el anterior salvo que este devuelve un String con el registro indicado.
     *
     * @param fichero
     * @param apellidos
     * @return
     */
    public static String buscarElementoPorApellido(File fichero, String apellidos) {

        Scanner sc = null;
        String codigo;
        String[] parte;
        String cliente = "";

        try {

            sc = new Scanner(new FileReader(fichero));

            while (sc.hasNextLine()) {

                codigo = sc.nextLine();
                parte = codigo.split(",");

                if (apellidos.equals(parte[1])) {
                    cliente = codigo;
                }
            }

        } catch (IOException e) {
            System.out.println(e);
        } finally {

            sc.close();

        }

        return cliente;
    }


    /**
     * Hace lo mismo que el método consultarElementoPorApellidos pero comprobando el cif.
     *
     * @param fichero
     * @param cif
     */

    public static void consultarElementoPorCif(File fichero, String cif) {
        Scanner sc = null;
        String codigo;
        String[] parte;

        try {

            sc = new Scanner(new FileReader(fichero));

            while (sc.hasNextLine()) {

                codigo = sc.nextLine();
                parte = codigo.split(",");

                if (cif.equals(parte[2])) {
                    System.out.println(codigo);
                }
            }

        } catch (IOException e) {
            System.out.println(e);
        } finally {
            sc.close();
        }
    }

    /**
     * Igual que el ejercicio anterior pero esta vez devuelve un String con el registro al que le pertenece el cif.
     *
     * @param fichero
     * @param cif
     * @return
     */

    public static String buscarElementoPorCif(File fichero, String cif) {

        Scanner sc = null;
        String codigo;
        String[] parte;
        String cliente = "";

        try {

            sc = new Scanner(new FileReader(fichero));

            while (sc.hasNextLine()) {

                codigo = sc.nextLine();
                parte = codigo.split(",");


                if (cif.equals(parte[2])) {
                    cliente = codigo;
                }
            }

        } catch (IOException e) {
            System.out.println(e);
        } finally {

            sc.close();
        }

        return cliente;
    }


    /**
     * Como para este método se necesita un fichero y un cliente de entrada, se usa el método altaCliente. Que inserta
     * un cliente en el fichero que se le indique.
     *
     * @param fichero
     * @param clientes
     */

    public static void insertarModificacionCliente(File fichero, Clientes clientes) {

        altaCliente(fichero, clientes);
    }


    /**
     * Este método recorre el fichero de modificaciones, el cual tendrá un registro que ya existe en el archivo de
     * clientes. Por lo que se hará dos bucles donde se comparará el registro del fichero de modificaciones
     * con los de clientes. Durante esta lectura se irá insertando todos aquellos clientes que no concuerdan en cif
     * con el registro de modificaciones. Cuando dos de los registros son iguales en lugar de escribir el registro
     * del fichero clientes, se escribirá el registro del fichero modificaciones. De esta forma quedará escrito en el
     * fichero auxiliar todos los registros que no sean iguales al del fichero modificaciones, y también el registro
     * de modificaciones, dejando sin escribir únicamente el registro del fichero  cliente que tiene el mismo cif
     * que el del fichero modificaciones.
     *
     * @param clientes
     * @param modificaciones
     */
    public static void realizarModificaciones(File clientes, File modificaciones) {

        BufferedWriter bw = null;
        Scanner scModificaciones = null;
        Scanner scClientes = null;
        String cadenaMoficiaciones;
        String cadenaClientes;
        String arrayModificaciones[];
        String arrayClientes[];

        String auxiliar = "Auxiliar.txt";
        try {

            bw = new BufferedWriter((new FileWriter(auxiliar, true)));

            scModificaciones = new Scanner(modificaciones);

            while (scModificaciones.hasNextLine()) {

                cadenaMoficiaciones = scModificaciones.nextLine();
                arrayModificaciones = cadenaMoficiaciones.split(",");

                scClientes = new Scanner(clientes);

                while (scClientes.hasNextLine()) {

                    cadenaClientes = scClientes.nextLine();
                    arrayClientes = cadenaClientes.split(",");

                    if (arrayClientes[2].equals(arrayModificaciones[2])) {

                        bw.write(cadenaMoficiaciones + "\n");
                    } else {
                        bw.write(cadenaClientes + "\n");
                    }

                }
                scClientes.close();
            }

            bw.close();

        } catch (IOException e) {
            System.out.println(e);
        } finally {
        }
    }


    /**
     * Como para este método se necesita un fichero y un cliente de entrada, se usa el método altaCliente. Que inserta
     * un cliente en el fichero que se le indique.
     *
     * @param fichero
     * @param clientes
     */
    public static void insertarBajaCliente(File fichero, Clientes clientes) {

        altaCliente(fichero, clientes);
    }

    /**
     * Este método hace lo mismo que el método realizarModificaciones, cambiando únicamente el criterio de inserción.
     *
     * @param clientes
     * @param bajas
     */

    public static void realizarBajas(File clientes, File bajas) {

        BufferedWriter bw = null;
        Scanner scBajas = null;
        Scanner scClientes = null;

        String cadenaBajas;
        String cadenaClientes;

        String arrayBajas[];
        String arrayClientes[];

        String auxiliar = "AuxiliarBajas.txt";
        try {

            bw = new BufferedWriter((new FileWriter(auxiliar, true)));

            scBajas = new Scanner(bajas);

            while (scBajas.hasNextLine()) {

                cadenaBajas = scBajas.nextLine();
                arrayBajas = cadenaBajas.split(",");

                scClientes = new Scanner(clientes);

                while (scClientes.hasNextLine()) {

                    cadenaClientes = scClientes.nextLine();
                    arrayClientes = cadenaClientes.split(",");

                    if (!(arrayClientes[2].equals(arrayBajas[2]))) {

                        bw.write(cadenaClientes + "\n");
                    }

                }
                scClientes.close();
            }

            bw.close();

        } catch (IOException e) {
            System.out.println(e);
        } finally {
        }

    }

    /**
     * Se crea un array tipo String donde se meterá el registro que se pide por parámetro spliteado. De esta forma
     * se creará un nuevo cliente de forma muy fácil, poniendo las partes correspondientes del split en el cliente.
     * Este método retorna dicho cliente.
     *
     * @param registro
     * @return
     */
    public static Clientes transformarAObjeto(String registro) {


        Clientes clienteNuevo;

        String[] arrayRegistro;

        arrayRegistro = registro.split(",");

        clienteNuevo = new Clientes(arrayRegistro[0], arrayRegistro[1], arrayRegistro[2],
                Integer.parseInt(arrayRegistro[3]), arrayRegistro[4]);

        return clienteNuevo;
    }


    /**
     * Se crea un bucle for que recorrerá la lista creada en el Main, que está ordenada usando el Collections.sort. Por
     * lo que simplemente se sobrescribe el fichero de clientes con los clientes ya ordenados de la lista.
     * @param fichero
     */

    public static void ordenarFichero(File fichero) {

        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(fichero));

            for (Clientes e : listaClientes) {
                bw.write(e.toString());
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {

            try {
                bw.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }


    /**
     * Primero se inserta el cliente en la listaClientes creada en el main. Luego se hará lo mismo que en el ejercicio
     * anterior.
     * @param fichero
     * @param cliente
     */
    public static void altaClienteOrdenado(File fichero, Clientes cliente) {

        listaClientes.add(cliente);

        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(fichero));

            for (Clientes e : listaClientes) {

                bw.write(e.toString());
            }

        } catch (IOException e) {
            System.out.println(e);
        } finally {

            try {
                bw.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

    }


    /**
     * En este método se splitea en primer lugar el registroViejo para poder acceder con facilidad a su cif. Una vez
     * que se hace esto, se hará lo mismo con el método realizarBajas.
     * @param clientes
     * @param registroViejo
     * @param clienteNuevo
     */
    public static void modificarElemento(File clientes, String registroViejo, Clientes clienteNuevo) {

        BufferedWriter bw = null;
        Scanner scClientes = null;
        String cadenaClientes;
        String arrayClientes[];
        String arrayAuxiliar[];
        String auxiliar = "Auxiliar.txt";

        try {

            bw = new BufferedWriter((new FileWriter(auxiliar, true)));

            arrayAuxiliar = registroViejo.split(",");
            scClientes = new Scanner(clientes);

            while (scClientes.hasNextLine()) {

                cadenaClientes = scClientes.nextLine();
                arrayClientes = cadenaClientes.split(",");

                if (!(arrayAuxiliar[2].equals(arrayClientes[2]))) {
                    bw.write(cadenaClientes + "\n");
                }
            }
            bw.write(clienteNuevo.toString());
            scClientes.close();


            bw.close();

        } catch (IOException e) {
            System.out.println(e);
        } finally {
        }
    }

    /**
     * Al igual que el otro método, se compara el split del String registro con los diferentes registros del fichero,
     * y copia todos los registros menos el que coincida.
     * @param fichero
     * @param registro
     */
    public static void bajaElemento(File fichero, String registro) {

        BufferedWriter bw;
        Scanner sc = null;
        String codigo = "";
        String[] parteRegistro;

        String[] parte;

        try {
            bw = new BufferedWriter(new FileWriter(fichero));
            sc = new Scanner(fichero);
            parteRegistro = registro.split(",");
            while (sc.hasNextLine()) {
                codigo = sc.nextLine();
                parte = codigo.split(",");

                if (!(parteRegistro[2].equals(parte[2]))) {

                    bw.write(codigo);
                }
            }

            bw.close();

        } catch (IOException e) {
            System.out.println("xd");
        }

    }

}
