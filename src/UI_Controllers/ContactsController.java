package UI_Controllers;

import ExtraWork.CreateMessages;
import Data.Data;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javafx.util.Duration;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.animation.FadeTransition;
import javafx.collections.ListChangeListener;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;



public class ContactsController implements Initializable{
    
    @FXML private VBox MAIN_CONTACTS, MSGS_CONTAINER;
    @FXML private AnchorPane MAIN_FRM;
    @FXML private ScrollPane SCROLL_BAR_CONTACTS, SCROLL_BAR;
    @FXML private AnchorPane ADDUSER_PANE;
    @FXML private TextField USERNAME_TXT, PHONENUMBER_TXT;
    @FXML private TextArea MSG_TXT;
    @FXML private HBox MORE_BTNS, TITLE_FINAL_CONTAINER;
    @FXML private Label ERR_NUM_LBL, IMAGE_NAME_LBL;
    @FXML private StackPane IMAGE_CONTAINER;
    
    CreateMessages SR = new CreateMessages();
    File file;
    Image UserImage;
    @FXML
    public void showNewDialog(ActionEvent e){
        ADDUSER_PANE.setDisable(false);
        ADDUSER_PANE.setLayoutX((MAIN_FRM.getWidth()/2) - (ADDUSER_PANE.getWidth()/2));
        ADDUSER_PANE.setLayoutY((MAIN_FRM.getHeight()/2) - (ADDUSER_PANE.getHeight()/2));
        
        IMAGE_NAME_LBL.setText("");
        USERNAME_TXT.clear();
        PHONENUMBER_TXT.clear();
        Image image = new Image(getClass().getResourceAsStream("/Images/plus.png"));
        ImageView imageView = new ImageView(image);
        IMAGE_CONTAINER.getChildren().remove(0);
        IMAGE_CONTAINER.getChildren().add(imageView);
        
        
        FadeTransition ft = new FadeTransition();
        ft.setDuration(Duration.millis(200));
        ft.setNode(ADDUSER_PANE);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }
    
    @FXML
    public void closeAddPane(ActionEvent e){
        FadeTransition ft = new FadeTransition();
        ft.setDuration(Duration.millis(200));
        ft.setNode(ADDUSER_PANE);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.play();
        ERR_NUM_LBL.setOpacity(0);
        ADDUSER_PANE.setDisable(true);
    }
    
    @FXML
    public void closeNewDialog(ActionEvent e){
        
        if(PHONENUMBER_TXT.getText().equals("")){
            ERR_NUM_LBL.setText("\'Phone Number\' field is required!");
            FadeTransition ft = new FadeTransition();
            ft.setDuration(Duration.millis(200));
            ft.setNode(ERR_NUM_LBL);
            ft.setFromValue(0);
            ft.setToValue(1);
            ft.play();
        }
        else if (UserImage == null){
            ERR_NUM_LBL.setText("\'Avatar\' field is required!");
            FadeTransition ft = new FadeTransition();
            ft.setDuration(Duration.millis(200));
            ft.setNode(ERR_NUM_LBL);
            ft.setFromValue(0);
            ft.setToValue(1);
            ft.play();
        }
        else{
            //*****************[Top Bar]*************************************************
            Label TIME = new Label(new SimpleDateFormat("hh:mm a").format(new Date()));
            TIME.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
            TIME.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
            TIME.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
            TIME.setId("TIME");

            HBox TOP_BAR = new HBox(TIME);
            TOP_BAR.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
            TOP_BAR.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
            TOP_BAR.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
            TOP_BAR.setAlignment(Pos.CENTER_RIGHT);
            TOP_BAR.setId("TOP_BAR");


            //*****************[Center Componentes]***************************************
            Label CONTACT_NAME = new Label(USERNAME_TXT.getText());
            CONTACT_NAME.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
            CONTACT_NAME.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
            CONTACT_NAME.setMaxSize(250, Region.USE_COMPUTED_SIZE);
            CONTACT_NAME.setId("CONTACT_NAME");

            Label PHONENUMBER = new Label("+964" + PHONENUMBER_TXT.getText());
            PHONENUMBER.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
            PHONENUMBER.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
            PHONENUMBER.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
            PHONENUMBER.setId("PHONENUMBER");

            VBox CONTACT_ITEM = new VBox(TOP_BAR, CONTACT_NAME, PHONENUMBER);
            CONTACT_ITEM.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
            CONTACT_ITEM.setPrefSize(100, 200);
            CONTACT_ITEM.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
            HBox.setHgrow(CONTACT_ITEM, Priority.ALWAYS);

            //*****************[UserImage and Final Combination]***************************

            Circle USER_IMAGE = new Circle(25, 25, 25);
            USER_IMAGE.setFill(new ImagePattern(UserImage));
            USER_IMAGE.setSmooth(true);

            HBox CONTACT = new HBox(USER_IMAGE, CONTACT_ITEM);
            CONTACT.setMinSize(Region.USE_COMPUTED_SIZE, 80);
            CONTACT.setPrefSize(Region.USE_COMPUTED_SIZE, 80);
            CONTACT.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
            CONTACT.setAlignment(Pos.CENTER_LEFT);
            CONTACT.setId("CONTACT");
            CONTACT.setOnMouseClicked((event) -> {
                System.out.println(CONTACT.getAccessibleText());
                ContextMenu contextMenu = new ContextMenu();
                MenuItem item1 = new MenuItem("Add to Favorite");
                MenuItem item2 = new MenuItem("Mark as Read");
                MenuItem item3 = new MenuItem("Delete Chat");
                MenuItem item4 = new MenuItem("User Info");
                item3.setOnAction((deleteEvent) -> {
                    MAIN_CONTACTS.getChildren().remove(Integer.parseInt(CONTACT.getAccessibleText()));
                });
                contextMenu.getItems().addAll(item1, item2, item3, item4);
                CONTACT.setOnContextMenuRequested((value) -> {
                    contextMenu.show(CONTACT, value.getScreenX(), value.getScreenY());
                });
                
            });
            MAIN_CONTACTS.getChildren().add(CONTACT);
            
            
            /******************************* [Closing Dialog] ************************************/
            FadeTransition ft = new FadeTransition();
            ft.setDuration(Duration.millis(200));
            ft.setNode(ADDUSER_PANE);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.play();
            ERR_NUM_LBL.setOpacity(0);
            ADDUSER_PANE.setDisable(true);
        }

        
        
        
    }
    
