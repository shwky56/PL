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
import javafx.util.converter.NumberStringConverter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddStudent implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<AddStudentInfo,String> firstNameCol;

    @FXML
    private TableColumn<AddStudentInfo, String> lastNameCol;

    @FXML
    private TableColumn<AddStudentInfo, Number> ageCol;

    @FXML
    private TableColumn<AddStudentInfo, Number> gpaCol;

    @FXML
    private TableColumn<AddStudentInfo, String> courseCol;

    @FXML
    private TableColumn<AddStudentInfo,String> genderCol;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField ageField;

    @FXML
    private TextField gpaField;

    @FXML
    private TextField courseField;

    @FXML
    private TextField filterInput;

    @FXML
    private ComboBox<String> genderBox;
    ObservableList<String> genderBoxData = FXCollections.observableArrayList();

    @FXML
    private TableView<AddStudentInfo> studentTable;

    @FXML
    private Button addBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private MenuBar fileMenu;
    @FXML
    private Button backB;
    private Stage stage;
    private Scene scene;
    private Parent root;
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

    ObservableList<AddStudentInfo> observableStudentList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        filterInput.textProperty().addListener(new ChangeListener(){
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                filterStudentList((String)oldValue,(String)newValue);
            }
        });
        //initialize editable attributes
        studentTable.setEditable(true);
        firstNameCol.setOnEditCommit(e -> firstNameCol_OnEditCommit(e));
        lastNameCol.setOnEditCommit(e -> lastNameCol_OnEditCommit(e));
        courseCol.setOnEditCommit(e -> courseCol_OnEditCommit(e));
        ageCol.setOnEditCommit(e -> ageCol_OnEditCommit(e));
        gpaCol.setOnEditCommit(e -> gpaCol_OnEditCommit(e));
        genderCol.setOnEditCommit(e -> genderCol_OnEditCommit(e));

        studentTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        courseCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ageCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        gpaCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        genderCol.setCellFactory(TextFieldTableCell.forTableColumn());

        firstNameCol.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameCol.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        courseCol.setCellValueFactory(cellData -> cellData.getValue().courseProperty());
        ageCol.setCellValueFactory(cellData -> cellData.getValue().ageProperty());
        gpaCol.setCellValueFactory(cellData -> cellData.getValue().gpaProperty());
        genderCol.setCellValueFactory(cellData -> cellData.getValue().genderProperty());

        //initialize gender ComboBox
        genderBoxData.add(new String("Male"));
        genderBoxData.add(new String("Female"));

        genderBox.setItems(genderBoxData);

        addBtn.setDisable(true);
        deleteBtn.setDisable(true);
        studentTable.setItems(observableStudentList);
        studentTable.setEditable(true);
        studentTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        studentTable.setPlaceholder(new Label("Your Table is Empty"));

        firstNameField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable,Boolean oldValue,Boolean newValue){
                if(firstNameField.isFocused()){
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

    public void handleAddButtonClick(ActionEvent event){
        /* add input from user and add to table */
        if(observableStudentList.size() < 1000){
            if(isValidInput(event)){
                if(genderBox.getValue().equals("Male")){
                    AddStudentInfo student = new AddStudentInfo();
                    student.setFirstName(firstNameField.getText());
                    student.setLastName(lastNameField.getText());
                    student.setCourse(courseField.getText());
                    student.setAge(Integer.parseInt(ageField.getText()));
                    student.setGpa(Double.parseDouble(gpaField.getText()));
                    student.setGender(genderBox.getValue());
                    observableStudentList.add(student);
                    System.out.println(student.toString());
                    firstNameField.clear();
                    lastNameField.clear();
                    courseField.clear();
                    ageField.clear();
                    gpaField.clear();
                    genderBox.setValue("Gender");
                }
                if(genderBox.getValue().equals("Female")){
                    AddStudentInfo student = new AddStudentInfo();
                    student.setFirstName(firstNameField.getText());
                    student.setLastName(lastNameField.getText());
                    student.setCourse(courseField.getText());
                    student.setAge(Integer.parseInt(ageField.getText()));
                    student.setGpa(Double.parseDouble(gpaField.getText()));
                    student.setGender(genderBox.getValue());
                    observableStudentList.add(student);
                    System.out.println(student.toString());
                    firstNameField.clear();
                    lastNameField.clear();
                    courseField.clear();
                    ageField.clear();
                    gpaField.clear();
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
                firstNameField.clear();
                lastNameField.clear();
                courseField.clear();
                ageField.clear();
                gpaField.clear();
                genderBox.setValue("Gender");
            }
        }
    }
    /*
    In Case of empty fields, gives alert for respective empty field and requests focus on that field
     */
    private boolean isValidInput(ActionEvent event){
        Boolean validInput = true;
        if(firstNameField == null || firstNameField.getText().trim().isEmpty()){
            validInput = false;
            Alert emptyFirstName = new Alert(Alert.AlertType.WARNING,"Warning",ButtonType.OK);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            emptyFirstName.setContentText("First Name is Empty");
            emptyFirstName.initModality(Modality.APPLICATION_MODAL);
            emptyFirstName.initOwner(owner);
            emptyFirstName.showAndWait();
            if(emptyFirstName.getResult() == ButtonType.OK){
                emptyFirstName.close();
                firstNameField.requestFocus();
            }
        }
        if(lastNameField == null || lastNameField.getText().trim().isEmpty()){
            validInput = false;
            Alert emptyLastName = new Alert(Alert.AlertType.WARNING,"Warning",ButtonType.OK);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            emptyLastName.setContentText("Last Name is Empty");
            emptyLastName.initModality(Modality.APPLICATION_MODAL);
            emptyLastName.initOwner(owner);
            emptyLastName.showAndWait();
            if(emptyLastName.getResult() == ButtonType.OK){
                emptyLastName.close();
                lastNameField.requestFocus();
            }
        }
        if(courseField == null || courseField.getText().trim().isEmpty()){
            validInput = false;
            Alert emptyCourse = new Alert(Alert.AlertType.WARNING,"Warning",ButtonType.OK);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            emptyCourse.setContentText("Course is Empty");
            emptyCourse.initModality(Modality.APPLICATION_MODAL);
            emptyCourse.initOwner(owner);
            emptyCourse.showAndWait();
            if(emptyCourse.getResult() == ButtonType.OK){
                emptyCourse.close();
                courseField.requestFocus();
            }
        }
        if(ageField == null || ageField.getText().trim().isEmpty()){
            validInput = false;
            Alert emptyAge = new Alert(Alert.AlertType.WARNING,"Warning",ButtonType.OK);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            emptyAge.setContentText("Age is Empty");
            emptyAge.initModality(Modality.APPLICATION_MODAL);
            emptyAge.initOwner(owner);
            emptyAge.showAndWait();
            if(emptyAge.getResult() == ButtonType.OK){
                emptyAge.close();
                ageField.requestFocus();
            }
        }
        if(gpaField == null || gpaField.getText().trim().isEmpty()){
            validInput = false;
            Alert emptyGPA = new Alert(Alert.AlertType.WARNING,"Warning",ButtonType.OK);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            emptyGPA.setContentText("GPA is Empty");
            emptyGPA.initModality(Modality.APPLICATION_MODAL);
            emptyGPA.initOwner(owner);
            emptyGPA.showAndWait();
            if(emptyGPA.getResult() == ButtonType.OK){
                emptyGPA.close();
                gpaField.requestFocus();
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
    /*
        handle column edits:
     */
    @FXML
    private void firstNameCol_OnEditCommit(Event e){
        TableColumn.CellEditEvent<AddStudentInfo,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<AddStudentInfo,String>) e;
        AddStudentInfo student = cellEditEvent.getRowValue();
        student.setFirstName(cellEditEvent.getNewValue());
    }
    @FXML
    private void lastNameCol_OnEditCommit(Event e){
        TableColumn.CellEditEvent<AddStudentInfo,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<AddStudentInfo,String>) e;
        AddStudentInfo student = cellEditEvent.getRowValue();
        student.setLastName(cellEditEvent.getNewValue());
    }
    @FXML
    private void courseCol_OnEditCommit(Event e){
        TableColumn.CellEditEvent<AddStudentInfo,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<AddStudentInfo,String>) e;
        AddStudentInfo student = cellEditEvent.getRowValue();
        student.setCourse(cellEditEvent.getNewValue());
    }
    @FXML
    private void ageCol_OnEditCommit(Event e){
        TableColumn.CellEditEvent<AddStudentInfo,Integer> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<AddStudentInfo,Integer>) e;
        AddStudentInfo student = cellEditEvent.getRowValue();
        student.setAge(cellEditEvent.getNewValue());
    }
    @FXML
    private void gpaCol_OnEditCommit(Event e){
        TableColumn.CellEditEvent<AddStudentInfo,Double> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<AddStudentInfo,Double>) e;
        AddStudentInfo student = cellEditEvent.getRowValue();
        student.setGpa(cellEditEvent.getNewValue());
    }
    @FXML
    private void genderCol_OnEditCommit(Event e){
        TableColumn.CellEditEvent<AddStudentInfo,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<AddStudentInfo,String>) e;
        AddStudentInfo student = cellEditEvent.getRowValue();
        student.setGender(cellEditEvent.getNewValue());
    }
    public void handleDeleteButtonClick(ActionEvent e){
        if(!observableStudentList.isEmpty()){
            System.out.println("Delete button clicked");
            Alert deleteAlert = new Alert(Alert.AlertType.WARNING,"Confirm",ButtonType.OK,ButtonType.CANCEL);
            Window owner = ((Node)e.getTarget()).getScene().getWindow();
            deleteAlert.setContentText("Are you sure you want to delete this?\n\nTHIS CANNOT BE UNDONE.");
            deleteAlert.initModality(Modality.APPLICATION_MODAL);
            deleteAlert.initOwner(owner);
            deleteAlert.showAndWait();
            if(deleteAlert.getResult()==ButtonType.OK){
                observableStudentList.removeAll(studentTable.getSelectionModel().getSelectedItems());
                studentTable.getSelectionModel().clearSelection();
            }
            else{
                deleteAlert.close();
            }
        }
    }
    public void handleClearButtonClick(ActionEvent event){
        firstNameField.clear();
        lastNameField.clear();
        courseField.clear();
        ageField.clear();
        gpaField.clear();
        genderBox.setValue("Gender");
    }

    //filter table by first or last name:

    public void filterStudentList(String oldvalue,String newvalue){
        ObservableList<AddStudentInfo> filteredList = FXCollections.observableArrayList();
        if(filterInput == null || (newvalue.length()<oldvalue.length()) || newvalue == null){
            studentTable.setItems(observableStudentList);
        }
        else{
            newvalue = newvalue.toUpperCase();
            for (AddStudentInfo students : studentTable.getItems()) {
                String filterFirstname = students.getFirstName();
                String filterLastname = students.getLastName();
                if(filterFirstname.toUpperCase().contains(newvalue) || filterLastname.toUpperCase().contains(newvalue)){
                    filteredList.add(students);
                }
            }
            studentTable.setItems(filteredList);
        }
    }
    public void handleSave(ActionEvent event){
        Stage secondaryStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Student Table");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        if(observableStudentList.isEmpty()){
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
    private void saveFile(ObservableList<AddStudentInfo> observableStudentList, File file){
        try {
            BufferedWriter outWriter = new BufferedWriter(new FileWriter(file));
            for(AddStudentInfo students : observableStudentList){
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
}