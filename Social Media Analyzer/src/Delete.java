import java.util.List;
import java.util.Collection;
public class Delete extends Search{
    public Delete(int numId, List<Posts> postsList) {
        super(numId, postsList);
        this.numId = numId;
        this.postsList = postsList;
    }

    // Delete
    public void deleteById(){
        boolean removed = postsList.removeIf(post -> post.getId() == numId);
        if (removed){
            System.out.println("The post with "+ numId + " ID got deleted");
        }
        else {
            System.out.println("Sorry the post does not exist in the collection!");
        }
    }
}

