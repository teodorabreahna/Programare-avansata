package items;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Queries and database mapping
 */
@Entity
@Table(name = "continents")
@NamedQueries({
        @NamedQuery(name = "Continent.findAll", query = "select e from Continent e order by e.name"),
})

/**
 * this class describes a continent and its relations
 */
public class Continent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    public Continent() {
    }

    public Continent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Continent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
