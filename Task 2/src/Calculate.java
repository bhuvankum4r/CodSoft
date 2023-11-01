public class Calculate {
    public static float SGPA;

    public Calculate() {
        for (int i = 0; i < Student.Externals.length; i++) {
            if(Student.Externals[i]>50)
                Student.Externals[i] /= 2;
            Student.Marks[i] = Student.Externals[i] + Student.Internals[i];
            if (Student.Marks[i] >= 90 && Student.Marks[i] <= 100) {
                Student.GP[i] = 10;
                Student.Grades[i] = "O";
            } else if (Student.Marks[i] >= 80 && Student.Marks[i] <= 89) {
                Student.GP[i] = 9;
                Student.Grades[i] = "A+";
            } else if (Student.Marks[i] >= 70 && Student.Marks[i] <= 79) {
                Student.GP[i] = 8;
                Student.Grades[i] = "A";
            } else if (Student.Marks[i] >= 60 && Student.Marks[i] <= 69) {
                Student.GP[i] = 7;
                Student.Grades[i] = "B+";
            } else if (Student.Marks[i] >= 55 && Student.Marks[i] <= 59) {
                Student.GP[i] = 6;
                Student.Grades[i] = "B";
            } else if (Student.Marks[i] >= 50 && Student.Marks[i] <= 54) {
                Student.GP[i] = 5;
                Student.Grades[i] = "C";
            } else if (Student.Marks[i] >= 40 && Student.Marks[i] <= 49) {
                Student.GP[i] = 4;
                Student.Grades[i] = "P";
            } else {
                Student.GP[i] = 0;
                Student.Grades[i] = "F";
            }
        }
        int totalCredits = 0, totalGP = 0;
        for (int i = 0; i < Student.Credits.length; i++)
        {
            totalCredits += Student.Credits[i];
            totalGP = totalGP + (Student.Credits[i] * Student.GP[i]);
        }
        SGPA = (float) totalGP / totalCredits;
        Output output = new Output();
    }
}
