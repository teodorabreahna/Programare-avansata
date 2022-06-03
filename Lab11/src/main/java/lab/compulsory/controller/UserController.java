package lab.compulsory.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lab.compulsory.model.Friends;
import lab.compulsory.model.User;
import lab.compulsory.repository.FriendsRepository;
import lab.compulsory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.swap;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
    private FriendsRepository friendsRepository;

    @Autowired
    public UserController(UserRepository userRepository, FriendsRepository friendsRepository) {
        this.userRepository = userRepository;
        this.friendsRepository = friendsRepository;
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getProduct(@PathVariable("id") int id) {
        return userRepository.findById(id);
    }

    /*adds a user to the database (the user information is of type json)*/
    @PostMapping()
    public ResponseEntity<String> addProduct(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>("User added successfully", HttpStatus.CREATED);
    }

    /*updates the name of a user (the name is given in a json)*/
    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<String> updateUserName(@PathVariable int id, @RequestBody String name) {
        ResponseEntity responseEntity = null;
        try {
            User user = userRepository.findUserById(id);
            if (user == null) {
                responseEntity = new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
            }
            ObjectMapper mapper = new ObjectMapper();
            User newValue = mapper.readValue(name, User.class);
            user.setName(newValue.getName());
            userRepository.save(user);
            responseEntity = new ResponseEntity<>("User updated!", HttpStatus.OK);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return responseEntity;
    }

    /*deletes a product after the id*/
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        User user = userRepository.findUserById(id);
        if (user == null) {
            return new ResponseEntity<>("Product not found!", HttpStatus.NOT_FOUND);
        }
        userRepository.delete(user);
        return new ResponseEntity<>("Product deleted successfully!", HttpStatus.OK);
    }

    @GetMapping("/{id}/friends")
    public List<User> getFriends(@PathVariable("id") int id) {
        List<Friends> friendsRelationship1 = friendsRepository.findUserByFriendId1(id);
        List<Friends> friendsRelationship2 = friendsRepository.findUserByFriendId2(id);
        List<User> friendsOfUser = new ArrayList<>();
        for (Friends friends : friendsRelationship1) {
            friendsOfUser.add(userRepository.findUserById(friends.getFriendId2()));
        }
        for (Friends friends : friendsRelationship2) {
            friendsOfUser.add(userRepository.findUserById(friends.getFriendId1()));
        }
        return friendsOfUser;
    }

    @PostMapping(value = "/{id}/friends")
    public ResponseEntity<String> addFriend(@PathVariable int id, @RequestParam String name) {
        try {
            User userFriend = userRepository.findUsersByName(name);
            Friends newFriends = new Friends(id, userFriend.getId());
            friendsRepository.saveAndFlush(newFriends);
        } catch (DataAccessException e) {
            return new ResponseEntity<>("You cannot add this relationship, this friendship may already exist" +
                    " or check if it's a self relationship!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Friend Relationship added successfully", HttpStatus.CREATED);
    }

    @GetMapping(value = "/celebrities")
    public List<User> getMostKPopularUsers(@RequestParam Integer k) {
        List<User> users = userRepository.findAll();
        List<Integer> friendsNumber = new ArrayList<>();
        for (User user : users) {
            List<Friends> friendsRelationship1 = friendsRepository.findUserByFriendId1(user.getId());
            List<Friends> friendsRelationship2 = friendsRepository.findUserByFriendId2(user.getId());
            int count = friendsRelationship1.size() + friendsRelationship2.size();
            friendsNumber.add(count);
        }
        /*sorting after the number of friends*/
        for (int i = 0; i < friendsNumber.size() - 1; i++) {
            for (int j = i + 1; j < friendsNumber.size(); j++) {
                if (friendsNumber.get(i) < friendsNumber.get(j)) {
                    int aux = friendsNumber.get(i);
                    friendsNumber.set(i, friendsNumber.get(j));
                    friendsNumber.set(j, aux);

                    User auxUser = users.get(i);
                    users.set(i, users.get(j));
                    users.set(j, auxUser);
                }
            }
        }
        users = users.stream().limit(k).toList();
        return users;
    }
}






















