package org.miphi.learn.repository;

import org.miphi.learn.model.Country;
import org.miphi.learn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByCountryInOrderByCountryAsc(List<Country> countries);
}
