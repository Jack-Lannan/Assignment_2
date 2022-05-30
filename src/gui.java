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
                System.out.println(Character.toString(degreeComboBox.getSelectedItem().toString().charAt(0)) + ',' + studentNumberText.getText() + ',' + familyNameText.getText() + ',' + givenNameText.getText());
                sd.addStudent(Character.toString(degreeComboBox.getSelectedItem().toString().charAt(0)) + ',' + studentNumberText.getText() + ',' + familyNameText.getText() + ',' + givenNameText.getText());
                sd.printRecords();
            }
        });
//        Print All Records Button (Add a seperate popout panel?)
        printAllRecordsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sd.NUMBER_OF_STUDENTS == 0) {
                    System.out.println("There is no available data.");
                }
                else {
                    sd.printRecords();
                }
            }
        });
//      Clear Everything
        clearAllRecordsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sd.clearRecords();
                System.out.println("All data has been cleared from the Database.");
            }
        });
//      Find Student (Need to change the degree combobox?)
        findStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student foundStudent = sd.findStudent(studentNumberText.getText());
                if (foundStudent != null) {
                    givenNameText.setText(foundStudent.getGivenName());
                    familyNameText.setText(foundStudent.getFamilyName());
                }
                else {
                    JOptionPane.showMessageDialog(null, "No Student with this ID in database.");
            }
        }

    });
//      Add Topic Result Button
        addTopicResultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student foundStudent = sd.findStudent(studentNumberText.getText());
                if (studentNumberText.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Student ID entered, please enter a Student ID.");
                }
                else if (foundStudent == null) {
                    JOptionPane.showMessageDialog(null, "No Student with this ID exists, check the ID and try again.");
                    }
                else if (gradeCombobox.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "No Grade has been selected, please select a grade.");
                }
                else if (topicCodeText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No Topic Code entered, please select a topic code.");
                }
                else {
                    String awardedGrade = gradeCombobox.getSelectedItem().toString();
                    String enteredTopic = topicCodeText.getText();
                    String awardedMark = markText.getText();
                    foundStudent.addResult("R" + ',' + foundStudent.getStudentID() + ',' + enteredTopic + ',' + awardedGrade + ',' + awardedMark);
                }
            }
        });

//      Find Topic Button
        findTopicResultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student foundStudent = sd.findStudent(studentNumberText.getText());
                //if (topicCodeText.getText().contains(foundStudent.writeResults())) {
                 //   gradeCombobox.
                String results = foundStudent.writeResults();
                System.out.println(results);
                //}
                }



        });
    }
    }