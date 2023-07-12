package com.facebookclone.be.repository;

import com.facebookclone.be.entity.PostEntity;
import com.facebookclone.be.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, String> {
}