    @FXML
    public void chooseImage(MouseEvent e){
        Stage stage = (Stage) IMAGE_NAME_LBL.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files (*.jpg, *.jpeg, *.png)", "*.jpg", "*.jpeg", "*.png"));
        file = fileChooser.showOpenDialog(stage);
        
        if(file != null){
            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                UserImage = SwingFXUtils.toFXImage(bufferedImage, null);

                Circle circleImage = new Circle(30, 30, 30);
                circleImage.setFill(new ImagePattern(UserImage));
                circleImage.setSmooth(true);

                IMAGE_NAME_LBL.setText(file.getName());
                IMAGE_CONTAINER.getChildren().remove(0);
                IMAGE_CONTAINER.getChildren().add(circleImage);
            } catch (IOException ex) {
               ex.printStackTrace();
            }
        }
        
        
        
    }
    
    @FXML
    public void sendMessage(ActionEvent e){
        if(!MSG_TXT.getText().equals("")){
            SR.sendMessage(MSG_TXT.getText(), new SimpleDateFormat("hh:mm a").format(new Date()), MSGS_CONTAINER, (event) -> {
                System.out.println("1. Clecked :D");
            });
        }
        MSG_TXT.clear();
    }
    
    @FXML
    public void receiveMessage(ActionEvent e){
        if(!MSG_TXT.getText().equals("")){
            SR.receiveMessage(MSG_TXT.getText(), new SimpleDateFormat("hh:mm a").format(new Date()), MSGS_CONTAINER, (event) -> {
                System.out.println("1. Clecked :D");
            });
        }
        MSG_TXT.clear();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ADDUSER_PANE.setDisable(true);
        MAIN_FRM.widthProperty().addListener(e -> {
            if(MAIN_FRM.getWidth() <= 620){
                AnchorPane.setLeftAnchor(SCROLL_BAR, 0.0);
                AnchorPane.setLeftAnchor(MSG_TXT, 0.0);
                AnchorPane.setLeftAnchor(MORE_BTNS, 70.0);
                SCROLL_BAR_CONTACTS.setVisible(false);
            }
            else{
                AnchorPane.setLeftAnchor(MORE_BTNS, 360.0);
                AnchorPane.setLeftAnchor(MSG_TXT, 291.0);
                AnchorPane.setLeftAnchor(SCROLL_BAR, 291.0);
                SCROLL_BAR_CONTACTS.setVisible(true);
            }
            
            ADDUSER_PANE.setLayoutX((MAIN_FRM.getWidth()/2) - (ADDUSER_PANE.getWidth()/2));
            ADDUSER_PANE.setLayoutY((MAIN_FRM.getHeight()/2) - (ADDUSER_PANE.getHeight()/2));
        });
        
        MAIN_FRM.heightProperty().addListener(e -> {
            ADDUSER_PANE.setLayoutX((MAIN_FRM.getWidth()/2) - (ADDUSER_PANE.getWidth()/2));
            ADDUSER_PANE.setLayoutY((MAIN_FRM.getHeight()/2) - (ADDUSER_PANE.getHeight()/2));
        });
        
        MAIN_CONTACTS.getChildren().addListener((ListChangeListener.Change<? extends Node> c) -> {
            Data.usersCount = -1;
            for(int i = 0; i < MAIN_CONTACTS.getChildren().size(); i++){
                MAIN_CONTACTS.getChildren().get(i).setAccessibleText(String.valueOf(i));
                Data.usersCount++;
            }
        });
        IMAGE_CONTAINER.setOnMouseClicked((value) -> {
            chooseImage(value);
        });
    } 
    
    
    
    void setTempInfo(){
        
    }
}
