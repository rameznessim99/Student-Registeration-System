/**
 * The main class in the student registration program.. 
 * This class defines public methods to provide the following functionality:
 *     - maintains the course catalog.
 *     - registers and drop courses for students
 *     - at the end of semester, post grades
 *     
 * @author CS211 GMU
 */
import java.util.Scanner;

public class Registrar {
  
/**
 * Attributes.
 */
 private Student [] students;
 private int numStudents; // keeps track of the students array size
 private Course [] courseCatalog;
 private int numCourses;  // keeps track of the courseCatalog array size
 private String semester;
 private int year;
 
/**
 * Constructor.
 */
 public Registrar(String semester, int year) {
  // TODO.
  // note: maximum number of students is 100, and maximum number of courses is 50.
  //
   this.semester = semester;
   this.year = year;
   students = new Student[100];
   courseCatalog = new Course[50];
 }

/**
 * Accessor methods.
 */
 public void setSemester(String semester) { this.semester=semester;}
 public String getSemester() { return semester; }
 
 public void setYear(int year) { this.year=year;}
 public int getYear() { return year; }
 
/**
 * Public methods.
 */      
 public boolean addCourse(String code, String title, int hours) { 
 // if courseCatalog is full , return false, otherwise, add course to the catalog.
 // TODO
   // looping through the student's transcript array
   for(int i = 0; i < courseCatalog.length; i++){
     if(courseCatalog[i] == null){
       // increamenting numCourses 
       numCourses ++;
       // creating a new course object 
       Course c = new Course(code,title,hours);
       // adding the course to courseCataolog 
       courseCatalog[i] = c;
       return true;
     }
   }
   return false;
  }
 
 public String getCourseCatalog() {
   String str="";
   for (Course c : courseCatalog)
     if (c == null) break;
     else str = str + c.fullString() +"\n";
   return str;
   }
 
 public boolean addStudent(String fname, String lname, long gnum, String major, 
                           String degree, String highSchool) {  
 // if the students array is full, return false.
 // otherwise add the student information to the students arrays
 // TODO
   // looping through th students array 
   for(int i = 0; i < students.length; i++){
     if(students[i] == null){
       // creating a new undergraduate student 
       Undergraduate u = new Undergraduate(fname,lname,gnum,major,degree,highSchool);
       // adding the undergraduate student to the students list 
       students[i] = u;
       return true;
     }
   }
   return false;
  }
 
  public boolean addStudent(String fname, String lname, long gnum, String major, 
                            String degree, String uMajor, String uInstit) {  
    // an overloaded method which does the sam as the other addStudent method
    // TODO
    // looping through the students array 
    for(int i = 0; i < students.length; i++){
     if(students[i] == null){
       // creating a new graduate student object 
       Graduate g = new Graduate(fname,lname,gnum,major,degree,uMajor,uInstit);
       // adding the student to the students array
       students[i] = g;
       return true;
     }
   }
   return false;
  }
  
  // A method that displays the student's array
  public String getStudents() {
   String str="";
   for (Student s : students)
     if (s == null) break;
     else str = str + s.toString() +"\n";
   return str;
   }
 
  public boolean register(long gnum, String courseCode) {
    // first check if the course is offered (by searching courseCatalog array using courseCode), if 
    // the course is not found return false.
    // then find the student object in the students array using their gnum, if no student is found 
    // return false.
    // otherwise register the student in the class and return true.
    // TODO
    boolean isCourseFound = false;
    int courseCodeIndex = 0;
    boolean isStudentFound = false;
    int studentIndex = 0;
    boolean courseInArray = false;
    // looping throught the courseCatolog array
    for(int i = 0; i < courseCatalog.length; i++){    
      if(courseCatalog[i] != null){
        //System.out.println("courseCatalog[i].getCode() = " + courseCatalog[i].getCode());
        //System.out.println("Course Code = " + courseCode);
        
        // checking if the current index course equals to courseCode
        if(courseCatalog[i].getCode().equalsIgnoreCase(courseCode)){
          //System.out.println("We got a match for course");
          // setting isCourseFound to true
          isCourseFound = true;
          // saving that courseCode index
          courseCodeIndex = i;
          break;
        }
      }
    }
    
    // looping throgh the students array
    for(int i = 0; i < students.length; i++){
      if(students[i] != null){
        // checking is the current student index's gnum matches the given one
        if(students[i].getGnum() == gnum){
          // setting isStudentFound to true
          isStudentFound = true;
          // saving that student's index
          studentIndex = i;
        }
      }
    }
    
    // checking if whether student or course was not found and returning false if so 
    if(isStudentFound == false || isCourseFound == false){
      return false;
    }
    //System.out.println("Is the course found? " + isCourseFound + " and it's in index " + courseCodeIndex);
    //System.out.println("Is the student found? " + isStudentFound + " and it's in index " + studentIndex);
    //register student in the class
    //System.out.println(students[studentIndex]);
    //System.out.println(courseCatalog[courseCodeIndex]);
    
    // registering the student to the course and returning true
    if(students[studentIndex].registerAClass(courseCatalog[courseCodeIndex],semester,year)){
      return true;
    }
    return false;
    
    
  }
  
