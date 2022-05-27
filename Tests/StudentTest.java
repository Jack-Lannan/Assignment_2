import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student s = new Student();

    @Test
    void setStudentID() {
        s.setStudentID("newID.D");
    }

    @Test
    void setFamilyName() {
        s.setFamilyName("Jones");
    }

    @Test
    void setGivenName() {
        s.setGivenName("Mary");
    }

    @Test
    void getStudentID() {
        assertEquals("newID.D",s.getStudentID());
    }

    @Test
    void getFamilyName() {
        assertEquals("jones", s.getFamilyName());
    }


    @Test
    void getGivenName() {
        assertEquals("Mary",s.getGivenName());
    }


    @Test
    void addResult() {
        s.addResult("R,9800123,PSYC0123,FL,42");

    }

    @Test
    void getResults() {
        Student student = new Student("S,1234,bob,bob");
        student.addResult("R,9800123,PSYC0123,FL,42");
        int thing[] = student.getResult("PSYC,1");
       assertEquals(Arrays.stream(thing).sum(), 42);

    }

    @Test
    void writeResults() {
        s.addResult("R,9800123,PSYC0123,FL,42");
        s.addResult("R,9800123,COMP9000,HD,100");
        System.out.println(s.writeResults());
    }

    @Test
    void getTopicCount() {
        s.addResult("R,9800123,PSYC0123,FL,42");
        s.addResult("R,9800123,COMP9000,HD,100");
        assertEquals(2,s.getTopicCount());
    }

    @Test
    void writeHeader() {

    }
    @Test
    void writeRecord() {
        Student student = new Student("S,1234,bob,bob");
        student.addResult("R,9800123,PSYC0123,FL,42");
        assertEquals("Academic record for bob bob(1234)" + '\n' + "Degree: Science" + '\n' + "PSYC0123 FL 42" + '\n',student.writeRecord());
    }

    @Test
    void testToString() {

    }
}