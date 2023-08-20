package helpme.Netflix.Service;

import helpme.Netflix.DAO.Overview;
import helpme.Netflix.DAO.Rate;
import helpme.Netflix.DTO.Request.RequestRateDTO;
import helpme.Netflix.Repository.RateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RateService {
    private final RateRepository rateRepository;

    public void save(RequestRateDTO rateDTO) {
        Rate entity = rateDTO.toEntity();
        Overview overview = entity.getOverview();
        rateRepository.save(entity);
        overview.getRates().add(entity);
    }
}
