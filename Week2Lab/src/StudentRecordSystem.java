import java.util.Scanner;
/**
 * StudentRecordSystem.java: This is a class which is used to add student
 * in to the array, print all the student records and calculate average CGPA.
 * @author Sai Surya Prakash Moka
 * @date 09/07/2023
 */
public class StudentRecordSystem {

    private Student[] studentArray=new Student[5];

    /**
     * addStudentRecord method is used to add a new student record in to the array.
     * @param studentName
     * @param studentAge
     * @param gpa
     */
    public void addStudentRecord(String studentName,int studentAge,double gpa)
    {
        int index=0;
        Student student=new Student(studentName,studentAge,gpa);
        for(Student studentObj:studentArray)
        {
            if(studentObj!=null)
            {
                index++;
            }
        }
        studentArray[index]=student;
    }

    /**
     * printStudentDetails is used to print all the student records present in the list
     */
    public void printStudentDetails()
    {
        int displayCount=0;
        for(Student student:studentArray)
        {
            if(student!=null) {
                displayCount++;
                System.out.println("****Student Record-" + displayCount + "****");
                System.out.println("Student Name:" + student.getStudentName());
                System.out.println("Student Age:" + student.getStudentAge());
                System.out.println("Student GPA:" + student.getStudentGpa());
            }
        }
    }

    /**
     * calculateAverageGpa is used to calculate the average CGPA for all the students present in
     * the array
     */

    public double calculateAverageGpa()
    {
        double cgpa=0.0;
        int count=0;
        for(Student student:studentArray)
        {
            if(student!=null)
            {
                count++;
                cgpa+= student.getStudentGpa();
            }
        }
        return cgpa/count;
    }


    public static void main(String[] args)
    {
        String studentName;
        int studentAge;
        double studentGpa;
        StudentRecordSystem studentRecordSystem =new StudentRecordSystem();
        Scanner scanner=new Scanner(System.in);
        for(int i=0;i<5;i++)
        {
            System.out.print("Enter the Student Name:");
            studentName=scanner.next();
            System.out.print("Enter the Student Age:");
            studentAge=scanner.nextInt();
            System.out.print("Enter the Student GPA:");
            studentGpa=scanner.nextDouble();
            studentRecordSystem.addStudentRecord(studentName,studentAge,studentGpa);
            System.out.println("***Student "+Integer.valueOf(i+1)+" Record Inserted Sucessfully. Proceed with others***");
        }
        studentRecordSystem.printStudentDetails();
        System.out.println("*************************");
        System.out.printf("Average CGPA:%.2f",studentRecordSystem.calculateAverageGpa());
    }
}
