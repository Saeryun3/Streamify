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

        import com.Streamify.Model.Category;
        import com.Streamify.Repository.CategoryRepository;
        import com.Streamify.Repository.VideoRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import com.Streamify.Model.Video;
        import org.springframework.web.bind.annotation.RequestParam;

        import java.util.ArrayList;
        import java.util.List;

@Service
public class VideoService {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Video> getVideos() {
        return videoRepository.findAll();
    }

    public Video addVideo (Video video){
        return videoRepository.save(video); // VideoRepository.save(video);
    }
    public Boolean deleteVideoById(Long id) {
        Video video = videoRepository.findById(id).orElse(null);
        if (video == null) {
            // Delete failed
            return false;
        } else {
            // Remove the video from categories
            for (Category category : video.getCategories()) {
                category.getVideos().remove(video);
            }
            // Delete video
            videoRepository.deleteById(id);
            return true;
        }
    }
    public List<Video> getVideosBySearchInput(String query) {
        return videoRepository.getVideosByTitleLike("%" + query + "%");
    }
    public List<Video> getVideosByCategoryName(String CategoryName){
        return videoRepository.findAllByCategoriesCategoryName(CategoryName);
    }

    public List<String> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<String> names = new ArrayList<>();
        for (Category category : categories) {
            names.add(category.getCategoryName());
        }
        return names;
    }
}
