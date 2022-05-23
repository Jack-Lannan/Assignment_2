import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtsStudentTest {
    static ArtsStudent student;
    @BeforeAll
    static void before(){
        student = new ArtsStudent("test,98575,Test,First,Games,Linguistics");
    }

    @Test
    void getMajor() {
        assertEquals("Games",student.getMajor());
    }

    @Test
    void getMinor() {
        assertEquals("Linguistics",student.getMinor());
    }

    @Test
    void writeRecord() {
        assertEquals("Academic record for " + "First" + " " + "Test" + "(" + "98575" + ")" + '\n'
                + "Degree: " + "Arts" + '\n'
                + "Major: " + "Games" + '\n'
                + "Minor: " + "Linguistics" + '\n'
                + student.writeResults(),student.writeRecord());
    }
}