package com.otrs.user.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.otrs.user.Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{

	@Query("select us from UserEntity us where us.name = :name")
	Optional<UserEntity> findByName(String name);
	
	@Query("select us.city from UserEntity us where us.id = :Uid")
	String findAddressById(long Uid);
}
