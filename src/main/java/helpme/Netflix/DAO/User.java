package helpme.Netflix.DAO;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    private String nickname;

    // 연관관계
    @OneToMany
    private List<Review> reviews;
    @OneToMany
    private List<Rate> rates;
}
