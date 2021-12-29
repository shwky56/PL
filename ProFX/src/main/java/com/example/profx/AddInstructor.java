package com.example.profx;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddInstructor implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button backB;
    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("adminHome.fxml"));
        root = loader.load();
        AdminHome studentCont= loader.getController();
        //Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
 @FXML
 private ResourceBundle resources;
 @FXML
 private URL location;
    @FXML
    private MenuBar fileMenu;

    @FXML
    private TableView<InstructorInfo> studentTable;

    @FXML
    private TableColumn<InstructorInfo, String> NameCol;

    @FXML
    private TableColumn<InstructorInfo, String> departmentCol;

    @FXML
    private TableColumn<InstructorInfo, String> emailCol;

    @FXML
    private TableColumn<InstructorInfo, String> phoneCol;

    @FXML
    private TableColumn<InstructorInfo, String> addressCol;

    @FXML
    private TableColumn<InstructorInfo, String> genderCol;

    @FXML
    private TextField NameField;

    @FXML
    private TextField departmentField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneField;

    @FXML
    private ComboBox<String> genderBox;
    ObservableList<String>genderBoxData = FXCollections.observableArrayList();

    ObservableList<InstructorInfo>observableInstructorList=FXCollections.observableArrayList();

    @FXML
    private Button addBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private TextField filterInput;

    @FXML
    void handleAddButtonClick(ActionEvent event) {
        if(observableInstructorList.size() < 1000){
            if(isValidInput(event)){
                if(genderBox.getValue().equals("Male")){
                    InstructorInfo student = new InstructorInfo();
                    student.setInstName(NameField.getText());
                    student.setInstDept(departmentField.getText());
                    student.setInstMail(emailField.getText());
                    student.setInstPhone(phoneField.getText());
                    student.setAddress(addressField.getText());
                    student.setGender(genderBox.getValue());
                    observableInstructorList.add(student);
                    System.out.println(student.toString());
                    NameField.clear();
                    departmentField.clear();
                    emailField.clear();
                    phoneField.clear();
                    addressField.clear();
                    genderBox.setValue("Gender");
                }
                if(genderBox.getValue().equals("Female")){
                    InstructorInfo student = new InstructorInfo();
                    student.setInstName(NameField.getText());
                    student.setInstDept(departmentField.getText());
                    student.setInstMail(emailField.getText());
                    student.setInstPhone(phoneField.getText());
                    student.setAddress(addressField.getText());
                    student.setGender(genderBox.getValue());
                    observableInstructorList.add(student);
                    System.out.println(student.toString());
                    NameField.clear();
                    departmentField.clear();
                    emailField.clear();
                    phoneField.clear();
                    addressField.clear();
                    genderBox.setValue("Gender");
                }
            }
        }else {
            Alert sizeAlert = new Alert(Alert.AlertType.WARNING,"Warning",ButtonType.OK);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            sizeAlert.setContentText("You may only hold 1000 Students at this time");
            sizeAlert.initModality(Modality.APPLICATION_MODAL);
            sizeAlert.initOwner(owner);
            sizeAlert.showAndWait();
            if(sizeAlert.getResult()==ButtonType.OK){
                sizeAlert.close();
                NameField.clear();
                departmentField.clear();
                emailField.clear();
                phoneField.clear();
                addressField.clear();
                genderBox.setValue("Gender");
            }
        }


    }
    /*In Case of empty fields, gives alert for respective empty field and requests focus on that field
     */
    private boolean isValidInput(ActionEvent event){
        Boolean validInput = true;
        if(NameField == null || NameField.getText().trim().isEmpty()){
            validInput = false;
            Alert emptyFirstName = new Alert(Alert.AlertType.WARNING,"Warning",ButtonType.OK);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            emptyFirstName.setContentText("First Name is Empty");
            emptyFirstName.initModality(Modality.APPLICATION_MODAL);
            emptyFirstName.initOwner(owner);
            emptyFirstName.showAndWait();
            if(emptyFirstName.getResult() == ButtonType.OK){
                emptyFirstName.close();
                NameField.requestFocus();
            }
        }
        if(departmentField == null || departmentField.getText().trim().isEmpty()){
            validInput = false;
            Alert emptyLastName = new Alert(Alert.AlertType.WARNING,"Warning",ButtonType.OK);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            emptyLastName.setContentText("Last Name is Empty");
            emptyLastName.initModality(Modality.APPLICATION_MODAL);
            emptyLastName.initOwner(owner);
            emptyLastName.showAndWait();
            if(emptyLastName.getResult() == ButtonType.OK){
                emptyLastName.close();
                departmentField.requestFocus();
            }
        }
        if(phoneField == null || phoneField.getText().trim().isEmpty()){
            validInput = false;
            Alert emptyCourse = new Alert(Alert.AlertType.WARNING,"Warning",ButtonType.OK);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            emptyCourse.setContentText("Course is Empty");
            emptyCourse.initModality(Modality.APPLICATION_MODAL);
            emptyCourse.initOwner(owner);
            emptyCourse.showAndWait();
            if(emptyCourse.getResult() == ButtonType.OK){
                emptyCourse.close();
                phoneField.requestFocus();
            }
        }
        if(addressField == null || addressField.getText().trim().isEmpty()){
            validInput = false;
            Alert emptyAge = new Alert(Alert.AlertType.WARNING,"Warning",ButtonType.OK);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            emptyAge.setContentText("Age is Empty");
            emptyAge.initModality(Modality.APPLICATION_MODAL);
            emptyAge.initOwner(owner);
            emptyAge.showAndWait();
            if(emptyAge.getResult() == ButtonType.OK){
                emptyAge.close();
                addressField.requestFocus();
            }
        }
        if(emailField == null || emailField.getText().trim().isEmpty()){
            validInput = false;
            Alert emptyGPA = new Alert(Alert.AlertType.WARNING,"Warning",ButtonType.OK);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            emptyGPA.setContentText("GPA is Empty");
            emptyGPA.initModality(Modality.APPLICATION_MODAL);
            emptyGPA.initOwner(owner);
            emptyGPA.showAndWait();
            if(emptyGPA.getResult() == ButtonType.OK){
                emptyGPA.close();
                emailField.requestFocus();
            }
        }
        if(genderBox == null || genderBox.getValue().isEmpty()){
            validInput = false;
            Alert emptyGender = new Alert(Alert.AlertType.WARNING,"Warning",ButtonType.OK);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            emptyGender.setContentText("Gender is Empty");
            emptyGender.initModality(Modality.APPLICATION_MODAL);
            emptyGender.initOwner(owner);
            emptyGender.showAndWait();
            if(emptyGender.getResult() == ButtonType.OK){
                emptyGender.close();
                genderBox.requestFocus();
            }
        }
        return validInput;
    }

    @FXML
    void handleDeleteButtonClick(ActionEvent event) {
        if(!observableInstructorList.isEmpty()){
            System.out.println("Delete button clicked");
            Alert deleteAlert = new Alert(Alert.AlertType.WARNING,"Confirm",ButtonType.OK,ButtonType.CANCEL);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            deleteAlert.setContentText("Are you sure you want to delete this?\n\nTHIS CANNOT BE UNDONE.");
            deleteAlert.initModality(Modality.APPLICATION_MODAL);
            deleteAlert.initOwner(owner);
            deleteAlert.showAndWait();
            if(deleteAlert.getResult()==ButtonType.OK){
                observableInstructorList.removeAll(studentTable.getSelectionModel().getSelectedItems());
                studentTable.getSelectionModel().clearSelection();
            }
            else{
                deleteAlert.close();
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        filterInput.textProperty().addListener(new ChangeListener(){
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                filterStudentList((String)oldValue,(String)newValue);
            }
        });


        //initialize editable attributes
        studentTable.setEditable(true);
        NameCol.setOnEditCommit(e -> NameCol_OnEditCommit(e));
        departmentCol.setOnEditCommit(e -> departmentCol_OnEditCommit(e));
        emailCol.setOnEditCommit(e -> emailCol_OnEditCommit(e));
        phoneCol.setOnEditCommit(e -> phoneCol_OnEditCommit(e));
        addressCol.setOnEditCommit(e -> addressCol_OnEditCommit(e));
        genderCol.setOnEditCommit(e -> genderCol_OnEditCommit(e));
        studentTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        NameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        departmentCol.setCellFactory(TextFieldTableCell.forTableColumn());
        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneCol.setCellFactory(TextFieldTableCell.forTableColumn());
        addressCol.setCellFactory(TextFieldTableCell.forTableColumn());
        genderCol.setCellFactory(TextFieldTableCell.forTableColumn());

        NameCol.setCellValueFactory(cellData -> cellData.getValue().instNameProperty());
        departmentCol.setCellValueFactory(cellData -> cellData.getValue().instDeptProperty());
        emailCol.setCellValueFactory(cellData -> cellData.getValue().instMailProperty());
        phoneCol.setCellValueFactory(cellData -> cellData.getValue().instPhoneProperty());
        addressCol.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
        genderCol.setCellValueFactory(cellData -> cellData.getValue().genderProperty());

        //initialize gender ComboBox
        genderBoxData.add(new String("Male"));
        genderBoxData.add(new String("Female"));

        genderBox.setItems(genderBoxData);

        addBtn.setDisable(true);
        deleteBtn.setDisable(true);
        studentTable.setItems(observableInstructorList);
        studentTable.setEditable(true);
        studentTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        studentTable.setPlaceholder(new Label("Your Table is Empty"));
        NameField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue){
                if(NameField.isFocused()){
                    addBtn.setDisable(false);
                }
            }
        });
        studentTable.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable,Boolean oldValue,Boolean newValue){
                if(studentTable.isFocused()){
                    deleteBtn.setDisable(false);
                }
            }
        });
    }
