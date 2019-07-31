package tabla_simon;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class FXMLvistaController implements Initializable {
    
    static String xStrPath;
    static double[][] myArray;
    
    @FXML
    private void handleButtonAction(ActionEvent event){
        System.out.println("You clicked me!");
        numficom();
    }
    
    //Primera ejecucion.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    //Arma el Array con los datos del csv
    public static void numficom(){
        Scanner scanIn = null;
        int filas = 0;
        int colum = 0;
        String Inputline = "";
        double xnum;
        
        String xfileLocation;
        xfileLocation = "C:\\Users\\sfv02\\Downloads\\ISO-Codes.csv";
        
        System.out.println("Armando...");
        
        try {
            System.out.print("aqui");
            scanIn = new Scanner(new BufferedReader(new FileReader("ISO-Codes.csv")));
            
            while(scanIn.hasNextLine()){
                String InputLine = scanIn.nextLine();
                String[] InArray = InputLine.split(",");
                
                for(int x = 0; x < InArray.length; x++){
                    myArray[filas][x] = Double.parseDouble(InArray[x]);
                }
                filas++;
            }
            
            
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
        System.out.println(Arrays.toString(myArray));
    }
}
