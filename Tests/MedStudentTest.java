import jdk.jfr.Label;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MedStudentTest {

    static MedStudent student;
    static MedStudent student1;
    @BeforeAll
    static void before(){
        student = new MedStudent("test,98575,Test,First,TheWorld");
        student1 = new MedStudent("test1");
    }

    @Test
    void MedStudent(){
        assertEquals("test1",student1.getFamilyName());
    }

    @Test
    void addPrize() {
        student.addPrize("Tunes");
        List<String> list = new ArrayList<>();
        list.add("TheWorld");
        list.add("Tunes");
        assertEquals(list, student.getPrizes());
    }

    @Test
    void getPrizes() {
        student.addPrize("Tunes");
        List<String> list = new ArrayList<>();
        list.add("TheWorld");
        list.add("Tunes");
        assertEquals(list, student.getPrizes());
    }

    @Test
    void writeRecord() {

    }
}