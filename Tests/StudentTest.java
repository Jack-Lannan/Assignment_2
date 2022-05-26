import org.junit.jupiter.api.Test;

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
//        s.addResult();
    }

    @Test
    void getResults() {
    }

    @Test
    void writeResults() {
    }

    @Test
    void getTopicCount() {
        assertEquals(0,s.getTopicCount());
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