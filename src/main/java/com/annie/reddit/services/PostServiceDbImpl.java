package com.annie.reddit.services;

import com.annie.reddit.models.Post;
import com.annie.reddit.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceDbImpl implements PostService {

  private final PostRepo postRepository;

  @Autowired
  public PostServiceDbImpl(PostRepo postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  public void save(Post post) {
    postRepository.save(post);
  }

  @Override
  public List<Post> findAll() {
    return postRepository.findAll();
  }

  @Override
  public Post findOne(long id) {
    return postRepository.findOne(id);
  }

  @Override
  public Page<Post> findByPage(Pageable pageable) {
    return (Page<Post>) postRepository.findAll((Iterable<Long>) pageable);
  }

  @Override
  public void delete(long id) {
    postRepository.delete(id);
  }
}
