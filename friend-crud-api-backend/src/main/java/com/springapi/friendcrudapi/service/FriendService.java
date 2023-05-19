package com.springapi.friendcrudapi.service;

import com.springapi.friendcrudapi.entity.Friend;

import java.util.List;

public interface FriendService {
    Friend addFriend (Friend friend);
    List<Friend> getAllFriends ();
    Friend getFriendById(int id);
    Friend updateFriend(int id, Friend friendDetail);
    Friend deleteFriend(int id);
}
