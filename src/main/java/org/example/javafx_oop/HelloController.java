package org.example.javafx_oop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloController {
    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, String> colId;
    @FXML
    private TableColumn<Student, String> colFirstName;
    @FXML
    private TableColumn<Student, String> colLastName;
    @FXML
    private TableColumn<Student, String> colDepartment;
    @FXML
    private TableColumn<Student, String> colMajor;
    @FXML
    private TableColumn<Student, String> colEmail;

    @FXML
    private TextField tfFirstName;
    @FXML
    private TextField tfLastName;
    @FXML
    private TextField tfDepartment;
    @FXML
    private TextField tfMajor;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfImageURL;

    @FXML
    private ImageView profileImageView;

    private final ObservableList<Student> studentList = FXCollections.observableArrayList();
    private int nextId = 1;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(data -> data.getValue().idProperty());
        colFirstName.setCellValueFactory(data -> data.getValue().firstNameProperty());
        colLastName.setCellValueFactory(data -> data.getValue().lastNameProperty());
        colDepartment.setCellValueFactory(data -> data.getValue().departmentProperty());
        colMajor.setCellValueFactory(data -> data.getValue().majorProperty());
        colEmail.setCellValueFactory(data -> data.getValue().emailProperty());

        tableView.setItems(studentList);

        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) ->
        {
            if (newVal != null) populateForm(newVal);
        });

        tfImageURL.textProperty().addListener((obs, oldVal, newVal) -> loadProfileImage(newVal));
    }

    @FXML
    private void handleAdd() {
        String firstName = tfFirstName.getText().trim();
        String lastName = tfLastName.getText().trim();
        if (firstName.isEmpty() || lastName.isEmpty()) {
            showAlert("Validation Error", "First Name and Last Name are Required");
            return;
        }
        studentList.add(new Student(
                String.valueOf(nextId++), firstName, lastName,
                tfDepartment.getText().trim(), tfMajor.getText().trim(),
                tfEmail.getText().trim(), tfImageURL.getText().trim()
        ));
        clearForm();
    }

    @FXML
    private void handleDelete() {
        Student selected = tableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("No Selection", "Please select a student to delete.");
            return;
        }
        studentList.remove(selected);
        clearForm();
    }

    @FXML
    private void handleEdit() {
        Student selected = tableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("No Selection", "Please select a student to edit.");
            return;
        }
        selected.setFirstName(tfFirstName.getText().trim());
        selected.setLastName(tfLastName.getText().trim());
        selected.setDepartment(tfDepartment.getText().trim());
        selected.setMajor(tfMajor.getText().trim());
        selected.setEmail(tfEmail.getText().trim());
        selected.setImageURL(tfImageURL.getText().trim());
        tableView.refresh();
        clearForm();
    }
    @FXML private void handleClear(){ clearForm(); tableView.getSelectionModel().clearSelection(); }
    @FXML private void handleNew(){ studentList.clear(); nextId = 1; clearForm();}
    @FXML private void handleOpen(){showAlert("Open", "Coming soon :)");}
    @FXML private void handleSave(){showAlert("Save", "Coming soon :)");}
    @FXML private void handleExit(){System.exit(0);}
    @FXML private void handleCut(){showAlert("Cut", "Cut action triggered.");}
    @FXML private void handleCopy(){showAlert("Copy", "Copy action triggered.");}
    @FXML private void handlePaste(){showAlert("Paste", "Paste action triggered.");}
    @FXML private void handleAbout(){showAlert("About", "Full stack project, JavaFX/OOP app.");}

    @FXML private void handleLightTheme(){ tableView.getScene().getRoot().getStyleClass().remove("dark-theme");}
    @FXML private void handleDarkTheme(){
        if (!tableView.getScene().getRoot().getStyleClass().contains("dark-theme"))
            tableView.getScene().getRoot().getStyleClass().add("dark-theme");
    }

    private void populateForm(Student s){
        tfFirstName.setText(s.getFirstName());
        tfLastName.setText(s.getLastName());
        tfDepartment.setText(s.getDepartment());
        tfMajor.setText(s.getMajor());
        tfEmail.setText(s.getEmail());
        tfImageURL.setText(s.getImageURL());
        loadProfileImage(s.getImageURL());

    }
    private void clearForm(){
        tfFirstName.clear(); tfLastName.clear(); tfDepartment.clear();
        tfMajor.clear(); tfEmail.clear(); tfImageURL.clear();
        profileImageView.setImage(null);
    }

    private void loadProfileImage(String url){
        if (url == null || url.isBlank())
        {
            profileImageView.setImage(null);
            return;
        }
        try{ profileImageView.setImage(new Image(url, true)); }
        catch (Exception ignored) { profileImageView.setImage(null); }
        }

        private void showAlert(String title, String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}