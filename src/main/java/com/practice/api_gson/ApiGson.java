package com.practice.api_gson;

import com.practice.api_gson.controllers_2.HackerNewsClient;
import com.practice.api_gson.controllers_2.StoryItemRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ApiGson {
    public static HackerNewsClient hackerNewsClient;

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = SpringApplication.run(ApiGson.class, args);
        hackerNewsClient = applicationContext.getBean(HackerNewsClient.class);

        var staticStoryRepo = applicationContext.getBean(StoryItemRepositoryImpl.class);

        var allStoryItems = hackerNewsClient.getTopStories();

        staticStoryRepo.saveAllStoryItems(allStoryItems);
    }

}
