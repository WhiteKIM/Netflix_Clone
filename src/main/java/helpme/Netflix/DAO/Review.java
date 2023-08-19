package helpme.Netflix.DAO;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    @CreationTimestamp
    private Timestamp createTime;

    // 연관 관계
    @ManyToOne
    private User user;

    @ManyToOne
    private Overview overview;
}
