package postit.comment;

public class Comment {
    private String username;
    private String comment;
    private int score;

    public Comment(String username, String comment, int score) {
        this.username = username;
        this.comment = comment;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "username='" + username + '\'' +
                ", comment='" + comment + '\'' +
                ", score=" + score +
                '}';
    }
}
