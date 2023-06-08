package com.Streamify.Controller;

import com.Streamify.Model.Category;
import com.Streamify.Model.Video;
// import com.Streamify.exception.ResourceNotFoundException;
import com.Streamify.Repository.UserRepository;
import com.Streamify.Repository.VideoRepository;
import com.Streamify.Service.VideoService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class VideoController {
    @Autowired
    private  VideoService videoService;
    @GetMapping("/videos")
    public List<Video> GetAllVideos(){return videoService.getVideos();}
    @PostMapping
    public ResponseEntity<String> createdVideo(@RequestBody Video video) {
        videoService.addVideo(video);
        return ResponseEntity.status(HttpStatus.CREATED).body("Video created successfully");
    }
    @DeleteMapping("/video/{videoId}")
    public ResponseEntity<String>deleteVideoById(@PathVariable Long videoId){
        Boolean isDeleted = videoService.deleteVideoById(videoId);
        if (!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Video with id " + videoId + " has been deleted.");
    }
    @GetMapping("/search")
    public List<Video> getVideosBySearchInput(@RequestParam String query) {
        return videoService.getVideosBySearchInput(query);
    }
    @GetMapping("/category")
    public List<Video> getVideoByCategory(@RequestParam String categoryName){
        return videoService.getVideosByCategoryName(categoryName);
    }
    @GetMapping("/categories")
    public List<String> getAllCategories(){
        return videoService.getAllCategories();
    }
}