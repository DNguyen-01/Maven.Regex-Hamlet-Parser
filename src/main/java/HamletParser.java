import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = null;
        try {
            file = new File(new URI(classLoader.getResource("hamlet.txt").toString()).getPath());
        }
        catch (Exception e){

        }
            StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    //this method will mutate existing data, this will return how many instances that will change
    public int changeHamletWithLeon(){

        //pattern matcher to search for "Hamlet"
        int matchCounter = 0;
        Pattern pattern = Pattern.compile("Hamlet");
        //find all matches in hamletData
        Matcher matcher = pattern.matcher(hamletData);
        matchCounter += matcher.groupCount();
        //replace all the matcher w/ Leon
        hamletData = matcher.replaceAll("Leon");

        //searches for all uppercase
        pattern = Pattern.compile("HAMLET");
        matcher = pattern.matcher(hamletData);
        matchCounter += matcher.groupCount();
        //replace with all uppercase
        hamletData = matcher.replaceAll("LEON");

        return matchCounter;


    }

    public int changeHoratioWithTariq(){

        int matchCounter = 0;
        Pattern pattern = Pattern.compile("Horatio");
        Matcher matcher = pattern.matcher(hamletData);

        matchCounter += matcher.groupCount();
        hamletData = matcher.replaceAll("Tariq");
        pattern = Pattern.compile("HORATIO");
        matcher = pattern.matcher(hamletData);

        matchCounter += matcher.groupCount();
        hamletData = matcher.replaceAll("TARIQ");



        return matchCounter;

    }


    public int findHoratio (){
        //find where Horatio begins in the index
        //find instances of Horatio

        //match counter keeps count of the word Horatio
        int matchCounter = 0;
        //Pattern class uses .compile to search for the specific pattern to be searched for(I.e. horatio) (?i) = ignore casing
        Pattern pattern = Pattern.compile("(?i)horatio");
        //Matcher class uses .matcher to search the hamletData for the pattern
        Matcher matcher = pattern.matcher(hamletData);
        //while(loop) using the .find - if pattern is found, increment counter
        while(matcher.find()){
            matchCounter++;
        }
        return matchCounter;

    }

    public int findHamlet(){
        int matchCounter = 0;
        Pattern pattern = Pattern.compile("(?i)hamlet");
        Matcher matcher = pattern.matcher(hamletData);
        while(matcher.find()){
            matchCounter++;
        }
        return matchCounter;

    }



}

//preserve case sensitivity
