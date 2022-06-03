package items;

import javax.persistence.*;

/**
 * Queries and database mapping
 */
@Entity
@Table(name = "cities")
@NamedQueries({
        @NamedQuery(name = "City.findAll", query = "select e from City e order by e.name"),

        @NamedQuery(name = "City.findByCountry", query = "select e from City e where e.country = ?1"),

        @NamedQuery(name = "City.findByName", query = "select e from City e where e.name = ?1")
})

/**
 * this class describes the city and its relations
 */
public class City {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public City() {
    }

    City(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
