public class Output {
    public Output() {
        System.out.println("Sl.\tCourse\t\tCredits\t\tGrade\t\tGrade Points");
        for (int i = 0; i < Student.Courses.length; i++) {
            System.out.println((i + 1) + "\t" + Student.Courses[i] + "\t\t\t" + Student.Credits[i] + "\t\t\t" + Student.Grades[i] + "\t\t\t" + Student.GP[i]);
        }
        System.out.println("SGPA: " + Calculate.SGPA);
    }
}