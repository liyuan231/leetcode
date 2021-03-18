package designPattern.mvc;

public class Main {
    public static void main(String[] args) {
        Student model = retrieveStudentFromDatabase();
        StudentView view = new StudentView();
        StudentController studentController = new StudentController(model,view);
        studentController.updateView();

        studentController.setStudentName("Liyuan");
        studentController.setStudentRollNo("999");
        studentController.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
//        return null;
        Student student = new Student();
        student.setName("yuanxi");
        student.setRollNo("777");
        return student;
    }

}
