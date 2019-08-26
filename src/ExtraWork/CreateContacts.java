package ExtraWork;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class CreateContacts {
    public int count = 0;
    public void addContact(String UserName, String LastMessage, String Time, Image UserImage,
        VBox ContactsList, EventHandler<ActionEvent> OptionsButtonEvent, EventHandler<MouseEvent> event){
        //*****************[Top Bar]*********************************
        Label TIME = new Label(Time);
        TIME.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        TIME.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        TIME.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        TIME.setId("TIME");
        
        Image BTN_IMG = new Image(getClass().getResourceAsStream("/Images/h_options.png"));
        
        Button H_OPTIONS_BTN = new Button();
        H_OPTIONS_BTN.setGraphic(new ImageView(BTN_IMG));
        H_OPTIONS_BTN.setMinSize(0, 0);
        H_OPTIONS_BTN.setPrefSize(30, 10);
        H_OPTIONS_BTN.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        H_OPTIONS_BTN.setId("H_OPTIONS_BTN");
        H_OPTIONS_BTN.setCursor(Cursor.HAND);
        H_OPTIONS_BTN.setOnAction(OptionsButtonEvent);
        
        HBox TOP_BAR = new HBox(H_OPTIONS_BTN, TIME);
        TOP_BAR.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        TOP_BAR.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        TOP_BAR.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        TOP_BAR.setAlignment(Pos.CENTER_RIGHT);
        TOP_BAR.setId("TOP_BAR");
        
        
        //*****************[Center Componentes]***********************
        Label CONTACT_NAME = new Label(UserName);
        CONTACT_NAME.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        CONTACT_NAME.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        CONTACT_NAME.setMaxSize(250, Region.USE_COMPUTED_SIZE);
        CONTACT_NAME.setId("CONTACT_NAME");
        
        Label LAST_MSG = new Label(LastMessage);
        LAST_MSG.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        LAST_MSG.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        LAST_MSG.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        LAST_MSG.setId("LAST_MSG");
        
        VBox CONTACT_ITEM = new VBox(TOP_BAR, CONTACT_NAME, LAST_MSG);
        CONTACT_ITEM.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        CONTACT_ITEM.setPrefSize(100, 200);
        CONTACT_ITEM.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        HBox.setHgrow(CONTACT_ITEM, Priority.ALWAYS);
        
        //*****************[UserImage and Final Combination]************
        
        Circle USER_IMAGE = new Circle(25, 25, 25);
        USER_IMAGE.setFill(new ImagePattern(UserImage));
        USER_IMAGE.setSmooth(true);
        
        HBox CONTACT = new HBox(USER_IMAGE, CONTACT_ITEM);
        CONTACT.setMinSize(Region.USE_COMPUTED_SIZE, 80);
        CONTACT.setPrefSize(Region.USE_COMPUTED_SIZE, 80);
        CONTACT.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        CONTACT.setAlignment(Pos.CENTER_LEFT);
        CONTACT.setId("CONTACT");
        CONTACT.setAccessibleText(String.valueOf(count++));
        CONTACT.setOnMouseClicked(event);
        ContactsList.getChildren().add(CONTACT);
        
        
    }
}
