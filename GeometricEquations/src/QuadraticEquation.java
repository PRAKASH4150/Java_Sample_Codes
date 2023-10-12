/**
 * QuadraticEquation.Java:This file is used to calculate
 * the X-intercept for a Quadratic equation.
 * @author Sai Surya Prakash Moka
 * @date 10-05-2023
 */
public class QuadraticEquation extends LinearEquation{

    double aTerm;
    QuadraticEquation(double aTerm,double slope, double yIntercept)
    {
        super(slope, yIntercept);
        this.aTerm=aTerm;
    }

    /**
     * findXIntercept(): This function is used to find the
     * X-Intercept for a Quadratic equation.
     */
    @Override
    public void findXIntercept()
    {
        double root1;
        double root2;
        double discriminantValue;

        try
        {
           if(aTerm!=0)
           {
               discriminantValue=(this.slope * this.slope) - 4 * this.aTerm*this.yIntercept;

               if(discriminantValue >=0)
               {
                   root1 = (-this.slope + Math.sqrt(discriminantValue)) / (2 * this.aTerm);
                   root2 = (-this.slope - Math.sqrt(discriminantValue)) / (2 * this.aTerm);
                   System.out.printf("For the equation y="+this.aTerm+"x^2+"+this.slope+"x+"+
                           this.yIntercept+" is at ("+"%.2f"+",0) and ("+"%.2f"+",0)",root1,root2);
                   System.out.println();
               }
               else{
                   System.out.println("The equation y="+this.aTerm+"x^2+"+this.slope+"x+"+
                           this.yIntercept+" may have Imaginary roots.");
               }
           }
           else
           {
               throw new ArithmeticException();
           }
        }
        catch (ArithmeticException arithmeticException)
        {
            System.out.println("Division by zero is not possible.");
        }
        System.out.println();
        System.out.println();
    }

    @Override
    public String toString()
    {
        return "Quadratic Equation:y="+this.aTerm+"x^2+"+this.slope+"x+"+
        this.yIntercept;
    }
}
