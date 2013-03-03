import java.text.DateFormat;
import java.util.*;

public class Student implements Comparable <Student> {
    public Student(String firstName, String lastName, Calendar birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    @Override
    public int compareTo(Student that){
        return this.getBirthday().compareTo(that.getBirthday());
    }

    @Override
    public String toString() {
        DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT);
        String formattedDate = dateFormatter.format(getBirthday().getTime());

        Formatter fmt = new Formatter();
        fmt.format("%-10s | %-10s | %-13s", getFirstName(), getLastName(), formattedDate);

        return fmt.toString();
    }

    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName; }
    public Calendar getBirthday() { return birthday; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    private String firstName;
    private String lastName;
    private Calendar birthday;
}
