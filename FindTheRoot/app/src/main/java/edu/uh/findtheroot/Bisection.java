/**
 * Created by ashikkhatri on 5/2/16.
 */
package edu.uh.findtheroot;

public class Bisection {

    private EquationBuilder er;

    public Bisection(EquationBuilder builder) {
        er = builder;
    }

    public double fval(double xval){
        double f = 0;
        if (er.coefficientArray != null) {
            for (int i = er.coefficientArray.size()-1; i >= 0; --i) {
                float temp=(float)Math.pow(xval,er.exponentArray.get(i));
                f=f+ er.coefficientArray.get(i)*temp;
            }
        }
        return f;
    }

    public double compute(double aValue,double bValue,double tolerance,double n) {
        double result = 0;
        for(int i=0;i<=n-1;i++) {
            if (fval(aValue) * fval(bValue) < 0) {
                result = (aValue + bValue) / 2;
                while(Math.abs(fval(result))>tolerance) {
                    if (fval(aValue) * fval(result) < 0) {
                        bValue = result;
                    } else {
                        aValue = result;
                    }
                    result = (aValue + bValue) / 2;
                }
            }
        }
        return result;
    }
}
