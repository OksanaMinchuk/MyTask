import java.io.*;

public class Task03 {

    private static final String INPUT_FILE_PATH = "1.txt";
    private static final String OUPUT_FILE_PATH = "1_res.txt" ;

    public static void main(String[] args) {

        String text = readFile(INPUT_FILE_PATH);
        writeFile(OUPUT_FILE_PATH, text);

    }

    public static String readFile(String inputFilePath) {
        StringBuilder stringBuilder = new StringBuilder();

        try {

            FileInputStream fis = new FileInputStream(inputFilePath);
            InputStreamReader ist = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(ist);

            String read;
            while ((read = br.readLine()) != null) {
                stringBuilder.append(read);
                stringBuilder.append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static void writeFile(String outputFilePath, String str) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(outputFilePath);
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

