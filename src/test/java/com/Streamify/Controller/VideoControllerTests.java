package com.Streamify.Controller;

import com.Streamify.Model.Video;
import com.Streamify.Service.VideoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VideoController.class)
public class VideoControllerTests {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    VideoService videoService;

    @Test
    public void getVideosTest() throws Exception {
        //arrange
        List<Video> videoList = new ArrayList<>();
        Video video = new Video();
        video.setVideoId(1L);
        video.setVideoUrl("url");
        video.setType(false);
        video.setTitle("title");
        video.setDescription("description");
        video.setImage("image");

        videoList.add(video);
        videoList.add(video);

        Mockito.when(videoService.getVideos()).thenReturn(videoList);

        //assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/videos").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].videoId", is(1)))
                .andExpect(jsonPath("$[0].videoUrl", is("url")))
                .andExpect(jsonPath("$[0].type", is(false)))
                .andExpect(jsonPath("$[0].title", is("title")))
                .andExpect(jsonPath("$[0].description", is("description")))
                .andExpect(jsonPath("$[0].image", is("image")))
                .andExpect(jsonPath("$[1].videoId", is(1)))
                .andExpect(jsonPath("$[1].videoUrl", is("url")))
                .andExpect(jsonPath("$[1].type", is(false)))
                .andExpect(jsonPath("$[1].title", is("title")))
                .andExpect(jsonPath("$[1].description", is("description")))
                .andExpect(jsonPath("$[1].image", is("image")));
    }
    @Test
    public void searchTest() throws Exception{
        //arrange
        List<Video> videoList = new ArrayList<>();
        Video video = new Video();
        video.setVideoId(1L);
        video.setVideoUrl("url");
        video.setType(false);
        video.setTitle("title");
        video.setDescription("description");
        video.setImage("image");

        videoList.add(video);
        videoList.add(video);

        Mockito.when(videoService.getVideosBySearchInput("ti")).thenReturn(videoList);
        //assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/search?query=ti").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].videoId", is(1)))
                .andExpect(jsonPath("$[0].videoUrl", is("url")))
                .andExpect(jsonPath("$[0].type", is(false)))
                .andExpect(jsonPath("$[0].title", is("title")))
                .andExpect(jsonPath("$[0].description", is("description")))
                .andExpect(jsonPath("$[0].image", is("image")))
                .andExpect(jsonPath("$[1].videoId", is(1)))
                .andExpect(jsonPath("$[1].videoUrl", is("url")))
                .andExpect(jsonPath("$[1].type", is(false)))
                .andExpect(jsonPath("$[1].title", is("title")))
                .andExpect(jsonPath("$[1].description", is("description")))
                .andExpect(jsonPath("$[1].image", is("image")));
    }
}
