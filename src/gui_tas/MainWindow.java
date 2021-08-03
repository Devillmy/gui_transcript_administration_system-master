package gui_tas;
import gui_tas.customexceptions.*;
import gui_tas.datastructure.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainWindow implements ActionListener
{
    //界面
    JFrame frame=new JFrame("学生成绩管理系统");

    JPanel studentAddPanel=new JPanel();

    JPanel studentNamePanel=new JPanel();
    JLabel studentNameLabel=new JLabel("输入学生姓名");
    JTextField studentNameField=new JTextField();

    JPanel studentCodePanel=new JPanel();
    JLabel studentCodeLabel=new JLabel("输入学生学号");
    JTextField studentCodeField=new JTextField();

    JPanel studentMajorPanel=new JPanel();
    JLabel studentMajorLabel=new JLabel("输入学生专业");
    JTextField studentMajorField=new JTextField();

    JPanel studentBirthdayPanel=new JPanel();
    JLabel studentBitrhdayLabel=new JLabel("输入生日年月日");
    JTextField studentBirthdayFieldYear=new JTextField();
    JTextField studentBirthdayFieldMonth=new JTextField();
    JTextField studentBirthdayFieldDay=new JTextField();

    JButton studentAddButton=new JButton("添加此学生");
    JButton studentSearchButton=new JButton("根据学号搜索此学生");

    JPanel lessonAddPanel=new JPanel();

    JPanel lessonStudentCodePanel=new JPanel();
    JLabel lessonStudentCodeLabel=new JLabel("输入被操作学生的学号");
    JTextField lessonStudentCodeField=new JTextField();

    JPanel lessonNamePanel=new JPanel();
    JLabel lessonNameLabel=new JLabel("输入科目名");
    JTextField lessonNameField=new JTextField();

    JPanel lessonTeacherPanel=new JPanel();
    JLabel lessonTeacherLabel=new JLabel("输入科目授课老师名");
    JTextField lessonTeacherField=new JTextField();

    JPanel lessonScorePanel=new JPanel();
    JLabel lessonScoreLabel=new JLabel("输入科目成绩");
    JTextField lessonScoreField=new JTextField();

    JPanel lessonDatePanel=new JPanel();
    JLabel lessonDateLabel=new JLabel("输入科目考试年月日");
    JTextField lessonDateFieldYear=new JTextField();
    JTextField lessonDateFieldMonth=new JTextField();
    JTextField lessonDateFieldDay=new JTextField();

    JButton lessonAddButton=new JButton("为该学生添加此科目记录");

    JButton showClassButton=new JButton("显示全班成绩");
    JPanel controlPanel=new JPanel();
    JTextArea console=new JTextArea();
    JScrollPane consolescrollPane=new JScrollPane(console);
    //班级
    Classroom classroom=new Classroom();
    public MainWindow()
    {
        studentAddButton.addActionListener(this);
        studentSearchButton.addActionListener(this);
        lessonAddButton.addActionListener(this);
        showClassButton.addActionListener(this);

        console.setEditable(false);
        console.setLineWrap(true);

        studentNamePanel.setLayout(new GridLayout(1,2));
        studentNamePanel.add(studentNameLabel);
        studentNamePanel.add(studentNameField);

        studentCodePanel.setLayout(new GridLayout(1,2));
        studentCodePanel.add(studentCodeLabel);
        studentCodePanel.add(studentCodeField);

        studentMajorPanel.setLayout(new GridLayout(1,2));
        studentMajorPanel.add(studentMajorLabel);
        studentMajorPanel.add(studentMajorField);

        studentBirthdayPanel.setLayout(new GridLayout(1,4));
        studentBirthdayPanel.add(studentBitrhdayLabel);
        studentBirthdayPanel.add(studentBirthdayFieldYear);
        studentBirthdayPanel.add(studentBirthdayFieldMonth);
        studentBirthdayPanel.add(studentBirthdayFieldDay);

        studentAddPanel.setLayout(new GridLayout(6,1));
        studentAddPanel.add(studentCodePanel);
        studentAddPanel.add(studentNamePanel);
        studentAddPanel.add(studentMajorPanel);
        studentAddPanel.add(studentBirthdayPanel);
        studentAddPanel.add(studentAddButton);
        studentAddPanel.add(studentSearchButton);



        lessonStudentCodePanel.setLayout(new GridLayout(1,2));
        lessonStudentCodePanel.add(lessonStudentCodeLabel);
        lessonStudentCodePanel.add(lessonStudentCodeField);

        lessonNamePanel.setLayout(new GridLayout(1,2));
        lessonNamePanel.add(lessonNameLabel);
        lessonNamePanel.add(lessonNameField);

        lessonTeacherPanel.setLayout(new GridLayout(1,2));
        lessonTeacherPanel.add(lessonTeacherLabel);
        lessonTeacherPanel.add(lessonTeacherField);

        lessonScorePanel.setLayout(new GridLayout(1,2));
        lessonScorePanel.add(lessonScoreLabel);
        lessonScorePanel.add(lessonScoreField);

        lessonDatePanel.setLayout(new GridLayout(1,4));
        lessonDatePanel.add(lessonDateLabel);
        lessonDatePanel.add(lessonDateFieldYear);
        lessonDatePanel.add(lessonDateFieldMonth);
        lessonDatePanel.add(lessonDateFieldDay);

        lessonAddPanel.setLayout(new GridLayout(6,1));
        lessonAddPanel.add(lessonStudentCodePanel);
        lessonAddPanel.add(lessonNamePanel);
        lessonAddPanel.add(lessonTeacherPanel);
        lessonAddPanel.add(lessonScorePanel);
        lessonAddPanel.add(lessonDatePanel);
        lessonAddPanel.add(lessonAddButton);

        controlPanel.setLayout(new GridLayout(3,1));
        controlPanel.add(studentAddPanel);
        controlPanel.add(lessonAddPanel);
        controlPanel.add(showClassButton);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(1,2));
        frame.getContentPane().add(controlPanel);
        frame.getContentPane().add(consolescrollPane);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        if("添加此学生".equals(e.getActionCommand()))
        {
            boolean hasException=false;
            try {
                classroom.AddStudent(
                        new Student(
                                studentCodeField.getText(),
                                studentNameField.getText(),
                                studentMajorField.getText(),
                                new Date(
                                        Integer.parseInt(studentBirthdayFieldYear.getText()),
                                        Integer.parseInt(studentBirthdayFieldMonth.getText()),
                                        Integer.parseInt(studentBirthdayFieldDay.getText())
                                )
                        )
                );
            } catch (DateIllegalException ex) {
                hasException=true;
                console.append("您所提供的出生日期不合法！\n");
                ex.printStackTrace();
            } catch (FieldEmptyException ex) {
                hasException=true;
                console.append("您所提供的学生信息不全！\n");
                ex.printStackTrace();
            }catch (NumberFormatException ex)
            {
                hasException=true;
                console.append("您提供的生日不是数字!\n");
                ex.printStackTrace();
            } catch (StudentCodeRepeatException ex) {
                hasException=true;
                console.append("已有此学生！\n");
                ex.printStackTrace();
            }
            if(!hasException)
            {
                console.append("成功添加学生"+studentCodeField.getText()+studentNameField.getText()+"\n");
                studentCodeField.setText("");
                studentNameField.setText("");
                studentMajorField.setText("");
                studentBirthdayFieldDay.setText("");
                studentBirthdayFieldMonth.setText("");
                studentBirthdayFieldYear.setText("");
            }
        }

        if("显示全班成绩".equals(e.getActionCommand()))
        {
            console.append(classroom.toString());
        }

        if("为该学生添加此科目记录".equals(e.getActionCommand()))
        {
            boolean hasException=false;
            try {
                classroom.studentAddLessoninfo(
                        lessonStudentCodeField.getText(),
                        new LessonInfo(
                        lessonNameField.getText(),
                        lessonTeacherField.getText(),
                        Integer.parseInt(lessonScoreField.getText()),
                        new Date(
                                Integer.parseInt(lessonDateFieldYear.getText()),
                                Integer.parseInt(lessonDateFieldMonth.getText()),
                                Integer.parseInt(lessonDateFieldDay.getText())
                                )
                        )
                );
            }
            catch (LessonIllegalException ex)
            {
                hasException=true;
                ex.printStackTrace();
                console.append("您所提供的分数不在范围内[0-100]！\n");
            }
            catch (DateIllegalException ex)
            {
                hasException=true;
                ex.printStackTrace();
                console.append("您所提供的考试日期不合法！\n");
            }
            catch (DateEarlyException ex)
            {
                hasException=true;
                console.append("您提供的考试日期早于学生的出生日期！\n");
            }
            catch (FieldEmptyException ex)
            {
                hasException=true;
                console.append("您提供的课程信息不全！\n");
                ex.printStackTrace();
            }
            catch (StudentNotFoundException ex) {
                hasException=true;
                console.append("未找到该学生！\n");
                ex.printStackTrace();
            }
            catch (NumberFormatException ex)
            {
                hasException=true;
                console.append("您提供的成绩或日期不是数字!\n");
                ex.printStackTrace();
            }
            catch (LessonRepeatException ex) {
                hasException=true;
                console.append("您提供课程信息重复！\n");
                ex.printStackTrace();
            }
            if(!hasException)
            {
                console.append("成功添加课程记录"+lessonNameField.getText()+"\n");
                lessonStudentCodeField.setText("");
                lessonNameField.setText("");
                lessonTeacherField.setText("");
                lessonScoreField.setText("");
                lessonDateFieldDay.setText("");
                lessonDateFieldMonth.setText("");
                lessonDateFieldYear.setText("");
            }
        }

        if("根据学号搜索此学生".equals(e.getActionCommand()))
        {
            try {
                console.append(classroom.studentSearch(studentCodeField.getText()));
            } catch (StudentNotFoundException ex) {
                console.append("未找到此学生，请确认您输入的学号是否准确！\n");
                ex.printStackTrace();
            }

        }
    }
}
