

public class Graduate extends Student {
  
  /* TODO : write the class definition for the Graduate class.  This class extends Student and includes 
   * the following two attribute definitions: */
  private String undergraduateMajor;
  private String undergraduateInstitution; 
  
  /**
   * Constructor method.
   */
  public Graduate(String fname, String lname, long ssn, String major, String degree, String undergraduateMajor, String undergraduateInstitution) {
    // caliing the super method and sending 1 for PROGRAM 
    super(1,fname,lname,ssn,major,degree);
    this.undergraduateMajor = undergraduateMajor;
    this.undergraduateInstitution = undergraduateInstitution;
  }
  
  // Accessors methods 
  public String getUndergraduateMajor() { return undergraduateMajor;}
  public String getUndergraduateInstitution() { return undergraduateInstitution; }
  
  @Override    
  public String toString() {
    return super.toString() + ", Degree: " + super.getDegree() + ", Major: " + super.getMajor();
  }
  
  protected boolean approvedForClass(Course c) { 
    // A GraduateStudent can only register to a course if either it belongs to the program he majors in,
    // for example if the student majors in Physics, then the course's program must be physics
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
    // no plus/minus ,, and no D option for a graduate
    // checking what the score is and calling setGrade to set the letter grade for the student 
    if (score >= 90){
      entry.setGrade("A");
    }
    else if (score >= 80){
      entry.setGrade("B");
    }
    else if (score >= 70){
      entry.setGrade("C");
    }
    else{
      entry.setGrade("F");
    }
  }
  
}


