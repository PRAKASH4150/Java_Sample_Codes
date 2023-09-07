/**
 * Student.java: This is a POJO class for the Student
 * @author Sai Surya Prakash Moka
 * @date 09/07/2023
 */
public class Student {
    private String studentName;
    private int studentAge;
    private double gpa;


    Student(String studentName,int studentAge,double gpa)
    {
        this.studentName=studentName;
        this.studentAge=studentAge;
        this.gpa=gpa;
    }

    public String getStudentName(){
        return this.studentName;
    }

    public int getStudentAge()
    {
        return this.studentAge;
    }

    public double getStudentGpa()
    {
        return this.gpa;
    }

    @Override
    public String toString()
    {
        return "Student Records: Student Name:"+studentName+" Student Age:"+studentAge+" Student GPA"+gpa;
    }
}
