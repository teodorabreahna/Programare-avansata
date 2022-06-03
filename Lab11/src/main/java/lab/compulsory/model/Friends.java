package lab.compulsory.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Table(name = "friends")
@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Friends {

    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="friend_1")
    private int friendId1;

    @Column(name="friend_2")
    private int friendId2;

    public Friends(){}

    public Friends(int id1, int id2){
        this.friendId1 = id1;
        this.friendId2 = id2;
    }

}
