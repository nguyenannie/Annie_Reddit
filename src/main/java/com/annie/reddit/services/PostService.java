package com.annie.reddit.services;

import com.annie.reddit.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

  void save(Post post);
  List<Post> findAll();
  Post findOne(long id);
  Page<Post> findByPage(Pageable pageable);
  void delete(long id);

}
