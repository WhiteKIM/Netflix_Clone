package helpme.Netflix.Service;

import helpme.Netflix.DTO.Request.RequestOverViewDTO;
import helpme.Netflix.Repository.OverViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OverviewService {
    private final OverViewRepository overViewRepository;

    public void save(RequestOverViewDTO overViewDTO) {
        overViewRepository.save(overViewDTO.toEntity());
    }
}
