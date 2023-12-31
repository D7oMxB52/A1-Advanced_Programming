import java.time.LocalDateTime;

public class Posts {
    int id;
    String content;
    String author;
    int likes;
    int shares;
    String dateTime;

    public Posts() {
    }

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", likes=" + likes +
                ", shares=" + shares +
                ", dateTime=" + dateTime +
                '}';
    }

    public Posts(int id, String content, String author, int likes, int shares, String dateTime) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.likes = likes;
        this.shares = shares;
        this.dateTime = dateTime;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }


}
