package com.practice.api_gson.drivers_3;


import com.practice.api_gson.controllers_2.CommentDto;
import com.practice.api_gson.controllers_2.StoryItemDto;

import java.util.List;

public interface HackerNewsProvider {
    int TOP_LIMIT = 500;
    String baseurl = "https://hacker-news.firebaseio.com/v0/";

    List<StoryItemDto> getTopStories() throws Exception;

    List<CommentDto> getCommentsForStory(int[] kids);
}
