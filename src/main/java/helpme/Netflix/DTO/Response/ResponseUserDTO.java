package helpme.Netflix.DTO.Response;

import helpme.Netflix.DAO.Rate;
import helpme.Netflix.DAO.Review;
import helpme.Netflix.DAO.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ResponseUserDTO {
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private List<Review> reviews;
    private List<Rate> rates;

    @Builder
    public ResponseUserDTO(Long id, String username, String password, String nickname, List<Review> reviews, List<Rate> rates) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.reviews = reviews;
        this.rates = rates;
    }

    public ResponseUserDTO toDto(User user) {
        return ResponseUserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .nickname(user.getNickname())
                .reviews(user.getReviews())
                .rates(user.getRates())
                .build();
    }
}
