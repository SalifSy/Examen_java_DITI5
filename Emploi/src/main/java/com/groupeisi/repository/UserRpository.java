package com.groupeisi.repository;

import com.groupeisi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRpository extends JpaRepository<User, Long> {

}
