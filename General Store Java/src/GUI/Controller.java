package GUI;

import BillAPI.Bill_Data;
import BillAPI.Bill_Get;
import BillAPI.Bill_Post;
import BillAPI.Bill_ProductData;
import EmployeeAPI.Employee_Data;
import EmployeeAPI.Employee_Get;
import EmployeeAPI.Employee_Post;
import EmployeeAPI.Employee_Put;
import billClasses.BillDetail_Table;
import billClasses.Bill_Table;
import com.sun.javafx.tools.resource.ConsolidatedResources;
import javafx.beans.InvalidationListener;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.scene.image.Image;
import saleClasses.*;
import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;
import javafx.scene.web.WebView;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.stage.FileChooser;

import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TableCell;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import productAPI.Data;
import productAPI.Get;
import productClasses.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;
import javafx.scene.web.WebView;
import productAPI.*;
import java.util.Random;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

import javafx.scene.web.WebView;

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
//import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.function.Predicate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;

import javafx.scene.control.*;
import saleClasses.SaleSearch_Table;

import javax.lang.model.type.NullType;
import javax.xml.stream.Location;

public class Controller implements Initializable {

    @FXML
    private HBox employeeButton;
    @FXML
    private SVGPath customerIcon;

    @FXML
    private SVGPath billIcon;
    @FXML
    private Label customerText;

    @FXML
    private AnchorPane anchorSale;


    @FXML
    private AnchorPane anchorAddProduct;


    @FXML
    private AnchorPane anchorProduct;


    @FXML
    private AnchorPane anchorBills;

    @FXML
    private AnchorPane anchorEmployee;


    @FXML
    private AnchorPane anchorLogin;


    @FXML
    private WebView Employee_Image_Web;

    @FXML
    private WebView CanvasWeb;

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
    private ImageView productButtonRefresh;

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

    @FXML
    private TextField productDeleteName;

    @FXML
    private TextField productDeleteQuantity;

    @FXML
    private TextField SaleAddQuantity;

    @FXML
    private TextField SaleRemoveQuantity;

    @FXML
    private TextField productDeleteBuyPrice;

    @FXML
    private TextField productDeleteSalePrice;

    @FXML
    private ImageView productButtonDeleteTick;

    @FXML
    private ImageView AddImage;

    @FXML
    private SVGPath productIcon;


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

    @FXML
    private VBox vboxSearchProduct;

    @FXML
    private VBox Product;


    @FXML
    private TextField productSearchName;

    @FXML
    private TextField productSearchQuantity;

    @FXML
    private TextField productSearchBuyPrice;

    @FXML
    private TextField productSearchSalePrice;

    @FXML
    private ImageView productButtonSearchTick;

    @FXML
    private ImageView productButtonSearchCross;

    @FXML
    private VBox AddProduct;

    @FXML
    private TextField AddProductName;

    @FXML
    private TextField AddProductQuantity;

    @FXML
    private TextField AddProductBuyPrice;

    @FXML
    private TextField AddProductSalePrice;

    @FXML
    private ImageView AddProductTick;

    @FXML
    private ImageView AddProductCross;


    //Extra
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox vbox_menu;

    @FXML
    private VBox Product1;


    @FXML
    private ImageView SaleTick;

    @FXML
    private ImageView SaleCross;

    @FXML
    private ImageView SaleRemove;

    @FXML
    private TextField SaleSearch;


    @FXML
    private ImageView SaleAdd;

    @FXML
    private ImageView SaleRefresh;


    @FXML
    private VBox Product2;


    @FXML
    private TableView<SaleSearch_Table> SaleSearchTable;

    @FXML
    private TableColumn<SaleSearch_Table, String> SaleSearchTableName;

    @FXML
    private TableColumn<SaleSearch_Table, String> SaleSearchTablePrice;

    @FXML
    private TableColumn<SaleSearch_Table, String> SaleSearchTableQuantity;

    @FXML
    private TableView<SaleItems_Table> SaleItemsTable;

    @FXML
    private TableColumn<SaleItems_Table, String> SaleItemsTableID;

    @FXML
    private TableColumn<SaleItems_Table, String> SaleItemsTableName;

    @FXML
    private TableColumn<SaleItems_Table, String> SaleItemsTableQuantity;


    @FXML
    private TableColumn<SaleItems_Table, String> SaleItemsTablePrice;


    @FXML
    private TableColumn<SaleItems_Table, String> SaleItemsTablePriceX;

    @FXML
    private TableView<SaleBill_Table> SaleBillTable;

    @FXML
    private TableColumn<SaleBill_Table, String> SaleBillTableitems;

    @FXML
    private TableColumn<SaleBill_Table, String> SaleBillTablePrice;


    @FXML
    private ImageView productButtonSearch1;


    @FXML
    private ImageView productButtonUpdateDown;


    @FXML
    private ImageView productButtonRefresh1;

    @FXML
    private VBox vboxSearchProduct11;

    @FXML
    private TextField productSearchName11;

    @FXML
    private TextField productSearchQuantity11;

    @FXML
    private TextField productSearchBuyPrice11;

    @FXML
    private VBox vboxSearchProduct1;

    @FXML
    private TextField productSearchName1;

    @FXML
    private TextField productSearchQuantity1;

    @FXML
    private TextField productSearchBuyPrice1;

    @FXML
    private ImageView productButtonSearchTick1;

    @FXML
    private ImageView productButtonSearchCross1;

    @FXML
    private TextField productSearchName2;

    @FXML
    private TextField productSearchSalePrice11;

    @FXML
    private TableView<Bill_Table> BillTable;

    @FXML
    private TableColumn<Bill_Table, String> BillTableID;

    @FXML
    private TableColumn<Bill_Table, String> BillTableTotalItems;

    @FXML
    private TableColumn<Bill_Table, String> BillTableTotalPrice;

    @FXML
    private TableColumn<Bill_Table, String> BillTableDate;

    @FXML
    private TableView<BillDetail_Table> BillTableDetait;

    @FXML
    private TableColumn<BillDetail_Table, String> BillTableName;

    @FXML
    private TableColumn<BillDetail_Table, String> BillTableQuantity;

    @FXML
    private TableColumn<BillDetail_Table, String> BillTablePrice;

    @FXML
    private VBox vboxBillSearch;

    @FXML
    private VBox vboxEmployeeDiv;

    @FXML
    private HBox hBoxImageDiv;

    @FXML
    private ImageView billSearch;

    @FXML
    private ImageView billrefresh;

    @FXML
    private ImageView billtick;

    @FXML
    private ImageView billcross;

    @FXML
    private TextField billtextid;

    @FXML
    private TextField billtextitems;

    @FXML
    private TextField billtextprice;

    @FXML
    private TextField employeeUsername;

    @FXML
    private PasswordField employeePassword;

    @FXML
    private PasswordField employeeconfirm;

    @FXML
    private TextField employeeImageUrl;

    @FXML
    private ImageView EmployeeEdit;

    @FXML
    private ImageView EmployeeNew;

    @FXML
    private TextField loginuser;

    @FXML
    private PasswordField loginpassword;

    @FXML
    private Button loginbutton;


    //variables
    String tepm_user;
    String temp_password;
    String temp_Image;


    ObservableList<productTable> data;
    ObservableList<productTable> data2;
    ObservableList<SaleSearch_Table> SaleSearchdata;
    ObservableList<SaleItems_Table> SaleItemdata;
    ObservableList<SaleItems_Table> SaleItemdata2;
    ObservableList<SaleBill_Table> SaleBilldata;
    ObservableList<Bill_Table> Billdata;
    ObservableList<BillDetail_Table> Billdetaildata;
    ObservableList<BillDetail_Table> BillDetaildata;

