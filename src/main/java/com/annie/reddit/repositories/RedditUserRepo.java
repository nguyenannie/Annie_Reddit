package com.annie.reddit.repositories;

import com.annie.reddit.models.RedditUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedditUserRepo extends JpaRepository<RedditUser, Long> {

  RedditUser findByName(String name);

}
