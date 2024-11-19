package rupizzeria.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import rupizzeria.models.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PizzaViewController {
    public static int orderNumber = 1;
    public TextArea toppingsListTextArea;
    public TextArea outputTextArea; // TextArea to display output messages
    public TextArea subtotalTextArea;
    private static final int MAX_TOPPINGS = 7; // Maximum number of toppings allowed
    private Set<String> selectedToppings = new HashSet<>(); // Set to keep track of selected toppings
    public ComboBox<String> sizeComboBox; // ComboBox for selecting size
    private Size selectedSize = null; // No default size initially
    private Pizza pizza; // Pizza instance to store the current pizza

    private ToggleGroup styleToggleGroup;
    private ToggleGroup typeToggleGroup;

    public RadioButton deluxeRadioButton;
    public RadioButton bbqchkRadioButton;
    public RadioButton meatzzaRadioButton;
    public RadioButton byoRadioButton;

    public RadioButton chicagoRadioButton;
    public RadioButton newyorkRadioButton;

    public CheckBox sausageCheckBox;
    public CheckBox onionCheckBox;
    public CheckBox pepperoniCheckBox;
    public CheckBox greenPepperCheckBox;
    public CheckBox mushroomCheckBox;
    public CheckBox bbqchkCheckBox;
    public CheckBox provoloneCheckBox;
    public CheckBox cheddarCheckBox;
    public CheckBox baconCheckBox;
    public CheckBox beefCheckBox;
    public CheckBox hamCheckBox;
    public CheckBox oliveCheckBox;
    public CheckBox pineappleCheckBox;

    public ImageView pizzaImageView; // Link this to the FXML
    private Image chicagoDeluxeImage;
    private Image chicagoBBQChickenImage;
    private Image chicagoMeatzzaImage;
    private Image chicagoBYOImage;
    private Image newYorkDeluxeImage;
    private Image newYorkBBQChickenImage;
    private Image newYorkMeatzzaImage;
    private Image newYorkBYOImage;

    private PizzaFactory pizzaFactory; // Factory for creating pizzas

    private Order order;

    public void initialize() {

        ObservableList<String> sizes = FXCollections.observableArrayList("Small", "Medium", "Large");
        sizeComboBox.setItems(sizes);
        sizeComboBox.setOnAction(event -> handleSizeSelection());

        order = new Order(orderNumber++);

        // Initialize the ToggleGroup for pizza style
        styleToggleGroup = new ToggleGroup();
        chicagoRadioButton.setToggleGroup(styleToggleGroup);
        newyorkRadioButton.setToggleGroup(styleToggleGroup);

        // Initialize the ToggleGroup for pizza type
        typeToggleGroup = new ToggleGroup();
        deluxeRadioButton.setToggleGroup(typeToggleGroup);
        bbqchkRadioButton.setToggleGroup(typeToggleGroup);
        meatzzaRadioButton.setToggleGroup(typeToggleGroup);
        byoRadioButton.setToggleGroup(typeToggleGroup);

        // Initially disable toppings CheckBoxes
        updateToppingCheckBoxes(false);

        // Convert the file path to a URI
        File chicagoDeluxeFile = new File("C:\\Users\\erika\\Downloads\\chicago_deluxe.jpg");
        File chicagoBBQChickenFile = new File("C:\\Users\\erika\\Downloads\\chicago_bbq.jpg");
        File chicagoMeatzzaFile = new File("C:\\Users\\erika\\Downloads\\chicago_meatzza.jpg");
        File chicagoBYOFile = new File("C:\\Users\\erika\\Downloads\\chicago_build_your_own.jpg");
        File newYorkDeluxeFile = new File("C:\\Users\\erika\\Downloads\\ny_deluxe.jpeg");
        File newYorkBBQChickenFile = new File("C:\\Users\\erika\\Downloads\\ny_bbq.jpg");
        File newYorkMeatzzaFile = new File("C:\\Users\\erika\\Downloads\\ny_meatzza.jpg");
        File newYorkBYOFile = new File("C:\\Users\\erika\\Downloads\\ny_build_your_own.jpg");

        if (chicagoDeluxeFile.exists()) {
            chicagoDeluxeImage = new Image(chicagoDeluxeFile.toURI().toString());
        } else {
           return;
        }
        if (chicagoBBQChickenFile.exists()) {
            chicagoBBQChickenImage = new Image(chicagoBBQChickenFile.toURI().toString());
        } else {
            return;
        }
        if (chicagoMeatzzaFile.exists()) {
            chicagoMeatzzaImage = new Image(chicagoMeatzzaFile.toURI().toString());
        } else {
            return;
        }
        if (chicagoBYOFile.exists()) {
            chicagoBYOImage = new Image(chicagoBYOFile.toURI().toString());
        } else {
            return;
        }
        if (newYorkDeluxeFile.exists()) {
            newYorkDeluxeImage = new Image(newYorkDeluxeFile.toURI().toString());
        } else {
            return;
       }
        if (newYorkBBQChickenFile.exists()) {
            newYorkBBQChickenImage = new Image(newYorkBBQChickenFile.toURI().toString());
        } else {
            return;
        }
        if (newYorkMeatzzaFile.exists()) {
            newYorkMeatzzaImage = new Image(newYorkMeatzzaFile.toURI().toString());
        } else {
            return;
        }
        if (newYorkBYOFile.exists()) {
            newYorkBYOImage = new Image(newYorkBYOFile.toURI().toString());
        } else {
            return;
        }

    }

    private void handleSizeSelection() {
        String sizeText = sizeComboBox.getValue(); // Get selected size from ComboBox
        if (sizeText != null) {
            for (Size size : Size.values()) {
                if (size.toString().equalsIgnoreCase(sizeText)) {
                    selectedSize = size;
                    break;
                }
            }
            outputTextArea.setText("Selected size: " + selectedSize);
        }

        if(pizzaFactory != null && pizzaFactory instanceof ChicagoPizza) {
            ((ChicagoPizza) pizzaFactory).setSize(selectedSize);
        }
        else if(pizzaFactory != null && pizzaFactory instanceof NYPizza) {
            ((NYPizza) pizzaFactory).setSize(selectedSize);
        }

        if (pizza != null)
        {
            pizza.setSize(selectedSize);
        }

        if(selectedSize != null && pizzaFactory != null && pizza != null) {
            updateSubtotalTextArea();
        }
    }

    public void handleStyleSelection(ActionEvent actionEvent) {
        RadioButton selectedStyle = (RadioButton) styleToggleGroup.getSelectedToggle();
        if (selectedStyle == chicagoRadioButton) {
            pizzaFactory = new ChicagoPizza(); // Pass the selected size
            outputTextArea.setText("Selected Chicago Style");
        } else if (selectedStyle == newyorkRadioButton) {
            pizzaFactory = new NYPizza(); // Pass the selected size
            outputTextArea.setText("Selected New York Style");
        }
        if(selectedSize != null && pizzaFactory != null && pizza != null) {
            updateSubtotalTextArea();
        }
    }

    public void handleTypeSelection(ActionEvent actionEvent) {
        RadioButton selectedType = (RadioButton) typeToggleGroup.getSelectedToggle();
        if (selectedType == deluxeRadioButton && chicagoRadioButton.isSelected()) {
            pizzaImageView.setImage(chicagoDeluxeImage); // Set the image
        } else if (selectedType == bbqchkRadioButton && chicagoRadioButton.isSelected()) {
            pizzaImageView.setImage(chicagoBBQChickenImage); // Set the image
        } else if (selectedType == meatzzaRadioButton && chicagoRadioButton.isSelected()) {
            pizzaImageView.setImage(chicagoMeatzzaImage); // Set the image
        } else if (selectedType == byoRadioButton && chicagoRadioButton.isSelected()) {
            pizzaImageView.setImage(chicagoBYOImage); // Set the image
        } else if (selectedType == deluxeRadioButton && newyorkRadioButton.isSelected()) {
            pizzaImageView.setImage(newYorkDeluxeImage); // Set the image
        } else if (selectedType == bbqchkRadioButton && newyorkRadioButton.isSelected()) {
            pizzaImageView.setImage(newYorkBBQChickenImage); // Set the image
        } else if (selectedType == meatzzaRadioButton && newyorkRadioButton.isSelected()) {
            pizzaImageView.setImage(newYorkMeatzzaImage); // Set the image
        } else if (selectedType == byoRadioButton && newyorkRadioButton.isSelected()) {
            pizzaImageView.setImage(newYorkBYOImage); // Set the image
        } else {
            pizzaImageView.setImage(null); // Clear the image for other selections
        }


        if (selectedType == deluxeRadioButton) {
            pizza = pizzaFactory.createDeluxe();
            updateToppingCheckBoxes(false);
            toppingsListTextArea.clear();
            toppingsListTextArea.setText("Sausage\nOnion\nPepperoni\nGreen Pepper\nMushroom");
            outputTextArea.setText("Selected Deluxe Pizza");
        } else if (selectedType == bbqchkRadioButton) {
            pizza = pizzaFactory.createBBQChicken();
            updateToppingCheckBoxes(false);
            toppingsListTextArea.clear();
            toppingsListTextArea.setText("BBQ Chicken\nProvolone\nCheddar\nBacon\nGreen Pepper");
            outputTextArea.setText("Selected BBQ Chicken Pizza");
        } else if (selectedType == meatzzaRadioButton) {
            pizza = pizzaFactory.createMeatzza();
            updateToppingCheckBoxes(false);
            toppingsListTextArea.clear();
            toppingsListTextArea.setText("Sausage\nPepperoni\nBeef\nHam");
            outputTextArea.setText("Selected Meatzza Pizza");
        } else if (selectedType == byoRadioButton) {
            pizza = pizzaFactory.createBuildYourOwn();
            updateToppingCheckBoxes(true);
            toppingsListTextArea.clear();
            outputTextArea.setText("Selected Build Your Own Pizza");
        }

        if(selectedSize != null && pizzaFactory != null && pizza != null) {
            updateSubtotalTextArea();
        }


    }


    public void submitOrderButton(ActionEvent actionEvent) {
        // Ensure a style is selected
        if (pizzaFactory == null) {
            outputTextArea.setText("Missing selection, please make sure every step is completed.");
            return;
        }

        // Get selected pizza type
        RadioButton selectedType = (RadioButton) typeToggleGroup.getSelectedToggle();
        if (selectedType == null) {
            outputTextArea.setText("Please select a pizza type!");
            return;
        }

        switch (selectedType.getText().toLowerCase()) {
            case "deluxe":
                pizza = pizzaFactory.createDeluxe();
                break;
            case "bbq chicken":
                pizza = pizzaFactory.createBBQChicken();
                break;
            case "meatzza":
                pizza = pizzaFactory.createMeatzza();
                break;
            case "build your own (up to 7 toppings)":
                pizza = pizzaFactory.createBuildYourOwn();
                for (String topping : selectedToppings) {
                    pizza.addTopping(Topping.valueOf(topping.toUpperCase().replace(" ", "_")));
                }
                break;
            default: // Should never happen
                outputTextArea.setText("Invalid pizza type selected.");
                return;
        }


        // Determine the style based on the factory
        String style = (pizzaFactory instanceof ChicagoPizza) ? "Chicago" : "New York";

        // Add the pizza to the order
        order.addPizza(pizza);

        outputTextArea.setText("Order submitted: " + pizza + " (" + style + " Style)");

        resetSelections();
    }

    private void updateSubtotalTextArea() {
        double subtotal = pizza.price();
        subtotalTextArea.setText(String.format("$%.2f", subtotal)); // Format the price to two decimal places
    }

    public void clearOrderButton(ActionEvent actionEvent) {
        selectedToppings.clear(); // Clear selected toppings
        updateToppingsTextArea(); // Clear the TextArea
        updateToppingCheckBoxes(false); // Disable CheckBoxes
        typeToggleGroup.getToggles().forEach(toggle -> ((RadioButton) toggle).setSelected(false)); // Clear pizza type selection
        styleToggleGroup.getToggles().forEach(toggle -> ((RadioButton) toggle).setSelected(false)); // Clear pizza style selection
        sizeComboBox.getSelectionModel().clearSelection(); // Clear size selection
        outputTextArea.setText("Order cleared.");
    }

    public void handleToppingCheckBox(ActionEvent actionEvent) {
        CheckBox source = (CheckBox) actionEvent.getSource(); // Get the clicked CheckBox
        String topping = source.getText();

        if (source.isSelected()) {
            if (selectedToppings.size() < MAX_TOPPINGS) {
                selectedToppings.add(topping);
                updateToppingCheckBoxes(true);
            } else {
                source.setSelected(false);
                outputTextArea.setText("You may only select up to " + MAX_TOPPINGS + " toppings.");
            }
        } else {
            selectedToppings.remove(topping);
            updateToppingCheckBoxes(false);
        }

        updateToppingsTextArea();
    }


    private void updateToppingsTextArea() {
        StringBuilder toppingsList = new StringBuilder();
        for (String topping : selectedToppings) {
            toppingsList.append(topping).append("\n");
        }
        toppingsListTextArea.setText(toppingsList.toString());
    }

    private void updateToppingCheckBoxes(boolean enable) {
        // Map CheckBox to Topping
        Map<CheckBox, Topping> checkBoxToppingMap = new HashMap<>();
        checkBoxToppingMap.put(sausageCheckBox, Topping.SAUSAGE);
        checkBoxToppingMap.put(onionCheckBox, Topping.ONION);
        checkBoxToppingMap.put(pepperoniCheckBox, Topping.PEPPERONI);
        checkBoxToppingMap.put(greenPepperCheckBox, Topping.GREEN_PEPPER);
        checkBoxToppingMap.put(mushroomCheckBox, Topping.MUSHROOM);
        checkBoxToppingMap.put(bbqchkCheckBox, Topping.BBQ_CHICKEN);
        checkBoxToppingMap.put(provoloneCheckBox, Topping.PROVOLONE);
        checkBoxToppingMap.put(cheddarCheckBox, Topping.CHEDDAR);
        checkBoxToppingMap.put(baconCheckBox, Topping.BACON);
        checkBoxToppingMap.put(beefCheckBox, Topping.BEEF);
        checkBoxToppingMap.put(hamCheckBox, Topping.HAM);
        checkBoxToppingMap.put(oliveCheckBox, Topping.OLIVE);
        checkBoxToppingMap.put(pineappleCheckBox, Topping.PINEAPPLE);

        for (CheckBox checkBox : checkBoxToppingMap.keySet()) {
            Topping topping = checkBoxToppingMap.get(checkBox);

            // Enable or disable the checkbox
            checkBox.setDisable(!enable);

            if (!enable) {
                // Clear selection and remove topping if disabling
                checkBox.setSelected(false);
                if (pizza != null) {
                    pizza.getToppings().remove(topping);
                }
            } else {
                // Add a listener for real-time updates
                checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
                    if (pizza != null) {
                        if (newValue) {
                            // Add topping if selected
                            pizza.addTopping(topping);
                        } else {
                            // Remove topping if deselected
                            pizza.removeTopping(topping);
                        }

                        // Update subtotal dynamically
                        updateSubtotalTextArea();

                    }
                });
            }
        }
    }


    private void resetSelections() {
        chicagoRadioButton.setSelected(false);
        newyorkRadioButton.setSelected(false);
        deluxeRadioButton.setSelected(false);
        bbqchkRadioButton.setSelected(false);
        meatzzaRadioButton.setSelected(false);
        byoRadioButton.setSelected(false);
        updateToppingCheckBoxes(false);
        sizeComboBox.getSelectionModel().clearSelection();
        toppingsListTextArea.clear();
        subtotalTextArea.clear();
    }



    public void continueButton(ActionEvent actionEvent) {
        try {
            // Ensure the correct path to the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/rupizzeria/finalize-view.fxml"));
            Parent root = loader.load();

            // Get the current stage
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            FinalizeViewController finalizeViewController = loader.getController();
            finalizeViewController.setOrder(order);

            // Set the new scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
