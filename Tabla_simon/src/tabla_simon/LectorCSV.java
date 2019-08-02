package tabla_simon;

import java.io.BufferedReader;
import java.io.FileReader;

// Clase que lee los datos del archivo CSV y los devuelve
// en forma de un String Array
public class LectorCSV {
    
    public String[][] leerCSV(String direccion){
        
        String datos = "";
        int ii = 0;
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String aux = "";
            String bfRead;
            
            while((bfRead = bf.readLine())!=null){
                aux = aux + bfRead + "\n";
                ii++;
            }
            datos = aux;
            
        }catch(Exception e){
            System.err.println("No se encontro el archivo.");
        }
        
        String[] columnas = datos.split("\n");
        int jj=columnas.length;
        String[][] filas = new String[ii][jj];
        for(int i=0;i<columnas.length;i++){
            String temp = columnas[i];
            String[] tempSplit = temp.split(",");
            for(int j=0;j<tempSplit.length;j++){
                filas[i][j]=tempSplit[j];
            }
        }
        
        return filas;
    }
    
}
