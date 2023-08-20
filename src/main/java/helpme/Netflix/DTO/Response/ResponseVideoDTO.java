package helpme.Netflix.DTO.Response;

import helpme.Netflix.DAO.Video;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ResponseVideoDTO {
    private Long id;
    private String videoName;
    private String thumbnail;
    private String videoURL;
    private String describe;

    @Builder
    public ResponseVideoDTO(Long id, String videoName, String thumbnail, String videoURL, String describe) {
        this.id = id;
        this.videoName = videoName;
        this.thumbnail = thumbnail;
        this.videoURL = videoURL;
        this.describe = describe;
    }

    public ResponseVideoDTO toDto(Video video) {
        return ResponseVideoDTO.builder()
                .id(video.getId())
                .videoName(video.getVideoName())
                .thumbnail(video.getThumbnail())
                .videoURL(video.getVideoURL())
                .describe(video.getDescribe())
                .build();
    }
}
