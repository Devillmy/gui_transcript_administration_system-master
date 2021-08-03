package gui_tas.datastructure;
import gui_tas.customexceptions.DateEarlyException;
import gui_tas.customexceptions.DateIllegalException;
import gui_tas.customexceptions.FieldEmptyException;
import gui_tas.customexceptions.LessonRepeatException;

import javax.swing.*;
import java.util.ArrayList;

public class Student
{
    private String code;//学生学号
    private String name;//学生名字
    private String major;//专业
    private Date birthday;//生日
    private ArrayList<LessonInfo> lessonInfos=new ArrayList<>();//课程信息

    public Student()
    {
        code="0000";
        name="张三";
        major="未指定";
        birthday=new Date();
    }

    public Student(String code,String name,String major,Date birthday) throws FieldEmptyException
    {
        if(code.equals(""))
            throw new FieldEmptyException();
        this.code=code;
        if(name.equals(""))
            throw new FieldEmptyException();
        this.name=name;
        if(major.equals(""))
            throw new FieldEmptyException();
        this.major=major;
        this.birthday=birthday;
    }

    public Student(String code,String name,String major,int year,int month,int day) throws DateIllegalException, FieldEmptyException//大约不会用到的构造函数，但还是写上
    {
        if(code.equals(""))
            throw new FieldEmptyException();
        this.code=code;
        if(name.equals(""))
            throw new FieldEmptyException();
        this.name=name;
        if(major.equals(""))
            throw new FieldEmptyException();
        this.major=major;
        try
        {
            this.birthday=new Date(year,month,day);
        }
        catch (DateIllegalException e)
        {
            throw e;
        }
    }
    public void addLessonInfo(LessonInfo lessonInfo) throws DateEarlyException, LessonRepeatException
    {
        if(lessonInfo.getDate().compareTo(birthday)<1)
            throw new DateEarlyException();
        for(LessonInfo lessonInfo1:lessonInfos)
        {
            if(lessonInfo1.getName().equals(lessonInfo.getName())&&lessonInfo1.getDate().compareTo(lessonInfo.getDate())==0)
                throw new LessonRepeatException();
        }
        lessonInfos.add(lessonInfo);
    }

    public String getCode()
    {
        return code;
    }

    public String toString()
    {
        String text=this.code+" "+this.name+" 专业:"+this.major+" 生日："+this.birthday+"\n";
        for(LessonInfo lessoninfo : lessonInfos)
        {
            text=text+lessoninfo.toString()+"\n";
        }
        return text;
    }
}
