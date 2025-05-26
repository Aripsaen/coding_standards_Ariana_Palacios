import java.util.ArrayList;
import java.util.List;

class Student {
  // poner privados los atributos
  private String id;
  private String name;
  private List<Double> grades; // Especificar tipo de datos
  private boolean honor;
  private String passStatus; // "Passed" o "Failed"


  public Student(String id, String name) {
    if (id == null || id.isEmpty()) {
      throw new IllegalArgumentException("ID no puede estar vacío");
    }
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Nombre no puede estar vacío");
    }
    this.id = id;
    this.name = name;
    this.grades = new ArrayList<>();
    this.passStatus = "Unknown";
    this.honor = false;
  }

  public void addGrade(double grade) {
    if (grade < 0 || grade > 100) {
      System.out.println("Error: La nota debe estar entre 0 y 100");
      return;
    }
    grades.add(grade);
    updateStatus(); // actualizar estado tras agregar nota
  }

  public double average() {
    if (grades.isEmpty()) {
      return 0;
    }
    double total = 0;
    for (double g : grades) {
      total += g;
    }
    return total / grades.size();
  }

  public char getLetterGrade() {
    double avg = average();
    if (avg >= 90) {
      return 'A';
    }
    if (avg >= 80) {
      return 'B';
    }
    if (avg >= 70) {
      return 'C';
    }
    if (avg >= 60) {
      return 'D';
    }
    return 'F';
  }

  public void checkHonorStatus() {
    honor = average() > 90;
  }

  private void updateStatus() {
    double avg = average();
    passStatus = (avg >= 60) ? "Passed" : "Failed";
    honor = (avg >= 90);
  }

  public void removeGrade(int index) {
    if (index < 0 || index >= grades.size()) {
      System.out.println("Error: Índice fuera de rango");
      return;
    }
    grades.remove(index);
    updateStatus(); // actualizar estado tras eliminar nota
  }

  // Elimina nota por valor (primera aparición), con manejo de error
  public void removeGradeByValue(double grade) {
    if (!grades.remove(grade)) {
      System.out.println("Error: No se encontró la nota " + grade);
      return;
    }
    updateStatus(); // actualizar estado tras eliminar nota
  }

  public void reportCard() {
    System.out.println("Student ID: " + id);
    System.out.println("Student Name: " + name);
    System.out.println("Number of Grades: " + grades.size());
    System.out.printf("Average Grade: %.2f%n", average());
    System.out.println("Letter Grade: " + getLetterGrade());
    System.out.println("Pass/Fail Status: " + passStatus);
    System.out.println("Honor Roll: " + (honor ? "Yes" : "No"));
  }
}
