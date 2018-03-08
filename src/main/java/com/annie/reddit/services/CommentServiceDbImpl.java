package com.annie.reddit.services;

import com.annie.reddit.models.Comment;
import com.annie.reddit.repositories.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceDbImpl implements CommentService {

  private final CommentRepo commentRepository;

  @Autowired
  public CommentServiceDbImpl(CommentRepo commentRepository) {
    this.commentRepository = commentRepository;
  }

  @Override
  public void save(Comment comment) {
    commentRepository.save(comment);
  }

  @Override
  public Comment findOne(long id) {
    return commentRepository.findOne(id);
  }

  @Override
  public void delete(long id) {
    commentRepository.delete(id);
  }

}
