package com.otrs.restaurant.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.otrs.restaurant.Entity.TableEntity;

@Repository
public interface TableRepository extends JpaRepository<TableEntity,Long>{

}
