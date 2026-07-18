
import java.util.ArrayList;
import java.util.Scanner;

class Patient {
       static final String URL = "jdbc:mysql://localhost:3306/company";

    static final String USER = "root";

    static final String PASSWORD = "test@123";   // Change to your MySQL password
    int patientId;
    String name;
    int age;
    String gender;
    String disease;
    String doctor;
    String contact;

    Patient(int patientId, String name, int age, String gender,
            String disease, String doctor, String contact) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
        this.doctor = doctor;
        this.contact = contact;
    }

    void display() {
        System.out.println("---------------------------------------");
        System.out.println("Patient ID   : " + patientId);
        System.out.println("Name         : " + name);
        System.out.println("Age          : " + age);
        System.out.println("Gender       : " + gender);
        System.out.println("Disease      : " + disease);
        System.out.println("Doctor       : " + doctor);
        System.out.println("Contact No.  : " + contact);
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Patient> patients = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== Hospital Management System =====");
            System.out.println("1. Add Patient");
            System.out.println("2. Display All Patients");
            System.out.println("3. Search Patient by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Gender: ");
                    String gender = sc.nextLine();

                    System.out.print("Enter Disease: ");
                    String disease = sc.nextLine();

                    System.out.print("Enter Doctor Name: ");
                    String doctor = sc.nextLine();

                    System.out.print("Enter Contact Number: ");
                    String contact = sc.nextLine();

                    patients.add(new Patient(id, name, age, gender,
                            disease, doctor, contact));

                    System.out.println("Patient added successfully!");
                    break;

                case 2:
                    if (patients.isEmpty()) {
                        System.out.println("No patient records found.");
                    } else {
                        for (Patient p : patients) {
                            p.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Patient ID to Search: ");
                    int searchId = sc.nextInt();

                    boolean found = false;
                    for (Patient p : patients) {
                        if (p.patientId == searchId) {
                            p.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using Hospital Management System.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
} 
