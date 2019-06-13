/**
 * A sub-class which extends the Course class to keep track of a student 
 * registration in a course, and also perform 
 * @author CS211 GMU
 */
public class TranscriptEntry extends Course {
/**
 * Attributes
 * 
 */
  // initializing the TranscriptEntry class variables 
  private String semester;
  private int year;
  private String grade;
  private boolean active;
  
  public TranscriptEntry(Course c, String semester, int year) {
    // TODO
    // note: active must be initialized to true.
    super(c.getCode(), c.getTitle(), c.getCredits());
    grade = null;
    this.semester = semester;
    this.year = year;
    active = true;
  }     
  
/**
 * Accessor methods methods.
 * // TODO
 * define a setter and a getter for each instance variable.
 * note: Do not write accessor methods for the active variable since its an internal variable:
 *       if a course is flagged active, then the student is currently enrolled in that course.
 *       When a grade is posted for a course, active is set to false.
 */
  public String getSemester() { return semester; }
  public int getYear() { return year; }
  public String getGrade() { return grade; }
  
  public void setSemester(String s) { semester = s; }
  public void setYear(int y) { year = y; }
  // setting active to false when a grade is assigned 
  public void setGrade(String g) {
    grade = g;
    active = false;
  }
  
  
  /**
   * Public Mathods.
   * 
   */
  
  public boolean isActive() {
   //TODO
    return active;
  }
  
  //a helper method comparing 2 TranscriptEnties based on the course code
  public boolean equalTo(TranscriptEntry t){
    if(this.getCode() == t.getCode()){
      return true;
    }
    return false;
  }
  
 @Override
 public String toString() { 
   // return a string with the following format:
   //  "\tINFS 510 Database Systems,   credits: 3, GRADE: A" 
   //TODO
   if (grade != null){
     return "\t" + super.getCode() + " " + super.getTitle() + ",   credits: " + super.getCredits() + ", GRADE: " + this.grade;
   }
   else{
     return "\t" + super.getCode() + " " + super.getTitle() + ",   credits: " + super.getCredits();
   }
 }
}