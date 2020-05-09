package sample;

import javafx.scene.paint.Color;

public class RandomRecords {

    public static Record[] randomiseRecords(int numberOfRecords, int range){
        Record[] arrayOfRecords = new Record[numberOfRecords];
        for (int i=0; i<numberOfRecords ;i++){
            arrayOfRecords[i] = new Record(((int) (Math.random() * range)) + 7);    //added 7 so there's no possibility that a record will be of a height of 0 or 1 so basically invisible
            arrayOfRecords[i].setX(i * ((SortingController.WINDOW_WIDTH  - SortingController.BUTTONROW_BOUNDARY)/ arrayOfRecords.length));
            arrayOfRecords[i].setY(SortingController.WINDOW_HEIGHT - arrayOfRecords[i].getValue());
            arrayOfRecords[i].setFill(Color.valueOf("black"));
            setRecordDimensios(arrayOfRecords[i], arrayOfRecords.length);
        }
        return arrayOfRecords;
    }

    private static void setRecordDimensios(Record record, int n) {
        record.setWidth(SortingController.WINDOW_WIDTH / n - SortingController.xGap);
        record.setHeight(record.getValue());
    }
}
