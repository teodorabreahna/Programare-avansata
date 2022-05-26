package lab.compulsory.repository;

import lab.compulsory.model.Friends;
import lab.compulsory.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FriendsRepository extends JpaRepository<Friends, Integer> {

    List<Friends> findUserByFriendId1(@Param("friendId1")Integer id);

    /*the name of the function has to match the data members in the class Friends*/
    List<Friends> findUserByFriendId2(@Param("friend_2")Integer id);
}
