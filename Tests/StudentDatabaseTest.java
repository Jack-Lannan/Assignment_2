import org.junit.jupiter.api.Test;

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
        assertEquals("Moo Mary",newStudent.findStudent("9990199"));
    }

    @Test
    void addResult() {
        newStudent.addResult("R,9990199,COMP1001,DN,77");
        newStudent.addResult("R,9990199,MEDD0119,HD,86");
        newStudent.addResult("R,9990099,COMP1011,HD,99");
    }

    @Test
    void awardPrize() {
        newStudent.awardPrize();
    }

    @Test
    void printRecords() {
        newStudent.printRecords();
    }

    @Test
    void clearRecords() {
    }
}