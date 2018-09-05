/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import actions.BookAction;
import actions.RadioAction;
import actions.CheckAction;
import actions.CompanyAction;
import actions.TimeAction;
import actions.DatePickerAction;
import actions.LocationAction;
import java.io.File;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author wint4
 */
public class MainFrame extends BorderPane {

    private Pane head = new Pane();
    private HBox body = new HBox(100);
    private VBox left_body = new VBox();
    private VBox right_body = new VBox();

    private GridPane location_pane = new GridPane();
    private ComboBox<String> aLocation_combo = new ComboBox<>();
    private ComboBox<String> bLocation_combo = new ComboBox<>();

    private GridPane date_pane = new GridPane();
    private DatePicker datePicker = new DatePicker();
    private ComboBox<String> departure_time = new ComboBox<>();

    private GridPane company_pane = new GridPane();
    private ComboBox<String> company_combo = new ComboBox<>();

    private VBox bus_type = new VBox();
    private RadioButton minibus_rb = new RadioButton("Minibus");
    private RadioButton standard_rb = new RadioButton("Standard");
    private RadioButton double_rb = new RadioButton("Double-decker");
    private ToggleGroup type_group = new ToggleGroup();

    private VBox discount = new VBox();
    private RadioButton student_rb = new RadioButton("Student");
    private RadioButton retiree_rb = new RadioButton("Retiree");
    private RadioButton no_discount_rb = new RadioButton("No discount");
    private ToggleGroup discount_group = new ToggleGroup();

    private VBox luggage_vb = new VBox();
    private HBox luggage_hb = new HBox();
    private RadioButton luggage_1 = new RadioButton("1");
    private RadioButton luggage_2 = new RadioButton("2");
    private RadioButton luggage_3 = new RadioButton("3");
    private RadioButton luggage_4 = new RadioButton("4");
    private ToggleGroup luggage_group = new ToggleGroup();

    private GridPane check = new GridPane();
    private Label status = new Label("Status:");
    private TextField statusField = new TextField("~~~ seats available");
    private Label price = new Label("Price:");
    private TextField priceField = new TextField("~~~ RSD");

    private GridPane buttons = new GridPane();
    private Button check_btn = new Button("Check");
    private Button book_btn = new Button("Book");

    private File file_cover = new File("src/cover.jpg");
    private Image image = new Image(file_cover.toURI().toString());
    private ImageView imageView = new ImageView(image);

