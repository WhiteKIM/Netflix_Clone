package helpme.Netflix.DTO.Request;

import helpme.Netflix.DAO.Rate;
import helpme.Netflix.DAO.Review;
import helpme.Netflix.DAO.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RequestUserDTO {
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private List<Review> reviews;
    private List<Rate> rates;

    @Builder
    public RequestUserDTO(Long id, String username, String password, String nickname, List<Review> reviews, List<Rate> rates) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.reviews = reviews;
        this.rates = rates;
    }

    public User toEntity() {
        return User.builder()
                .id(id)
                .username(username)
                .password(password)
                .nickname(nickname)
                .reviews(reviews)
                .rates(rates)
                .build();
    }
}
