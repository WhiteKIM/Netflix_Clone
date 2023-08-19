package helpme.Netflix.DAO;

import jakarta.persistence.*;

@Entity
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rate;

    // 연관관게
    @ManyToOne
    private User user;

    @ManyToOne
    private Overview overview;
}
