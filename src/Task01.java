import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task01 {

    private static final String DIR_PATH = "DataFolder";
    private static final String REGEX_FILENAME = "^(file).*";

    public static void main(String[] args) {

        File dir = new File(DIR_PATH);
        List<File> fileListByName = new ArrayList<>();
        Pattern pattern = Pattern.compile(REGEX_FILENAME);
        Matcher matcher;

        //find files by name
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (int i = 0; i < files.length; i++) {
                matcher = pattern.matcher(files[i].getName());
                if (matcher.matches()) {
                    fileListByName.add(files[i]);
                }
            }
        }

        System.out.println("\tFind files by name pattern:");
        for (File file: fileListByName) {
            System.out.println(file.getName() + " - " + new Date(file.lastModified()));
        }

        //find last file
        List<File> fileListWanted = new ArrayList<>(); //list of files different from lastFile no more than 10_000 milliseconds
        Date lastDate;
        Date tempDate;
        File lastFile = fileListByName.get(0);
        lastDate = new Date(lastFile.lastModified());
        for (int i = 1; i < fileListByName.size(); i++) {
            tempDate = new Date(fileListByName.get(i).lastModified());
            if (tempDate.after(lastDate)) {
                lastFile = fileListByName.get(i);
                lastDate = tempDate;
            } else if ((lastDate.getTime() - tempDate.getTime()) <= 10_000) {
                fileListWanted.add(fileListByName.get(i));
            }
        }

        System.out.println("\tLast file is: " + lastFile.getName());

        System.out.println("\tList of files different from lastFile no more than 10_000 milliseconds:");
        for (File file: fileListWanted) {
            System.out.println(file.getName());
        }
    }
}
