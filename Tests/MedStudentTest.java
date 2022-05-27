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
    static MedStudent student2;
    @BeforeAll
    static void before(){
        student = new MedStudent("test,98575,Test,First,TheWorld");
        student1 = new MedStudent("test1");
        student2 = new MedStudent("M,95656,Jones,Mary,Chemistry Prize 1998");
        student2.addResult("R,95656,CHEM0001,HD,92");
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
        student.addPrize("test");
        List<String> list = new ArrayList<>();
        list.add("TheWorld");
        list.add("Tunes");
        list.add("test");
        assertEquals(list, student.getPrizes());
    }

    @Test
    void writeRecord() {
        assertEquals("Academic record for Mary Jones(95656)\n" +
                        "Degree: Medicine\n" +
                        "Prize: Chemistry Prize 1998\n" +
                        "CHEM0001 HD 92\n"
                , student2.writeRecord());
    }
}