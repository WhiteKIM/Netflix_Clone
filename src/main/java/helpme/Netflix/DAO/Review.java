package helpme.Netflix.DAO;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    @CreationTimestamp
    private Timestamp createTime;

    // 연관 관계
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "overview_id")
    private Overview overview;

    @Builder
    public Review(Long id, String content, Timestamp createTime, User user, Overview overview) {
        this.id = id;
        this.content = content;
        this.createTime = createTime;
        this.user = user;
        this.overview = overview;
    }
}
