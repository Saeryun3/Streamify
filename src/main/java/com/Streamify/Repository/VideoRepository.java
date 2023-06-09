package com.Streamify.Repository;

import com.Streamify.Model.Category;
import com.Streamify.Model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long>
{
    List<Video> getVideosByTitleLike(String search);
    List<Video> findAllByCategoriesCategoryName(String categoryName);
}
