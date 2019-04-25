import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task02Collection {

    public static void main(String[] args) {
        String[] arr1 = {"Alex", "Dima", "Kate", "Galina", "Ivan"};
        String[] arr2 = {"Dima", "Ivan", "Kate"};

        List<String> names1 = Arrays.asList(arr1);
        List<String> names2 = Arrays.asList(arr2);

        List<String> wantedNames = new ArrayList<>();

        for (String name1: names1) {
            boolean isNameFound = true;
            for (String name2: names2) {
                if (name1.equals(name2)) {
                    isNameFound = false;
                }
            }
            if (isNameFound) {
                wantedNames.add(name1);
            }
        }

        for (String name: wantedNames) {
            System.out.println(name);
        }
    }
}
