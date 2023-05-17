package com.otrs.booking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.otrs.booking.Entity.BookingEntity;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity,Long>{

}
