package com.annie.reddit.services;

import com.annie.reddit.models.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {

  void save(Role role);

}
