package com.practice.api_gson.controllers_2;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HomeController {

    ApiGsonService apiGsonService;

    @Autowired
    public HomeController(ApiGsonService apiGsonService) {
        this.apiGsonService = apiGsonService;
    }

    @GetMapping("/top-stories")
    public ResponseEntity<String> getTopStoryItems() throws Exception {
        var items = apiGsonService.getTopStories();
        Gson gson = new Gson();
        String gsonJson = gson.toJson(items);

        return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(gsonJson);
    }

    @GetMapping("/comments/{parentId}")
    public ResponseEntity<String> getCommentsForParentItem(@PathVariable Integer parentId) throws Exception {
        var comments = apiGsonService.getCommentsForStory(parentId);
        Gson gson = new Gson();
        String gsonJson = gson.toJson(comments);

        return ResponseEntity.status(200).body(gsonJson);
    }
}

