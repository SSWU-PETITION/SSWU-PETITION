package Webo0.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Post {
    Long member_id; //primary key
    LocalDateTime localDateTime; //primary key
    String PostName;
    String Post;
    Boolean anonymous;
    int likeNum;

    List<Comment> comments;
}
