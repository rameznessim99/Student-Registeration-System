
/**
 * An abstract class for maintaing basic information about a student attending this college. 
 * This class defines public methods to provide the following functionality to a student object:
 *     - register and drop courses 
 *     - record a grade for a completed course
 *     - get transcripts / a list of completed courses
 * sub-classes of this class will specify how student rgistration is to be performed (depending 
 * on the level of the student), and also grade assignments.
 *     
 * @author CS211 GMU
 */

public abstract class Student {
/**
 * Attributes.
 * note how the class is defining its instance variables as protected so 
 * that they are accessible to its sub-classes.
 */
 protected String first, last;
 protected long gnum;
 protected String major;
 protected String degree;
 protected TranscriptEntry [] transcripts; // an array of objects
 protected final int PROGRAM; // a constant which will be initilized to 0 or 1 
                              // in the constructor method

/**
 * Attributes.
 * note how the class is defining its instance variables as protected so 
 * that they are accessible to its sub-classes.
 */
 public Student(int level, String first, String last, long gnum, String major, 
                String degree) {
  // TODO initialize the instance variables
  //  Also use the parameter variable "level" as follows
  //     1) use its value to initialized the PROGRAM constant
  //     2) create the transcripts array to be of size [50] if is level 0, 
  //        or to be of size [15] if level is 1.  
  // note that level refers to the student type and we use a value of 0 for 
  // an undergrad and a value of 1 for a grad
   PROGRAM = level;
   this.first = first;
   this.last = last;
   this.gnum = gnum;
   this.major = major;
   this.degree = degree;
   if (PROGRAM == 0){
     transcripts = new TranscriptEntry[50];
   }
   else{
     transcripts = new TranscriptEntry[15];
   }
 }

 /**
 * Accessor methods.
 */
// TODO: define a setter and a getter method for each of the instance variables
 public String getFirst(){ return this.first; }
 public String getLast(){ return this.last; }
 public long getGnum() { return this.gnum; }
 public String getMajor() { return this.major; }
 public String getDegree() { return this.degree; }
 public TranscriptEntry [] getTranscripts() { return transcripts; }
 
