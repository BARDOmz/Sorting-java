
/**
 * Write a description of class ba here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main {
class ParentException extends Exception { public ParentException (String message) { super (message);
}
class ChildException extends ParentException { public ChildException(String message) { super (message);
}
}
public class Example {
public static void main(String[] args) { try {
throw new ChildException("This is a child exception."); } catch (ParentException e) {
System.out.println(e.getMessage());



