package DB;

import java.util.Date;

public class Posts {
    private Long id;
    private User authod_id;
    private String title;
    private String short_content;
    private String content;
    private Date post_date;

    public Posts() {
    }

    public Posts(Long id, User authod_id, String title, String short_content, String content, Date post_date) {
        this.id = id;
        this.authod_id = authod_id;
        this.title = title;
        this.short_content = short_content;
        this.content = content;
        this.post_date = post_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthod_id() {
        return authod_id;
    }

    public void setAuthod_id(User authod_id) {
        this.authod_id = authod_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShort_content() {
        return short_content;
    }

    public void setShort_content(String short_content) {
        this.short_content = short_content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPost_date() {
        return post_date;
    }

    public void setPost_date(Date post_date) {
        this.post_date = post_date;
    }
}
