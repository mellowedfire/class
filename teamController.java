  
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author vjvib
 */
public class teamController implements Initializable {

    /**
     * 
     * Variables that are a mapping to the FXML controls
     * 
     */
    @FXML private ListView lvMLB;
    @FXML private TableView tblResult;
    @FXML private TableColumn <String, Player> colname;
    @FXML private TableColumn <String, Player> colteam;
    @FXML private TableColumn <String, Player> colatBats;
    @FXML private TableColumn <String, Player> colhits;
    
    
    //ArrayList of States objects
    private final List<Player> player = new ArrayList<>();
    
    //Gets the directory path of the project
    private final String DIR = System.getProperty("user.dir");
          
    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        readFile();
        
        //ChangeListerner for when you click on a ListView Item
        lvMLB.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
               
                //Find the state chosen in the ArrayList
                int idx = findPlayer(newValue);
                
                //Link the column's cell value to the get function of the States Class.
                //REMEMBER the name in the quotation marks should match the case of the get function
                colname.setCellValueFactory(new PropertyValueFactory<>("Name"));
                colteam.setCellValueFactory(new PropertyValueFactory<>("Team"));
                colatBats.setCellValueFactory(new PropertyValueFactory<>("At Bats"));
                colhits.setCellValueFactory(new PropertyValueFactory<>("Hits"));
                
                //Create an ObservableList object to store the States object(s)
                ObservableList<Player> result = FXCollections.observableArrayList();
                
                //Add the States object to the list
                result.add(player.get(idx));
              
                //Bind the list  to the table
                tblResult.setItems(result);
                
            }

            private int findPlayer(String newValue) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    
    /**
     * Sequential search of the states by name
     * @param value
     * @return 
     */
    
    private int findPlayer(String value){
     
        for(int i = 0; i < player.size(); i++)
            if(player.get(i).getName().equals(value))
                return i;
        return 0;
    }
    
    /**
     * Read file contents and populate the Lists and ListView
     */
    private void readFile() {
        
        //ObservableList to add states to the ListView
        ObservableList<String> playerList = FXCollections.observableArrayList();
        
        //Open csv file for input
        try(BufferedReader xmlReader = Files.newBufferedReader(Paths.get(DIR + "//src//usstates//data//baseball.xml"))){
            
            String row;
            //reads a line at a time until the EOF
            while ((row = xmlReader.readLine()) != null) {
                String[] data = row.split(","); 
                
                //States object
                Player players = new Player(data[0], data[1], data[2], data[3], data[4]);
                //add object to ArrayList
                player.add(players);
                //add state name to ObservableList
                playerList.add(data[0]);
            }
        
        }catch(IOException e){
            System.err.println("Error openning file");
            e.printStackTrace();
        }
        
        //Sorts the List of State objects by state name in ascending order
        Collections.sort(player, new PlayerComparator());
        //sorts the ObservableList
        Collections.sort(playerList);
        
        //Binds the ObservableList to the ListView
        lvMLB.setItems(playerList);
    }
}