//end initialize

    //Control Handlers:
    public void handleSave(ActionEvent event){
        Stage secondaryStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Student Table");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        if(observableInstructorList.isEmpty()){
            secondaryStage.initOwner(this.fileMenu.getScene().getWindow());
            Alert emptyTableAlert = new Alert(Alert.AlertType.ERROR,"Empty Table",ButtonType.OK);
            emptyTableAlert.setContentText("You have nothing to save");
            emptyTableAlert.initModality(Modality.APPLICATION_MODAL);
            emptyTableAlert.initOwner(this.fileMenu.getScene().getWindow());
            emptyTableAlert.showAndWait();
            if(emptyTableAlert.getResult() == ButtonType.OK){
                emptyTableAlert.close();
            }
        }
        else{
            File file = fileChooser.showSaveDialog(secondaryStage);
            if(file != null){
                saveFile(studentTable.getItems(),file);
            }
        }
    }
    private void saveFile(ObservableList<InstructorInfo> observableStudentList, File file){
        try {
            BufferedWriter outWriter = new BufferedWriter(new FileWriter(file));
            for(InstructorInfo students : observableStudentList){
                outWriter.write(students.toString());
                outWriter.newLine();
            }
            System.out.println(observableStudentList.toString());
            outWriter.close();
        }catch (IOException e) {
            Alert ioAlert = new Alert(Alert.AlertType.ERROR,"oops!",ButtonType.OK);
            ioAlert.showAndWait();
            if(ioAlert.getResult() == ButtonType.OK){
                ioAlert.close();
            }
        }
    }
    public void closeApp(ActionEvent e){
        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION,"confirm",ButtonType.OK,ButtonType.CANCEL);
        Stage stage = (Stage) fileMenu.getScene().getWindow();
        exitAlert.setContentText("Are you sure you want to exit?");
        exitAlert.initModality(Modality.APPLICATION_MODAL);
        exitAlert.initOwner(stage);
        exitAlert.showAndWait();
        if(exitAlert.getResult() == ButtonType.OK){
            Platform.exit();
        }
        else {
            exitAlert.close();
        }
    }
    @FXML
    private void NameCol_OnEditCommit(Event e){
        TableColumn.CellEditEvent<InstructorInfo,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<InstructorInfo,String>) e;
        InstructorInfo student = cellEditEvent.getRowValue();
        student.setInstName(cellEditEvent.getNewValue());
    }
    @FXML
    private  void departmentCol_OnEditCommit(Event e){
        TableColumn.CellEditEvent<InstructorInfo,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<InstructorInfo,String>) e;
        InstructorInfo student = cellEditEvent.getRowValue();
        student.setInstDept(cellEditEvent.getNewValue());
    }
    @FXML
    private void emailCol_OnEditCommit(Event e){
        TableColumn.CellEditEvent<InstructorInfo,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<InstructorInfo,String>) e;
        InstructorInfo student = cellEditEvent.getRowValue();
        student.setInstMail(cellEditEvent.getNewValue());
    }
    @FXML
    private  void phoneCol_OnEditCommit(Event e){
        TableColumn.CellEditEvent<InstructorInfo,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<InstructorInfo,String>) e;
        InstructorInfo student = cellEditEvent.getRowValue();
        student.setInstPhone(cellEditEvent.getNewValue());
    }
    @FXML
    private  void addressCol_OnEditCommit(Event e){
        TableColumn.CellEditEvent<InstructorInfo,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<InstructorInfo,String>) e;
        InstructorInfo student = cellEditEvent.getRowValue();
        student.setAddress(cellEditEvent.getNewValue());
    }
    @FXML
    private  void genderCol_OnEditCommit(Event e){
        TableColumn.CellEditEvent<InstructorInfo,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<InstructorInfo,String>) e;
        InstructorInfo student = cellEditEvent.getRowValue();
        student.setGender(cellEditEvent.getNewValue());
    }
    public void handleClearButtonClick(ActionEvent event){
        NameField.clear();
       departmentField.clear();
        addressField.clear();
        emailField.clear();
        phoneField.clear();
        genderBox.setValue("Gender");
    }
    public void filterStudentList(String oldvalue,String newvalue){
        ObservableList<InstructorInfo> filteredList = FXCollections.observableArrayList();
        if(filterInput == null || (newvalue.length()<oldvalue.length()) || newvalue == null){
            studentTable.setItems(observableInstructorList);
        }
        else{
            newvalue = newvalue.toUpperCase();
            for (InstructorInfo students : studentTable.getItems()) {
                String filterFirstname = students.getInstName();
                if(filterFirstname.toUpperCase().contains(newvalue) ){
                    filteredList.add(students);
                }
            }
            studentTable.setItems(filteredList);
        }
    }

}
