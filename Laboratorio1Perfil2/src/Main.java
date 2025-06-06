import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeMap<Integer, Student> students = new TreeMap<>();
        int globalOption = 0;
        boolean validator = true;
        while(validator){
            System.out.println("Opciones");
            System.out.println("1. Crear estudiante");
            System.out.println("2. Mostrar todos los estudiantes");
            System.out.println("3. Actualizar estudiante");
            System.out.println("4. Eliminar estudiante");
            System.out.println("5. Buscar por ID");
            System.out.println("6. Salir");
            String option = scan.nextLine();
            if (isInteger(option)) {
                globalOption= Integer.parseInt(option);
                if(globalOption == 1){
                    addStudent(students);
                } else if (globalOption ==2) {
                    showAllStudents(students);
                } else if (globalOption ==3) {
                    updateSingleStudent(students);
                } else if (globalOption ==4) {
                    removeStudent(students);
                } else if (globalOption==5) {
                    showSingleStudent(students);
                }else{
                    System.out.println("Favor ingresar una opcion vaida");
                }
                validator = globalOption !=6;
            }else{
                System.out.println("ERROR: Favor proporcionar un numero entero");
                System.out.println("Enter para continuar");
                scan.nextLine();
            }

        }
    }
    public static void addStudent(TreeMap<Integer, Student> students){
        Scanner scan = new Scanner(System.in);
        int globalCode=0;
        System.out.println("Ingresa el codigo del estudiante");
        String code = scan.nextLine();
        if (isInteger(code)){
            globalCode = Integer.parseInt(code);
        }else {
            System.out.println("Favor proporcionar un numero para el codigo");
            return;
        }
        if (students.containsKey(globalCode)){
            System.out.println("Ya hay un estudiante con ese ID");
            return;
        }
        if (globalCode <= 0){
            System.out.println("Favor ingresar un numero mayor a 1");
            return;
        }
        System.out.println("Ingresa el nombre del estudiante");
        String name = scan.nextLine();
        System.out.println("Ingresa la edad del estudiante");
        int age = scan.nextInt();
        scan.nextLine();
        if (age <= 0){
            System.out.println("Error: la edad no puede ser menor a 1");
            return;
        }
        System.out.println("Ingresa el promedio del estudiante");
        double average = scan.nextDouble();
        scan.nextLine();
        if(average >= 1  && average <=10){
            students.put(globalCode,new Student(name, age, average));
        }else{
            System.out.println("ERROR: Promedio o edad no valido, asegurate de que el promedio sea decimal y la edad entera, ademas de que el promedio no pase de 10");
        }
        System.out.println("Enter para continuar");
        scan.nextLine();

    }
    public static void showAllStudents(TreeMap<Integer, Student> students){
        Scanner scan = new Scanner(System.in);
        if (students.isEmpty()){
            System.out.println("No hay estudiantes para ingresar");
            return;
        }
        for(Map.Entry<Integer, Student> student : students.entrySet()){
            System.out.println("Codigo: "+student.getKey()+" Datos: Nombre " + student.getValue().getName() +"/Edad "+ student.getValue().getAge()+ "/Promedio "+student.getValue().getAverage());
        }
        System.out.println("Enter para continuar");
        scan.nextLine();
    }
    public static void updateSingleStudent(TreeMap<Integer, Student> students){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa el codigo del estudiante al cual quieres actualizar");
        int code = scan.nextInt();
        scan.nextLine();
        if (code <= 0){
            System.out.println("Valor no valido: Favor ingresar un numero mayor a 1");
            return;
        }
        if(students.containsKey(code)){
            Student estudiante = students.get(code);
            String name = estudiante.getName();
            int age = estudiante.getAge();
            double average = estudiante.getAverage();
            System.out.println("Que quieres actualizar");
            System.out.println("1. Nombre");
            System.out.println("2. Edad");
            System.out.println("3. Promedio");
            int option = scan.nextInt();
            scan.nextLine();
            if (option == 1){
                System.out.println("Que nombre le quieres poner");
                name = scan.nextLine();
                students.put(code, new Student(name, age, average));
            } else if (option ==2) {
                System.out.println("Que edad le quieres poner");
                age = scan.nextInt();
                scan.nextLine();
                if(age <= 0){
                    System.out.println("ERROR: Favor ingresa un edad valida");
                    return;
                }
                students.put(code, new Student(name, age, average));
            } else if (option ==3) {
                System.out.println("Que promedio le quieres poner");
                average = scan.nextDouble();
                scan.nextLine();
                if(average < 1 ){
                    System.out.println("Favor ingresa un promedio valido: No puede ser menor a 1");
                    return;
                }
                if(average >= 11 ){
                    System.out.println("Favor ingresa un promedio valido: No puede ser mayor a 10");
                    return;
                }
                students.put(code, new Student(name, age, average));
            }else{
                System.out.println("No hay un estudiante con ese ID");
            }
        }else {
            System.out.println("No hay ningun estudiante el cual coincida con el codigo proporcionado");
        }
        System.out.println("Enter para continuar");
        scan.nextLine();

    }
    public static void removeStudent(TreeMap<Integer, Student> students){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa el codigo del estudiante al cual quieres eliminar");
        int code = scan.nextInt();
        scan.nextLine();
        if (code <= 0){
            System.out.println("Valor no valido: Favor ingresar un numero mayor a 1");
            return;
        }
        if (students.containsKey(code)){
            students.remove(code);
        }else{
            System.out.println("No existe un estudiante con ese codigo");
        }
        System.out.println("Enter para continuar");
        scan.nextLine();

    }
    public  static void  showSingleStudent(TreeMap<Integer, Student> students){
        Scanner scan = new Scanner(System.in);
        if (students.isEmpty()){
            System.out.println("No hay estudiantes registrados");
            System.out.println("Enter para continuar");
            scan.nextLine();
            return;
        }
        System.out.println("Ingresa el codigo del estudiante");
        int code = scan.nextInt();
        scan.nextLine();
        Student student = students.get(code);
        if (students.containsKey(code)) {
            System.out.println("Codigo: "+ code+" Datos: Nombre " + student.getName() +"/Edad "+ student.getAge()+ "/Promedio "+student.getAverage());
            System.out.println("Enter para continuar");
        }else{
            System.out.println("ERROR: no existe ningun estudiante con ese codigo");
        }
        System.out.println("Enter para continuar");
        scan.nextLine();

    }
    public static boolean isInteger(String text) {
        int v;
        try {
            v=Integer.parseInt(text);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}