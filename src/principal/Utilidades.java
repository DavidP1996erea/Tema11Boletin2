package principal;

import java.io.*;
import java.util.Scanner;

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



}
