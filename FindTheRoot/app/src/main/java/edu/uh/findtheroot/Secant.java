/**
 * Created by ashikkhatri on 5/2/16.
 */
package edu.uh.findtheroot;

public class Secant {

    private EquationBuilder er;

    public Secant(EquationBuilder builder) {
        er = builder;
    }

    double fval( double xval)
    {
        double f=0;
        if (er.coefficientArray != null) {
            for (int i = er.coefficientArray.size()-1; i >= 0; --i) {
                float temp=(float)Math.pow(xval,er.exponentArray.get(i));
                f=f+ (er.coefficientArray.get(i)*temp);
            }
        }
        return f;
    }


    public double compute(double aValue,double bValue,double tolerance, double n)
    {
        double result = 0;
        for(int i=1;i<=n;i++) {
            result=bValue-((bValue-aValue)/(fval(bValue)-fval(aValue))*fval(bValue));
            aValue=bValue;
            bValue=result;
            if(Math.abs(fval(result))<tolerance)
            {
                break;
            }
        }
        return result;
    }

}
