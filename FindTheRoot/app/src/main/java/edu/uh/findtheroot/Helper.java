package edu.uh.findtheroot;

import android.util.Log;

/**
 * Created by ashikkhatri on 5/5/16.
 */
public class Helper {
    public static double getDoubleFromString(String number) {
        if(number.length() <= 0) {
            return 0;
        }
        else {
            try {
                double num = Double.parseDouble(number);
                return num;
            } catch (Exception ex) {
                Log.e("Helper", ex.getMessage());
                return 0;
            }

        }
    }
}
