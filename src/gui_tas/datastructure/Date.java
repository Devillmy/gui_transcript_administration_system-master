package gui_tas.datastructure;

import gui_tas.customexceptions.DateIllegalException;

public class Date
{
    private int day;
    private int month;
    private int year;

    public Date()
    {
        day=1;
        month=1;
        year=1990;
    }

    public Date(int year,int month,int day) throws DateIllegalException
    {
        this.day=day;
        this.month=month;
        this.year=year;
        try{
            this.checkLegal();
        }
        catch(DateIllegalException e)
        {
            throw e;
        }

    }

    private Boolean isLeapYear()
    {
        return (this.year % 4 == 0 && this.year % 100 != 0) || this.year % 400 == 0;
    }

    private void checkLegal() throws DateIllegalException
    {
        if(month>12||month<1)
            throw new DateIllegalException("month out of bound");
        else
        {
            switch(month)
            {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    if(day>31||day<1)
                        throw new DateIllegalException("day out of bound");
                case 4: case 6: case 9: case 11:
                    if(day>30||day<1)
                        throw new DateIllegalException("day out of bound");
                case 2:
                    if(isLeapYear())
                    {
                        if(day>29||day<1)
                            throw new DateIllegalException("day out of bound");
                    }
                    else
                    {
                        if(day>28||day<1)
                            throw new DateIllegalException("day out of bound");
                    }
                }
            }
    }

    public String toString()
    {
        return year+"/"+month+"/"+day;
    }

    public int compareTo(Date date) {
        if(this.year>date.year)
            return 1;
        else if(this.year<date.year)
            return -1;
        else{
            if(this.month>date.month)
                return 1;
            else if(this.month<date.month)
                return -1;
            else
            {
                if(this.day>date.day)
                    return 1;
                else if(this.day<date.day)
                    return -1;
                else return 0;
            }
        }
    }
}
