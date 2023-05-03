package com.Streamify.Repository;

import com.Streamify.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
 //all crud database methods
    User getUserById(Long id);
    User getUserByEmail(String Email);
}
