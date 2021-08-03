package gui_tas.datastructure;

import gui_tas.customexceptions.*;

import java.util.ArrayList;

public class Classroom
{
    private ArrayList<Student> studentList= new ArrayList<>();
    public Classroom(){}
    public void AddStudent(Student student) throws StudentCodeRepeatException
    {
        for(Student student1:studentList)
        {
            if(student1.getCode().equals(student.getCode()))
                throw new StudentCodeRepeatException();
        }
        studentList.add(student);
    }

    public void studentAddLessoninfo(String studentCode,LessonInfo lessonInfo ) throws DateEarlyException,StudentNotFoundException,LessonRepeatException
    {
        for(Student student:studentList)
        {
            if(studentCode.equals(student.getCode()))
            try {
                student.addLessonInfo(lessonInfo);
                return;
            } catch (DateEarlyException e) {
                e.printStackTrace();
                throw e;
            } catch (LessonRepeatException e) {
                e.printStackTrace();
                throw e;
            }
        }
        throw new StudentNotFoundException();
    }

    public String studentSearch(String studentCode) throws StudentNotFoundException
    {
        for(Student student:studentList)
        {
            if(student.getCode().equals(studentCode))
                return student.toString();
        }
        throw new StudentNotFoundException();
    }

    public String toString()
    {
        String text= "======对于当前班级======\n";
        int length=studentList.size();
        for (Student student : studentList) {
            text=text + student.toString()+"\n";
        }
        return text;
    }

}
