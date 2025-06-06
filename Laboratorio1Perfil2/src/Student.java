public class Student {
    public Student(String name, int age, double average) {
        this.name = name;
        this.age = age;
        this.average = average;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    private int age;
    private double average;

}
