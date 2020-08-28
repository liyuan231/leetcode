package JAVA;

import JAVA.annotation.AnnotationTest;

import java.lang.annotation.Annotation;

public class SubAnnotationTest extends AnnotationTest {
    public static void main(String[] args) {
        Annotation[] declaredAnnotations = SubAnnotationTest.class.getDeclaredAnnotations();
        Annotation[] annotations1 = SubAnnotationTest.class.getAnnotations();
        System.out.print("SubAnnotationTest.class:");
        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.print(declaredAnnotation+" ");
        }
        for (Annotation annotation : annotations1) {
            System.out.print(annotation+" ");
        }
        System.out.println();
        Annotation[] annotations = AnnotationTest.class.getDeclaredAnnotations();
        Annotation[] annotations2 = AnnotationTest.class.getAnnotations();
        System.out.print("AnnotationTest.class:");
        for (Annotation annotation : annotations) {
            System.out.print(annotation+" ");
        }
        for (Annotation annotation : annotations) {
            System.out.print(annotation+" ");
        }
        System.out.println();
    }
}
