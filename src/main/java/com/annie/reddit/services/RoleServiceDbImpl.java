package com.annie.reddit.services;

import com.annie.reddit.models.Role;
import com.annie.reddit.repositories.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceDbImpl implements RoleService {

  private final RoleRepo roleRepo;

  @Autowired
  public RoleServiceDbImpl(RoleRepo roleRepo) {
    this.roleRepo = roleRepo;
  }

  @Override
  public void save(Role role) {
    roleRepo.save(role);
  }

}
