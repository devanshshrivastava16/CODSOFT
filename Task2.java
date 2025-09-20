import java.util.*;
class Task2 {                
    String grade(int n) { 
        String g; 
        if (n >= 90 && n <= 100) { 
            g = "A+";     
        } else if (n >= 80 && n < 90) {
            g = "A";
        } else if (n >= 70 && n < 80) {
            g = "A-";
        } else if (n >= 60 && n < 70) {
            g = "B+";
        } else if (n >= 50 && n < 60) {
            g = "B";
        } else if (n >= 40 && n < 50) {
            g = "B-";
        } else if (n >= 30 && n < 40) {
            g = "C+";
        } else if (n < 30) {
            g = "F";
        } else {
            g = "Invalid score";
        }
        return g;
    }

    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Subjects:");
        int r = sc.nextInt();

        int sum = 0;
        System.out.println("Enter Marks of " + r + " Subjects:");
        for (int i = 0; i < r; i++) {
            int mark = sc.nextInt();
            sum += mark;
        }
        sc.close();
        average(sum, r);
    }

    void average(int totalMarks, int subjects) {
        double avg = (double) totalMarks / subjects;
        double percentage = (avg / 100) * 100; // Assuming max marks per subject is 100
        display(percentage, totalMarks);
    }

    void display(double percentage, int totalMarks) {
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", percentage);
        System.out.println("Grade: " + grade((int) percentage));
    }

    public static void main(String args[]) {
        Task2 ob = new Task2();
        ob.input();
    }
}
