import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

class StudentDatabaseTest {
    StudentDatabase newStudent = new StudentDatabase();

    @Test
    void addStudent() {

        newStudent.addStudent("S,9990099,Smith,John");
        newStudent.addStudent("M,9990199,Mary,Moo,Chemistry Prize 1998");

    }

    @Test
    void findStudent() {
        newStudent.addStudent("M,9990199,Mary,Moo,Chemistry Prize 1998");
        assertEquals("Mary Moo",newStudent.findStudent("9990199").getFamilyName() + " "
        + newStudent.findStudent("9990199").getGivenName());

    }

    @Test
    void addResult() {

    }

    @Test
    void awardPrize() {


    }

    @Test
    void printRecords() {
        newStudent.addStudent("M,9990199,Mary,Moo,Chemistry Prize 1998");

        newStudent.printRecords();

    }

    @Test
    void clearRecords() {
        newStudent.addStudent("M,9990199,Mary,Moo,Chemistry Prize 1998");

        System.out.println(newStudent.findStudent("9990199").getFamilyName() + " "
                + newStudent.findStudent("9990199").getGivenName());

        newStudent.clearRecords();

        assertNull(newStudent.findStudent("9990199"),"Should be Null");
    }
}
