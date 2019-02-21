package org.SpringDataJpaOneToOne.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", length = 255)
    private String name;
    @OneToOne(mappedBy = "card")
    private Employee employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Card(String name) {
        this.name = name;
    }

    public Card(String name, Employee employee) {
        this.name = name;
        this.employee = employee;
    }

    public Card() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) &&
                Objects.equals(name, card.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}