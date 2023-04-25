package com.Streamify.Controller;

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

//import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/video")
public class VideoController {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private  VideoService videoService;
    @GetMapping
    public List<Video> GetAllVideos(){return videoRepository.findAll();}
    @PostMapping
    public ResponseEntity<String> createdVideo(@RequestBody Video video) {
        videoRepository.save(video);
        return ResponseEntity.status(HttpStatus.CREATED).body("Video created successfully");
    }



}
