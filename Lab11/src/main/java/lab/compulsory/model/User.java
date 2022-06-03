package lab.compulsory.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "users")
@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonPropertyOrder({"id", "name"})
public class User {

    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty("name")
    @Column(name="name")
    private String name;

    public User(String name){
        this.name = name;
    }

    public User(){}

}
