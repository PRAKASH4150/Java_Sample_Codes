import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UserRegistrationPortal extends Application {

    private static final double FIELD_WIDTH=200;
    private static final double FIELD_HEIGHT=50;
    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane stackPane =null;
        final UserDetails[]  userDetails=new UserDetails[1];
        final String[] selectedCountry = new String[1];
        final String[] progLang=new String[1];

        Label headerLabel=new Label("User Registration Form");
        headerLabel.setTextFill(Color.BLUE);
        headerLabel.setStyle("-fx-font-size:40px;-fx-font-weight: bold");

        TextField fullName=new TextField();
        fullName.setPromptText("Full Name");
        fullName.setStyle("-fx-prompt-text-fill:black; -fx-font-size:18px;");
        fullName.setPrefWidth(UserRegistrationPortal.FIELD_WIDTH);
        fullName.setPrefHeight(UserRegistrationPortal.FIELD_HEIGHT);

        TextField emailAdderss=new TextField();
        emailAdderss.setPromptText("Email Address");
        emailAdderss.setStyle("-fx-prompt-text-fill:black; -fx-font-size:18px;");
        emailAdderss.setPrefWidth(UserRegistrationPortal.FIELD_WIDTH);
        emailAdderss.setPrefHeight(UserRegistrationPortal.FIELD_HEIGHT);

        TextField phoneNumber=new TextField();
        phoneNumber.setPromptText("Phone Number");
        phoneNumber.setStyle("-fx-prompt-text-fill:black; -fx-font-size:18px;");
        phoneNumber.setPrefWidth(UserRegistrationPortal.FIELD_WIDTH);
        phoneNumber.setPrefHeight(UserRegistrationPortal.FIELD_HEIGHT);

        ComboBox<String> countryListBox = new ComboBox<>();
        ObservableList<String> countries = FXCollections.observableArrayList(
                "United States", "Canada", "United Kingdom", "Germany", "France", "Japan", "China", "India", "Brazil", "Australia"
        );
        countryListBox.setItems(countries);
        countryListBox.setPromptText("Country");
        countryListBox.setStyle("-fx-border-color:grey;-fx-background-color:white;-fx-prompt-text-fill:black; -fx-font-size:18px;");
        countryListBox.setPrefWidth(510);
        countryListBox.setPrefHeight(50);
        countryListBox.setOnAction(e -> {
             selectedCountry[0] = countryListBox.getSelectionModel().getSelectedItem();
        });

        TextField city=new TextField();
        city.setPromptText("City");
        city.setStyle("-fx-prompt-text-fill:black; -fx-font-size:18px;");
        city.setPrefWidth(UserRegistrationPortal.FIELD_WIDTH);
        city.setPrefHeight(UserRegistrationPortal.FIELD_HEIGHT);

        Label radioLabel=new Label("Pref. Prog. Language:");
        radioLabel.setTextFill(Color.BLACK);
        radioLabel.setStyle(" -fx-font-size:18px;");

        RadioButton cRadioButton = new RadioButton("C Programming");
        cRadioButton.setStyle("-fx-font-size:18px;");
        RadioButton javaRadioButton = new RadioButton("Java");
        javaRadioButton.setStyle("-fx-font-size:18px;");
        RadioButton pythonRadioButton = new RadioButton("Python");
        pythonRadioButton.setStyle("-fx-font-size:18px;");


        ToggleGroup toggleGroup = new ToggleGroup();
        javaRadioButton.setToggleGroup(toggleGroup);
        pythonRadioButton.setToggleGroup(toggleGroup);
        cRadioButton.setToggleGroup(toggleGroup);

        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (toggleGroup.getSelectedToggle() != null) {
                RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
                progLang[0]=selectedRadioButton.getText();
            }
        });


        Button submitButton =new Button("Register");
        submitButton.setPrefHeight(FIELD_HEIGHT);
        submitButton.setPrefWidth(FIELD_WIDTH);
        submitButton.setTextFill(Color.WHITE);
        submitButton.setStyle("-fx-background-color: green;" +
                "-fx-font-weight: bold;-fx-font-size:18px");
        submitButton.setOnAction(e -> {
            userDetails[0] = new UserDetails(fullName.getText(), emailAdderss.getText(),
                    phoneNumber.getText(), selectedCountry[0], city.getText(), progLang[0]);
            new UserRegistrationHandler(userDetails[0]).handle(e);
            fullName.clear();
            emailAdderss.clear();
            phoneNumber.clear();
            countryListBox.getSelectionModel().clearSelection(); // Clear ComboBox selection
            city.clear();
            toggleGroup.selectToggle(null);
        });


        Button quitButton =new Button("Quit");
        quitButton.setPrefHeight(FIELD_HEIGHT);
        quitButton.setPrefWidth(FIELD_WIDTH);
        quitButton.setTextFill(Color.WHITE);
        quitButton.setStyle("-fx-background-color: red;" +
                "-fx-font-weight: bold;-fx-font-size:18px");
        quitButton.setOnAction(e ->{
            new UserRegistrationHandler().handle(e);
            primaryStage.close();
        });

        HBox buttonsHBox=new HBox(40,submitButton,quitButton);

        HBox radioButtonsHBox=new HBox(10,radioLabel,cRadioButton,javaRadioButton,pythonRadioButton);
        VBox formVBox=new VBox(10,headerLabel,fullName,emailAdderss,phoneNumber,countryListBox
                ,city,radioButtonsHBox,buttonsHBox);
        HBox formHBox=new HBox(10,formVBox);
        buttonsHBox.setAlignment(Pos.CENTER);
        formVBox.setAlignment(Pos.CENTER);
        formHBox.setAlignment(Pos.CENTER);
        stackPane=new StackPane(formHBox);
        primaryStage.setScene(new Scene(stackPane,500,500));
        primaryStage.setTitle("User Registration Portal");
        primaryStage.show();
    }
    public static void main(String[] args)
    {
     Application.launch();
    }


}
