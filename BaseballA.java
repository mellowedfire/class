/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseballa;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
/**
 *
 * @author gear5
 */
public class BaseballA extends Application{

    @FXML private ListView lvTeam;
    @FXML private TableView Plsyer;
    
    private final List<TeamStat> stat = new ArrayList<>();
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("BaseballPlayer.fxml"));
        
        Scene scene = new Scene(root);
                
        primaryStage.setScene(scene);
        primaryStage.show();
        stat.setItems(primaryStage);
        
        ObservableList<TeamStat> result = FXCollections.observableArrayList();
        result.add(stat);
        
        Hash
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
}
