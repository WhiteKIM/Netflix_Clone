package helpme.Netflix.DTO.Request;

import helpme.Netflix.DAO.Overview;
import helpme.Netflix.DAO.Review;
import helpme.Netflix.DAO.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class RequestReviewDTO {
    private Long id;
    private String content;
    private Timestamp timestamp;
    private User user;
    private Overview overview;

    @Builder
    public RequestReviewDTO(Long id, String content, Timestamp timestamp, User user, Overview overview) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
        this.user = user;
        this.overview = overview;
    }

    public Review toEntity() {
        return Review.builder()
                .id(id)
                .content(content)
                .createTime(timestamp)
                .user(user)
                .overview(overview)
                .build();
    }
}
