package org.SpringDataJpaOneToOne.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", length = 255)
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private Card card;

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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, Card card) {
        this.name = name;
        this.card = card;
    }

    public Employee() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(card, employee.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, card);
    }
}
