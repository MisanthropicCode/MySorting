import java.util.*;

public class Main {

    public static void main(String[] args) {
        Student[] s = createStudents();

        printStudents(Arrays.asList(s));
        SelectionSort.sort(s);
        printStudents(Arrays.asList(s));

        LinkedList<Student> list = new LinkedList<Student>();

        for(Student student : s)
            list.addFirst(student);

    }

    private static Student[] createStudents() {
        return new Student[] {
                new Student("Kkhigew", "Hiuhaf", new GregorianCalendar(1990, 3, 28)),
                new Student("HGiugre", "Hisbjeb", new GregorianCalendar(1991, 3, 20)),
                new Student("BHiwwgsg", "HBkjsf", new GregorianCalendar(1992, 3, 11)),
                new Student("JBKkjsfd", "BHkdsf", new GregorianCalendar(1993, 3, 1)),
                new Student("IGUHbfd", "IGkujdf", new GregorianCalendar(1991, 3, 5)),
                new Student("KGBHjkfd", "IUGfds", new GregorianCalendar(1995, 3, 3))
        };

    }

    private static void printStudents(Iterable<Student> students) {
        printHeader();
        for(Student s: students)
            System.out.println(s);
        System.out.println();
    }

    private static void printHeader() {
        Formatter header = new Formatter();
        header.format("%-10s | %-10s | %-13s", "First Name", "Last Name", "Date");
        System.out.println(header);
    }
}
