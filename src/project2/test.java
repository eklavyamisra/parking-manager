package project2;

class Student {
    String name;
}

public class test {
    static void changeName(Student s) {
        s.name = "Naman";
    }

    public static void main(String[] args) {
        Student st = new Student();
        st.name = "Rahul";

        changeName(st);

        System.out.println(st.name);
    }
}