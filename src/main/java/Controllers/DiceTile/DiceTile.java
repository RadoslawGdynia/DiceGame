package Controllers.DiceTile;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiceTile extends StackPane {
    public static final Logger log = LoggerFactory.getLogger(DiceTile.class);

    public DiceTile(Pane tPane, int value) {

        tPane.getChildren().add(this);
        Rectangle border = new Rectangle(80, 80);
        border.setStroke(Color.BLACK);
        border.setFill(Color.IVORY);
        Text text = new Text(value+"");
        text.setFont(Font.font("Calibri", 30));
        text.setTextAlignment(TextAlignment.CENTER);

        getChildren().addAll(border,text);
    }
}
