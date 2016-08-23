/**
 * Created by karas_000 on 8/16/2016.
 */
public class ArrayBuilder {

    public Object[][] array;
    String header; //changing to StudentCreation[][] array; and this to StudentCreation header; allows for object references to be in each cell
    //StudentCreation student = new StudentCreation("bob", 3.5, "Junior"); // by using this can I just populate the first column and have the sub arrays fill?


    public ArrayBuilder(int rows, int column){
        array = new Object[rows +1][column + 1];
        for (int i = 0; i <= column; i++) {
            //array[0][i] = header;
            switch (i){
                case 0: header = "Name";
                    break;
                case 1: header = "GPA";
                    break;
                case 2: header = "\tGradeLevel";
                        break;
            }
            array[0][i] = header;
        }
    }

    public void insert(String name, Object[] values) {
        for (int i = 1; i < array.length; i++) {
            if (array[i][0] == null) { // <- search for an empty row to insert the data there
                array[i][0] = name;
                array[i][1] = values;
                break;
            }
        }
    }

    /*private void insert(String name, Object[] values, int row) {
        array[row][0] = name; // <- write the name to the first column
        for (int j = 1; j < array[row].length; j++) { // <- data starts at the second column
            array[row][j] = values[j - 1]; // <- -1 because the num array is one column shorter than 'array' (due to the country name column in 'array')
        }
    }*/







}
