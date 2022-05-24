package principal;

import java.io.*;

public class Clientes implements Comparable <Clientes>{


    private String nombre;
    private String apellidos;
    private String CIF;
    private int categoria;
    private String direccion;
    private int LONGITUD_MAX_NOMBRE=50;

    public Clientes(String nombre, String apellidos, String CIF, int categoria, String direccion) {
        setNombre(this.nombre=nombre);
        setApellidos(this.apellidos=apellidos);
        setCIF(this.CIF=CIF);
        this.categoria = categoria;
        setDireccion(this.direccion=direccion);
    }

    public Clientes(){

    }

    public static void altaCliente(File fichero, Clientes clientes){

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



    /**
     * Métodos getters and setters
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        if(nombre.length()>LONGITUD_MAX_NOMBRE) {
            nombre = nombre.substring(0, LONGITUD_MAX_NOMBRE);

            this.nombre = nombre;
        }
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        if(apellidos.length()>LONGITUD_MAX_NOMBRE) {
            apellidos = apellidos.substring(0, LONGITUD_MAX_NOMBRE);

            this.apellidos = apellidos;
        }
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        if(CIF.length()>10) {
            CIF = CIF.substring(0, 10);

            this.CIF = CIF;
        }
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if(direccion.length()>LONGITUD_MAX_NOMBRE) {
            direccion = direccion.substring(0, LONGITUD_MAX_NOMBRE);

            this.direccion = direccion;
        }
    }


    @Override
    public String toString() {
        return nombre +"," + apellidos + "," + CIF + "," + categoria + "," + direccion + "\n";
    }

    @Override
    public int compareTo(Clientes clienteB) {

        int estado = -1;

        if(this.CIF == clienteB.CIF){
            estado=0;
        }else if(Integer.parseInt(this.CIF.substring(0,4)) > Integer.parseInt(clienteB.CIF.substring(0,4)) ){
            estado=1;
        }

        return estado;
    }
}
