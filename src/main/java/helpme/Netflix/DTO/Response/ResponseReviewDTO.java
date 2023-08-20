package helpme.Netflix.DTO.Response;

import helpme.Netflix.DAO.Overview;
import helpme.Netflix.DAO.Review;
import helpme.Netflix.DAO.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class ResponseReviewDTO {
    private Long id;
    private String content;
    private Timestamp timestamp;
    private User user;
    private Overview overview;

    @Builder
    public ResponseReviewDTO(Long id, String content, Timestamp timestamp, User user, Overview overview) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
        this.user = user;
        this.overview = overview;
    }

    public ResponseReviewDTO toDto(Review review) {
        return ResponseReviewDTO.builder()
                .id(review.getId())
                .content(review.getContent())
                .timestamp(review.getCreateTime())
                .user(review.getUser())
                .overview(review.getOverview())
                .build();
    }
}
