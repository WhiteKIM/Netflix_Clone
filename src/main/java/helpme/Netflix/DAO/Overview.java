package helpme.Netflix.DAO;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity
public class Overview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @CreationTimestamp
    private Timestamp createTime;

    // 연관관계
    @OneToMany(mappedBy = "overview")
    private List<Rate> rates;
    @OneToMany(mappedBy = "overview")
    private List<Review> reviews;
    @OneToOne
    private Video video;
}
