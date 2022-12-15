package com.example.review.service;


import com.example.review.model.Role;
import com.example.review.model.RoleName;

import java.util.List;
import java.util.Optional;

public interface IRoleService {

    Role saveRole(Role role);

    List<Role> getAllRoles();

    Optional<Role> getRoleByName(RoleName roleUser);
}
