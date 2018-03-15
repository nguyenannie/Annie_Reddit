package com.annie.reddit.services;

import com.annie.reddit.models.RedditUser;
import com.annie.reddit.repositories.RedditUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RedditUserServiceDbImpl implements RedditUserService {

  private final RedditUserRepo userRepository;


  @Autowired
  public RedditUserServiceDbImpl(RedditUserRepo userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void save(RedditUser user) {
    userRepository.save(user);
  }

  @Override
  public RedditUser findByName(String name) {
    return userRepository.findByName(name);
  }

  @Override
  public boolean exists(long id) {
    return userRepository.exists(id);
  }

  @Override
  public boolean exists(String username) {
    return userRepository.findByName(username) != null;
  }

  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    RedditUser user = findByName(username);
    if(user == null) {
      throw new UsernameNotFoundException("RedditUser not found");
    }
    return user;
  }

}
