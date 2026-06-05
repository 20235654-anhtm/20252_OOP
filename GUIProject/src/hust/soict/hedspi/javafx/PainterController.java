package hust.soict.hedspi.javafx;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class PainterController {
    @FXML private Pane drawingAreaPane;
    @FXML private RadioButton penRadio;
    @FXML private RadioButton eraserRadio;

    private Color currentColor = Color.BLACK;
    private final ToggleGroup toolGroup = new ToggleGroup();

    @FXML
    public void initialize() {
        penRadio.setToggleGroup(toolGroup);
        eraserRadio.setToggleGroup(toolGroup);
        penRadio.setSelected(true);
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        drawCircle(event);
    }

    @FXML
    void drawingAreaMousePressed(MouseEvent event) {
        drawCircle(event);
    }

    private void drawCircle(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, currentColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void clearButtonPressed() {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void setPen() {
        currentColor = Color.BLACK;
    }

    @FXML
    void setEraser() {
        currentColor = Color.WHITE;
    }
}