 public void setFirst(String f) { first = f; }
 public void setLast(String l) { last = l; }
 public void setGnum(long g) { gnum = g; }
 public void setMajor(String m) { major = m; }
 public void setDegree(String d) { degree = d; }
 
 
 /**
 * Public methods.
 */
  public boolean registerAClass(Course c, String semester, int year) { 
   // this method will call the approvedForClass method defined by 
   // the subclasses before enrolling the student into the course.
   //  This method also checks if the studnet is already enrolled in 
   // in the current semester and will return false if thats the case.
   // hint: a student would be currently enrolled if the .isActive() method returned true.
   // 
    
    // initializing a boolean variable and setting it to ture
    boolean registerationStatus = true;
    // checking if the student is approved for the course 
    if(this.approvedForClass(c) == true){
      //System.out.println("It passed approved for class");
      //checking if they already took the course
      /*TranscriptEntry te = new TranscriptEntry(c,semester,year);
       for(int i = 0; i < transcripts.length; i++){
       if(transcripts[i] != null){
       if(transcripts[i].equalTo(te)){
       if(transcripts[i].isActive() == false){
       registerationStatus = false;
       }
       }
       }
       }*/
      //System.out.println("registerationStatus = " + registerationStatus);
      //if(registerationStatus == true){
      
      //looping throught the transcripts array 
      for(int i = 0; i < transcripts.length; i++){ 
        // creating a new TranscriptEntry object 
        TranscriptEntry t = new TranscriptEntry(c,semester,year);
        if(transcripts[i] != null){
          /*System.out.println();
           System.out.println("transcripts[i] semester = " + transcripts[i].getSemester() +  " year = " + transcripts[i].getYear() );
           System.out.println("t semester = " + t.getSemester() + " year = " + t.getYear());
           System.out.println(transcripts[i] + " = " + t);
           System.out.println();*/
          
          //checking if student is trying to register for the same class in the same semester
          if(transcripts[i].equalTo(t) && transcripts[i].getSemester().equals(t.getSemester())){
            return false;
          }
        }
        else if(transcripts[i] == null){
          // creating a new TranscriptEntry object 
          TranscriptEntry ti = new TranscriptEntry(c,semester,year);
          // adding that object to the transcripts array
          transcripts[i] = ti;
          return true;
        }
      }
    }
    return false; 
  }
   
   
  public boolean dropAClass(String courseCode) {
  // We may only drop a student if he/she is currently enrolled (ie no grade posted yet).
  // Find the course entry in transcripts array and literally remove it, don't just
  // replace it with a null value, shift array elementsleft-ward to replace it!
  // hint: create a new array when removing a course from the transcripts array
       //TODO
    /*TranscriptEntry[] newTranscripts = new TranscriptEntry[transcripts.length];
    for(int i = 0; i < transcripts.length; i++){
      if(transcripts[i] != null){
        if(transcripts[i].getCode().equalsIgnoreCase(courseCode)){
          transcripts[i] = null;
          for(int j = 0; j < i+1; j++){
            newTranscripts[j] = transcripts[j];
          }
          for(int j = i+1; j < transcripts.length; j++){
            newTranscripts[j-1] = transcripts[j];
          }
          System.out.println("The course that we're removing is " + courseCode);
          for(int z = 0; z < transcripts.length; z++){
            System.out.print(transcripts[z] + " ");   
          }
          System.out.println();
          System.out.println();
          for(int a = 0; a < transcripts.length; a++){
            System.out.print(newTranscripts[a] + " ");
          }
          return true;
        }
      }
    }
    return false;*/
    // looping through the transcripts array 
    for (int i = 0; i < transcripts.length; i++) {
      if(transcripts[i] != null){
        // checking if the given course code equal to transcripts[i]'s code
        if (courseCode.equals(transcripts[i].getCode())) {
          // checking if there is no grade posted in for that course
          if (transcripts[i].getGrade() == null) {
            // creating a new TranscriptEntry element with the same size as transcripts array 
            TranscriptEntry[] newTranscripts = new TranscriptEntry[transcripts.length];
            // looping through the transcripts array 
            for (int j = 0; j < transcripts.length-1; j++) {
              // checking if we got to the part we want to skip 
              if (j >= i) {
                // assigning the initial j to j+1 in the transcripts array
                newTranscripts[j] = transcripts[j + 1];
              } 
              else {
                newTranscripts[j] = transcripts[j];
              }
            }
            //System.out.println("The course that we're removing is " + courseCode);
            /*for(int z = 0; z < transcripts.length; z++){
              System.out.print(transcripts[z] + " ");   
            }
            System.out.println();
            System.out.println();
            for(int a = 0; a < transcripts.length; a++){
              System.out.print(newTranscripts[a] + " ");
            }*/
            // updating the old array 
            transcripts = newTranscripts;            
            return true;         
          }         
        }
      }
    }
    return false;
  }
  
  

   
 public boolean obtainAGrade(String courseCode, int score) {     
   // this method will search the transcripts array to find a course and will
   // then assigne a letter grade for the student in that course.  if the course is not found 
   // in the array, or if its a past course then return false (should overwrite a past course grade).
      //TODO
   
   // looping through the transcripts array 
   for(int i = 0; i < transcripts.length; i++){
     if(transcripts[i] != null){
       // checking if the given course code equal to transcripts[i]'s code and the course does not have a grade in it
       if (transcripts[i].getCode().equalsIgnoreCase(courseCode) && transcripts[i].getGrade() == null){
         //System.out.println("transcripts[i].getCode() = " + transcripts[i].getCode());
         //System.out.println("courseCode = " + courseCode);
         // setting the course grade
         this.setCourseGrade(transcripts[i],score);
         
         return true;
       }
     }
   }
   return false;
   
 }
 // A method that displays the student's courses 
  public String getClassList(String semester, int year) {
    String str=String.format(" %s %d\n", semester, year);
    for (TranscriptEntry en : transcripts) {
            if (en == null) break;
      else if ((en.getSemester().equalsIgnoreCase(semester)) && 
               (en.getYear()==year))
         str += en.toString() + "\n";
    }  
    return str;
  }  

 @Override 
 public boolean equals(Object o) {
   // two student onjects are equal if they have the same G#
   // TODO
   // checking if 2 students equal each other based on g number 
   if(this.gnum == ((Student)(o)).getGnum()){
     return true;
   }
   return false;
 }
 
 @Override
 public String toString() {
   // return a string with the following format:
   //  �Smith, John (G#0000000000)� 
   //TODO
   return last + ", " + first + " (G#" + gnum + ")";
 }

 
/**
 * Private methods.
 * you may add as much helper methods as you need. 
 * 
 */
 
  protected abstract boolean approvedForClass(Course c); 
  protected abstract void setCourseGrade(TranscriptEntry entry, int score);
}
