package helpme.Netflix.DTO.Request;

import helpme.Netflix.DAO.Overview;
import helpme.Netflix.DAO.Rate;
import helpme.Netflix.DAO.Review;
import helpme.Netflix.DAO.Video;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
public class RequestOverViewDTO {
    private Long id;
    private String content;
    private Timestamp timestamp;
    private List<Rate> rates;
    private List<Review> reviews;
    private Video video;

    @Builder
    public RequestOverViewDTO(Long id, String content, Timestamp timestamp, List<Rate> rates, List<Review> reviews, Video video) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
        this.rates = rates;
        this.reviews = reviews;
        this.video = video;
    }

    public Overview toEntity() {
        return Overview.builder()
                .id(id)
                .content(content)
                .createTime(timestamp)
                .rates(rates)
                .reviews(reviews)
                .video(video)
                .build();
    }
}
