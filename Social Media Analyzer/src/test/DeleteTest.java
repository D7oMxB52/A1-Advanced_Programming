import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DeleteTest {
    private List<Posts> postsList;
    private Posts newPost1;
    private Posts newPost2;
    @Before
    public void setUp(){

        //dummy postslist
        postsList = new ArrayList<>();

        //making 2 posts
        newPost1 = new Posts();
        newPost1.setId(1);
        newPost1.setAuthor("abdul");
        newPost1.setContent("hello there");
        newPost1.setShares(500);
        newPost1.setLikes(400);
        newPost1.setDateTime("13/12/2013 20:15");
        postsList.add(newPost1);

        newPost2 = new Posts();
        newPost2.setId(2);
        newPost2.setAuthor("wania");
        newPost2.setContent("this is wania :)");
        newPost2.setShares(1000);
        newPost2.setLikes(900);
        newPost2.setDateTime("17/11/2021 20:15");
        postsList.add(newPost2);

    }

    @Test
    public void testDeleteByIdWithExistedPost(){

        // we will try to remove the post with id num 2
        int removedPostID = 2;
        Delete deleteById = new Delete(removedPostID , postsList);

        // we expected that num 2 is now deleted and the results is following:
        String expectedResult = "The post with "+ removedPostID + " ID got deleted";

        //test search functionality
        assertEquals(expectedResult, deleteById.deleteById());


    }

    @Test
    public void testDeleteByIdWithNonExistedPost(){

        // as we know we have post 1&2, lets search for 3 (which is not exist).
        // we expect that the result will be the following: "Sorry the post does not exist in the collection!"

        int nonExistedPostID = 3;
        Delete deleteById = new Delete(nonExistedPostID , postsList);

        String expectedResult = "Sorry the post does not exist in the collection!";
        assertEquals(expectedResult, deleteById.deleteById());


    }

}