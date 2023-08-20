package helpme.Netflix.DAO;

import helpme.Netflix.DTO.Request.RequestOverViewDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Overview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @CreationTimestamp
    private Timestamp createTime;

    // 연관관계
    @OneToMany(mappedBy = "overview")
    private List<Rate> rates = new ArrayList<>();
    @OneToMany(mappedBy = "overview")
    private List<Review> reviews = new ArrayList<>();
    @OneToOne
    private Video video;

    @Builder
    public Overview(Long id, String content, Timestamp createTime, List<Rate> rates, List<Review> reviews, Video video) {
        this.id = id;
        this.content = content;
        this.createTime = createTime;
        this.rates = rates;
        this.reviews = reviews;
        this.video = video;
    }
}
