package com.Streamify.Repository;

import com.Streamify.Model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
public interface VideoRepository extends JpaRepository<Video, Long>
{
    Video getVideoById(Long Id);
}
