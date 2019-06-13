
 /**
 * This class extends the Student class to provide specialized behavior.
 */
public class Undergraduate extends Student {
  /**
 * Attributes.
 */
  private String highSchool;


 /**
 * Constructor method.
 */
 public Undergraduate(String first, String last, long gnum, 
                      String major, String degree, String highSchool) {
   // TODO
   // calling super to get and sending 0 for PROGRAM
   super(0,first,last,gnum,major,degree);
   this.highSchool = highSchool;
 }
 

 /**
 * Accessor methods.
 */
 // TODO
 public String getHighSchool() { return highSchool; }
 public void setHighSchoo(String hs) { this.highSchool = hs; }

 /**
 * The two abstract methods from parent class.
 */
 protected boolean approvedForClass(Course c) {
   /* an undergraduate is allowed to register if this course belongs to his major, or he has already 
    * registered to 2 courses (6.0 credits) of his major in the current semester.
    */
   // TODO
   int count = 0;
   // checking if the class is within the student's major
   if(this.major == c.getDept()){
     return true;
   }
   // looping through the student's transcript array
   for(int i = 0; i < super.getTranscripts().length; i++){
     if(super.getTranscripts()[i] != null){
       // checking if the student already signed up for ant other courses that semester
       if(super.getTranscripts()[i].isActive() == true){
         // adding the amount of credit of that course to count 
         count += super.getTranscripts()[i].getCredits();
       }
     }
   }
   // checking if the student is signed up for more than 2 courses that semester
   if(count >= 6.0){
     return true;
   }
   return false;
   
 }
    
  protected void setCourseGrade(TranscriptEntry entry, int score) {
  // use the following for grade assignments:
  // if (score >= 98) then the grade is A+, 
  // if (92 <= score < 98) then the grade is A,
  // if (90 <= score < 92) then the grade is A-,
  // if (score >= 88) then the grade is B+, 
  // if (82 <= score < 88) then the grade is B,
  // if (80 <= score < 82) then the grade is B-,
  // if (score >= 78) then the grade is C+, 
  // if (72 <= score < 78) then the grade is C,
  // if (70 <= score < 72) then the grade is C-,
  // if (score >= 60) then the grade is D,
  // if (score < 60) then the grade is F,
    // TODO
   
    // checking what the score is and calling setGrade to set the letter grade for the student 
    if (score >= 98){
      entry.setGrade("A+");
    }
    else if (score >= 92){
      entry.setGrade("A");
    }
    else if (score >= 90){
      entry.setGrade("A-");
    }
    else if (score >= 88){
      entry.setGrade("B+");
    }
    else if (score >= 82){
      entry.setGrade("B");
    }
    else if (score >= 80){
      entry.setGrade("B-");
    }
    else if (score >= 78){
      entry.setGrade("C+");
    }
    else if (score >= 72){
      entry.setGrade("C");
    }
    else if (score >= 70){
      entry.setGrade("C-");
    }
    else if (score >= 60){
      entry.setGrade("D");
    }
    else{
      entry.setGrade("F");
    }
    
  }
  
 @Override
 public String toString() {
  // overrides the toString() method defined in its parent class, returns a String in the following format: 
  //                 �John Smith, Degree: B.S., Major: Computer Science�
  // TODO
   return super.toString() + ", Degree: " + super.getDegree() + ", Major: " + super.getMajor();
 }
}
