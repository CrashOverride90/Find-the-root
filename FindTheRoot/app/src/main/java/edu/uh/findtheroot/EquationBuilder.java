package edu.uh.findtheroot;

import java.util.ArrayList;

public class EquationBuilder {

    public ArrayList<Double> coefficientArray = new ArrayList<Double>();
    public ArrayList<Integer> exponentArray = new ArrayList<Integer>();

    public EquationBuilder(ArrayList<Double> coeff, ArrayList<Integer> exps) {
        coefficientArray = coeff;
        exponentArray = exps;
    }

}