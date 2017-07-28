package com.vukoye.annotationstest;

import android.support.annotation.NonNull;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;


public class AnnotationProcessor {
    
    private static AnnotationProcessor instance;
    public static AnnotationProcessor getInstance() {
        return instance == null ? instance = new AnnotationProcessor() : instance;
    }
    
    public void process(@NonNull Object object) {
        Class<?> currentClass = object.getClass();
        List<Field> fields = Arrays.asList(currentClass.getDeclaredFields());
        for (Field field : fields) {
            if (field.getType().isAssignableFrom(Court.class)) {
                CourtParams courtAnnotation = field.getAnnotation(CourtParams.class);
                if (courtAnnotation != null) {
                    try {
                        field.setAccessible(true);
                        field.set(object, new Court(courtAnnotation.width(), courtAnnotation.length(), courtAnnotation.dimension()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void processCourt(final Object object, Field field) throws IllegalAccessException {

        if (field.getType().isAssignableFrom(TennisCourt.class)) {
            CourtParams courtParams = TennisCourt.class.getAnnotation(CourtParams.class);
            if (courtParams != null) {
                field.setAccessible(true);
                field.set(object, new TennisCourt(courtParams.width(), courtParams.length(), courtParams.dimension()));
            }
        }


    }
}