    List<Bill_Data> Billd = new ArrayList<>();

    Validations validate = new Validations();
    ColorAdjust brightLight = new ColorAdjust(0, 0, .25, 0.25);

    //Login
    public void Login(MouseEvent event) {
        if (event.getSource() == loginbutton) {
            System.out.println("login pressed");
            try {
                List<Employee_Data> d = new ArrayList<>();
                d = Employee_Get.get();
                System.out.println(d.size());
                for (int i = 0; i < d.size(); i++) {
                    System.out.println(loginuser.getText() + "==" + d.get(i).getUsername() + loginpassword.getText() + "==" + d.get(i).getPassword());
                    if (loginuser.getText().equals(d.get(i).getUsername()) && loginpassword.getText().equals(d.get(i).getPassword())) {
                        System.out.println("login");
                        tepm_user = d.get(i).getUsername();
                        temp_password = d.get(i).getPassword();
                        temp_Image = d.get(i).getImage();
                        anchorLogin.setVisible(false);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    //Side_Menu
    public void displayMenu(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == saleButton) {
            anchorSale.setVisible(true);
            anchorAddProduct.setVisible(false);
            anchorProduct.setVisible(false);
            anchorBills.setVisible(false);
            anchorEmployee.setVisible(false);

            //
            saleIcon.setFill(Color.valueOf("#FFFFFF"));
            saleText.setTextFill(Color.valueOf("#FFFFFF"));
            addproductIcon.setFill(Color.valueOf("#FFFFFF"));
            addproductText.setTextFill(Color.valueOf("#FFFFFF"));
            productIcon.setFill(Color.valueOf("#FFFFFF"));
            productText.setTextFill(Color.valueOf("#FFFFFF"));
            billIcon.setFill(Color.valueOf("#FFFFFF"));
            billText.setTextFill(Color.valueOf("#FFFFFF"));
            customerIcon.setFill(Color.valueOf("#FFFFFF"));
            customerText.setTextFill(Color.valueOf("#FFFFFF"));
////////////////
            saleIcon.setFill(Color.valueOf("#F3C300"));
            saleText.setTextFill(Color.valueOf("#F3C300"));

            getSaleSearchTableData();
            SaleItemdata2 = FXCollections.observableArrayList();
        }
        if (mouseEvent.getSource() == addproductButton) {
            anchorSale.setVisible(false);
            anchorAddProduct.setVisible(true);
            anchorProduct.setVisible(false);
            anchorBills.setVisible(false);
            anchorEmployee.setVisible(false);
//
            saleIcon.setFill(Color.valueOf("#FFFFFF"));
            saleText.setTextFill(Color.valueOf("#FFFFFF"));
            addproductIcon.setFill(Color.valueOf("#FFFFFF"));
            addproductText.setTextFill(Color.valueOf("#FFFFFF"));
            productIcon.setFill(Color.valueOf("#FFFFFF"));
            productText.setTextFill(Color.valueOf("#FFFFFF"));
            billIcon.setFill(Color.valueOf("#FFFFFF"));
            billText.setTextFill(Color.valueOf("#FFFFFF"));
            customerIcon.setFill(Color.valueOf("#FFFFFF"));
            customerText.setTextFill(Color.valueOf("#FFFFFF"));
////////////////
            addproductIcon.setFill(Color.valueOf("#F3C300"));
            addproductText.setTextFill(Color.valueOf("#F3C300"));


        } else if (mouseEvent.getSource() == productButtoN) {
            anchorSale.setVisible(false);
            anchorAddProduct.setVisible(false);
            anchorProduct.setVisible(true);
            anchorBills.setVisible(false);
            anchorEmployee.setVisible(false);
//
            saleIcon.setFill(Color.valueOf("#FFFFFF"));
            saleText.setTextFill(Color.valueOf("#FFFFFF"));
            addproductIcon.setFill(Color.valueOf("#FFFFFF"));
            addproductText.setTextFill(Color.valueOf("#FFFFFF"));
            productIcon.setFill(Color.valueOf("#FFFFFF"));
            productText.setTextFill(Color.valueOf("#FFFFFF"));
            billIcon.setFill(Color.valueOf("#FFFFFF"));
            billText.setTextFill(Color.valueOf("#FFFFFF"));
            customerIcon.setFill(Color.valueOf("#FFFFFF"));
            customerText.setTextFill(Color.valueOf("#FFFFFF"));
////////////////
            productIcon.setFill(Color.valueOf("#F3C300"));
            productText.setTextFill(Color.valueOf("#F3C300"));

            getProductTableData();

        } else if (mouseEvent.getSource() == billButton) {
            anchorSale.setVisible(false);
            anchorAddProduct.setVisible(false);
            anchorProduct.setVisible(false);
            anchorBills.setVisible(true);
            anchorEmployee.setVisible(false);
//
            saleIcon.setFill(Color.valueOf("#FFFFFF"));
            saleText.setTextFill(Color.valueOf("#FFFFFF"));
            addproductIcon.setFill(Color.valueOf("#FFFFFF"));
            addproductText.setTextFill(Color.valueOf("#FFFFFF"));
            productIcon.setFill(Color.valueOf("#FFFFFF"));
            productText.setTextFill(Color.valueOf("#FFFFFF"));
            billIcon.setFill(Color.valueOf("#FFFFFF"));
            billText.setTextFill(Color.valueOf("#FFFFFF"));
            customerIcon.setFill(Color.valueOf("#FFFFFF"));
            customerText.setTextFill(Color.valueOf("#FFFFFF"));
////////////////
            billIcon.setFill(Color.valueOf("#F3C300"));
            billText.setTextFill(Color.valueOf("#F3C300"));
            GetBills();
        } else if (mouseEvent.getSource() == employeeButton) {
            anchorSale.setVisible(false);
            anchorAddProduct.setVisible(false);
            anchorProduct.setVisible(false);
            anchorBills.setVisible(false);
            anchorEmployee.setVisible(true);
//
            saleIcon.setFill(Color.valueOf("#FFFFFF"));
            saleText.setTextFill(Color.valueOf("#FFFFFF"));
            addproductIcon.setFill(Color.valueOf("#FFFFFF"));
            addproductText.setTextFill(Color.valueOf("#FFFFFF"));
            productIcon.setFill(Color.valueOf("#FFFFFF"));
            productText.setTextFill(Color.valueOf("#FFFFFF"));
            billIcon.setFill(Color.valueOf("#FFFFFF"));
            billText.setTextFill(Color.valueOf("#FFFFFF"));
            customerIcon.setFill(Color.valueOf("#FFFFFF"));
            customerText.setTextFill(Color.valueOf("#FFFFFF"));
////////////////
            customerIcon.setFill(Color.valueOf("#F3C300"));
            customerText.setTextFill(Color.valueOf("#F3C300"));
            GetEmployee();
            SetImages();
        }

    }


    //Sale_page
    public void getSaleSearchTableData() {
        productAPI.Get gat = new Get();
        List<Data> d = new ArrayList<>();
        try {
            d = Get.get();
            System.out.println(d.size());
            for (int i = 0; i < d.size(); i++)
                System.out.println(d.get(i).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SaleSearchdata = FXCollections.observableArrayList();
        for (int i = 0; i < d.size(); i++) {
            SaleSearchdata.add(new SaleSearch_Table(d.get(i).getName(), d.get(i).getQuantity(), d.get(i).getBuyPrice(), d.get(i).getSellPrice()));
        }
        SaleSearchTableName.setCellValueFactory(
                new PropertyValueFactory<SaleSearch_Table, String>("tName")
        );
        SaleSearchTablePrice.setCellValueFactory(
                new PropertyValueFactory<SaleSearch_Table, String>("tPrice")
        );
        SaleSearchTableQuantity.setCellValueFactory(
                new PropertyValueFactory<SaleSearch_Table, String>("tQuantity")
        );

        SaleSearchTable.setItems(SaleSearchdata);
    }
    public void getSaleBillTableData() {
        double bill_total = 0;
        for (int i = 0; i < SaleItemdata.size(); i++) {
            bill_total += Double.parseDouble(SaleItemdata.get(i).gettPriceX());
        }
        SaleBilldata = FXCollections.observableArrayList();
        SaleBilldata.add(new SaleBill_Table(Integer.toString(SaleItemdata.size()), Double.toString(bill_total)));

        SaleBillTableitems.setCellValueFactory(
                new PropertyValueFactory<SaleBill_Table, String>("tItems")
        );
        SaleBillTablePrice.setCellValueFactory(
                new PropertyValueFactory<SaleBill_Table, String>("tPrice")
        );

        SaleBillTable.setItems(SaleBilldata);

    }
    public void SaleButtonsActions(MouseEvent mouseEvent) {
        boolean flagquantityremove = true;
        boolean flagquantityadd = true;
        if (mouseEvent.getSource() == SaleAdd) {
            int quantityset = Integer.parseInt(SaleAddQuantity.getText());
            int quantitystored = Integer.parseInt(SaleSearchTable.getSelectionModel().getSelectedItem().gettQuantity());
            if (quantityset > quantitystored) {
                flagquantityadd = false;
            }

            if (SaleAddQuantity.getText().equalsIgnoreCase("") || validate.getIntValid(SaleAddQuantity.getText()) == 0 ||!validate.getQuantityValid(SaleAddQuantity.getText())|| flagquantityadd == false) {
                SaleAddQuantity.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(0, 0, 2, 0))));
            } else if (SaleSearchTable.getSelectionModel().isEmpty()) {
                System.out.println("SaleAddempty");
            } else {
                boolean flagfind = false;
                SaleItemdata = FXCollections.observableArrayList();
                for (int i = 0; i < SaleItemdata2.size(); i++) {
                    if (SaleItemdata2.get(i).gettName() == SaleSearchTable.getSelectionModel().getSelectedItem().gettName()) {

                        int id = i + 1;
                        String ID = Integer.toString(id);
                        String quantity = Integer.toString(validate.getIntValid(SaleAddQuantity.getText()) + validate.getIntValid(SaleItemdata2.get(i).gettQuantity()));
                        String PriceX = Double.toString(validate.getDoubleValid(quantity) * validate.getDoubleValid(SaleSearchTable.getSelectionModel().getSelectedItem().gettPrice()));
                        System.out.println("find" + quantity + PriceX);
                        try {
                            Data d = new Data();
                            Data up = new Data();
                            String quantityRemain = Integer.toString(validate.getIntValid(SaleSearchTable.getSelectionModel().getSelectedItem().gettQuantity()) - validate.getIntValid(SaleAddQuantity.getText()));
                            //old data
                            d.setName(SaleSearchTable.getSelectionModel().getSelectedItem().gettName());
                            d.setQuantity(SaleSearchTable.getSelectionModel().getSelectedItem().gettQuantity());
                            d.setBuyPrice(SaleSearchTable.getSelectionModel().getSelectedItem().gettBuyPrice());
                            d.setSellPrice(SaleSearchTable.getSelectionModel().getSelectedItem().gettPrice());

                            //new data
                            up.setName(SaleSearchTable.getSelectionModel().getSelectedItem().gettName());
                            up.setQuantity(quantityRemain);
                            up.setSellPrice(SaleSearchTable.getSelectionModel().getSelectedItem().gettPrice());
                            up.setBuyPrice(SaleSearchTable.getSelectionModel().getSelectedItem().gettBuyPrice());

                            Put.put(d, up);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        SaleItemdata.add(new SaleItems_Table(ID, SaleItemdata2.get(i).gettName(), quantity, SaleItemdata2.get(i).gettPrice(), PriceX));
                        flagfind = true;

                    } else {
                        int id = i + 1;
                        String ID = Integer.toString(id);
                        SaleItemdata.add(new SaleItems_Table(ID, SaleItemdata2.get(i).gettName(), SaleItemdata2.get(i).gettQuantity(), SaleItemdata2.get(i).gettPrice(), SaleItemdata2.get(i).gettPriceX()));
                    }

                }
                if (flagfind == false) {
                    for (int i = 0; i < 1; i++) {
                        int id = SaleItemdata.size() + 1;
                        String ID = Integer.toString(id);
                        String PriceX = Double.toString(validate.getDoubleValid(SaleAddQuantity.getText()) * validate.getDoubleValid(SaleSearchTable.getSelectionModel().getSelectedItem().gettPrice()));
                        try {
                            Data d = new Data();
                            Data up = new Data();
                            String quantityRemain = Integer.toString(validate.getIntValid(SaleSearchTable.getSelectionModel().getSelectedItem().gettQuantity()) - validate.getIntValid(SaleAddQuantity.getText()));
                            //old data
                            d.setName(SaleSearchTable.getSelectionModel().getSelectedItem().gettName());
                            d.setQuantity(SaleSearchTable.getSelectionModel().getSelectedItem().gettQuantity());
                            d.setBuyPrice(SaleSearchTable.getSelectionModel().getSelectedItem().gettBuyPrice());
                            d.setSellPrice(SaleSearchTable.getSelectionModel().getSelectedItem().gettPrice());

                            //new data
                            up.setName(SaleSearchTable.getSelectionModel().getSelectedItem().gettName());
                            up.setQuantity(quantityRemain);
                            up.setSellPrice(SaleSearchTable.getSelectionModel().getSelectedItem().gettPrice());
                            up.setBuyPrice(SaleSearchTable.getSelectionModel().getSelectedItem().gettBuyPrice());

                            Put.put(d, up);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        SaleItemdata.add(new SaleItems_Table(ID, SaleSearchTable.getSelectionModel().getSelectedItem().gettName(), SaleAddQuantity.getText(), SaleSearchTable.getSelectionModel().getSelectedItem().gettPrice(), PriceX));
//                    System.out.println(ID+SaleSearchTable.getSelectionModel().getSelectedItem().gettName()+" "+SaleSearchTable.getSelectionModel().getSelectedItem().gettPrice());
                    }
                }

                SaleItemsTableID.setCellValueFactory(
                        new PropertyValueFactory<SaleItems_Table, String>("tID")
                );
                SaleItemsTableName.setCellValueFactory(
                        new PropertyValueFactory<SaleItems_Table, String>("tName")
                );

                SaleItemsTableQuantity.setCellValueFactory(
                        new PropertyValueFactory<SaleItems_Table, String>("tQuantity")
                );

                SaleItemsTablePrice.setCellValueFactory(
                        new PropertyValueFactory<SaleItems_Table, String>("tPrice")
                );
                SaleItemsTablePriceX.setCellValueFactory(
                        new PropertyValueFactory<SaleItems_Table, String>("tPriceX")
                );

                SaleItemsTable.setItems(SaleItemdata);
                SaleItemdata2 = SaleItemdata;

                SaleAddQuantity.setText("");
                getSaleBillTableData();
                getSaleSearchTableData();
            }


        }
        if (mouseEvent.getSource() == SaleRefresh) {
            getSaleSearchTableData();
        }
        if (mouseEvent.getSource() == SaleRemove) {
            String name11 = SaleItemsTable.getSelectionModel().getSelectedItem().gettName();
            String name22;
            for (int j = 0; j < SaleSearchdata.size(); j++) {
                name22 = SaleSearchdata.get(j).gettName();
                System.out.println(name11 + "=" + name22);
                if (name11.equals(name22)) {
                    int setquantity = validate.getIntValid(SaleRemoveQuantity.getText());
                    int storedquantity = validate.getIntValid(SaleItemsTable.getSelectionModel().getSelectedItem().gettQuantity());
                    if (setquantity > storedquantity) {
                        flagquantityremove = false;
                    }
                }
            }
            if (SaleRemoveQuantity.getText().equalsIgnoreCase("") || validate.getIntValid(SaleRemoveQuantity.getText()) == 0 || flagquantityremove == false||!validate.getQuantityValid(SaleAddQuantity.getText())) {
                SaleRemoveQuantity.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(0, 0, 2, 0))));
            } else if (SaleItemsTable.getSelectionModel().isEmpty()) {
                System.out.println("Empyt");
            } else {
                boolean flagfind = false;
                SaleItemdata = FXCollections.observableArrayList();
                boolean flagid = false;
                int id_reverse = 0;
                for (int i = 0; i < SaleItemdata2.size(); i++) {
                    int id = i + 1;
                    if (flagid == true) {
                        for (int j = 0; j < id_reverse; j++) {
                            id = id - 1;
                        }

                    }
                    String ID = Integer.toString(id);
                    if (SaleItemdata2.get(i).gettName() == SaleItemsTable.getSelectionModel().getSelectedItem().gettName()) {
                        String quantity = Integer.toString(validate.getIntValid(SaleItemdata2.get(i).gettQuantity()) - validate.getIntValid(SaleRemoveQuantity.getText()));
                        try {
                            System.out.println("in try");
                            Data d = new Data();
                            Data up = new Data();
                            //old data
                            String name1 = SaleItemsTable.getSelectionModel().getSelectedItem().gettName();
                            String name2;
                            for (int j = 0; j < SaleSearchdata.size(); j++) {
                                name2 = SaleSearchdata.get(j).gettName();
                                System.out.println(name1 + "=" + name2);
                                if (name1.equals(name2)) {
                                    System.out.println("error");
                                    int prevoiusquantity = validate.getIntValid(SaleSearchdata.get(j).gettQuantity());
                                    int newquantity = validate.getIntValid(SaleRemoveQuantity.getText());
                                    newquantity = prevoiusquantity + newquantity;
                                    String quantityRemain = Integer.toString(newquantity);
                                    System.out.println("remain quantity" + quantityRemain);
                                    d.setName(SaleItemsTable.getSelectionModel().getSelectedItem().gettName());
                                    d.setQuantity(SaleSearchdata.get(j).gettQuantity());
                                    d.setBuyPrice(SaleSearchdata.get(j).gettBuyPrice());
                                    d.setSellPrice(SaleSearchdata.get(j).gettPrice());

                                    //new data
                                    up.setName(SaleSearchdata.get(j).gettName());
                                    up.setQuantity(quantityRemain);
                                    up.setSellPrice(SaleSearchdata.get(j).gettPrice());
                                    up.setBuyPrice(SaleSearchdata.get(j).gettBuyPrice());

                                } else {
                                    System.out.println("not found" + j);
                                }
                            }

                            Put.put(d, up);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (quantity == "0" || validate.getIntValid(quantity) <= 0) {
//                            SaleItemdata2.remove(i);
                            id_reverse++;
                            flagid = true;
                        } else {
                            String PriceX = Double.toString(validate.getDoubleValid(quantity) * validate.getDoubleValid(SaleItemsTable.getSelectionModel().getSelectedItem().gettPrice()));
                            System.out.println("find" + quantity + PriceX);
                            SaleItemdata.add(new SaleItems_Table(ID, SaleItemdata2.get(i).gettName(), quantity, SaleItemdata2.get(i).gettPrice(), PriceX));
                            flagfind = true;
                        }
                    } else {
                        SaleItemdata.add(new SaleItems_Table(ID, SaleItemdata2.get(i).gettName(), SaleItemdata2.get(i).gettQuantity(), SaleItemdata2.get(i).gettPrice(), SaleItemdata2.get(i).gettPriceX()));
                    }

                }

                SaleItemsTableID.setCellValueFactory(
                        new PropertyValueFactory<SaleItems_Table, String>("tID")
                );
                SaleItemsTableName.setCellValueFactory(
                        new PropertyValueFactory<SaleItems_Table, String>("tName")
                );

                SaleItemsTableQuantity.setCellValueFactory(
                        new PropertyValueFactory<SaleItems_Table, String>("tQuantity")
                );

                SaleItemsTablePrice.setCellValueFactory(
                        new PropertyValueFactory<SaleItems_Table, String>("tPrice")
                );
                SaleItemsTablePriceX.setCellValueFactory(
                        new PropertyValueFactory<SaleItems_Table, String>("tPriceX")
                );

                SaleItemsTable.setItems(SaleItemdata);
                SaleItemdata2 = SaleItemdata;


                SaleRemoveQuantity.setText("");
                getSaleBillTableData();
                getSaleSearchTableData();
            }

        }
        if (mouseEvent.getSource() == SaleCross) {
            for (int i = 0; i < SaleItemsTable.getItems().size(); i++) {
                SaleItemsTable.getItems().clear();

            }
            SaleItemdata = FXCollections.observableArrayList();
            SaleItemdata2 = SaleItemdata;
            getSaleBillTableData();
        }
        if (mouseEvent.getSource() == SaleTick && (validate.getIntValid(SaleBilldata.get(0).gettItems()) > 0)) {
            try {
                Bill_Data data = new Bill_Data();
                data.setBillid("tahseen");
                data.setTotalitems(SaleBilldata.get(0).gettItems());
                data.setTotalprice(SaleBilldata.get(0).gettPrice());
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                System.out.println(dateFormat.format(date));
                data.setDate(dateFormat.format(date));
                List<Bill_ProductData> billProductData = new ArrayList<>();
                Bill_ProductData[] b = new Bill_ProductData[SaleItemdata2.size()];
                for (int i = 0; i < SaleItemdata2.size(); i++) {
                    b[i] = new Bill_ProductData(SaleItemdata2.get(i).gettName(), SaleItemdata2.get(i).gettQuantity(), SaleItemdata2.get(i).gettPriceX(), SaleItemdata2.get(i).gettPrice());
                    billProductData.add(b[i]);

                }
                data.setProductData(billProductData);
                Bill_Post.post(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
            SaleItemdata2.clear();
            SaleItemsTable.setItems(SaleItemdata2);
            SaleBilldata.clear();
            SaleBillTable.setItems(SaleBilldata);
        }
    }


    //Add_Product
    public void AddProduct(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == AddProductCross) {
            AddProductName.setText("");
            AddProductQuantity.setText("");
            AddProductBuyPrice.setText("");
            AddProductSalePrice.setText("");
        }
        if (mouseEvent.getSource() == AddProductTick) {


            boolean lockUpdate1 = false, lockUpdate2 = false, lockUpdate3 = false, lockUpdate4 = false;

            if (AddProductName.getText().equalsIgnoreCase("")) {
                AddProductName.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(0, 0, 2, 0))));
                lockUpdate1 = true;
            } else {
                AddProductName.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(0, 0, 2, 0))));

            }
            if (AddProductQuantity.getText().equalsIgnoreCase("") || (validate.getDoubleValid(AddProductQuantity.getText()) == 0)) {
                AddProductQuantity.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(0, 0, 2, 0))));
                lockUpdate2 = true;
            } else {
                AddProductQuantity.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(0, 0, 2, 0))));
            }
            if (AddProductBuyPrice.getText().equalsIgnoreCase("") || (validate.getDoubleValid(AddProductBuyPrice.getText()) == 0)) {
                AddProductBuyPrice.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(0, 0, 2, 0))));
                lockUpdate3 = true;
            } else {
                AddProductBuyPrice.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(0, 0, 2, 0))));
            }
            if (AddProductSalePrice.getText().equalsIgnoreCase("") || (validate.getDoubleValid(AddProductSalePrice.getText()) == 0)) {
                AddProductSalePrice.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(0, 0, 2, 0))));
                lockUpdate4 = true;
            } else {
                AddProductSalePrice.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(0, 0, 2, 0))));

            }

            if ((lockUpdate1 == false) && (lockUpdate2 == false) && (lockUpdate3 == false) && (lockUpdate4 == false)) {
                Data d = new Data();
                d.setName(AddProductName.getText());
                d.setQuantity(AddProductQuantity.getText());
                d.setBuyPrice(AddProductBuyPrice.getText());
                d.setSellPrice(AddProductSalePrice.getText());
                AddProductName.setText("");
                AddProductQuantity.setText("");
                AddProductBuyPrice.setText("");
                AddProductSalePrice.setText("");

                try {
                    Post.post(d);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //Product
    public void getProductTableData() {
        productAPI.Get gat = new Get();
        List<Data> d = new ArrayList<>();
        try {

            d = Get.get();
            System.out.println(d.size());
            for (int i = 0; i < d.size(); i++)
                System.out.println(d.get(i).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        data = FXCollections.observableArrayList();
        for (int i = 0; i < d.size(); i++) {
            data.add(new productTable(d.get(i).getName(), d.get(i).getQuantity(), d.get(i).getBuyPrice(), d.get(i).getSellPrice()));
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
                new PropertyValueFactory<productTable, String>("tName")
        );
        pTableQuantity.setCellValueFactory(
                new PropertyValueFactory<productTable, String>("tQuantity")
        );
        pTableBuyPrice.setCellValueFactory(
                new PropertyValueFactory<productTable, String>("tBuyPrice")
        );

        pTableSalePrice.setCellValueFactory(
                new PropertyValueFactory<productTable, String>("tSalePrice")
        );

        pTableID.setItems(data);
    }
    public void DeleteProduct(MouseEvent mouseEvent) {

        if (mouseEvent.getSource() == productButtonDelete && (pTableID.getSelectionModel().getSelectedItem() != null)) {
            productDeleteName.setText(pTableID.getSelectionModel().getSelectedItem().gettName());
            productDeleteQuantity.setText(pTableID.getSelectionModel().getSelectedItem().gettQuantity());
            productDeleteBuyPrice.setText(pTableID.getSelectionModel().getSelectedItem().gettBuyPrice());
            productDeleteSalePrice.setText(pTableID.getSelectionModel().getSelectedItem().gettSalePrice());
            vboxDeleteProduct.setVisible(true);
        } else if (mouseEvent.getSource() == productButtonDeleteTick && (productDeleteName.getText().equalsIgnoreCase(pTableID.getSelectionModel().getSelectedItem().gettName())) && (productDeleteQuantity.getText().equalsIgnoreCase(pTableID.getSelectionModel().getSelectedItem().gettQuantity())) && (productDeleteBuyPrice.getText().equalsIgnoreCase(pTableID.getSelectionModel().getSelectedItem().gettBuyPrice())) && (productDeleteSalePrice.getText().equalsIgnoreCase(pTableID.getSelectionModel().getSelectedItem().gettSalePrice()))) {
            try {
                Data d = new Data();
                d.setName(pTableID.getSelectionModel().getSelectedItem().gettName());
                d.setQuantity(pTableID.getSelectionModel().getSelectedItem().gettQuantity());
                d.setBuyPrice(pTableID.getSelectionModel().getSelectedItem().gettBuyPrice());
                d.setSellPrice(pTableID.getSelectionModel().getSelectedItem().gettSalePrice());
                try {
                    Delete.delete(d);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                pTableID.getItems().removeAll(pTableID.getSelectionModel().getSelectedItem());
                productDeleteName.setText("");
                productDeleteQuantity.setText("");
                productDeleteBuyPrice.setText("");
                productDeleteSalePrice.setText("");
                vboxDeleteProduct.setVisible(false);

            } catch (Exception ex) {
                System.out.println("Delete Error here!");
                System.out.println(pTableID.getSelectionModel().getSelectedItem().gettName() + pTableID.getSelectionModel().getSelectedItem().gettQuantity());
                Data d = new Data();

                d.setName(pTableID.getSelectionModel().getSelectedItem().gettName());
                d.setQuantity(pTableID.getSelectionModel().getSelectedItem().gettQuantity());
                d.setBuyPrice(pTableID.getSelectionModel().getSelectedItem().gettBuyPrice());
                d.setSellPrice(pTableID.getSelectionModel().getSelectedItem().gettSalePrice());

                try {
                    Delete.delete(d);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                productDeleteName.setText("");
                productDeleteQuantity.setText("");
                productDeleteBuyPrice.setText("");
                productDeleteSalePrice.setText("");
                vboxDeleteProduct.setVisible(false);
                getProductTableData();

            }

        } else if (mouseEvent.getSource() == productButtonDeleteCross) {
            vboxDeleteProduct.setVisible(false);
        }

    }
    public void UpdateProduct(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == productButtonUpdate && (pTableID.getSelectionModel().getSelectedItem() != null)) {
            productUpdateName.setText(pTableID.getSelectionModel().getSelectedItem().gettName());
            productUpdateQuantity.setText(pTableID.getSelectionModel().getSelectedItem().gettQuantity());
            productUpdateBuyPrice.setText(pTableID.getSelectionModel().getSelectedItem().gettBuyPrice());
            productUpdateSalePrice.setText(pTableID.getSelectionModel().getSelectedItem().gettSalePrice());
            vboxUpdateProduct.setVisible(true);
            productUpdateNewQuantity.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));
            productUpdateNewBuyPrice.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));
            productUpdateNewSalePrice.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));
            productUpdateNewName.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));


        } else if (mouseEvent.getSource() == productButtonUpdateTick && (productUpdateName.getText().equalsIgnoreCase(pTableID.getSelectionModel().getSelectedItem().gettName())) && (productUpdateQuantity.getText().equalsIgnoreCase(pTableID.getSelectionModel().getSelectedItem().gettQuantity())) && (productUpdateBuyPrice.getText().equalsIgnoreCase(pTableID.getSelectionModel().getSelectedItem().gettBuyPrice())) && (productUpdateSalePrice.getText().equalsIgnoreCase(pTableID.getSelectionModel().getSelectedItem().gettSalePrice()))) {


            boolean lockUpdate1 = false, lockUpdate2 = false, lockUpdate3 = false, lockUpdate4 = false;

            if (productUpdateNewName.getText().equalsIgnoreCase("")) {
                productUpdateNewName.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(0, 0, 2, 0))));
                lockUpdate1 = true;
            } else {
                productUpdateNewName.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));
