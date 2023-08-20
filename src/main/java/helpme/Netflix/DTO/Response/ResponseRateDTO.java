package helpme.Netflix.DTO.Response;

import helpme.Netflix.DAO.Overview;
import helpme.Netflix.DAO.Rate;
import helpme.Netflix.DAO.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseRateDTO {
    private Long id;
    private int rate;
    private User user;
    private Overview overview;

    @Builder
    public ResponseRateDTO(Long id, int rate, User user, Overview overview) {
        this.id = id;
        this.rate = rate;
        this.user = user;
        this.overview = overview;
    }

    public ResponseRateDTO toDto(Rate rate) {
        return ResponseRateDTO.builder()
                .id(rate.getId())
                .rate(rate.getRate())
                .user(rate.getUser())
                .overview(rate.getOverview())
                .build();
    }
}
