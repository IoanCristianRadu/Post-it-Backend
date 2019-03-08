package postit.post;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import postit.comment.Comment;

import java.util.ArrayList;

@Document(collection = "Posts")
public class Post {
    @Id
    private String id;
    private String title;
    private String content;
    private String username;
    private String photoURL;
    private ArrayList<Comment> comments;

    public Post(String title, String content, String username, String photoURL) {
        this.title = title;
        this.content = content;
        this.username = username;
        this.photoURL = photoURL;
        this.comments = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                ", photoURL='" + photoURL + '\'' +
                ", comments=" + comments +
                '}';
    }
}
