import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String csvFile = "posts.csv";
        String line = "";
        String delimiter = ",";
        List<Posts> postsList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream(csvFile)))) {
            // skipping the header
            br.readLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm");
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(delimiter);
                postsList.add(new Posts(Integer.parseInt(fields[0]), fields[1], fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[4]), LocalDateTime.parse(fields[5], formatter)));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Descending order in likes
        postsList.sort(Comparator.comparingInt(Posts::getLikes).reversed());
        System.out.println(postsList);
        System.out.println("==================================");
        // Descending order in shares
        postsList.sort(Comparator.comparingInt(Posts::getShares).reversed());
        System.out.println(postsList);

    }


}
