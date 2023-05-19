package com.springapi.friendcrudapi.controller;

import com.springapi.friendcrudapi.entity.Friend;
import com.springapi.friendcrudapi.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friends")
@CrossOrigin("*")
public class FriendController {
    @Autowired
    private FriendService friendService;

    @PostMapping
    public ResponseEntity<Friend> addFriend(@RequestBody Friend friend){
        Friend createdFriend = friendService.addFriend(friend);
        return new ResponseEntity<>(createdFriend, HttpStatus.CREATED);
    }
    @GetMapping
    public List<Friend> getAllFriends(){
        return friendService.getAllFriends();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Friend> getFriendById(@PathVariable int id){
        Friend friend = friendService.getFriendById(id);
        return ResponseEntity.ok(friend);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Friend> updateFriend(@PathVariable int id, @RequestBody Friend friendDetail){
        Friend updatedFriend = friendService.updateFriend(id, friendDetail);
        return ResponseEntity.ok(updatedFriend);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFriend(@PathVariable int id){
        Friend friend = friendService.deleteFriend(id);
        String msg = "Friend With The Id " + id + " Is Deleted";
        return ResponseEntity.ok(msg);
    }
}
