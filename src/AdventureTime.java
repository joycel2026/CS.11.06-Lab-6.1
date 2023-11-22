import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        writeFileAllAnswers("answers", challengeOne("InputOneTwo.txt"), challengeTwo("InputOneTwo.txt"),challengeThree("InputThreeFour.txt"),challengeFour("InputThreeFour.txt"));
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int[] file = readFile(fileName);
        int result = 0;
        for (int i = 1; i<countLinesInFile(fileName);i++){
            if (file[i]>file[i-1]){
                result++;
            }
        }
        return result;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int[] file = readFile(fileName);
        int number = ((countLinesInFile(fileName))-((countLinesInFile(fileName))%3));
        int result = 0;
        for (int i = 0; i<number-2;i++){
            int previous = (file[i]+file[i+1]+file[i+2]);
            int after = (file[i+1]+file[i+2]+file[i+3]);
            if (after>previous){
                result++;
            }
        }
        return result;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        String[] file = stringReadFile(fileName);
        int horizontal = 0;
        int depth = 0;
        for (int i = 0; i < countLinesInFile(fileName);i++){
            if (file[i].contains("forward")){
                String value = file[i].substring(8);
                horizontal = horizontal+ Integer.parseInt(value);
            }
            if (file[i].contains("up")){
                String value = file[i].substring(3);
                depth = depth - Integer.parseInt(value);
            }
            if (file[i].contains("down")){
                String value = file[i].substring(5);
                depth = depth + Integer.parseInt(value);
            }
        }
        return horizontal*depth;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        String[] file = stringReadFile(filename);
        int horizontal = 0;
        int depth = 0;
        int aim = 0;
        for (int i = 0; i < countLinesInFile(filename);i++){
            if (file[i].contains("forward")){
                String value = file[i].substring(8);
                horizontal = horizontal+ Integer.parseInt(value);
                depth = depth + Integer.parseInt(value)*aim;
            }
            if (file[i].contains("up")){
                String value = file[i].substring(3);
                aim = aim - Integer.parseInt(value);
            }
            if (file[i].contains("down")){
                String value = file[i].substring(5);
                aim = aim + Integer.parseInt(value);
            }
        }
        return horizontal*depth;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    private static String[] stringReadFile(String inputFilename) throws FileNotFoundException{
        File file = new File(inputFilename);
        Scanner scanner = new Scanner (file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()){
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}