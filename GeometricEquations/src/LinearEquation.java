/**
 * LinearEquation.Java:This file is used to calculate the X-intercept
 * for a linear equation.
 * @author Sai Surya Prakash Moka
 * @date 10-05-2023
 */
public class LinearEquation {
    protected double slope;
    protected double yIntercept;

    LinearEquation(double slope,double yIntercept)
    {
        this.slope=slope;
        this.yIntercept=yIntercept;
    }

    /**
     * findXIntercept() is used to calculate
     * X-Intercept for a linear equation.
     */
    public void findXIntercept()
    {
        try
        {
            double xIntercept;
            if(slope==0)
            {
                throw new ArithmeticException();
            }
            else{
                xIntercept=-yIntercept/slope;
                System.out.printf("For the equation y="+slope+"x+"+yIntercept+
                        " the x-Intercept is at ("+"%.2f"+",0)",xIntercept);
            }
        }
        catch(ArithmeticException arithmeticException)
        {
            System.out.println("Division by Zero is not possible.");
        }
        System.out.println();
        System.out.println();
    }


    @Override
    public String toString() {
        return "Linear Equation: y="+slope+"x+"+yIntercept;
    }
}
