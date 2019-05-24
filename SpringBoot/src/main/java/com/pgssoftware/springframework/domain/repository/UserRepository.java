package com.pgssoftware.springframework.domain.repository;

import com.pgssoftware.springframework.domain.model.AppUser;
import com.pgssoftware.springframework.domain.repository.projection.UserLimited;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

    UserLimited findFirstByFirstName(String firstName);

    List<AppUser> findByFirstNameAndLastName(String firstName, String lastName);

    List<AppUser> findByFirstNameOrLastName(String firstName, String lastName);

    List<AppUser> findByFirstName(String firstName);

    List<AppUser> findByAgeLessThan(long age);

    List<AppUser> findByEmailStartingWith(String email);

    List<AppUser> findByLastName(String lastName, Pageable pageable);
}
