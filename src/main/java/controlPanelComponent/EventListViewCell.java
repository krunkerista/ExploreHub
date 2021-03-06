package controlPanelComponent;

import persistenceComponent.UserConnectionSingleton;
import com.jfoenix.controls.JFXListCell;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import models.Events;

import javax.persistence.EntityManager;


/**
 * Class serves as a controller for the custom list view cell
 *
 * @author Gheorghe Mironica
 */
public class EventListViewCell extends JFXListCell<Events> {

    private FXMLLoader loader;
    private UserConnectionSingleton con;
    private EntityManager entityManager;

    @FXML
    private HBox editEventLayout;

    @FXML
    private Label compLabelList, dateLabelList, shortLabelList;

    @Override
    protected synchronized void updateItem(Events item, boolean empty) {
        super.updateItem(item, empty);


        if(empty || item == null){
            setText(null);
            setGraphic(null);
        } else {
            if(loader == null){
                loader = new FXMLLoader(getClass().getResource("/FXML/editEvent.fxml"));
                loader.setController(this);
            }
            try{
                loader.load();
            } catch(Exception e){
                //
            }

            try {
                compLabelList.setText(item.getCompany());
                dateLabelList.setText(String.valueOf(item.getDate()));
                shortLabelList.setText(item.getShortDescription());
            } catch(Exception e){
                e.printStackTrace();
            }
            // set views
            setText(null);
            setGraphic(editEventLayout);
        }


    }
}
