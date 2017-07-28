package com.vukoye.annotationstest;

public class Court {
    private double mWidth;
    private double mLength;
    public static final double CM_IN_FEET = 30.48d;

    public Court(double width, double length, CourtParams.Dimension dimension) {
        if (dimension == CourtParams.Dimension.FEETS) {
            mWidth = width * CM_IN_FEET;
            mLength = length * CM_IN_FEET;
        } else {
            mWidth = width;
            mLength = length;
        }
    }

    public String print() {
        return  "Width = " + mWidth;
    }
}
