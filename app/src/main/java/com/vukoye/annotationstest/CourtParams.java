package com.vukoye.annotationstest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CourtParams {
    public enum Dimension {CM, FEETS }
    double width();
    double length();
    Dimension dimension() default Dimension.CM;
}
