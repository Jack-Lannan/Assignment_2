import jdk.jfr.Label;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


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

        degreeMajorText.setEnabled(false);
        degreeMinorText.setEnabled(false);
        prizeNameText.setEnabled(false);
        courseNameText.setEnabled(false);
        topicNumberText.setEnabled(false);

//      Disables the degree fields if 'Arts' is not selected
        degreeComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (degreeComboBox.getSelectedIndex() == 1) {
                    degreeMajorText.setEnabled(true);
                    degreeMinorText.setEnabled(true);
                }
                else {
                    degreeMajorText.setEnabled(false);
                    degreeMinorText.setEnabled(false);
                }
            }
        });

   //   Disables the prize panel if 'Medical' is not selected
        degreeComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (degreeComboBox.getSelectedIndex() == 3) {
                    prizeNameText.setEnabled(true);
                    courseNameText.setEnabled(true);
                    topicNumberText.setEnabled(true);
                }
                else {
                    prizeNameText.setEnabled(false);
                    courseNameText.setEnabled(false);
                    topicNumberText.setEnabled(false);
                }
            }
        });

//      Add Student Button
        addStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (degreeComboBox.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "No degree has been selected, please select a degree.");
                }
                else if (studentNumberText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No student ID has been entered, please enter a student ID.");
                }
                else if (familyNameText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No family name has been entered, please enter a family name.");
                }
                else if (givenNameText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No given name has been entered, please enter a given name.");
                }
                else if (degreeComboBox.getSelectedIndex() == 1) {

                    if (degreeMajorText.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No degree major has been entered, please enter a major.");
                    }
                    else if (degreeMinorText.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No degree minor has been entered, please enter a minor.");
                    }

                    else {
                        System.out.println(studentNumberText.getText());
                        System.out.println(Character.toString(degreeComboBox.getSelectedItem().toString().charAt(0)) + ',' + studentNumberText.getText() + ',' + familyNameText.getText() + ',' + givenNameText.getText() + ',' + degreeMajorText.getText() + ',' + degreeMinorText.getText());
                        sd.addStudent(Character.toString(degreeComboBox.getSelectedItem().toString().charAt(0)) + ',' + studentNumberText.getText() + ',' + familyNameText.getText() + ',' + givenNameText.getText() + ',' + degreeMajorText.getText() + ',' + degreeMinorText.getText());
                        sd.printRecords();
                    }
                }
                else {
                    System.out.println(studentNumberText.getText());
                    System.out.println(Character.toString(degreeComboBox.getSelectedItem().toString().charAt(0)) + ',' + studentNumberText.getText() + ',' + familyNameText.getText() + ',' + givenNameText.getText());
                    sd.addStudent(Character.toString(degreeComboBox.getSelectedItem().toString().charAt(0)) + ',' + studentNumberText.getText() + ',' + familyNameText.getText() + ',' + givenNameText.getText());
                    sd.printRecords();
                }
            }
        });


//        Print All Records Button (Add a seperate popout panel?)
        printAllRecordsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sd.getDb().size() == 0) {
                    System.out.println("There is no available data.");
                    JOptionPane.showMessageDialog(null, "There is no available data.");
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
                JOptionPane.showMessageDialog(null, "All data has been cleared from the Database.");
            }
        });
//      Find Student (Need to change the degree combobox?)
        findStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student foundStudent = sd.findStudent(studentNumberText.getText());
                if (foundStudent != null) {
                    givenNameText.setText(foundStudent.getGivenName());
                    familyNameText.setText(foundStudent.getFamilyName());
                    degreeComboBox.setSelectedItem(foundStudent.degree);
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

//      Award Prize Button
        awardPrizeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student foundStudent = sd.findStudent(studentNumberText.getText());
                if (prizeNameText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No prize name entered, please enter a prize name.");
                }
                else if (courseNameText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No course entered, please enter a course.");
                }
                else if (topicNumberText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No topic number entered, please enter the minimum number of topics.");
                }
                else {
                    System.out.println("Testing the prize alerts");
                }

            }
        });
    }
    }