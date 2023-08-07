import java.util.List;
import java.util.Optional;
public class Search {
    int numId;
    List<Posts> postsList;
    public Search(int numId, List<Posts> postsList) {
        this.numId = numId;
        this.postsList = postsList;
    }

    public void searchById(){

        Optional<Posts> searchById = postsList.stream().filter(post -> post.getId() == numId).findFirst();
        if (searchById.isPresent()) {
            System.out.println("Found post with ID " + numId + ": " + searchById.get());
        } else {
            System.out.println("No post found with ID " + numId);
        }

    }

}
