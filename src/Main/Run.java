package Main;

import javafx.application.Application;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Run extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        AnchorPane root = FXMLLoader.load(getClass().getResource("/UI/ContactsUI.fxml"));
        root.getStylesheets().add(getClass().getResource("/CSS/ContactsUI_CSS.css").toExternalForm());
        
        
        /*
        AnchorPane root = FXMLLoader.load(getClass().getResource("/UI/LoginUI.fxml"));
        root.getStylesheets().add(getClass().getResource("/CSS/LoginUI_CSS.css").toExternalForm());
        */
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Sender World");
        
        // unstyled dialog exit requist [if needed].
        
//        stage.setOnCloseRequest(event -> {
//            Stage newStage = new Stage();
//            event.consume();
//            Button ExitBTN = new Button("Exit");
//            Button CancelBTN = new Button("Cancel");
//            ExitBTN.setOnAction(btn_event -> {
//                System.exit(0);
//            });
//            CancelBTN.setOnAction(btn2_event -> {
//                newStage.hide();
//            });
//            HBox hbox = new HBox(ExitBTN, CancelBTN);
//            hbox.setAlignment(Pos.BOTTOM_RIGHT);
//            hbox.setStyle("-fx-padding: 20px 10px 10px 10px;");
//            hbox.setSpacing(5);
//            BorderPane borderPane = new BorderPane(new Label("Are you sure you want to exit?"), null, null, hbox, null);
//            borderPane.setStyle("-fx-padding: 20px 0px 0px 0px;");
//            Scene newScene = new Scene(borderPane);
//            
//           
//            newStage.setWidth(300);
//            newStage.setHeight(150);
//            newStage.setScene(newScene);
//            newStage.setResizable(false);
//            newStage.show();
//        });
        stage.show();
        
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
