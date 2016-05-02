package edu.uh.findtheroot;

import java.lang.Math;

public class NewtonRaphson
{
    private EquationBuilder er;

    public NewtonRaphson(EquationBuilder builder) {
        er = builder;
    }

    private double fval(double xval) {
        double f = 0;
        double temp;
        if (er.coefficientArray != null) {
            f = 0;
            for (int i = er.coefficientArray.size()-1; i >= 0; --i) {
                temp = (float)Math.pow(xval,er.exponentArray.get(i));
                f= f+ er.coefficientArray.get(i)*temp;
            }
        }
        return f;
    }

    private double fdotval(double xval){
        double temp;
        double fdot = 0;
        if (er.coefficientArray != null) {
            fdot=0;
            for (int i = er.coefficientArray.size()-1; i >= 0; --i) {
                temp = (float) Math.pow(xval,(er.exponentArray.get(i))-1);
                fdot = fdot+(er.coefficientArray.get(i)*er.exponentArray.get(i)*temp);
            }
        }
        return fdot;
    }

    public double compute(double init_guess, double tolerance, double n)
    {
        double f, fdot, x;

        for(int i = 1; i <= n; i++)
        {
            x = init_guess;
            f = fval(x);
            fdot = fdotval(x);
            init_guess = x - f/fdot; //Newton Method formula
            if (Math.abs(x-init_guess) < tolerance){
                break;
            }
        }

        return init_guess;
    }
}
