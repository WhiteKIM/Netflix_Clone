package helpme.Netflix.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String videoName;
    private String thumbnail;
    private String videoURL;
    private String describe;

    @Builder
    public Video(Long id, String videoName, String thumbnail, String videoURL, String describe) {
        this.id = id;
        this.videoName = videoName;
        this.thumbnail = thumbnail;
        this.videoURL = videoURL;
        this.describe = describe;
    }
}
