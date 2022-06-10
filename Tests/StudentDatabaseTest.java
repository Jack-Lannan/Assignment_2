import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class StudentDatabaseTest {
    static StudentDatabase newStudent;

    @BeforeAll
    static void before(){
        newStudent = new StudentDatabase();
        newStudent.addStudent("S,9990099,Smith,John");
        newStudent.addStudent("M,9990199,Mary,Moo,Chemistry Prize 1998");
    }

    @Test
    void getDB(){
        assertEquals("2",newStudent.getDb().toString());
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
        assertEquals("Academic record for Moo Mary(9990199)\n" +
                "Degree: Medicine\n" +
                "Prize: Chemistry Prize 1998\n" +
                "COMP1001 DN 77\n" +
                "MEDD0119 HD 86\n" +
                "MEDD0139 CR 75\n" +
                "MEDD0129 HD 96\n",
                newStudent.findStudent("9990199").writeRecord());
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
    void getMeds(){
        newStudent.addStudent("S,9990299,Maaa,Mooo");
        newStudent.getMeds();
    }

    @Test
    void printcharRecords(){
        assertEquals("Academic record for John Smith(9990099)\n" +
                "Degree: Science\n" +
                "COMP1011 HD 99\n" +
                "\n" +
                "Academic record for Moo Mary(9990199)\n" +
                "Degree: Medicine\n" +
                "Prize: Chemistry Prize 1998\n" +
                "Theo\n" +
                "COMP1001 DN 77\n" +
                "MEDD0119 HD 86\n" +
                "MEDD0139 CR 75\n" +
                "MEDD0129 HD 96\n" +
                "\n" +
                "Academic record for Mooo Maaa(9990299)\n" +
                "Degree: Science\n" +
                "\n" +
                "Academic record for John Smith(9990099)\n" +
                "Degree: Science\n" +
                "\n" +
                "Academic record for Moo Mary(9990199)\n" +
                "Degree: Medicine\n" +
                "Prize: Chemistry Prize 1998\n" +
                "\n",newStudent.printcharRecords());
    }

   @Test
    void clearRecords() {
        newStudent.clearRecords();
        assertEquals(newStudent.getDb().toString(),"[]");
    }
}