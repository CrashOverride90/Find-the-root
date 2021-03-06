/**
 * Created by ashikkhatri on 5/2/16.
 */
package edu.uh.findtheroot;

public class RegulaFalsi {

    private EquationBuilder er;

    public RegulaFalsi(EquationBuilder builder) {
        er = builder;
    }

    public double fval(double xval) {
        double f = 0;
        if (er.coefficientArray != null) {
            for (int i = er.coefficientArray.size()-1; i >= 0; --i) {
                float temp=(float)Math.pow(xval,er.exponentArray.get(i));
                f=f+ er.coefficientArray.get(i)*temp;
            }
        }
        return f;

    }

    public double compute(double aValue, double bValue, double tolerance, double n)
    {
        double count=0;
        double result2 = 0;
        double result = ((aValue*fval(bValue))-(bValue*fval(aValue)))/(fval(bValue)-fval(aValue));
        for(int i=0;i<=n-1;i++) {
            if (fval(aValue)*fval(result)<0)
                bValue=result;
            else
                aValue=result;
            result2=result;
            result=((aValue*fval(bValue))-(bValue*fval(aValue)))/(fval(bValue)-fval(aValue));
            if(Math.abs(result2-result)<tolerance)
            {
                break;
            }
        }
        return result;
    }

}