//                String css2 = this.getClass().getResource("input.css").toExternalForm();
//                productUpdateNewName.getStylesheets().add(css2);
//                productUpdateNewName.getStyleClass().add("input");
            }
            if (productUpdateNewQuantity.getText().equalsIgnoreCase("") || (validate.getDoubleValid(productUpdateNewQuantity.getText()) == 0)) {
                productUpdateNewQuantity.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(0, 0, 2, 0))));
                lockUpdate2 = true;
            } else {
                productUpdateNewQuantity.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));
            }
            if (productUpdateNewBuyPrice.getText().equalsIgnoreCase("") || (validate.getDoubleValid(productUpdateNewBuyPrice.getText()) == 0)) {
                productUpdateNewBuyPrice.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(0, 0, 2, 0))));

                lockUpdate3 = true;
            } else {
                productUpdateNewBuyPrice.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));
            }
            if (productUpdateNewSalePrice.getText().equalsIgnoreCase("") || (validate.getDoubleValid(productUpdateNewSalePrice.getText()) == 0)) {
                productUpdateNewSalePrice.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(0, 0, 2, 0))));
                lockUpdate4 = true;
            } else {
                productUpdateNewSalePrice.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));
            }

            if ((lockUpdate1 == false) && (lockUpdate2 == false) && (lockUpdate3 == false) && (lockUpdate4 == false)) {


                Data old_d = new Data();
                Data new_d = new Data();
                //set old data
                old_d.setName(productUpdateName.getText());
                old_d.setQuantity(productUpdateQuantity.getText());
                old_d.setBuyPrice(productUpdateBuyPrice.getText());
                old_d.setSellPrice(productUpdateSalePrice.getText());
                //set new data
                new_d.setName(productUpdateNewName.getText());
                new_d.setQuantity(productUpdateNewQuantity.getText());
                new_d.setBuyPrice(productUpdateNewBuyPrice.getText());
                new_d.setSellPrice(productUpdateNewSalePrice.getText());
                System.out.println(old_d.getName() + old_d.getQuantity() + old_d.getBuyPrice() + old_d.getSellPrice());
                System.out.println(new_d.getName() + new_d.getQuantity() + new_d.getBuyPrice() + new_d.getSellPrice());
                try {
                    Put.put(old_d, new_d);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                pTableID.getSelectionModel().getSelectedItem().settName(productUpdateNewName.getText());
                pTableID.getSelectionModel().getSelectedItem().settQuantity(productUpdateNewQuantity.getText());
                pTableID.getSelectionModel().getSelectedItem().settBuyPrice(productUpdateNewBuyPrice.getText());
                pTableID.getSelectionModel().getSelectedItem().settSalePrice(productUpdateNewSalePrice.getText());

                productUpdateName.setText("");
                productUpdateQuantity.setText("");
                productUpdateBuyPrice.setText("");
                productUpdateSalePrice.setText("");

                productUpdateNewName.setText("");
                productUpdateNewQuantity.setText("");
                productUpdateNewBuyPrice.setText("");
                productUpdateNewSalePrice.setText("");

                vboxUpdateProduct.setVisible(false);
            }


        } else if (mouseEvent.getSource() == productButtonUpdateCross) {
            productUpdateName.setText("");
            productUpdateQuantity.setText("");
            productUpdateBuyPrice.setText("");
            productUpdateSalePrice.setText("");

            productUpdateNewName.setText("");
            productUpdateNewQuantity.setText("");
            productUpdateNewBuyPrice.setText("");
            productUpdateNewSalePrice.setText("");

            vboxUpdateProduct.setVisible(false);
        } else if (mouseEvent.getSource() == productButtonUpdateDown) {

            productUpdateNewName.setText(productUpdateName.getText());
            productUpdateNewQuantity.setText(productUpdateQuantity.getText());
            productUpdateNewBuyPrice.setText(productUpdateBuyPrice.getText());
            productUpdateNewSalePrice.setText(productUpdateSalePrice.getText());
        }
    }
    public void SearchProduct(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == productButtonSearch) {
            data2 = data;
            vboxSearchProduct.setVisible(true);
        } else if (mouseEvent.getSource() == productButtonSearchTick) {
            vboxSearchProduct.setVisible(false);
        } else if (mouseEvent.getSource() == productButtonSearchCross) {
            productSearchName.setText("");
            productSearchQuantity.setText("");
            productSearchBuyPrice.setText("");
            productSearchSalePrice.setText("");
            pTableID.setItems(data);
            vboxSearchProduct.setVisible(false);
        }
    }
    public void SearchProductList(KeyEvent keyEvent) {

        SortedList<productTable> sortedData, sortedQuantity, sortedBuyPrice, sortedSalePrice;
        if (keyEvent.getSource() == productSearchName) {

            FilteredList<productTable> filteredName = new FilteredList<>(data, n -> true);
            productSearchName.setOnKeyReleased(n -> {
                productSearchName.textProperty().addListener(((observable, oldValue, newValue) -> {
                    filteredName.setPredicate((Predicate<? super productTable>) data -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lowerCaseFilter = newValue.toLowerCase();
                        if (data.gettName().toLowerCase().contains(lowerCaseFilter)) {
                            return true;
                        }
                        return false;
                    });
                }));
            });
            sortedData = new SortedList<>(filteredName);
            sortedData.comparatorProperty().bind(pTableID.comparatorProperty());
            pTableID.setItems(sortedData);
            data = sortedData;

        } else if (keyEvent.getSource() == productSearchQuantity) {

            FilteredList<productTable> filteredQuantity = new FilteredList<>(data, q -> true);
            productSearchQuantity.setOnKeyReleased(q -> {
                productSearchQuantity.textProperty().addListener(((observable, oldValue, newValue) -> {
                    filteredQuantity.setPredicate((Predicate<? super productTable>) data -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lowerCaseFilter = newValue.toLowerCase();
                        if (data.gettQuantity().toLowerCase().contains(lowerCaseFilter)) {
                            return true;
                        }
                        return false;
                    });
                }));
            });
            sortedQuantity = new SortedList<>(filteredQuantity);
            sortedQuantity.comparatorProperty().bind(pTableID.comparatorProperty());
            pTableID.setItems(sortedQuantity);
            data = sortedQuantity;
        } else if (keyEvent.getSource() == productSearchBuyPrice) {
            FilteredList<productTable> filteredBuyPrice = new FilteredList<>(data, b -> true);
            productSearchBuyPrice.setOnKeyReleased(b -> {
                productSearchBuyPrice.textProperty().addListener(((observable, oldValue, newValue) -> {
                    filteredBuyPrice.setPredicate((Predicate<? super productTable>) data -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lowerCaseFilter = newValue.toLowerCase();
                        if (data.gettBuyPrice().toLowerCase().contains(lowerCaseFilter)) {
                            return true;
                        }
                        return false;
                    });
                }));
            });
            sortedBuyPrice = new SortedList<>(filteredBuyPrice);
            sortedBuyPrice.comparatorProperty().bind(pTableID.comparatorProperty());
            pTableID.setItems(sortedBuyPrice);
            data = sortedBuyPrice;

        } else if (keyEvent.getSource() == productSearchSalePrice) {
            FilteredList<productTable> filteredSalePrice = new FilteredList<>(data, s -> true);
            productSearchSalePrice.setOnKeyReleased(s -> {
                productSearchSalePrice.textProperty().addListener(((observable, oldValue, newValue) -> {
                    filteredSalePrice.setPredicate((Predicate<? super productTable>) data -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lowerCaseFilter = newValue.toLowerCase();
                        if (data.gettSalePrice().toLowerCase().contains(lowerCaseFilter)) {
                            return true;
                        }
                        return false;
                    });
                }));
            });
            sortedSalePrice = new SortedList<>(filteredSalePrice);
            sortedSalePrice.comparatorProperty().bind(pTableID.comparatorProperty());
            pTableID.setItems(sortedSalePrice);
            data = sortedSalePrice;
        }


    }
    public void RefreshProduct(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == productButtonRefresh) {

            productAPI.Get gat = new Get();
            List<Data> d = new ArrayList<>();
            try {

                d = Get.get();
                System.out.println(d.size());
                for (int i = 0; i < d.size(); i++)
                    System.out.println(d.get(i).getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            data = FXCollections.observableArrayList();
            for (int i = 0; i < d.size(); i++) {
                data.add(new productTable(d.get(i).getName(), d.get(i).getQuantity(), d.get(i).getBuyPrice(), d.get(i).getSellPrice()));
            }


            pTableName.setCellValueFactory(
                    new PropertyValueFactory<productTable, String>("tName")
            );
            pTableQuantity.setCellValueFactory(
                    new PropertyValueFactory<productTable, String>("tQuantity")
            );
            pTableBuyPrice.setCellValueFactory(
                    new PropertyValueFactory<productTable, String>("tBuyPrice")
            );

            pTableSalePrice.setCellValueFactory(
                    new PropertyValueFactory<productTable, String>("tSalePrice")
            );

            pTableID.setItems(data);
        }

    }


    //Bills
    public void GetBills() {

        try {
            Billd = Bill_Get.get();
            System.out.println(Billd.size());
            for (int i = 0; i < Billd.size(); i++)
                System.out.println(Billd.get(0).getProductData().get(0).getQuantity());

        } catch (Exception e) {
            e.printStackTrace();
        }
        Billdata = FXCollections.observableArrayList();
        Billdetaildata = FXCollections.observableArrayList();
        for (int i = 0; i < Billd.size(); i++) {
            for (int j = 0; j < Billd.get(i).getProductData().size(); j++) {
                Billdetaildata.add(new BillDetail_Table(Billd.get(i).getProductData().get(j).getName(), Billd.get(i).getProductData().get(j).getQuantity(), Billd.get(i).getProductData().get(j).getSellPrice()));
            }
            Billdata.add(new Bill_Table(Billd.get(i).getBillid(), Billd.get(i).getTotalitems(), Billd.get(i).getTotalprice(), Billd.get(i).getDate(), Billdetaildata));
        }
        BillTableID.setCellValueFactory(
                new PropertyValueFactory<Bill_Table, String>("tBillId")
        );
        BillTableTotalItems.setCellValueFactory(
                new PropertyValueFactory<Bill_Table, String>("tTotalItems")
        );
        BillTableTotalPrice.setCellValueFactory(
                new PropertyValueFactory<Bill_Table, String>("tTotalPrice")
        );
        BillTableDate.setCellValueFactory(
                new PropertyValueFactory<Bill_Table, String>("tDate")
        );

        BillTable.setItems(Billdata);
    }
    public void GetBillsDetail(MouseEvent mouseEvent) {
        int index = BillTable.getSelectionModel().getSelectedIndex();
        System.out.println("index" + index);
        System.out.println("size" + Billd.get(index).getProductData().size());
        BillDetaildata = FXCollections.observableArrayList();
        for (int j = 0; j < Billd.get(index).getProductData().size(); j++) {
            BillDetaildata.add(new BillDetail_Table(Billd.get(index).getProductData().get(j).getName(), Billd.get(index).getProductData().get(j).getQuantity(), Billd.get(index).getProductData().get(j).getSellPrice()));
        }
        BillTableName.setCellValueFactory(
                new PropertyValueFactory<BillDetail_Table, String>("tName")
        );
        BillTableQuantity.setCellValueFactory(
                new PropertyValueFactory<BillDetail_Table, String>("tQuantity")
        );
        BillTablePrice.setCellValueFactory(
                new PropertyValueFactory<BillDetail_Table, String>("tPrice")
        );
        BillTableDetait.setItems(BillDetaildata);
    }
    public void SearchBillList(KeyEvent keyEvent) {

        SortedList<Bill_Table> sortedBillId, sortedBillItems, sortedBillPrice, sortedBillDate;
        if (keyEvent.getSource() == billtextid) {

            FilteredList<Bill_Table> filteredBillId = new FilteredList<>(Billdata, n -> true);
            billtextid.setOnKeyReleased(n -> {
                billtextid.textProperty().addListener(((observable, oldValue, newValue) -> {
                    filteredBillId.setPredicate((Predicate<? super Bill_Table>) Billdata -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lowerCaseFilter = newValue.toLowerCase();
                        if (Billdata.gettBillId().toLowerCase().contains(lowerCaseFilter)) {
                            return true;
                        }
                        return false;
                    });
                }));
            });
            sortedBillId = new SortedList<>(filteredBillId);
            sortedBillId.comparatorProperty().bind(BillTable.comparatorProperty());
            BillTable.setItems(sortedBillId);
            Billdata = sortedBillId;

        } else if (keyEvent.getSource() == billtextitems) {

            FilteredList<Bill_Table> filteredBillItems = new FilteredList<>(Billdata, q -> true);
            billtextitems.setOnKeyReleased(q -> {
                billtextitems.textProperty().addListener(((observable, oldValue, newValue) -> {
                    filteredBillItems.setPredicate((Predicate<? super Bill_Table>) Billdata -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lowerCaseFilter = newValue.toLowerCase();
                        if (Billdata.gettTotalItems().toLowerCase().contains(lowerCaseFilter)) {
                            return true;
                        }
                        return false;
                    });
                }));
            });
            sortedBillItems = new SortedList<>(filteredBillItems);
            sortedBillItems.comparatorProperty().bind(BillTable.comparatorProperty());
            BillTable.setItems(sortedBillItems);
            Billdata = sortedBillItems;
        } else if (keyEvent.getSource() == billtextprice) {
            FilteredList<Bill_Table> filteredBillprice = new FilteredList<>(Billdata, b -> true);
            billtextprice.setOnKeyReleased(b -> {
                billtextprice.textProperty().addListener(((observable, oldValue, newValue) -> {
                    filteredBillprice.setPredicate((Predicate<? super Bill_Table>) Billdata -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lowerCaseFilter = newValue.toLowerCase();
                        if (Billdata.gettTotalPrice().toLowerCase().contains(lowerCaseFilter)) {
                            return true;
                        }
                        return false;
                    });
                }));
            });
            sortedBillPrice = new SortedList<>(filteredBillprice);
            sortedBillPrice.comparatorProperty().bind(BillTable.comparatorProperty());
            BillTable.setItems(sortedBillPrice);
            Billdata = sortedBillPrice;

        }


    }
    public void BillButtons(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == billSearch) {
            vboxBillSearch.setVisible(true);
        }
        if (mouseEvent.getSource() == billrefresh) {
            GetBills();
        }
        if (mouseEvent.getSource() == billtick) {

            vboxBillSearch.setVisible(false);
        }
        if (mouseEvent.getSource() == billcross) {
            billtextid.setText("");
            billtextitems.setText("");
            billtextprice.setText("");
            vboxBillSearch.setVisible(false);
        }
    }

    //Employees
    public void GetEmployee() {

        try {
            List<Employee_Data> d = new ArrayList<>();
            d = Employee_Get.get();
            System.out.println(d.size());
            for (int i = 0; i < d.size(); i++) {
                if (tepm_user.equals(d.get(i).getUsername()) && temp_password.equals(d.get(i).getPassword())) {
                    employeeUsername.setText(d.get(i).getUsername());
                    employeePassword.setText(d.get(i).getPassword());
                    employeeImageUrl.setText(d.get(i).getImage());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void SetImages() {

        String imguser = tepm_user.replace(" ", "%20");
        String extension = "";

        int i = temp_Image.lastIndexOf('.');
        if (i > 0) {
            extension = temp_Image.substring(i + 1);
        }
        System.out.println(extension);
        String img = "file:///C:/Users/qasim/Desktop/Semester-3-Main-Project/Golang/Image_server/Images/" + imguser + "." + extension;
        hBoxImageDiv.setStyle("-fx-background-image: url('" + img + "'); -fx-background-position: center center;");
        vboxEmployeeDiv.setStyle("-fx-background-color: #3C3F41e0;");

        WebEngine image = Employee_Image_Web.getEngine();
        image.loadContent("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"../css/main.css\">\n" +
                "    <style>body{\n" +
                "        background-color:#5F5F5F;\n" +
                "    }\n" +
                "    div{\n" +
                "        background-image: url(" + img + ");\n" +
                "        background-size: 170px 170px;\n" +
                "        width:170px;\n" +
                "        height:170px;\n" +
                "        border: 5px solid #FFCD00;\n" +
                "        border-radius:100px;\n" +
                "        box-shadow: 0 0 10px 2px #000;\n" +
                "    }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div>\n" +
                "    \n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
        WebEngine canvas = CanvasWeb.getEngine();
        canvas.load("");

    }
    public void Explorer(MouseEvent event) {
        if (event.getSource() == AddImage || event.getSource() == productIcon) {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter =
                    new FileChooser.ExtensionFilter("Images ", "*.png","*.jpg","*.gif","*.bmp");
            fileChooser.getExtensionFilters().add(extFilter);
            File SelectedFile = fileChooser.showOpenDialog(null);
            if (SelectedFile != null) {
//            listview.getItems().add(SelectedFile.getName());
                System.out.println(SelectedFile.getName());
                System.out.println(SelectedFile.getAbsolutePath());
                String my_new_str = SelectedFile.getAbsolutePath().replace("\\", "/");
                System.out.println(my_new_str);
                employeeImageUrl.setText(my_new_str);
            } else {
                System.out.println("file is not correct");
            }
        }
    }
    public void EmployeeButtons(MouseEvent event) {
        if (event.getSource() == EmployeeEdit) {

            employeeUsername.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));
            employeePassword.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));
            employeeconfirm.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));
            employeeImageUrl.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));


            boolean lockUpdate1 = false, lockUpdate2 = false, lockUpdate3 = false, lockUpdate4 = false;

            if (employeeUsername.getText().equalsIgnoreCase("")||!validate.getUserValidBool(employeeUsername.getText())) {
                employeeUsername.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(0, 0, 2, 0))));
                lockUpdate1 = true;
            } else {
                employeeUsername.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));
