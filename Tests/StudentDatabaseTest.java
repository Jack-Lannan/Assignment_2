import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class StudentDatabaseTest {
    static StudentDatabase newStudent;
    static StudentDatabase empty;

    @BeforeAll
    static void before(){
        newStudent = new StudentDatabase();
        newStudent.addStudent("S,9990099,Smith,John");
        newStudent.addStudent("M,9990199,Mary,Moo,Chemistry Prize 1998");
    }

    @Test
    void addStudent() {
        newStudent.addStudent("S,9990099,Smith,John");
        newStudent.addStudent("M,9990199,Mary,Moo,Chemistry Prize 1998");
    }

    @Test
    void findStudent() {
//        newStudent.addStudent("M,9990199,Mary,Moo,Chemistry Prize 1998");
        assertEquals("Mary",newStudent.findStudent("9990199").getFamilyName());
    }

    @Test
    void addResult() {
        newStudent.addResult("R,9990199,COMP1001,DN,77");
        newStudent.addResult("R,9990199,MEDD0119,HD,86");
        newStudent.addResult("R,9990099,COMP1011,HD,99");
        newStudent.addResult("R,9990199,MEDD0139,CR,75");
        newStudent.addResult("R,9990199,MEDD0129,HD,96");
        newStudent.printRecords();
    }

   @Test
    void awardPrize() {
        newStudent.awardPrize("Theo", "MEDD", 2);
    }

    @Test
    void printRecords() {
        newStudent.addStudent("M,1234567,jim,joff");
        newStudent.addResult("R,1234567,MEDD0139,HD,100");
        newStudent.printRecords();
    }

   @Test
    void clearRecords() {
        newStudent.clearRecords();
        assertEquals(newStudent.getDb().toString(),"[]");
    }
}