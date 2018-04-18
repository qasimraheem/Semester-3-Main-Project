package GUI;
import com.sun.javafx.tools.resource.ConsolidatedResources;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import productAPI.Data;
import productAPI.Get;
import productClasses.*;
import productAPI.*;


import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;
import javafx.scene.layout.HBox;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.*;
import javafx.fxml.LoadException;

import java.awt.*;
import java.net.URL;
import java.util.*;
import java.util.List;

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
    private VBox vboxDeleteProduct;

    @FXML
    private ImageView productButtonDelete;

    @FXML
    private ImageView productButtonUpdate;

    @FXML
    private ImageView productButtonSearch;


    @FXML
    private TableView<productTable> pTableID;
    ObservableList<productTable> data;

    @FXML
    private TableColumn<productTable, String> pTableName;

    @FXML
    private TableColumn<productTable, String> pTableQuantity;

    @FXML
    private TableColumn<productTable, String> pTableBuyPrice;

    @FXML
    private TableColumn<productTable, String> pTableSalePrice;

    @FXML
    private TextField productDeleteName;

    @FXML
    private TextField productDeleteQuantity;

    @FXML
    private TextField productDeleteBuyPrice;

    @FXML
    private TextField productDeleteSalePrice;

    @FXML
    private ImageView productButtonDeleteTick;

    @FXML
    private ImageView productButtonDeleteCross;

    @FXML
    private VBox vboxUpdateProduct;

    @FXML
    private TextField productUpdateName;

    @FXML
    private TextField productUpdateQuantity;

    @FXML
    private TextField productUpdateBuyPrice;

    @FXML
    private TextField productUpdateSalePrice;

    @FXML
    private TextField productUpdateNewName;

    @FXML
    private TextField productUpdateNewQuantity;

    @FXML
    private TextField productUpdateNewBuyPrice;

    @FXML
    private TextField productUpdateNewSalePrice;

    @FXML
    private ImageView productButtonUpdateTick;

    @FXML
    private ImageView productButtonUpdateCross;


    public void displayMenu(MouseEvent mouseEvent) {

    }


    Validations validate=new Validations();
    public void initialize(URL Location,ResourceBundle resourceBundle){
//        TableColumn namecol = new TableColumn("Name");
//        TableColumn quantitycol = new TableColumn("Quantity");
//        TableColumn buypricecol = new TableColumn("BuyPrice");
//        TableColumn salepricecol = new TableColumn("SalePrice");

//        pTableID.getColumns().addAll(namecol, quantitycol,buypricecol, salepricecol);
//        pTableID.getColumns().addAll(pTableName,pTableQuantity,pTableQuantity,pTableSalePrice);
        productAPI.Get gat=new Get();
        List<Data> d = new ArrayList<>();
        try {

            d=Get.get();
            System.out.println(d.size());
            for(int i=0;i<d.size();i++)
                System.out.println(d.get(i).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        data = FXCollections.observableArrayList();
        for (int i=0;i<d.size();i++){
            data.add(new productTable(d.get(i).getName(),d.get(i).getQuantity(),d.get(i).getBuyPrice(),d.get(i).getSellPrice()));
        }

//        data = FXCollections.observableArrayList(
//                new productTable("Jacob", "Smith", "jacob.smith@example.com", ""),
//                new productTable("Isabella", "Johnson", "isabella.johnson@example.com", ""),
//                new productTable("Ethan", "Williams", "ethan.williams@example.com", ""),
//                new productTable("Emma", "Jones", "emma.jones@example.com", ""),
//                new productTable("Michael", "Brown", "michael.brown@example.com", ""),
//                new productTable("Michael", "Brown", "michael.brown@example.com", ""),
//                new productTable("Michael", "Brown", "michael.brown@example.com", ""),
//                new productTable("Michael", "Brown", "michael.brown@example.com", "")
//        );

        pTableName.setCellValueFactory(
                new PropertyValueFactory<productTable,String>("tName")
        );
        pTableQuantity.setCellValueFactory(
                new PropertyValueFactory<productTable,String>("tQuantity")
        );
        pTableBuyPrice.setCellValueFactory(
                new PropertyValueFactory<productTable,String>("tBuyPrice")
        );

        pTableSalePrice.setCellValueFactory(
                new PropertyValueFactory<productTable,String>("tSalePrice")
        );

        pTableID.setItems(data);
    }

    public void DeleteProduct(MouseEvent mouseEvent) {

        if (mouseEvent.getSource()== productButtonDelete && (pTableID.getSelectionModel().getSelectedItem()!=null)){
            productDeleteName.setText(pTableID.getSelectionModel().getSelectedItem().gettName());
            productDeleteQuantity.setText(pTableID.getSelectionModel().getSelectedItem().gettQuantity());
            productDeleteBuyPrice.setText(pTableID.getSelectionModel().getSelectedItem().gettBuyPrice());
            productDeleteSalePrice.setText(pTableID.getSelectionModel().getSelectedItem().gettSalePrice());
            vboxDeleteProduct.setVisible(true);
        }else if(mouseEvent.getSource()==productButtonDeleteTick&&(productDeleteName.getText().equalsIgnoreCase( pTableID.getSelectionModel().getSelectedItem().gettName()))&&(productDeleteQuantity.getText().equalsIgnoreCase( pTableID.getSelectionModel().getSelectedItem().gettQuantity()))&&(productDeleteBuyPrice.getText().equalsIgnoreCase( pTableID.getSelectionModel().getSelectedItem().gettBuyPrice()))&&(productDeleteSalePrice.getText().equalsIgnoreCase( pTableID.getSelectionModel().getSelectedItem().gettSalePrice()))){
            pTableID.getItems().removeAll(pTableID.getSelectionModel().getSelectedItem());
        }else if(mouseEvent.getSource()==productButtonDeleteCross){
            vboxDeleteProduct.setVisible(false);
        }

    }

    public void UpdateProduct(MouseEvent mouseEvent) {
        if (mouseEvent.getSource()== productButtonUpdate && (pTableID.getSelectionModel().getSelectedItem()!=null)){
            productUpdateName.setText(pTableID.getSelectionModel().getSelectedItem().gettName());
            productUpdateQuantity.setText(pTableID.getSelectionModel().getSelectedItem().gettQuantity());
            productUpdateBuyPrice.setText(pTableID.getSelectionModel().getSelectedItem().gettBuyPrice());
            productUpdateSalePrice.setText(pTableID.getSelectionModel().getSelectedItem().gettSalePrice());
            vboxUpdateProduct.setVisible(true);
            productUpdateNewName.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0))));
        }else if(mouseEvent.getSource()==productButtonUpdateTick&&(productUpdateName.getText().equalsIgnoreCase( pTableID.getSelectionModel().getSelectedItem().gettName()))&&(productUpdateQuantity.getText().equalsIgnoreCase( pTableID.getSelectionModel().getSelectedItem().gettQuantity()))&&(productUpdateBuyPrice.getText().equalsIgnoreCase( pTableID.getSelectionModel().getSelectedItem().gettBuyPrice()))&&(productUpdateSalePrice.getText().equalsIgnoreCase( pTableID.getSelectionModel().getSelectedItem().gettSalePrice()))){
            if(productUpdateNewName.getText().equalsIgnoreCase("")){
                productUpdateNewName.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(2))));
            }
            if(productUpdateNewQuantity.getText().equalsIgnoreCase("")){
                productUpdateNewQuantity.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(2))));
            }
            if(productUpdateNewBuyPrice.getText().equalsIgnoreCase("")){
                productUpdateNewBuyPrice.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(2))));
            }
            if(productUpdateNewSalePrice.getText().equalsIgnoreCase("")){
                productUpdateNewSalePrice.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(2))));
            }
            pTableID.getSelectionModel().getSelectedItem().settName(productUpdateNewName.getText());
            pTableID.getSelectionModel().getSelectedItem().settQuantity(productUpdateNewQuantity.getText());
            pTableID.getSelectionModel().getSelectedItem().settBuyPrice(productUpdateNewBuyPrice.getText());
            pTableID.getSelectionModel().getSelectedItem().settSalePrice(productUpdateNewSalePrice.getText());
        }else if(mouseEvent.getSource()==productButtonUpdateCross){
            vboxUpdateProduct.setVisible(false);
        }
    }

}