//                String css2 = this.getClass().getResource("input.css").toExternalForm();
//                productUpdateNewName.getStylesheets().add(css2);
//                productUpdateNewName.getStyleClass().add("input");
            }
            if (employeePassword.getText().equalsIgnoreCase("") || !validate.getPasswordValid(employeePassword.getText(), 8, 1, 1)) {
                employeePassword.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(0, 0, 2, 0))));
                lockUpdate2 = true;
            } else {
                employeePassword.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));
            }
            if (employeeconfirm.getText().equalsIgnoreCase("") || !employeeconfirm.getText().equals(employeePassword.getText())) {
                employeeconfirm.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(0, 0, 2, 0))));

                lockUpdate3 = true;
            } else {
                employeeconfirm.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));
            }
            if (employeeImageUrl.getText().equalsIgnoreCase("")) {
                employeeImageUrl.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(0, 0, 2, 0))));
                lockUpdate4 = true;
            } else {
                employeeImageUrl.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));
            }

            if ((lockUpdate1 == false) && (lockUpdate2 == false) && (lockUpdate3 == false) && (lockUpdate4 == false)) {

                try {
                    System.out.println("post employee");
                    Employee_Data d = new Employee_Data();
                    Employee_Data up = new Employee_Data();

                    //old data
                    d.setUsername(tepm_user);
                    d.setPassword(temp_password);
                    d.setImage(temp_Image);

                    //new data
                    up.setUsername(employeeUsername.getText());
                    up.setPassword(employeePassword.getText());
                    up.setImage(employeeImageUrl.getText());


                    Employee_Put.put(d, up);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                tepm_user = employeeUsername.getText();
                temp_password = employeePassword.getText();
                temp_Image = employeeImageUrl.getText();

            } else if ((employeeImageUrl.getText().equals(temp_Image)) && (employeePassword.getText().equals(temp_password)) && (employeeUsername.getText().equals(tepm_user))) {
                System.out.println("Employee Exist");
            }
        }
        if (event.getSource() == EmployeeNew) {

            employeeUsername.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));
            employeePassword.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));
            employeeconfirm.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));
            employeeImageUrl.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));


            boolean lockUpdate1 = false, lockUpdate2 = false, lockUpdate3 = false, lockUpdate4 = false;

            if (employeeUsername.getText().equalsIgnoreCase("")||!validate.getUserValidBool(employeeUsername.getText())) {
                employeeUsername.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(0, 0, 2, 0))));
                lockUpdate1 = true;
            } else {
                employeeUsername.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));
