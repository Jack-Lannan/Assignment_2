import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentDatabaseTest {
    static StudentDatabase newStudent;

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
        newStudent.addResult("R,9990099,COMP1001,DN,77");
        newStudent.addResult("R,9990099,MEDD0119,HD,86");
        newStudent.addResult("R,9990199,COMP1011,HD,99");
        newStudent.addResult("R,9990099,MEDD0139,CR,75");
        newStudent.addResult("R,9990099,MEDD0129,HD,96");

        assertEquals("Academic record for John Smith(9990099)\n" +
                "Degree: Science\n" +
                "COMP1001 DN 77\n" +
                "MEDD0119 HD 86\n" +
                "MEDD0139 CR 75\n" +
                "MEDD0129 HD 96\n",
                newStudent.findStudent("9990099").writeRecord());
    }

    @Test
    void awardPrize() {
        newStudent.addStudent("M,9999999,Jim,Bob");
        newStudent.addResult("R,9999999,ENGR1000,HD,100");
        newStudent.awardPrize("Theo", "ENGR", 1);
        assertEquals("Academic record for Bob Jim(9999999)\n" +
        "Degree: Medicine\n"+
        "Prize: Theo\n" +
        "ENGR1000 HD 100\n"
                ,newStudent.findStudent("9999999").writeRecord());

    }
    @Test
    void printRecords() {
        newStudent.addResult("E,9990099,MEDD0139,HD,100");

        assertEquals("Academic record for John Smith(9990099)\n" +
                "Degree: Science\n" +
                "MEDD0139 HD 100\n",newStudent.findStudent("9990099").writeRecord());
    }


   @Test
    void clearRecords() {
        newStudent.clearRecords();
        assertEquals(newStudent.getDb().toString(),"[]");
    }
}