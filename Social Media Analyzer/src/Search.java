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
            System.out.printf("%d  |  %s  |  %d\n",searchById.get().id,searchById.get().content,searchById.get().likes);
        } else {
            System.out.println("Sorry the post does not exist in the collection! ");
        }

    }

}
