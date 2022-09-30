import java.io.*;
import com.thoughtworks.xstream.XStream;

class EscribirPersonas {
    public static void main(String[] args) throws IOException,
            ClassNotFoundException{
        File fichero = new File("FichPersona.dat");
        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream dataIS = new ObjectInputStream(filein);

        System.out.println("Comienza el proceso ... ");

        //Creamos un objeto Lista de Personas
        ListaPersonas listaper = new ListaPersonas();

        try{
            while (true) { //lectura del fichero
                Persona persona = (Persona) dataIS.readObject();
                listaper.add(persona); //añadir persona a la lista
            }
        }catch (EOFException eo) {}

        dataIS.close(); //cerrar screan Ce entrada
        try{
            XStream xstream = new XStream();
            //cambiar de nombre a las etiquetas XML
            xstream.alias("ListaPersonasMunicipio", ListaPersonas.class);
            xstream.alias("DatosPersona", Persona.class);
            //quitar etiqueta lista (atributo de la clase ListaPersonas)
            xstream.addImplicitCollection(ListaPersonas.class, "lista");
            //Insertar los objetos en el XML
            xstream.toXML(listaper, new FileOutputStream("Personas. xml")) ;
            System.out.println("Creado fichero XML...");
        }catch (Exception e) {e.printStackTrace();}
    }//fin main
}//fin EscribirPersonas