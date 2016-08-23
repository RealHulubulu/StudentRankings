/**
 * Created by karas_000 on 8/20/2016.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadWriteFiles {

    //final static String writaAFile = "C:\\Users\\karas_000\\Desktop\\ReadWriteJava\\input.txt";
    //final static String OUTPUT_FILE_NAME = "C:\\Temp\\output.txt";
    final static Charset ENCODING = StandardCharsets.UTF_8;
    private static int numberOfLines = 1;
    private static ArrayList arrayOfFile;



    void readTextFile(String aFileName) throws IOException {
        Path path = Paths.get(aFileName);
        //int arrayPosition = 0;
        //String[] readLines = new String[numberOfLines]; // only works with fixed size array
        ArrayList readLines = new ArrayList();
        try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)){
            String line = null;
            while ((line = reader.readLine()) != null){ //
                //process each line in some way
                //System.out.println(line);
                log(line);
                //readLines[arrayPosition] = line;
                readLines.add(line);
                //arrayPosition++;
                numberOfLines++;
            }
            arrayOfFile = readLines;
        }
    }
    public static int getNumberOfLines(){
        return numberOfLines - 1;
    }
    public static ArrayList getArrayOfFile(){
        return arrayOfFile;
    }

    void displayArrayOfFile(){
        System.out.println(arrayOfFile);

    }

    void writeTextFile(String aFileName, List<String> aLines) throws IOException {
        Path path = Paths.get(aFileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, ENCODING)){
            for(String line : aLines){
                writer.write(line);
                writer.newLine();
            }
        }
    }

    private static void log(Object aMsg){
        System.out.println(String.valueOf(aMsg));
    }

}

