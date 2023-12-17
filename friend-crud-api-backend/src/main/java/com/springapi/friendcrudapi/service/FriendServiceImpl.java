package com.springapi.friendcrudapi.service;

import antlr.collections.List;
import com.springapi.friendcrudapi.entity.Friend;
import com.springapi.friendcrudapi.exception.ResourceNotFoundException;
import com.springapi.friendcrudapi.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FriendServiceImpl implements FriendService{
    @Autowired
    private FriendRepository friendRepository;
    @Override
    public Friend addFriend(Friend friend) {
        return friendRepository.save(friend);
    }

    @Override
    public List<Friend> getAllFriends() {
        return friendRepository.findAll();
    }

    @Override
    public Friend getFriendById(int id) {
        return friendRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Friend is Not Found"));
    }

    @Override
    public Friend updateFriend(int id, Friend friendDetail) {
        Friend updatedFriend = friendRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Friend Is Not Found"));
        updatedFriend.setFirstname(friendDetail.getFirstname());
        updatedFriend.setLastname(friendDetail.getLastname());
        updatedFriend.setDepartment(friendDetail.getDepartment());
        updatedFriend.setEmail(friendDetail.getEmail());
        updatedFriend.setCountry(friendDetail.getCountry());
        return friendRepository.save(updatedFriend);
    }

    @Override
    public Friend deleteFriend(int id) {
        Friend friend = friendRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Friend Is Not Found"));
        friendRepository.delete(friend);
        return friend;
    }
}
