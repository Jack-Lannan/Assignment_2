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

    public gui() {
        degreeMajorText.setEnabled(false);
        degreeMajorText.setBackground(Color.lightGray);
        degreeMinorText.setEnabled(false);
        degreeMinorText.setBackground(Color.lightGray);
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

   //   button for inserting data files into the data files
        insertFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sd.insertFile(fileField.getText(), sd);
            }
        });
//      Add Student Button
        addStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student foundStudent = sd.findStudent(studentNumberText.getText());
                if (addStudentButton.getText().equals("Enter New Student")) {
                    studentNumberText.setText("");
                    familyNameText.setText("");
                    givenNameText.setText("");
                    degreeMajorText.setText("");
                    degreeMinorText.setText("");
                    degreeComboBox.setSelectedIndex(0);
                    addStudentButton.setText("Add Student");
                }
                else if (studentNumberText.getText().length() > 7) {
                    JOptionPane.showMessageDialog(null, "This student code is too long. Try again with a 7 digit number.");
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
                else if (familyNameText.getText().matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(null,"The Family Name field should not contain numbers. Try Again");
                }
                else if (givenNameText.getText().matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(null,"The Given Name field should not contain numbers. Try Again");
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
                            studentNumberText.setText("");
                            familyNameText.setText("");
                            givenNameText.setText("");
                            degreeComboBox.setSelectedItem(0);
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
                        studentNumberText.setText("");
                        familyNameText.setText("");
                        givenNameText.setText("");
                        degreeComboBox.setSelectedItem(0);
                        JOptionPane.showMessageDialog(null, "Student already exists, please check the ID and try again.");
                    }
                    else {
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
                    JFrame prtrcd = new JFrame("Academic Records");
                    JTextArea prtrcdta = new JTextArea(20,25);
                    prtrcdta.setEditable(false);
                    prtrcd.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    JPanel prtrcdjp = new JPanel();
                    prtrcdjp.add(prtrcdta);
                    prtrcd.add(prtrcdjp);
                    prtrcd.setSize(400,600);
                    prtrcdta.setText(sd.recordString());
                    prtrcd.setVisible(true);
                }
            }
        });
//      Clear Everything
        clearAllRecordsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int car = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear this Database? This cannot be reversed.", "Delete All Records", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (car == JOptionPane.YES_OPTION) {
                    sd.clearRecords();
                    System.out.println("All data has been cleared from the Database.");
                    JOptionPane.showMessageDialog(null, "All data has been cleared from the Database.");
                }
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
                    if (foundStudent.degree == "Arts"){
                        ArtsStudent artsStudent = sd.findArts(studentNumberText.getText());
                        degreeMajorText.setText(artsStudent.getMajor());
                        degreeMinorText.setText(artsStudent.getMinor());
                    }
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
                boolean checker = false;
                if (foundStudent != null) {
                    checker = foundStudent.containsResult(topicCodeText.getText());
                }
                    if (checker == false){
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
                        else if (topicCodeText.getText().length() > 8) {
                            JOptionPane.showMessageDialog(null, "This topic code has been incorrectly inputted. Please try again.");
                        }
                        else {
                            String awardedGrade = gradeCombobox.getSelectedItem().toString();
                            String enteredTopic = topicCodeText.getText().toUpperCase();
                            String awardedMark = markText.getText();
                            foundStudent.addResult("R" + ',' + foundStudent.getStudentID() + ',' + enteredTopic + ',' + awardedGrade + ',' + awardedMark);
                        }

                    }else JOptionPane.showMessageDialog(null, "A result for that topic already exists!");
            }
        });



//      Find Topic Button
        findTopicResultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                    sd.awardPrize(prizeNameText.getText(),courseNameText.getText(),Integer.parseInt(topicNumberText.getText()));
                    JOptionPane.showMessageDialog(null, "Congratulations, the prize has been distributed!");
                }

            }
        });
    }
    }