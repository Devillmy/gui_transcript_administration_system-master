package gui_tas.customexceptions;

public class FieldEmptyException extends Exception
{
    public FieldEmptyException(){ super(); }
    public FieldEmptyException(String message) { super(message); }
}
