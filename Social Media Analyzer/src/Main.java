import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        String csvFile = "posts.csv";
        String line = "";
        String delimiter = ",";
        List<Posts> postsList = new ArrayList<>();

        Scanner input = new Scanner(System.in);

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
        System.out.println("==================================");


        // Search by ID
        System.out.println("Insert ID: ");
        int num = input.nextInt();
        Optional<Posts> searchById = postsList.stream().filter(post -> post.getId() == num).findFirst();
        if (searchById.isPresent()) {
            System.out.println("Found post with ID " + num + ": " + searchById.get());
        } else {
            System.out.println("No post found with ID " + num);
        }
        System.out.println("==================================");



        // Delete
        System.out.println("Insert ID to delete: ");
        System.out.println(postsList);
        boolean removed = postsList.removeIf(post -> post.getId() == num);
        if (removed){
            System.out.println("The post with "+ num + " ID got deleted");
        }
        else {
            System.out.println("The post with "+ num + " ID does not exist");
        }
        System.out.println("==================================");

    }
}
