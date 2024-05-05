package com.practice.api_gson.controllers_2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.practice.api_gson.drivers_3.CommentsRepo;
import com.practice.api_gson.entities_0.CommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentsRepositoryImpl {
    private final Gson gson = new Gson();

    private final CommentsRepo commentsRepo;

    @Autowired
    public CommentsRepositoryImpl(CommentsRepo commentsRepo) {
        this.commentsRepo = commentsRepo;
    }

    public void saveAllComments(List<CommentDto> commentDtos) {
        var commentEntities = commentDtos.stream()
                .map(gson::toJson)
                .map(item -> new GsonBuilder().create().fromJson(item, CommentEntity.class))
                .toList();

        commentsRepo.saveAll(commentEntities);
    }

    public Iterable<CommentEntity> getCommentsForStory(int parentId) {
        return commentsRepo.findAllByParent(parentId);
    }

}
