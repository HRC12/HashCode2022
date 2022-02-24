import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        DataContainer data = DataIngest.ReadFile("a_an_example.txt");
        ArrayList<Contributor> contributors = data.contributors;
        ArrayList<Project> projects = data.projects;
    }
}
