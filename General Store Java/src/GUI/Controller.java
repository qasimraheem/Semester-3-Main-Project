package GUI;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;
import javafx.scene.layout.HBox;
import javafx.fxml.LoadException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*;

public class Controller {


    public HBox productButtoN;
    @FXML
    private HBox dashboardButton;

    @FXML
    private SVGPath dashboard;

    @FXML
    private Label dashboardText;

    @FXML
    private HBox saleButton;

    @FXML
    private SVGPath saleIcon;

    @FXML
    private Label saleText;

    @FXML
    private HBox addproductButton;

    @FXML
    private SVGPath addproductIcon;

    @FXML
    private Label addproductText;

    @FXML
    private SVGPath productButton;

    @FXML
    private Label productText;

    @FXML
    private HBox billButton;

    @FXML
    private Label billText;

    @FXML
    private HBox customerButton;

    @FXML
    private SVGPath customerIcon;

    @FXML
    private Label customerText;

    @FXML
    private VBox vbox;

    @FXML
    private TableView<?> productTable;

    @FXML
    private TableColumn<?, ?> productTableName;

    @FXML
    private TableColumn<?, ?> productTableQuantity;

    @FXML
    private TableColumn<?, ?> productTableButPrice;

    @FXML
    private TableColumn<?, ?> productTableSalePrice;

    @FXML
    void handleButtonAction(){}
    public void setDashboardButton(HBox dashboardButton) {
        this.dashboardButton = dashboardButton;
    }

    public void setProductTableData(List<Date> d){

    }

    public void displayMenu(MouseEvent mouseEvent) {
        if (mouseEvent.getSource()==dashboard||mouseEvent.getSource()==dashboardButton||mouseEvent.getSource()==dashboardText){
            System.out.println("dash button");
            vbox.setVisible(true);
        }
    }
}
