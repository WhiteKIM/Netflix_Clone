package helpme.Netflix.DTO.Request;

import helpme.Netflix.DAO.Video;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestVideoDTO {
    private Long id;
    private String viedoName;
    private String thumbnail;
    private String videoURL;
    private String describe;

    @Builder
    public RequestVideoDTO(Long id, String viedoName, String thumbnail, String videoURL, String describe) {
        this.id = id;
        this.viedoName = viedoName;
        this.thumbnail = thumbnail;
        this.videoURL = videoURL;
        this.describe = describe;
    }

    public Video toEntity() {
        return Video.builder()
                .id(id)
                .videoName(viedoName)
                .thumbnail(thumbnail)
                .videoURL(videoURL)
                .describe(describe)
                .build();
    }
}