    public MainFrame() {

        setTop(head);
        setStyle("-fx-background-color: #DAF2FC;");
        body.getChildren().add(left_body);
        body.getChildren().add(right_body);
        body.setAlignment(Pos.CENTER);
        setCenter(body);
        left_body.setPadding(new Insets(10, 5, 5, 5));
        left_body.setSpacing(30);
        left_body.setAlignment(Pos.CENTER);
        right_body.setPadding(new Insets(5, 5, 5, 5));
        right_body.setSpacing(30);
        right_body.setAlignment(Pos.CENTER);

        setPadding(new Insets(5, 5, 5, 5));

        left_body.getChildren().add(location_pane);
        location_pane.setHgap(60);
        location_pane.setVgap(5);
        location_pane.add(new Label("Location A:"), 0, 0);
        location_pane.add(aLocation_combo, 0, 1);
        aLocation_combo.setOnAction(new LocationAction());
        bLocation_combo.setOnAction(new RadioAction());
        aLocation_combo.setMinSize(120, 20);
        location_pane.add(new Label("Location B:"), 1, 0);
        location_pane.add(bLocation_combo, 1, 1);
        bLocation_combo.setMinSize(120, 20);

        left_body.getChildren().add(date_pane);
        date_pane.setHgap(60);
        date_pane.setVgap(5);
        date_pane.add(new Label("Date:"), 0, 0);
        date_pane.add(datePicker, 0, 1);
        datePicker.setOnAction(new DatePickerAction());
        date_pane.add(new Label("Departure time:"), 1, 0);
        date_pane.add(departure_time, 1, 1);
        departure_time.setOnAction(new TimeAction());
        datePicker.setMaxSize(120, 20);
        departure_time.setMinSize(120, 20);

        left_body.getChildren().add(company_pane);
        company_pane.setHgap(5);
        company_pane.setVgap(5);
        company_pane.add(new Label("Company:"), 0, 0);
        company_pane.add(company_combo, 0, 1);
        company_combo.setOnAction(new CompanyAction());
        company_combo.setMinSize(300, 20);

        left_body.getChildren().add(bus_type);
        bus_type.setPadding(new Insets(5, 5, 5, 5));
        bus_type.setStyle("-fx-background-color: #DAF2FC;");
        bus_type.setSpacing(5);
        bus_type.getChildren().add(new Label("Bus type:"));
        bus_type.getChildren().addAll(minibus_rb, standard_rb, double_rb);
        minibus_rb.setUserData("Minibus");
        minibus_rb.setDisable(true);
        standard_rb.setDisable(true);
        double_rb.setDisable(true);
        standard_rb.setUserData("Standard");
        double_rb.setUserData("Double-decker");
        minibus_rb.setToggleGroup(type_group);
        standard_rb.setToggleGroup(type_group);
        double_rb.setToggleGroup(type_group);
        minibus_rb.setOnAction(new RadioAction());
        standard_rb.setOnAction(new RadioAction());
        double_rb.setOnAction(new RadioAction());

        right_body.getChildren().add(discount);
        discount.setStyle("-fx-background-color: #DAF2FC;");
        discount.setSpacing(5);
        discount.setPadding(new Insets(5, 5, 5, 5));
        discount.getChildren().add(new Label("Discount:"));
        discount.getChildren().addAll(student_rb, retiree_rb, no_discount_rb);
        student_rb.setUserData("Student");
        retiree_rb.setUserData("Retiree");
        no_discount_rb.setUserData("Without");
        student_rb.setToggleGroup(discount_group);
        retiree_rb.setToggleGroup(discount_group);
        no_discount_rb.setToggleGroup(discount_group);
        student_rb.setOnAction(new RadioAction());
        retiree_rb.setOnAction(new RadioAction());
        no_discount_rb.setOnAction(new RadioAction());

        right_body.getChildren().add(luggage_vb);
        luggage_vb.setStyle("-fx-background-color: #DAF2FC;");
        luggage_hb.setPadding(new Insets(5, 5, 5, 5));
        luggage_vb.setPadding(new Insets(5, 5, 5, 5));
        luggage_vb.setSpacing(5);
        luggage_vb.getChildren().add(new Label("Luggage:"));
        luggage_vb.getChildren().add(luggage_hb);
        luggage_hb.setSpacing(10);
        luggage_hb.getChildren().addAll(luggage_1, luggage_2, luggage_3, luggage_4);
        luggage_1.setUserData("1");
        luggage_2.setUserData("2");
        luggage_3.setUserData("3");
        luggage_4.setUserData("4");
        luggage_1.setToggleGroup(luggage_group);
        luggage_2.setToggleGroup(luggage_group);
        luggage_3.setToggleGroup(luggage_group);
        luggage_4.setToggleGroup(luggage_group);
        luggage_1.setOnAction(new RadioAction());
        luggage_2.setOnAction(new RadioAction());
        luggage_3.setOnAction(new RadioAction());
        luggage_4.setOnAction(new RadioAction());

        right_body.getChildren().add(check);
        check.setHgap(20);
        check.setVgap(5);
        check.add(status, 0, 0);
        check.add(statusField, 1, 0);
        statusField.setMaxSize(120, 20);
        priceField.setMaxSize(120, 20);
        priceField.setEditable(false);
        priceField.setAlignment(Pos.CENTER_RIGHT);
        statusField.setEditable(false);
        statusField.setAlignment(Pos.CENTER_RIGHT);
        check.add(price, 0, 1);
        check.add(priceField, 1, 1);

        right_body.getChildren().add(buttons);
        buttons.setHgap(20);
        buttons.setVgap(5);
        check_btn.setMinSize(60, 25);
        check_btn.setOnAction(new CheckAction());
        book_btn.setMinSize(60, 25);
        book_btn.setDisable(true);
        book_btn.setOnAction(new BookAction());
        buttons.add(check_btn, 1, 1);
        buttons.add(book_btn, 2, 1);

    }

    public Pane getHead() {
        return head;
    }

    public void setHead(Pane head) {
        this.head = head;
    }

    public HBox getBody() {
        return body;
    }

    public void setBody(HBox body) {
        this.body = body;
    }

    public VBox getLeft_body() {
        return left_body;
    }

    public void setLeft_body(VBox left_body) {
        this.left_body = left_body;
    }

    public VBox getRight_body() {
        return right_body;
    }

    public void setRight_body(VBox right_body) {
        this.right_body = right_body;
    }

    public GridPane getLocation_pane() {
        return location_pane;
    }

    public void setLocation_pane(GridPane location_pane) {
        this.location_pane = location_pane;
    }

    public ComboBox<String> getaLocation_combo() {
        return aLocation_combo;
    }

    public void setaLocation_combo(ComboBox<String> aLocation_combo) {
        this.aLocation_combo = aLocation_combo;
    }

    public ComboBox<String> getbLocation_combo() {
        return bLocation_combo;
    }

    public void setbLocation_combo(ComboBox<String> bLocation_combo) {
        this.bLocation_combo = bLocation_combo;
    }

    public GridPane getDate_pane() {
        return date_pane;
    }

