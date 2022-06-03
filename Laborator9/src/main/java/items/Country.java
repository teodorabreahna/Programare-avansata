package items;

import javax.persistence.*;

/**
 * Queries and database mapping
 */
@Entity
@Table(name = "cities")
@NamedQueries({
        @NamedQuery(name = "Country.findAll", query = "select e from Country e order by e.name"),

        @NamedQuery(name = "Country.findByCountry", query = "select e from Country e where e.country = ?1"),

        @NamedQuery(name = "Country.findByName", query = "select e from Country e where e.name = ?1")
})

/**
 * this class describes a country and its relations
 */
public class Country {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "continent_id")
    private Continent continent;

    Country() {

    }

    Country(String name, Continent continent) {
        this.name = name;
        this.continent = continent;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", continent=" + continent +
                '}';
    }
}

