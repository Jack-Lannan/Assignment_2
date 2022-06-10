import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student s = new Student();

    @Test
    void Student() {
        Student s2 = new Student("S,9999,test,hello");
        assertEquals("Academic record for hello test(9999)\n" +
                "Degree: Science\n",s2.writeRecord());
    }

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
        s.setStudentID("newID.D");
        assertEquals("newID.D",s.getStudentID());
    }

    @Test
    void getFamilyName() {
        s.setFamilyName("Jones");
        assertEquals("Jones", s.getFamilyName());
    }


    @Test
    void getGivenName() {
        s.setGivenName("Mary");
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
    void writeRecord() {
        Student student = new Student("S,1234,bob,bob");
        student.addResult("R,9800123,PSYC0123,FL,42");
        assertEquals("Academic record for bob bob(1234)" + '\n' + "Degree: Science" + '\n' + "PSYC0123 FL 42" + '\n',student.writeRecord());
    }

    @Test
    void testToString() {

    }
}