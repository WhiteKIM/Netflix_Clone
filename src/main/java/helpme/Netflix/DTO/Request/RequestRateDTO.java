package helpme.Netflix.DTO.Request;

import helpme.Netflix.DAO.Overview;
import helpme.Netflix.DAO.Rate;
import helpme.Netflix.DAO.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestRateDTO {
    private Long id;
    private int rate;
    private User user;
    private Overview overview;

    @Builder
    public RequestRateDTO(Long id, int rate, User user, Overview overview) {
        this.id = id;
        this.rate = rate;
        this.user = user;
        this.overview = overview;
    }

    public Rate toEntity() {
        return Rate.builder()
                .id(id)
                .rate(rate)
                .user(user)
                .overview(overview)
                .build();
    }
}
