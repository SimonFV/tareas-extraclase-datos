package tabla_simon;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class FXMLvistaController implements Initializable {
    
    @FXML
    private void handleButtonAction(ActionEvent event){
        LectorCSV readCSV = new LectorCSV();
        String[][] datosTabla;
        datosTabla = readCSV.leerCSV("ISO-Codes.csv");
        System.out.println(datosTabla[3][4]);
        
    }
    
    //Primera ejecucion.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
   
}
