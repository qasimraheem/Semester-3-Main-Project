package GUI;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import productAPI.Data;
import productAPI.Get;
import productClasses.*;


import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;
import javafx.scene.layout.HBox;
import javafx.fxml.LoadException;
import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*;

import javax.xml.stream.Location;

public class Controller implements Initializable{


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
    private TableView<productTable> pTableID;

    @FXML
    private TableColumn<productTable, String> pTableName;

    @FXML
    private TableColumn<productTable, String> pTableQuantity;

    @FXML
    private TableColumn<productTable, String> pTableBuyPrice;

    @FXML
    private TableColumn<productTable, String> pTableSalePrice;


    final ObservableList<productTable> data = FXCollections.observableArrayList(
            new productTable("sd","df","b","bnnb")
    );



    public void displayMenu(MouseEvent mouseEvent) {

    }

    public void initialize(URL Location,ResourceBundle resourceBundle){
        pTableName.setCellValueFactory(new PropertyValueFactory<productTable, String>("tName"));
        pTableQuantity.setCellValueFactory(new PropertyValueFactory<productTable, String>("tQuantity"));
        pTableBuyPrice.setCellValueFactory(new PropertyValueFactory<productTable, String>("tBuyPrice"));
        pTableSalePrice.setCellValueFactory(new PropertyValueFactory<productTable, String>("tSalePrice"));
        pTableID.setItems(data);
    }
}
