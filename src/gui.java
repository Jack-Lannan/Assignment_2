import jdk.jfr.Label;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class gui {
    StudentDatabase sd = new StudentDatabase();
    private JButton addTopicResultButton;
    private JButton findTopicResultButton;
    private JTextField studentNumberText;
    private JTextField familyNameText;
    private JTextField givenNameText;
    private JComboBox gradeCombobox;
    private JComboBox degreeComboBox;
    private JTextField topicCodeText;
    private JTextField markText;
    private JTextField degreeMajorText;
    private JTextField degreeMinorText;
    private JButton findStudentButton;
    private JList prizesList;
    private JButton addStudentButton;
    private JTextField prizeNameText;
    private JTextField courseNameText;
    private JTextField topicNumberText;
    private JButton clearAllRecordsButton;
    private JButton printAllRecordsButton;
    private JButton awardPrizeButton;
    private JPanel studentButtons;
    private JPanel recordButtons;
    private JPanel studentDetails;
    private JLabel studentNumber;
    private JLabel familyName;
    private JLabel degree;
    private JPanel databaseMainPanel;
    private JPanel topicDetails;
    private JPanel topicDetailsPanel;
    private JLabel topicCodeLabel;
    private JLabel gradeLabel;
    private JLabel markLabel;
    private JPanel degreeOptionsPanel;
    private JLabel degreeMajorLabel;
    private JLabel prizesLabel;
    private JLabel degreeMinorLabel;
    private JPanel awardPrizesPanel;
    private JLabel prizeNameLabel;
    private JLabel topicNumberLabel;
    private JLabel courseNameLabel;
    private JLabel databaseProgramLabel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Database");
        frame.setContentPane(new gui().databaseMainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public gui() {
//      Add Student Button
        addStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(studentNumberText.getText());
                sd.addStudent(Character.toString(degreeComboBox.getSelectedItem().toString().charAt(0)) + ',' + studentNumberText.getText() + ',' + familyNameText.getText() + ',' + givenNameText.getText());
                sd.printRecords();
            }
        });
//        Print All Records Button
        printAllRecordsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sd.printRecords();
            }
        });
//      Clear Everything
        clearAllRecordsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sd.clearRecords();
                System.out.println("All data has been cleared from the Database.");
            }
        });
//

        /*findStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student test = new Student();
                test.setFamilyName("tester");
                test.setStudentID("12345");
                Student foundStudent = new StudentDatabase().findStudent(studentNumberText.toString());
                System.out.println(foundStudent);
                familyNameText.setText(foundStudent.getFamilyName());
            }
        });*/

    }

}
