/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.test.repositories;

import com.example.test.entities.Users;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Los_e
 */
@Repository
public interface UsersRepo extends JpaRepository<Users, String> {

    @Query("SELECT u FROM Users u WHERE u.username = ?1")
    Users findUserByUsername(String username);

    @Transactional
    @Modifying
    @Query("DELETE FROM Users u WHERE u.userid = ?1")
    void deleteUserById(int userid);

//    @Query(
//            value = "SELECT EXISTS (SELECT username FROM Users u1 WHERE u1.username = ?1)",
//            nativeQuery = true) Native query but used the following derived query instead
    boolean existsUsersByUsername(String username);
}
