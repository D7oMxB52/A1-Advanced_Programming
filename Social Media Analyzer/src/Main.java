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
        boolean exit = false;
        Scanner input = new Scanner(System.in);


        // reading csv file
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



        System.out.println("Welcome to Social Media Analyzer!");
        do {
            System.out.printf("%s\n", "-".repeat(80));
            System.out.println("> Select from main menu");
            System.out.printf("%s\n", "-".repeat(80));
            System.out.println("   1) Add a social media post");
            System.out.println("   2) Delete an existing social media post");
            System.out.println("   3) Retrieve a social media post");
            System.out.println("   4) Retrieve the top N posts with most likes");
            System.out.println("   5) Retrieve the top N posts with most shares");
            System.out.println("   6) Exit");

            try {
                int selection = input.nextInt();
                switch (selection){

                    //  1) Add a social media post
                    case 1:

                        Posts newPost = new Posts();

                        // Add new post
                        System.out.print("Please provide the post ID: ");
                        int promptedId = input.nextInt();
//                        newPost.setId(promptedId);

                        System.out.print("Please provide the post author: ");
                        String promptedAuthor = input.next();
//                        newPost.setAuthor(promptedAuthor);


                        // TODO:  make it not to contain ','
                        System.out.print("Please provide the post content: ");
                        String promptedContent = input.next();
//                        newPost.setContent(promptedContent);
                        if (promptedContent.contains(",")){
                            System.out.println("the content contain \" , \" and adding the post has been aborted.");
                            break;
                        }

                        System.out.print("Please provide the number of likes of the post: ");
                        int promptedShares = input.nextInt();
//                        newPost.setShares(promptedShares);

                        System.out.print("Please provide the number of shares of the post: ");
                        int promptedLikes = input.nextInt();
//                        newPost.setLikes(promptedLikes);

                        // TODO: Ask the lecturer more of how to use it.
                        //       Also, finish it by the end of this week.
                        System.out.println("Please provide the date and time of the post in the format of DD/MM/YYYY HH:MM:");
                        newPost.setDateTime(LocalDateTime.now());



                        newPost.setId(promptedId);
                        newPost.setAuthor(promptedAuthor);
                        newPost.setContent(promptedContent);
                        newPost.setShares(promptedShares);
                        newPost.setLikes(promptedLikes);
                        newPost.setDateTime(LocalDateTime.now());
                        postsList.add(newPost);

                        System.out.println("The post has been added to the collection!");
                        break;

                    //  2) Delete an existing social media post
                    case 2:

                        // Delete
                        System.out.println("Insert ID to delete: ");
                        int numIdForDelete = input.nextInt();

                        Delete deleteById = new Delete(numIdForDelete, postsList);
                        deleteById.deleteById();

                        break;

                    //  3) Retrieve a social media post
                    case 3:

                        // Search by ID
                        System.out.println("Insert ID: ");
                        int numIdForSearch = input.nextInt();

                        Search searchById = new Search(numIdForSearch , postsList);
                        searchById.searchById();

                        break;


                    //  4) Retrieve the top N posts with most likes
                    case 4:

                        postsList.sort(Comparator.comparingInt(Posts::getLikes).reversed());
                        for (int i = 0; i < postsList.size(); i++){
                            System.out.printf("%d)  %d  |  %s  |  %d\n",
                                    i+1,
                                    postsList.get(i).id,
                                    postsList.get(i).getContent(),
                                    postsList.get(i).getLikes());
                        }

                        break;


                    //  5) Retrieve the top N posts with most shares
                    case 5:
                        postsList.sort(Comparator.comparingInt(Posts::getShares).reversed());

                        for (int i = 0; i < postsList.size(); i++){
                            System.out.printf("%d)  %d  |  %s  |  %d\n",
                                    i+1,
                                    postsList.get(i).id,
                                    postsList.get(i).getContent(),
                                    postsList.get(i).getShares());
                        }
                        break;

                    //  6) Exit
                    case 6:
                        System.out.println("exit");
                        exit = true;
                        break;
                    default:
                        System.out.println("wrong selection");
                        break;
                }

            }
            catch (InputMismatchException e){
                System.out.println(" Incorrect input in this section");
                input.nextLine();

            }

        } while (!exit);



    }
}
