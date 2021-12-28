package com.example.profx;

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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CourseHome implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane an;

    @FXML
    private Button instractorB;

    @FXML
    private Button studentB;

    @FXML
    private Button logoutB;

    @FXML
    private TableView<CourseInfo> table;

    @FXML
    private TableColumn<CourseInfo, String> courseName;

    @FXML
    private TableColumn<CourseInfo, String> courseId;

    @FXML
    private TableColumn<CourseInfo, String> courseDegree;

    @FXML
    private TableColumn<CourseInfo, String> room;

    @FXML
    private TableColumn<CourseInfo, String> instructor;

    @FXML
    private TableColumn<CourseInfo, String> price;

    @FXML
    private TableColumn<CourseInfo, String> startDay;

    @FXML
    private TableColumn<CourseInfo, String> endDay;

    @FXML
    private TableColumn<CourseInfo, String> numberOfDays;

    @FXML
    private TextField courseNameTF;

    @FXML
    private TextField courseIdTF;

    @FXML
    private TextField instructorTF;

    @FXML
    private TextField priceTF;

    @FXML
    private TextField gradesTF;

    @FXML
    private TextField numberOfDaysTF;

    @FXML
    private TextField startDayTF;

    @FXML
    private TextField roomTF;

    @FXML
    private TextField endDayTF;

    @FXML
    private Button createB;

    @FXML
    private Button deleteB;

    @FXML
    private Button updateB;

    ObservableList<CourseInfo> observableStudentList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initialize editable attributes
        table.setEditable(true);
        courseName.setOnEditCommit(e -> courseName_OnEditCommit(e));
        courseId.setOnEditCommit(e -> courseId_OnEditCommit(e));
        courseDegree.setOnEditCommit(e -> courseDegree_OnEditCommit(e));
        room.setOnEditCommit(e -> room_OnEditCommit(e));
        instructor.setOnEditCommit(e -> instructor_OnEditCommit(e));
        price.setOnEditCommit(e -> price_OnEditCommit(e));
        startDay.setOnEditCommit(e -> startDay_OnEditCommit(e));
        endDay.setOnEditCommit(e -> endDay_OnEditCommit(e));
        numberOfDays.setOnEditCommit(e -> numberOfDays_OnEditCommit(e));

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        courseName.setCellFactory(TextFieldTableCell.forTableColumn());
        courseId.setCellFactory(TextFieldTableCell.forTableColumn());
        courseDegree.setCellFactory(TextFieldTableCell.forTableColumn());
        room.setCellFactory(TextFieldTableCell.forTableColumn());
        instructor.setCellFactory(TextFieldTableCell.forTableColumn());
        price.setCellFactory(TextFieldTableCell.forTableColumn());
        startDay.setCellFactory(TextFieldTableCell.forTableColumn());
        endDay.setCellFactory(TextFieldTableCell.forTableColumn());
        numberOfDays.setCellFactory(TextFieldTableCell.forTableColumn());

        courseName.setCellValueFactory(cellData -> cellData.getValue().courseNameProperty());
        courseId.setCellValueFactory(cellData -> cellData.getValue().courseIdProperty());
        courseDegree.setCellValueFactory(cellData -> cellData.getValue().courseDegreeProperty());
        room.setCellValueFactory(cellData -> cellData.getValue().roomProperty());
        instructor.setCellValueFactory(cellData -> cellData.getValue().instructorProperty());
        price.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
        startDay.setCellValueFactory(cellData -> cellData.getValue().startDayProperty());
        endDay.setCellValueFactory(cellData -> cellData.getValue().endDayProperty());
        numberOfDays.setCellValueFactory(cellData -> cellData.getValue().numberOfDaysProperty());


        createB.setDisable(true);
        deleteB.setDisable(true);
        updateB.setDisable(true);
        table.setItems(observableStudentList);
        table.setEditable(true);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.setPlaceholder(new Label("Your Table is Empty"));

        courseNameTF.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable,Boolean oldValue,Boolean newValue){
                if(courseNameTF.isFocused()){
                    createB.setDisable(false);
                }
            }
        });
        table.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable,Boolean oldValue,Boolean newValue){
                if(table.isFocused()){
                    deleteB.setDisable(false);
                }
            }
        });
    }
    /* end Initialize */

    /* Control Handler */
    public void create(ActionEvent event){
        /* add input from user and add to table */
        if(observableStudentList.size() < 1000){
            if(isValidInput(event)){
                CourseInfo student = new CourseInfo();
                student.setCourseName(courseNameTF.getText());
                student.setCourseId(courseIdTF.getText());
                student.setCourseDegree(gradesTF.getText());
                student.setRoom(roomTF.getText());
                student.setInstructor(instructorTF.getText());
                student.setPrice(priceTF.getText());
                student.setStartDay(startDayTF.getText());
                student.setEndDay(endDayTF.getText());
                student.setNumberOfDays(instructorTF.getText());
                observableStudentList.add(student);
                System.out.println(student.toString());
                courseNameTF.clear();
                courseIdTF.clear();
                gradesTF.clear();
                roomTF.clear();
                instructorTF.clear();
                priceTF.clear();
                startDayTF.clear();
                endDayTF.clear();
                numberOfDaysTF.clear();
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
                courseNameTF.clear();
                courseIdTF.clear();
                gradesTF.clear();
                roomTF.clear();
                instructorTF.clear();
                priceTF.clear();
                startDayTF.clear();
                endDayTF.clear();
                numberOfDaysTF.clear();
            }
        }
    }
    /*
    In Case of empty fields, gives alert for respective empty field and requests focus on that field
     */
    private boolean isValidInput(ActionEvent event){
        Boolean validInput = true;
        if(courseNameTF == null || courseNameTF.getText().trim().isEmpty()){
            validInput = false;
            Alert emptyCourseName = new Alert(Alert.AlertType.WARNING,"Warning",ButtonType.OK);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            emptyCourseName.setContentText("Course Name is Empty");
            emptyCourseName.initModality(Modality.APPLICATION_MODAL);
            emptyCourseName.initOwner(owner);
            emptyCourseName.showAndWait();
            if(emptyCourseName.getResult() == ButtonType.OK){
                emptyCourseName.close();
                courseNameTF.requestFocus();
            }
        }
        if(courseIdTF == null || courseIdTF.getText().trim().isEmpty()){
            validInput = false;
            Alert emptyCourseId = new Alert(Alert.AlertType.WARNING,"Warning",ButtonType.OK);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            emptyCourseId.setContentText("Course ID is Empty");
            emptyCourseId.initModality(Modality.APPLICATION_MODAL);
            emptyCourseId.initOwner(owner);
            emptyCourseId.showAndWait();
            if(emptyCourseId.getResult() == ButtonType.OK){
                emptyCourseId.close();
                courseIdTF.requestFocus();
            }
        }
        if(gradesTF == null || gradesTF.getText().trim().isEmpty()){
            validInput = false;
            Alert emptyGrades = new Alert(Alert.AlertType.WARNING,"Warning",ButtonType.OK);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            emptyGrades.setContentText("Grades is Empty");
            emptyGrades.initModality(Modality.APPLICATION_MODAL);
            emptyGrades.initOwner(owner);
            emptyGrades.showAndWait();
            if(emptyGrades.getResult() == ButtonType.OK){
                emptyGrades.close();
                gradesTF.requestFocus();
            }
        }
        if(roomTF == null || roomTF.getText().trim().isEmpty()){
            validInput = false;
            Alert emptyRoom = new Alert(Alert.AlertType.WARNING,"Warning",ButtonType.OK);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            emptyRoom.setContentText("Age is Empty");
            emptyRoom.initModality(Modality.APPLICATION_MODAL);
            emptyRoom.initOwner(owner);
            emptyRoom.showAndWait();
            if(emptyRoom.getResult() == ButtonType.OK){
                emptyRoom.close();
                roomTF.requestFocus();
            }
        }
        if(instructorTF == null || instructorTF.getText().trim().isEmpty()){
            validInput = false;
            Alert emptyInstructor = new Alert(Alert.AlertType.WARNING,"Warning",ButtonType.OK);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            emptyInstructor.setContentText("GPA is Empty");
            emptyInstructor.initModality(Modality.APPLICATION_MODAL);
            emptyInstructor.initOwner(owner);
            emptyInstructor.showAndWait();
            if(emptyInstructor.getResult() == ButtonType.OK){
                emptyInstructor.close();
                instructorTF.requestFocus();
            }
        }
        if(priceTF == null || priceTF.getText().trim().isEmpty()){
            validInput = false;
            Alert emptyPrice = new Alert(Alert.AlertType.WARNING,"Warning",ButtonType.OK);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            emptyPrice.setContentText("GPA is Empty");
            emptyPrice.initModality(Modality.APPLICATION_MODAL);
            emptyPrice.initOwner(owner);
            emptyPrice.showAndWait();
            if(emptyPrice.getResult() == ButtonType.OK){
                emptyPrice.close();
                priceTF.requestFocus();
            }
        }
        if(startDayTF == null || startDayTF.getText().trim().isEmpty()){
            validInput = false;
            Alert emptyInstructor = new Alert(Alert.AlertType.WARNING,"Warning",ButtonType.OK);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            emptyInstructor.setContentText("GPA is Empty");
            emptyInstructor.initModality(Modality.APPLICATION_MODAL);
            emptyInstructor.initOwner(owner);
            emptyInstructor.showAndWait();
            if(emptyInstructor.getResult() == ButtonType.OK){
                emptyInstructor.close();
                startDayTF.requestFocus();
            }
        }
        if(endDayTF == null || endDayTF.getText().trim().isEmpty()){
            validInput = false;
            Alert emptyEndDay = new Alert(Alert.AlertType.WARNING,"Warning",ButtonType.OK);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            emptyEndDay.setContentText("GPA is Empty");
            emptyEndDay.initModality(Modality.APPLICATION_MODAL);
            emptyEndDay.initOwner(owner);
            emptyEndDay.showAndWait();
            if(emptyEndDay.getResult() == ButtonType.OK){
                emptyEndDay.close();
                endDayTF.requestFocus();
            }
        }
        if(numberOfDaysTF == null || numberOfDaysTF.getText().trim().isEmpty()){
            validInput = false;
            Alert emptyNumberOfDays = new Alert(Alert.AlertType.WARNING,"Warning",ButtonType.OK);
            Window owner = ((Node)event.getTarget()).getScene().getWindow();
            emptyNumberOfDays.setContentText("GPA is Empty");
            emptyNumberOfDays.initModality(Modality.APPLICATION_MODAL);
            emptyNumberOfDays.initOwner(owner);
            emptyNumberOfDays.showAndWait();
            if(emptyNumberOfDays.getResult() == ButtonType.OK){
                emptyNumberOfDays.close();
                numberOfDaysTF.requestFocus();
            }
        }
        return validInput;
    }
    /*
        handle column edits:
     */
    @FXML
    private void courseName_OnEditCommit(Event e){
        TableColumn.CellEditEvent<CourseInfo,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<CourseInfo,String>) e;
        CourseInfo student = cellEditEvent.getRowValue();
        student.setCourseName(cellEditEvent.getNewValue());
    }
    @FXML
    private void courseId_OnEditCommit(Event e){
        TableColumn.CellEditEvent<CourseInfo,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<CourseInfo,String>) e;
        CourseInfo student = cellEditEvent.getRowValue();
        student.setCourseId(cellEditEvent.getNewValue());
    }
    @FXML
    private void courseDegree_OnEditCommit(Event e){
        TableColumn.CellEditEvent<CourseInfo,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<CourseInfo,String>) e;
        CourseInfo student = cellEditEvent.getRowValue();
        student.setCourseDegree(cellEditEvent.getNewValue());
    }
    @FXML
    private void room_OnEditCommit(Event e){
        TableColumn.CellEditEvent<CourseInfo,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<CourseInfo,String>) e;
        CourseInfo student = cellEditEvent.getRowValue();
        student.setRoom(cellEditEvent.getNewValue());
    }
    @FXML
    private void instructor_OnEditCommit(Event e){
        TableColumn.CellEditEvent<CourseInfo,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<CourseInfo,String>) e;
        CourseInfo student = cellEditEvent.getRowValue();
        student.setInstructor(cellEditEvent.getNewValue());
    }
    @FXML
    private void price_OnEditCommit(Event e){
        TableColumn.CellEditEvent<CourseInfo,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<CourseInfo,String>) e;
        CourseInfo student = cellEditEvent.getRowValue();
        student.setPrice(cellEditEvent.getNewValue());
    }
    @FXML
    private void startDay_OnEditCommit(Event e){
        TableColumn.CellEditEvent<CourseInfo,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<CourseInfo,String>) e;
        CourseInfo student = cellEditEvent.getRowValue();
        student.setPrice(cellEditEvent.getNewValue());
    }
    @FXML
    private void endDay_OnEditCommit(Event e){
        TableColumn.CellEditEvent<CourseInfo,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<CourseInfo,String>) e;
        CourseInfo student = cellEditEvent.getRowValue();
        student.setPrice(cellEditEvent.getNewValue());
    }
    @FXML
    private void numberOfDays_OnEditCommit(Event e){
        TableColumn.CellEditEvent<CourseInfo,String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<CourseInfo,String>) e;
        CourseInfo student = cellEditEvent.getRowValue();
        student.setPrice(cellEditEvent.getNewValue());
    }
    public void delete(ActionEvent e){
        if(!observableStudentList.isEmpty()){
            System.out.println("Delete button clicked");
            Alert deleteAlert = new Alert(Alert.AlertType.WARNING,"Confirm",ButtonType.OK,ButtonType.CANCEL);
            Window owner = ((Node)e.getTarget()).getScene().getWindow();
            deleteAlert.setContentText("Are you sure you want to delete this?\n\nTHIS CANNOT BE UNDONE.");
            deleteAlert.initModality(Modality.APPLICATION_MODAL);
            deleteAlert.initOwner(owner);
            deleteAlert.showAndWait();
            if(deleteAlert.getResult()==ButtonType.OK){
                observableStudentList.removeAll(table.getSelectionModel().getSelectedItems());
                table.getSelectionModel().clearSelection();
            }
            else{
                deleteAlert.close();
            }
        }
    }
    public void update(ActionEvent e){
        if(!observableStudentList.isEmpty()){
            System.out.println("Update button clicked");
            Alert updateAlert = new Alert(Alert.AlertType.WARNING,"Confirm",ButtonType.OK,ButtonType.CANCEL);
            Window owner = ((Node)e.getTarget()).getScene().getWindow();
            updateAlert.setContentText("Are you sure you want to update this?\n\nTHIS CANNOT BE UNDONE.");
            updateAlert.initModality(Modality.APPLICATION_MODAL);
            updateAlert.initOwner(owner);
            updateAlert.showAndWait();
            if(updateAlert.getResult()==ButtonType.OK){
                observableStudentList.removeAll(table.getSelectionModel().getSelectedItems());
                table.getSelectionModel().clearSelection();
            }
            else{
                updateAlert.close();
            }
        }
    }
    public void handleClearButtonClick(ActionEvent event){
        courseNameTF.clear();
        courseIdTF.clear();
        gradesTF.clear();
        roomTF.clear();
        instructorTF.clear();
        priceTF.clear();
        startDayTF.clear();
        endDayTF.clear();
        numberOfDaysTF.clear();
    }


    @FXML
    void goToInstrucor(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("instructor.fxml"));
        root = loader.load();
        Instructor studentCont= loader.getController();
        //Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goToStudent(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("studentCourseModul.fxml"));
        root = loader.load();
        StudentCourseModul studentCont= loader.getController();
        //Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void logOut(ActionEvent event) {
        Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to logout !");
        alert.setContentText("Do you want to save before exiting");
        if(alert.showAndWait().get()== ButtonType.APPLY.OK) {
            stage=(Stage) an.getScene().getWindow();
            System.out.println("You successfully logged out");
            stage.close();
        }
    }

}
