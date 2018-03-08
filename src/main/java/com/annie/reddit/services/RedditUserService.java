package com.annie.reddit.services;

import com.annie.reddit.models.RedditUser;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface RedditUserService {

  void save(RedditUser user);
  RedditUser findByName(String name);
  boolean exists(long id);
  boolean exists(String username);

}
