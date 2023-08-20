package helpme.Netflix.DAO;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    private String nickname;

    // 연관관계
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;
    @OneToMany(mappedBy = "user")
    private List<Rate> rates;

    @Builder
    public User(Long id, String username, String password, String nickname, List<Review> reviews, List<Rate> rates) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.reviews = reviews;
        this.rates = rates;
    }
}
