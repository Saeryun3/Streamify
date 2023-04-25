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

@Service
public class VideoService {
    @Autowired
    private VideoRepository videoRepository;
    public Video addVideo (Video video){
        return videoRepository.save(video); // VideoRepository.save(video);
    }
}
