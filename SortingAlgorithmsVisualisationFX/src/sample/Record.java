package sample;
import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Record extends Rectangle {
    private int value;

    public Record(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public TranslateTransition moveToX(int x) {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(this);
        translateTransition.setDuration(Duration.millis(50));
        translateTransition.setByX(x);

        return translateTransition;
    }
}
