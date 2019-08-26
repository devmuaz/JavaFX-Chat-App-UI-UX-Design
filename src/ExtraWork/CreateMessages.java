package ExtraWork;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;


/**
 * This is class contains two methods..
 * first is called <code>sendMessage()</code> used to make a UI send message style
 * in the main VBox Node....<br>
 * second is called <code>receiveMessage()</code> and used to make a UI receive message style
 * in the main VBox Node too...<br>
 * @author abdulmuaz
 */
public class CreateMessages {
    /**
     * @param Message is a String contains the content of sent message.
     * @param Time is a String of the sent time.
     * @param MSGS_CONTAINER is the Node that this message will be added to.
     * @param event is an event handler to add some actions when OPTIONS BUTTON clicked.
     */
    public void sendMessage(String Message, String Time, VBox MSGS_CONTAINER, EventHandler<ActionEvent> event){
        
    //*****************[Center Content]***********************
    Label MSG_LBL = new Label(Message);
    MSG_LBL.setMinSize(100, Region.USE_PREF_SIZE);
    MSG_LBL.setMaxSize(400, Region.USE_COMPUTED_SIZE);
    MSG_LBL.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
    MSG_LBL.setWrapText(true);
    MSG_LBL.setId("MSG_LBL");


    //*****************[Bottom Bar]***********************
    Label TIME_SENT = new Label(Time);
    TIME_SENT.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
    TIME_SENT.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
    TIME_SENT.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
    TIME_SENT.setId("TIME_SENT");

    ImageView seenImage = new ImageView(new Image(getClass().getResourceAsStream("/Images/seen_icon.png")));

    BorderPane BOTTOM_BAR_MSG = new BorderPane(null, null, seenImage, null, TIME_SENT);
    BOTTOM_BAR_MSG.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
    BOTTOM_BAR_MSG.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
    BOTTOM_BAR_MSG.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
    BOTTOM_BAR_MSG.setId("BOTTOM_BAR_MSG");


    //*****************[Combining Componentes]***********************
    BorderPane MSG_LAYOUT = new BorderPane(null, null, MSG_LBL, BOTTOM_BAR_MSG, null);
    MSG_LAYOUT.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
    MSG_LAYOUT.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
    MSG_LAYOUT.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
    MSG_LAYOUT.setId("MSG_LAYOUT");

    Image OPTIONS_IMG = new Image(getClass().getResourceAsStream("/Images/v_options.png"));
    
    Button OPTIONS_BTN = new Button("", new ImageView(OPTIONS_IMG));
    OPTIONS_BTN.setMinSize(0, 0);
    OPTIONS_BTN.setMaxSize(10, 30);
    OPTIONS_BTN.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
    OPTIONS_BTN.setTooltip(new Tooltip("Message Options"));
    OPTIONS_BTN.setId("OPTIONS_BTN");
    OPTIONS_BTN.setOnAction(event);
    
    HBox MAIN_MSG = new HBox(OPTIONS_BTN, MSG_LAYOUT);
    MAIN_MSG.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
    MAIN_MSG.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
    MAIN_MSG.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
    MAIN_MSG.setAlignment(Pos.CENTER_RIGHT);
    MAIN_MSG.setSpacing(5);
    MAIN_MSG.setId("MAIN_MSG");
    MSGS_CONTAINER.getChildren().add(MAIN_MSG);

}
    /**
     * @param Message is a String contains the content of received message.
     * @param Time is a String of the received time.
     * @param MSGS_CONTAINER is the Node that this message will be added to.
     * @param event is an event handler to add some actions when OPTIONS BUTTON clicked.
     */
    public void receiveMessage(String Message, String Time, VBox MSGS_CONTAINER, EventHandler<ActionEvent> event){
        
        
        //*****************[Center Content]***********************
        Label MSG_LBL2 = new Label(Message);
        MSG_LBL2.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_PREF_SIZE);
        MSG_LBL2.setMaxSize(270, Region.USE_COMPUTED_SIZE);
        MSG_LBL2.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        MSG_LBL2.setWrapText(true);
        MSG_LBL2.setId("MSG_LBL2");
        
        
        //*****************[Bottom Bar]***********************
        Label TIME_SENT2 = new Label(Time);
        TIME_SENT2.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        TIME_SENT2.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        TIME_SENT2.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        TIME_SENT2.setId("TIME_SENT2");
        
        
        BorderPane BOTTOM_BAR_MSG2 = new BorderPane(null, null, null, null, TIME_SENT2);
        BOTTOM_BAR_MSG2.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        BOTTOM_BAR_MSG2.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        BOTTOM_BAR_MSG2.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        BOTTOM_BAR_MSG2.setId("BOTTOM_BAR_MSG2");
        
        
        //*****************[Combining Componentes]***********************
        BorderPane MSG_LAYOUT2 = new BorderPane(null, null, MSG_LBL2, BOTTOM_BAR_MSG2, null);
        MSG_LAYOUT2.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        MSG_LAYOUT2.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        MSG_LAYOUT2.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        MSG_LAYOUT2.setId("MSG_LAYOUT2");
        
        Image OPTIONS_IMG = new Image(getClass().getResourceAsStream("/Images/v_options.png"));
    
        Button OPTIONS_BTN = new Button("", new ImageView(OPTIONS_IMG));
        OPTIONS_BTN.setMinSize(0, 0);
        OPTIONS_BTN.setMaxSize(10, 30);
        OPTIONS_BTN.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        OPTIONS_BTN.setTooltip(new Tooltip("Message Options"));
        OPTIONS_BTN.setId("OPTIONS_BTN");
        OPTIONS_BTN.setOnAction(event);
    
        HBox MAIN_MSG2 = new HBox(MSG_LAYOUT2, OPTIONS_BTN);
        MAIN_MSG2.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        MAIN_MSG2.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        MAIN_MSG2.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        MAIN_MSG2.setAlignment(Pos.CENTER_LEFT);
        MAIN_MSG2.setSpacing(5);
        MAIN_MSG2.setId("MAIN_MSG2");
        MSGS_CONTAINER.getChildren().add(MAIN_MSG2);
    }
}
