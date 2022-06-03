import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


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
    private JTextArea prizesList;
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
    private JButton insertButton;
    private JTextField fileField;
    private JButton insertFileButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Database");
        frame.setContentPane(new gui().databaseMainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void clear(){
        studentNumberText.setText("");
        topicCodeText.setText("");
        markText.setText("");
        familyNameText.setText("");
        givenNameText.setText("");
        gradeCombobox.setSelectedIndex(0);
        degreeComboBox.setSelectedIndex(0);
    }

    public gui() {
        degreeMajorText.setEnabled(false);
        degreeMajorText.setBackground(Color.lightGray);
        degreeMinorText.setEnabled(false);
        degreeMinorText.setBackground(Color.lightGray);
        prizeNameText.setEnabled(false);
        prizeNameText.setBackground(Color.lightGray);
        courseNameText.setEnabled(false);
        courseNameText.setBackground(Color.lightGray);
        topicNumberText.setEnabled(false);
        topicNumberText.setBackground(Color.lightGray);
        awardPrizeButton.setEnabled(false);
        prizesList.setEnabled(false);
        prizesList.setBackground(Color.lightGray);
        addStudentButton.setText("Add Student");
        degreeComboBox.setSelectedIndex(0);



//      Disables the degree fields if 'Arts' is not selected
        degreeComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (degreeComboBox.getSelectedIndex() == 1) {
                    degreeMajorText.setEnabled(true);
                    degreeMajorText.setBackground(Color.white);
                    degreeMinorText.setEnabled(true);
                    degreeMinorText.setBackground(Color.white);
                }
                else {
                    degreeMajorText.setEnabled(false);
                    degreeMajorText.setBackground(Color.lightGray);
                    degreeMinorText.setEnabled(false);
                    degreeMinorText.setBackground(Color.lightGray);
                }
            }
        });

   //   Disables the prize panel if 'Medical' is not selected
        degreeComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (degreeComboBox.getSelectedIndex() == 3) {
                    prizeNameText.setEnabled(true);
                    prizeNameText.setBackground(Color.white);
                    courseNameText.setEnabled(true);
                    courseNameText.setBackground(Color.white);
                    topicNumberText.setEnabled(true);
                    topicNumberText.setBackground(Color.white);
                    awardPrizeButton.setEnabled(true);
                    prizesList.setBackground(Color.white);
                }
                else {
                    prizeNameText.setEnabled(false);
                    prizeNameText.setBackground(Color.lightGray);
                    courseNameText.setEnabled(false);
                    courseNameText.setBackground(Color.lightGray);
                    topicNumberText.setEnabled(false);
                    topicNumberText.setBackground(Color.lightGray);
                    awardPrizeButton.setEnabled(false);
                    prizesList.setBackground(Color.lightGray);
                }
            }
        });
        insertFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sd.insertFile(fileField.getText(), sd);
            }
        });
//      Add Student Button
        addStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student foundStudent = sd.findStudent(studentNumberText.getText());
                if (addStudentButton.getText().equals("Enter New Student")) {
                    clear();
                    addStudentButton.setText("Add Student");
                }

               else if (degreeComboBox.getSelectedIndex() == 0) {
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
                        if (foundStudent != null) {
                            clear();
                            JOptionPane.showMessageDialog(null, "Student already exists, please check the ID and try again.");
                        }
                        else {
                            System.out.println(studentNumberText.getText());
                            System.out.println(Character.toString(degreeComboBox.getSelectedItem().toString().charAt(0)) + ',' + studentNumberText.getText() + ',' + familyNameText.getText() + ',' + givenNameText.getText() + ',' + degreeMajorText.getText() + ',' + degreeMinorText.getText());
                            sd.addStudent(Character.toString(degreeComboBox.getSelectedItem().toString().charAt(0)) + ',' + studentNumberText.getText() + ',' + familyNameText.getText() + ',' + givenNameText.getText() + ',' + degreeMajorText.getText() + ',' + degreeMinorText.getText());
                            System.out.println("Student " + studentNumberText.getText() + " has been added");
                            addStudentButton.setText("Enter New Student");
                        }
                    }
                }
                else {
                    if (foundStudent != null) {
                        clear();
                        JOptionPane.showMessageDialog(null, "Student already exists, please check the ID and try again.");
                    }
                    else {
                        System.out.println(studentNumberText.getText());
                        System.out.println(Character.toString(degreeComboBox.getSelectedItem().toString().charAt(0)) + ',' + studentNumberText.getText() + ',' + familyNameText.getText() + ',' + givenNameText.getText());
                        sd.addStudent(Character.toString(degreeComboBox.getSelectedItem().toString().charAt(0)) + ',' + studentNumberText.getText() + ',' + familyNameText.getText() + ',' + givenNameText.getText());
                        System.out.println("Student " + studentNumberText.getText() + " has been added");
                        addStudentButton.setText("Enter New Student");
                    }
                }
            }
        });


//      Print All Records Button (Add a seperate popout panel?)
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
//      Find Student Button
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
                    String enteredTopic = topicCodeText.getText().toUpperCase();
                    String awardedMark = markText.getText();
                    foundStudent.addResult("R" + ',' + foundStudent.getStudentID() + ',' + enteredTopic + ',' + awardedGrade + ',' + awardedMark, sd);
                    sd.writeToFile(sd);
                }
            }
        });





//      Find Topic Button
        findTopicResultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sd.findStudent(studentNumberText.getText()) == null){
                    JOptionPane.showMessageDialog(null, "No Topic Code entered, please select a topic code.");

                    return;
                }
                Student foundStudent = sd.findStudent(studentNumberText.getText());
                String topicCode = topicCodeText.getText().toUpperCase();
                Result[] results = foundStudent.getResults();
                    for (int i = 0; i < results.length; i++) {

                        if (results[i] != null) {
                            if (results[i].getCode().equals(topicCode)) {
                                if (results[i].getMark() == -1) {
                                    gradeCombobox.setSelectedItem(results[i].getGrade());
                                    markText.setText("");
                                    break;
                                }
                                else {
                                    gradeCombobox.setSelectedItem(results[i].getGrade());
                                    markText.setText(Integer.toString(results[i].getMark()));
                                    break;
                                }
                            }
                        }else{
                            System.out.println(results[i]);
                            topicCodeText.setText("");
                            gradeCombobox.setSelectedIndex(0);
                            markText.setText("");
                            JOptionPane.showMessageDialog(null, "No topic code found.");
                            break;
                        }
                    }
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