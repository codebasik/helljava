package helljava.domain;

/**
 * Created by yongjunjung on 2016. 7. 25..
 */
public class Board {

    private int seq;
    private String title;
    private String content;
    private String username;

    public Board() {
    }

    public Board(int seq, String title, String content, String username) {
        this.seq = seq;
        this.title = title;
        this.content = content;
        this.username = username;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
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

    @Override
    public String toString() {
        return "Board{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
