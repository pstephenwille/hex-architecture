package com.practice.api_gson.controllers_2;

import com.practice.api_gson.entities_0.CommentEntity;
import com.practice.api_gson.entities_0.StoryItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiGsonService {
    private final HackerNewsClient hackerNewsClient;
    private final StoryItemRepositoryImpl storyItemRepo;
    private final CommentsRepositoryImpl commentsRepo;

    @Autowired
    public ApiGsonService(HackerNewsClient hackerNews,
                          StoryItemRepositoryImpl storyItemRepo,
                          CommentsRepositoryImpl commentsRepo1) {
        this.hackerNewsClient = hackerNews;
        this.storyItemRepo = storyItemRepo;
        this.commentsRepo = commentsRepo1;
    }


    public Iterable<CommentEntity> getCommentsForStory(int storyId) {
        var storyEntity = storyItemRepo.getStoryById(storyId).get();
        var kids = storyEntity.kids;
        var parentId = storyEntity.storyId;

        var commentsForStory = commentsRepo.getCommentsForStory(parentId);

        if (commentsForStory.iterator().hasNext()) {
            return commentsForStory;
        }

        var newComments = hackerNewsClient.getCommentsForStory(kids);
        commentsRepo.saveAllComments(newComments);

        return this.getCommentsForStory(storyId);
    }


    public Iterable<StoryItemEntity> getTopStories() {
        return storyItemRepo.getAllTopStories(0, 10);
    }
}


