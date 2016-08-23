/**
 * Created by karas_000 on 8/16/2016.
 */
public class StudentCreation {

    private String name;
    private double gpa;
    private String gradeLevel;
    private static int studentPopulation = 0;
    //public int rankingNumber;

    public StudentCreation(String studentName, double studentGPA, String studentGradeLevel) {
        name = studentName;
        gpa = studentGPA;
        gradeLevel = studentGradeLevel;
        studentPopulation++;


    }

    public static int getStudentPopulation() {
        return studentPopulation;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return gpa;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public String toString() {
        return name + "\t" + gpa + "\t" + gradeLevel;
    }
}
