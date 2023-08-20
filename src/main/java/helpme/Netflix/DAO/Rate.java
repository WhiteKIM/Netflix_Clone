package helpme.Netflix.DAO;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rate;

    // 연관관게
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "overview_id")
    private Overview overview;

    @Builder
    public Rate(Long id, int rate, User user, Overview overview) {
        this.id = id;
        this.rate = rate;
        this.user = user;
        this.overview = overview;
    }
}
