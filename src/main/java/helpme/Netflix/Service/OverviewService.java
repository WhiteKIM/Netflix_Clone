package helpme.Netflix.Service;

import helpme.Netflix.DAO.Overview;
import helpme.Netflix.DAO.Video;
import helpme.Netflix.DTO.Request.RequestOverViewDTO;
import helpme.Netflix.DTO.Response.ResponseOverViewDTO;
import helpme.Netflix.DTO.Response.ResponseVideoDTO;
import helpme.Netflix.Repository.OverViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class OverviewService {
    private final OverViewRepository overViewRepository;

    public void save(RequestOverViewDTO overViewDTO) {
        overViewRepository.save(overViewDTO.toEntity());
    }

    public List<ResponseOverViewDTO> findAll() {
        List<ResponseOverViewDTO> overViewDTOList = overViewRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
        return overViewDTOList;
    }

    public ResponseOverViewDTO findById(Long id) {
        return overViewRepository.findById(id).map(this::toDto).orElseThrow(() -> {
            throw new NoSuchElementException("오브젝트를 찾을 수 없습니다");
        });
    }

    private ResponseOverViewDTO toDto(Overview overview) {
        return ResponseOverViewDTO.builder()
                .id(overview.getId())
                .content(overview.getContent())
                .timestamp(overview.getCreateTime())
                .rates(overview.getRates())
                .reviews(overview.getReviews())
                .video(overview.getVideo())
                .build();
    }
}
