package principal;

import java.io.*;
import java.util.Scanner;

import static principal.Main.listaClientes;

public class Utilidades{


    public static void consultarElementoPorApellidos(File fichero, String apellidos){

        BufferedReader br = null;
        Scanner sc;
        String codigo;
        String [] parte;

        try {

            br = new BufferedReader(new FileReader(fichero));
            sc = new Scanner(fichero);

            while (sc.hasNextLine()){

                codigo = sc.nextLine();
                parte = codigo.split(",");
                br.readLine();

                if(apellidos.equals(parte[1])){
                    System.out.println(codigo);
                }
            }


        } catch (IOException e) {
            System.out.println(e);
        } finally {

            try {
                br.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

    }


    public static String buscarElementoPorApellido(File fichero, String apellidos){

        BufferedReader br = null;
        Scanner sc;
        String codigo;
        String [] parte;
        String cliente="";

        try {

            br = new BufferedReader(new FileReader(fichero));
            sc = new Scanner(fichero);

            while (sc.hasNextLine()){

                codigo = sc.nextLine();
                parte = codigo.split(",");
                br.readLine();

                if(apellidos.equals(parte[1])){
                    cliente=codigo;
                }
            }

        } catch (IOException e) {
            System.out.println(e);
        } finally {

            try {
                br.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

        return cliente;
    }



    public static void consultarElementoPorCif(File fichero, String cif){

        BufferedReader br = null;
        Scanner sc;
        String codigo;
        String [] parte;

        try {

            br = new BufferedReader(new FileReader(fichero));
            sc = new Scanner(fichero);

            while (sc.hasNextLine()){

                codigo = sc.nextLine();
                parte = codigo.split(",");
                br.readLine();

                if(cif.equals(parte[2])){
                    System.out.println(codigo);
                }
            }

        } catch (IOException e) {
            System.out.println(e);
        } finally {

            try {
                br.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }


    public static String buscarElementoPorCif(File fichero, String cif){

        BufferedReader br = null;
        Scanner sc;
        String codigo;
        String [] parte;
        String cliente="";

        try {

            br = new BufferedReader(new FileReader(fichero));
            sc = new Scanner(fichero);

            while (sc.hasNextLine()){

                codigo = sc.nextLine();
                parte = codigo.split(",");
                br.readLine();

                if(cif.equals(parte[2])){
                    cliente=codigo;
                }
            }

        } catch (IOException e) {
            System.out.println(e);
        } finally {

            try {
                br.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

        return cliente;
    }



    public static void insertarModificacionCliente(File fichero, Clientes clientes){

        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(fichero, true));
            bw.write(clientes.toString());

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


    public static void realizarModificaciones(File clientes, File modificaciones){

        BufferedWriter bw = null;
        Scanner scModificaciones=null;
        Scanner scClientes=null;
        Scanner scAuxiliar=null;
        String cadenaMoficiaciones;
        String cadenaClientes;
        String cadenaAuxiliar;
        String arrayModificaciones [];
        String arrayClientes [];
        String arrayAuxiliar [];
        String auxiliar = "Auxiliar.txt";
        try {

            bw = new BufferedWriter((new FileWriter(auxiliar, true)));

            scModificaciones = new Scanner(modificaciones);

            while (scModificaciones.hasNextLine()){

                cadenaMoficiaciones=scModificaciones.nextLine();
                arrayModificaciones = cadenaMoficiaciones.split(",");

                scClientes = new Scanner(clientes);

                while (scClientes.hasNextLine()){

                    cadenaClientes=scClientes.nextLine();
                    arrayClientes=cadenaClientes.split(",");

                    if(arrayClientes[2].equals(arrayModificaciones[2])){

                            bw.write(cadenaMoficiaciones + "\n");
                    }else {
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


    public static void insertarBajaCliente(File fichero, Clientes clientes){

        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(fichero, true));
            bw.write(clientes.toString());

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


    public static void realizarBajas(File clientes, File bajas){

        BufferedWriter bw = null;
        Scanner scBajas=null;
        Scanner scClientes=null;

        String cadenaBajas;
        String cadenaClientes;

        String arrayBajas [];
        String arrayClientes [];

        String auxiliar = "AuxiliarBajas.txt";
        try {

            bw = new BufferedWriter((new FileWriter(auxiliar, true)));

            scBajas = new Scanner(bajas);

            while (scBajas.hasNextLine()){

                cadenaBajas=scBajas.nextLine();
                arrayBajas = cadenaBajas.split(",");

                scClientes = new Scanner(clientes);

                while (scClientes.hasNextLine()){

                    cadenaClientes=scClientes.nextLine();
                    arrayClientes=cadenaClientes.split(",");

                    if(!(arrayClientes[2].equals(arrayBajas[2]))){

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

    public static Clientes transformarAObjeto(String registro){


        Clientes clienteNuevo;

        String [] arrayRegistro;

        arrayRegistro = registro.split(",");

        clienteNuevo = new Clientes(arrayRegistro[0], arrayRegistro[1], arrayRegistro[2],
                Integer.parseInt(arrayRegistro[3]), arrayRegistro[4]);

        return clienteNuevo;
    }



    public static void ordenarFichero(File fichero){

        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(fichero));

            for (Clientes e : listaClientes){

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


    public static void altaClienteOrdenado(File fichero, Clientes cliente){

        listaClientes.add(cliente);

        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(fichero));

            for (Clientes e : listaClientes){

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


/*
    public static void modificarElemento(File clientes, String registroViejo, Clientes clienteNuevo){

        BufferedWriter bw = null;
        Scanner scModificaciones=null;
        Scanner scClientes=null;
        Scanner scAuxiliar=null;
        String cadenaMoficiaciones;
        String cadenaClientes;
        String cadenaAuxiliar;
        String arrayModificaciones [];
        String arrayClientes [];
        String arrayAuxiliar [];
        String auxiliar = "Auxiliar.txt";
        try {

            bw = new BufferedWriter((new FileWriter(auxiliar, true)));

            scModificaciones = new Scanner(modificaciones);

            while (scModificaciones.hasNextLine()){

                cadenaMoficiaciones=scModificaciones.nextLine();
                arrayModificaciones = cadenaMoficiaciones.split(",");

                scClientes = new Scanner(clientes);

                while (scClientes.hasNextLine()){

                    cadenaClientes=scClientes.nextLine();
                    arrayClientes=cadenaClientes.split(",");

                    if(arrayClientes[2].equals(arrayModificaciones[2])){

                        bw.write(cadenaMoficiaciones + "\n");
                    }else {
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

*/
}
