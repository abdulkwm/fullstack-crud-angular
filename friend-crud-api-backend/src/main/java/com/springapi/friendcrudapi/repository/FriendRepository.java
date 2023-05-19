package com.springapi.friendcrudapi.repository;

import com.springapi.friendcrudapi.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend, Integer> {
}
