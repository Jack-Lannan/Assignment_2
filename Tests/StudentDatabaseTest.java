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
    }

    @Test
    void awardPrize() {
    }

    @Test
    void printRecords() {
    }

    @Test
    void clearRecords() {
    }
}