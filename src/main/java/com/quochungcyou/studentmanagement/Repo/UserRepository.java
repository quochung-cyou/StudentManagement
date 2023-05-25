package com.quochungcyou.studentmanagement.Repo;

import com.quochungcyou.studentmanagement.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    public Long countById(Integer id);


    //search function
    @Query("SELECT u FROM User u WHERE u.email LIKE %?1%"
            + "OR u.firstName LIKE %?1%"
            + "OR u.lastName LIKE %?1%"
            + "OR CONCAT(u.firstName, ' ', u.lastName) LIKE %?1%")
    public List<User> findAll(String keyword);

}
