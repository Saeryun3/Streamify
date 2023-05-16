//package com.Streamify.Service;
//
//import com.Streamify.Repository.VideoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.Streamify.Model.Video;
//
//@Service
//public class VideoService {
//    private final VideoRepository videoRepository;
//
//    @Autowired
//    public VideoService(VideoRepository videoRepository) {
//        this.videoRepository = videoRepository;
//    }
//
//    public Video addVideo (Video video){
//        return videoRepository.save(video);
//    }
//}
package com.Streamify.Service;

        import com.Streamify.Repository.VideoRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import com.Streamify.Model.Video;
        import org.springframework.web.bind.annotation.RequestParam;

        import java.util.List;

@Service
public class VideoService {
    @Autowired
    private VideoRepository videoRepository;

    public List<Video> getVideos() {
        return videoRepository.findAll();
    }

    public Video addVideo (Video video){
        return videoRepository.save(video); // VideoRepository.save(video);
    }
    public Boolean deleteVideoById(Long id){
      Video video = videoRepository.findById(id).orElse(null);
      if(video.equals(null)) {
          //delete lukt niet
          return false;
      }
      else {
          //delete video
          videoRepository.deleteById(id);
          return true;
      }
    }
    public List<Video> getVideosBySearchInput(@RequestParam String query) {
        return videoRepository.getVideosByTitleLike("%" + query + "%");
    }
}
