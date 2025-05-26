class Main {
  public static void main(String[] args) {
    Student student1 = new Student("202215042", "Ariana Palacios");
    student1.addGrade(100);
    student1.addGrade(90); // Cambiado de "Ninety" a 90 numérico
    student1.checkHonorStatus();
    student1.removeGrade(1);
    student1.reportCard();
  }
}