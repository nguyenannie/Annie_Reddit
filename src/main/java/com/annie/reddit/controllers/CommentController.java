package com.annie.reddit.controllers;

import com.annie.reddit.models.Comment;
import com.annie.reddit.models.Post;
import com.annie.reddit.models.RedditUser;
import com.annie.reddit.services.CommentServiceDbImpl;
import com.annie.reddit.services.PostServiceDbImpl;
import com.annie.reddit.services.RedditUserServiceDbImpl;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {

  private final CommentServiceDbImpl commentServiceDb;
  private final PostServiceDbImpl postServiceDb;
  private final RedditUserServiceDbImpl userServiceDb;

  @Autowired
  public CommentController(CommentServiceDbImpl commentServiceDb, PostServiceDbImpl postServiceDb, RedditUserServiceDbImpl userServiceDb) {
    this.commentServiceDb = commentServiceDb;
    this.postServiceDb = postServiceDb;
    this.userServiceDb = userServiceDb;
  }

  @PostMapping("/{username}/post/{postid}/comment")
  @PreAuthorize("hasRole('ROLE_USER')")
  public String postComment(Model model, HttpServletRequest request,
                            @PathVariable(value = "username") String username,
                            @PathVariable(value = "postid") String id) {

    Post post = postServiceDb.findOne(Long.parseLong(id));
    RedditUser user = userServiceDb.findByName(username);

    String commentContent = request.getParameter("addcomment");
    Comment newComment = new Comment();

    newComment.setContent(commentContent);
    newComment.setPost(post);
    newComment.setUser(user);

    user.addComment(newComment);
    post.addComment(newComment);

    userServiceDb.save(user);
    postServiceDb.save(post);
    commentServiceDb.save(newComment);

    model.addAttribute("user", user);
    model.addAttribute("post", post);
    return "redirect:/" + username + "/post/" + id;
  }

}

