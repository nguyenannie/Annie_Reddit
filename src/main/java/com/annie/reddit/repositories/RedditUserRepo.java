package com.annie.reddit.repositories;

import com.annie.reddit.models.RedditUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedditUserRepo extends CrudRepository<RedditUser, Long> {

  RedditUser findByName(String name);

}
