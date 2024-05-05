package com.practice.api_gson.drivers_3;


import com.practice.api_gson.entities_0.CommentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepo extends CrudRepository<CommentEntity, Integer> {
    Iterable<CommentEntity> findAllByParent(int parent);
}