    public void setDate_pane(GridPane date_pane) {
        this.date_pane = date_pane;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public void setDatePicker(DatePicker datePicker) {
        this.datePicker = datePicker;
    }

    public ComboBox<String> getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(ComboBox<String> departure_time) {
        this.departure_time = departure_time;
    }

    public GridPane getCompany_pane() {
        return company_pane;
    }

    public void setCompany_pane(GridPane company_pane) {
        this.company_pane = company_pane;
    }

    public ComboBox<String> getCompany_combo() {
        return company_combo;
    }

    public void setCompany_combo(ComboBox<String> company_combo) {
        this.company_combo = company_combo;
    }

    public VBox getBus_type() {
        return bus_type;
    }

    public void setBus_type(VBox bus_type) {
        this.bus_type = bus_type;
    }

    public RadioButton getMinibus_rb() {
        return minibus_rb;
    }

    public void setMinibus_rb(RadioButton minibus_rb) {
        this.minibus_rb = minibus_rb;
    }

    public RadioButton getStandard_rb() {
        return standard_rb;
    }

    public void setStandard_rb(RadioButton standard_rb) {
        this.standard_rb = standard_rb;
    }

    public RadioButton getDouble_rb() {
        return double_rb;
    }

    public void setDouble_rb(RadioButton double_rb) {
        this.double_rb = double_rb;
    }

    public ToggleGroup getType_group() {
        return type_group;
    }

    public void setType_group(ToggleGroup type_group) {
        this.type_group = type_group;
    }

    public VBox getDiscount() {
        return discount;
    }

    public void setDiscount(VBox discount) {
        this.discount = discount;
    }

    public RadioButton getStudent_rb() {
        return student_rb;
    }

    public void setStudent_rb(RadioButton student_rb) {
        this.student_rb = student_rb;
    }

    public RadioButton getRetiree_rb() {
        return retiree_rb;
    }

    public void setRetiree_rb(RadioButton retiree_rb) {
        this.retiree_rb = retiree_rb;
    }

    public RadioButton getNo_discount_rb() {
        return no_discount_rb;
    }

    public void setNo_discount_rb(RadioButton no_discount_rb) {
        this.no_discount_rb = no_discount_rb;
    }

    public ToggleGroup getDiscount_group() {
        return discount_group;
    }

    public void setDiscount_group(ToggleGroup discount_group) {
        this.discount_group = discount_group;
    }

    public VBox getLuggage_vb() {
        return luggage_vb;
    }

    public void setLuggage_vb(VBox luggage_vb) {
        this.luggage_vb = luggage_vb;
    }

    public HBox getLuggage_hb() {
        return luggage_hb;
    }

    public void setLuggage_hb(HBox luggage_hb) {
        this.luggage_hb = luggage_hb;
    }

    public RadioButton getLuggage_1() {
        return luggage_1;
    }

    public void setLuggage_1(RadioButton luggage_1) {
        this.luggage_1 = luggage_1;
    }

    public RadioButton getLuggage_2() {
        return luggage_2;
    }

    public void setLuggage_2(RadioButton luggage_2) {
        this.luggage_2 = luggage_2;
    }

    public RadioButton getLuggage_3() {
        return luggage_3;
    }

    public void setLuggage_3(RadioButton luggage_3) {
        this.luggage_3 = luggage_3;
    }

    public RadioButton getLuggage_4() {
        return luggage_4;
    }

    public void setLuggage_4(RadioButton luggage_4) {
        this.luggage_4 = luggage_4;
    }

    public ToggleGroup getLuggage_group() {
        return luggage_group;
    }

    public void setLuggage_group(ToggleGroup luggage_group) {
        this.luggage_group = luggage_group;
    }

    public GridPane getCheck() {
        return check;
    }

    public void setCheck(GridPane check) {
        this.check = check;
    }

    public Label getStatus() {
        return status;
    }

    public void setStatus(Label status) {
        this.status = status;
    }

    public Label getPrice() {
        return price;
    }

    public void setPrice(Label price) {
        this.price = price;
    }

    public GridPane getButtons() {
        return buttons;
    }

    public void setButtons(GridPane buttons) {
        this.buttons = buttons;
    }

    public Button getCheck_btn() {
        return check_btn;
    }

    public void setCheck_btn(Button check_btn) {
        this.check_btn = check_btn;
    }

    public Button getBook_btn() {
        return book_btn;
    }

    public void setBook_btn(Button book_btn) {
        this.book_btn = book_btn;
    }

    public File getFile_cover() {
        return file_cover;
    }

    public void setFile_cover(File file_cover) {
        this.file_cover = file_cover;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public TextField getStatusField() {
        return statusField;
    }

    public void setStatusField(TextField statusField) {
        this.statusField = statusField;
    }

    public TextField getPriceField() {
        return priceField;
    }

    public void setPriceField(TextField priceField) {
        this.priceField = priceField;
    }

}