  public boolean drop(long gnum, String courseCode) {
    // Find the student object in the students array using their gnum, if no student is found 
    // return false.  otherwise drop the course for the student.
    // TODO
    boolean isCourseFound = false;
    int courseCodeIndex = 0;
    boolean isStudentFound = false;
    int studentIndex = 0;
    // looping throught the courseCatolog array
    for(int i = 0; i < courseCatalog.length; i++){
      if(courseCatalog[i] != null){
        // checking if the current index course equals to courseCode
        if(courseCatalog[i].getCode().equals(courseCode)){
          // setting isCourseFound to true
          isCourseFound = true;
          // saving that courseCode index
          courseCodeIndex = i;
        }
      }
    }
    for(int i = 0; i < students.length; i++){
      if(students[i] != null){
        // checking is the current student index's gnum matches the given one
        if(students[i].getGnum() == gnum){
          // setting isStudentFound to true
          isStudentFound = true;
          // saving that student's index
          studentIndex = i;
        }
      }
    }
    // checking if whether student or course was not found and returning false if so 
    if(isStudentFound == false || isCourseFound == false){
      return false;
    }
    //// dropping the student from the course and returning true
    if(students[studentIndex].dropAClass(courseCatalog[courseCodeIndex].getCode())){
      return true;
    }
    return false;
    
  }
  
  public boolean postGrade(long gnum, String courseCode, int score) {
    // Find the student object in the students array using their gnum, if no student is found 
    // return false.  otherwise post a course grade for the student.
    // TODO
    //System.out.println("For course: " + courseCode + " I'm at postGrade");
    boolean isCourseFound = false;
    int courseCodeIndex = 0;
    // looping throught the courseCatolog array
    for(int i = 0; i < courseCatalog.length; i++){
      if(courseCatalog[i] != null){
        // checking if the current index course equals to courseCode
        if(courseCatalog[i].getCode().equalsIgnoreCase(courseCode)){
          isCourseFound = true;
          courseCodeIndex = i;
        }
      }
    }
    // checking if the course is not found 
    if(isCourseFound == false){
      return false;
    }
    if(findStudent(gnum) != null){
      //System.out.println("Student found");
      // finding the student and assiging it to s
      Student s = findStudent(gnum);
      // calling obtainAGrade to assign the score to the course of the student 
      if(s.obtainAGrade(courseCode,score)){
        return true;
      }    
    }
    return false;
  }
  
  // displays the student and the courses they signed up for per semester 
  public String getProgress(long gnum, String semester, int year) {
    Student s = findStudent(gnum);
    if (s == null) 
        return "Student "+gnum+" not found";
    String str = String.format(" %s\n", s.toString());
    return str+s.getClassList(semester, year);
  }

  public static String getDeptName(String code) {
    // given a course code, this static method will return the name
    // of the academic department to which the course belong
    String dept = (new Scanner(code)).next();
    
    if (dept.equalsIgnoreCase("CS")) 
          return "Computer Science";
    else if (dept.equalsIgnoreCase("INFS"))
          return "Information Systems";
    else if (dept.equalsIgnoreCase("IT")) 
          return "Information Tecchnoloy";
    else if (dept.equalsIgnoreCase("MATH")) 
          return "Mathematics";
    else if (dept.equalsIgnoreCase("PHYS"))
          return "Physics";            
    else return null;
  }
  
  
/**
 * Private methods.
 * you will need few helper methods.
 */ 
  
  // recieves a gnum and returns a student with that gnum
  public Student findStudent(long gnum){
    for(int i = 0; i < students.length; i++){
      if(students[i] != null){     
        // checking if the current index's gnum is equal to the given gnum
        if (students[i].getGnum() == gnum){
          return students[i];
        }
      }
    }
    return null;
  }
  
}
