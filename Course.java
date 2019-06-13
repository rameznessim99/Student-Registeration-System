/**
 * A class which maintains basic information about an academic course. 
 * @author CS211 GMU
 */

public class Course {
  
/**
 * Attributes.
 */
  //initializing the variables for Course class 
  private String code;
  private String title;
  private String dept; // name of department offering the course
  private int credits;

/**
 * Constructor.
 */
  public Course(String code,  String title, int credits) {
     // TODO : initilize instance variables, use the static method defined in  
    // Registrar to initialize the dept name variable
    this.code = code;
    this.title = title;
    this.credits = credits;
    this.dept = Registrar.getDeptName(code);
 
    }

/**
 * Accessor methods.
 */
// TODO: define a setter and a getter method for each of the instance variables
  public String getCode() {return this.code;}
  public String getTitle() {return this.title;}
  public String getDept() {return this.dept;}
  public int getCredits() {return this.credits;}
  
  public void setCode(String code) { this.code = code; }
  public void setTitle(String title) { this.title = title; }
  public void setCredits(int credits) { this.credits = credits; }
/**
 * public methods.
 */
 @Override
 public String toString() { 
   // TODO: implement so that a string is returned in the following format:
   //  "\tINFS 612 Communication Systems (3)�

   return "" + this.code + " " + this.title + ", (" + this.credits + ")";
 }
 
 public String fullString() {
   // TODO: implement so that a string is returned in the following format:  
   //"\tINFS 612 Communication Systems (3) credit hours�
   return "" + this.code + " " + this.title + ", (" + this.credits + ") credit hours.";
 }

}
