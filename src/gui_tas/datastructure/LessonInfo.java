package gui_tas.datastructure;

import gui_tas.customexceptions.FieldEmptyException;
import gui_tas.customexceptions.LessonIllegalException;

import javax.naming.Name;

public class LessonInfo
{
    private String name;//课程名
    private String teacher;//授课教师
    private int score;//成绩
    private Date date;//考试日期

    public LessonInfo()
    {
        name="未指定";
        teacher="未指定";
        score=0;
        date=new Date();
    }
    public LessonInfo(String name,String teacher,int score,Date date)throws LessonIllegalException, FieldEmptyException
    {
        if(name.equals(""))
            throw new FieldEmptyException();
        this.name=name;
        if(teacher.equals(""))
            throw new FieldEmptyException();
        this.teacher=teacher;
        this.score=score;
        this.date=date;
        try
        {
            checkLegal();
        }
        catch (LessonIllegalException e)
        {
            throw e;
        }

    }

    private void checkLegal() throws LessonIllegalException
    {
        if(score>100||score<0)
            throw new LessonIllegalException();
    }

    public Date getDate()
    {
        return date;
    }

    public String getName(){return name;}

    public String toString()
    {
        return name+"由"+teacher+"老师授课，于"+date+"考试，得分："+score;
    }

}
