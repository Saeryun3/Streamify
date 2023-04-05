package com.Streamify.Repository;

import com.Streamify.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long>
{
 //all crud database methods
    User getUserById(Long id);
}
