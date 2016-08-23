import java.io.IOException;
import java.util.*;

/**
 * Created by karas_000 on 8/16/2016.
 */
public class MainProgram {



        public static void main(String[] args) throws IOException {

            Scanner scan = new Scanner(System.in);
            int arraySelection = 0;
            int arraySize = 0;
            boolean addMembers = true;
            boolean addToArray = true;
            boolean correctInput = false;
            boolean setArraySize = false;
            double gpaInput = 0;
            final String writeAFile = "C:\\Users\\karas_000\\Desktop\\ReadWriteJava\\writtenfile.txt";
            final  String readAFile = "C:\\Users\\karas_000\\Desktop\\ReadWriteJava\\writtenfile.txt";
            List<String> myList = new ArrayList<String>();
            ReadWriteFiles readWriteFiles = new ReadWriteFiles();



            System.out.println("Welcome to Storing Students in an Array.");
            while(setArraySize == false) {
                try {
                    System.out.println("How many to store in the array?");
                    arraySize = scan.nextInt(); //throw new InputMismatchException();
                    if (arraySize < 0) {
                        throw new NegativeArraySizeException();
                    }
                }catch (InputMismatchException ime) {
                    System.out.println("Message: Input Error: Please input a positive integer value");
                }catch (NegativeArraySizeException nase) {
                    System.out.println("Message: Input Error: Please input a positive integer value");
                }
                if (arraySize > 0) {
                setArraySize = true;                }
                scan.nextLine();
            }

            StudentCreation[] createdStudents = new StudentCreation[arraySize];

            while (addMembers) {
                System.out.println("Information");
                System.out.println("Enter name: ");
                String nameInput = scan.nextLine();
                while(correctInput == false){
                    System.out.println("Enter gpa: ");
                    try {
                        gpaInput = Double.parseDouble(scan.nextLine());
                        if (gpaInput < 0 ) {
                            throw new GpaException();
                        }else if(gpaInput > 4){
                            throw new GpaException("GPA input greater than 4",700);
                        }

                    } catch (GpaException exception) {
                        System.out.println("Error Code:" + exception.getErrorCode());
                        System.out.println("Message: " + exception.getMessage());
                        System.out.println("Error: Input has to be double between 0 and 4 " + exception.getMessage());

                    }catch(NullPointerException npe){
                        npe.printStackTrace();
                    }catch (NumberFormatException nfe){
                        System.out.println("Error: Not a double");
                    }
                    if ( gpaInput > 0 && gpaInput <= 4)
                        correctInput = true;
                }
                correctInput = false;
                System.out.println("Enter grade level: ");
                String gradeLevelInput = scan.nextLine();



                StudentCreation newStudent = new StudentCreation(nameInput, gpaInput, gradeLevelInput);

                myList.add(nameInput);
                String numberAsString = Double.toString(gpaInput);
                myList.add(numberAsString);
                myList.add(gradeLevelInput);

                createdStudents[arraySelection] = newStudent;

                arraySelection++;

                if(arraySize == arraySelection) {
                    addToArray = false;
                    addMembers = false;
                }

                while (addToArray) { // can make this a do/while up to the array size value
                    System.out.println("Add Another to Array? Y/N");

                    char q = scan.next().charAt(0);
                    if (q == 'y' || q == 'Y') {
                        addMembers = true;
                        addToArray = false;
                        correctInput= false;
                    } else if (q == 'n' || q == 'N') {
                        addMembers = false;
                        addToArray = false;


                    } else {
                        System.out.println("Error: Please enter y or n");
                        addToArray = true;
                    }
                    scan.nextLine();
                }
                addToArray = true;
            }

          /*  //these are premade students using the StudentCreation class

            StudentCreation bob = new StudentCreation("Bob", 3.5, "Freshman");
            StudentCreation joe = new StudentCreation("Joe", 3.2, "Sophomore");
            StudentCreation jane = new StudentCreation("Jane", 2.5, "Junior");

            StudentCreation[] studentCreations = {bob, joe, jane};
*/

            for (int i = 0; i < createdStudents.length; i++) {
                System.out.println(createdStudents[i]);
            }

            System.out.println("Student Population: " + StudentCreation.getStudentPopulation());
            System.out.println("Number of Manual Entries: " + arraySize);

            readWriteFiles.writeTextFile(writeAFile,myList);
            System.out.println("Data written to text file: " + writeAFile);
            System.out.println("Data read from text file: " + readAFile + "\nWhat was read from the text file:");
            readWriteFiles.readTextFile(readAFile);


            System.out.println("Number of lines read:" + ReadWriteFiles.getNumberOfLines());
            System.out.println("1-D array of the data:" + ReadWriteFiles.getArrayOfFile());


            System.exit(0);

        }




}


