package tabla_simon;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.util.Callback;

public class FXMLvistaController implements Initializable {
    
    @FXML
    private TableView myTableView;
    @FXML
    private Button SelectCSV;
    
    @FXML
    private void handleButtonAction(ActionEvent event){
        //Selecciona el archivo CSV
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        
        if(selectedFile != null){
            String dirCSV = selectedFile.getAbsolutePath();
            Seleccionar(dirCSV);
        }
    }
    
    //Primera ejecucion.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void Seleccionar(String direccion){
        LectorCSV readCSV = new LectorCSV();
        String[][] datosTabla;
        datosTabla = readCSV.leerCSV(direccion);
        
        //Añaden las filas y columnas a la tabla
        ObservableList<String[]> dataRows = FXCollections.observableArrayList();
        dataRows.addAll(Arrays.asList(datosTabla));
        dataRows.remove(0);//quita los titulos del array
        for (int i = 0; i < datosTabla[0].length; i++) {
            TableColumn tc = new TableColumn(datosTabla[0][i]);
            final int colNo = i;
            tc.setCellValueFactory(new Callback<CellDataFeatures<String[], String>, ObservableValue<String>>(){
                @Override
                public ObservableValue<String> call(CellDataFeatures<String[], String> p) {
                    return new SimpleStringProperty((p.getValue()[colNo]));
                }
            });
            tc.setPrefWidth(90);
            myTableView.getColumns().add(tc);
        }
        myTableView.setItems(dataRows);
        
    }
}
