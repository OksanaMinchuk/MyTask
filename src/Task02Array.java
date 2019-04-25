public class Task02Array {

    public static void main(String[] args) {

        String[] names1 = {"Alex", "Dima", "Kate", "Galina", "Ivan"};
        String[] names2 = {"Dima", "Ivan", "Kate"};

        int counter = 0;
        for (int i = 0; i < names1.length; i++) {
            boolean isNameFound = true; //required name
            for (String name2: names2) {
                if(names1[i].equals(name2)) {
                    isNameFound = false;
                    counter++; //count overlap
                }
            }
            if (!isNameFound) {
                names1[i] = "";
            }
        }
//        for (String name1: names1) {
//            System.out.println(name1);
//        }
//        System.out.println("---");
        int mismatches = names1.length - counter;
        String[] wantedNames = new String[mismatches];
        for (int i = 0; i < mismatches; i++) {
            String temp = null;
            for (int j = 0; j < names1.length; j++) {
                if(!names1[j].equals("")) {
                    temp = names1[j];
                    names1[j] = "";
                    break;
                }
            }
            wantedNames[i] = temp;
        }
        for (String name: wantedNames) {
            System.out.println(name);
        }
    }
}
