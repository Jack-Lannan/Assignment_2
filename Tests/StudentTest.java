import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    static Student student;

    @BeforeAll
    static void before() {student = new Student("test,98575,Test,First,TheWorld");}


    @Test
    void setStudentID() {
        student.setStudentID("95535");
        assertEquals("95535",student.getStudentID());
    }

    @Test
    void setFamilyName() {
        student.setFamilyName("Jeffries");
        assertEquals("Jeffries",student.getFamilyName());
    }

    @Test
    void setGivenName() {
        student.setGivenName("Jack");
        assertEquals("Jack",student.getGivenName());
    }

    @Test
    void getStudentID() {
        assertEquals("98575",student.getStudentID());
    }

    @Test
    void getFamilyName() {
        assertEquals("Test",student.getFamilyName());
    }


    @Test
    void getGivenName() {
        assertEquals("First",student.getGivenName());
    }

    //WIP
    @Test
    @BeforeAll
    void addResult() {
        student.addResult("COMP1000,HD,100");
        assertEquals("testing", student.getResult("TheWorld"));
    }
    //WIP
    @Test
    void getResults() {
        assertEquals("testing", student.getResult("TheWorld"));
    }

    @Test
    void writeResults() {
    }

    @Test
    void getTopicCount() {
    }

    @Test
    void writeHeader() {
    }

    @Test
    void writeRecord() {
    }

    @Test
    void testToString() {
    }
}