package gui_tas.customexceptions;

public class StudentNotFoundException extends Exception{
    public StudentNotFoundException()
    {
        super();
    }
    public StudentNotFoundException(String message)
    {
        super(message);
    }
}