//                String css2 = this.getClass().getResource("input.css").toExternalForm();
//                productUpdateNewName.getStylesheets().add(css2);
//                productUpdateNewName.getStyleClass().add("input");
            }
            if (employeePassword.getText().equalsIgnoreCase("") || !validate.getPasswordValid(employeePassword.getText(), 8, 1, 1)) {
                employeePassword.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(0, 0, 2, 0))));
                lockUpdate2 = true;
            } else {
                employeePassword.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));
            }
            if (employeeconfirm.getText().equalsIgnoreCase("") || !employeeconfirm.getText().equals(employeePassword.getText())) {
                employeeconfirm.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(0, 0, 2, 0))));

                lockUpdate3 = true;
            } else {
                employeeconfirm.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));
            }
            if (employeeImageUrl.getText().equalsIgnoreCase("")) {
                employeeImageUrl.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(0, 0, 2, 0))));
                lockUpdate4 = true;
            } else {
                employeeImageUrl.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));
            }

            if ((lockUpdate1 == false) && (lockUpdate2 == false) && (lockUpdate3 == false) && (lockUpdate4 == false)) {

                try {
                    Employee_Data d = new Employee_Data();
                    d.setUsername(employeeUsername.getText());
                    d.setPassword(employeePassword.getText());
                    d.setImage(employeeImageUrl.getText());
                    Employee_Post.post(d);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if ((employeeImageUrl.getText().equals(temp_Image)) && (employeePassword.getText().equals(temp_password)) && (employeeUsername.getText().equals(tepm_user))) {
                System.out.println("Employee Exist");
            }
        }
    }
    public void HideImageEdit(MouseEvent event) {
        AddImage.setVisible(false);
    }
    public void ShowImageEdit(MouseEvent event) {
        AddImage.setVisible(true);
    }




    public void initialize(URL Location,ResourceBundle resourceBundle){




//        TableColumn namecol = new TableColumn("Name");
//        TableColumn quantitycol = new TableColumn("Quantity");
//        TableColumn buypricecol = new TableColumn("BuyPrice");
//        TableColumn salepricecol = new TableColumn("SalePrice");

//        pTableID.getColumns().addAll(namecol, quantitycol,buypricecol, salepricecol);
//        pTableID.getColumns().addAll(pTableName,pTableQuantity,pTableQuantity,pTableSalePrice);

    }

    private void initialize() {

    }



}
