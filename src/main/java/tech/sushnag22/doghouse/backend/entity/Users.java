package tech.sushnag22.doghouse.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table(name = "users")

public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @NotEmpty
    @Column(name = "username", unique = true, nullable = false)
    @Size(min = 4, max = 20)
    private String username = "";

    @NotNull
    @NotEmpty
    @Column(name = "password", nullable = false)
    @Size(min = 4)
    private String password = "";

    @Email
    @NotNull
    @NotEmpty
    @Column(name = "email", unique = true)
    private String email = "";

    @NotNull
    @NotEmpty
    @Column(name = "first_name", nullable = false)
    private String firstName = "";

    @NotNull
    @NotEmpty
    @Column(name = "last_name")
    private String lastName = "";

    @OneToMany(mappedBy = "users", cascade = CascadeType.MERGE)
    private Set<Dog> dog;

    @OneToMany(mappedBy = "users", cascade = CascadeType.MERGE)
    private Set<Adopter> adopter;

    public Users() {

    }

    public Users(@NotNull @NotEmpty String username,
                @NotNull @NotEmpty String password,
                @Email @NotNull @NotEmpty String email,
                @NotNull @NotEmpty String firstName,
                @NotNull @NotEmpty String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<Dog> getDog() {
        return dog;
    }

    public void setDog(Set<Dog> dog) {
        this.dog = dog;
    }

    public Set<Adopter> getAdopter() {
        return adopter;
    }

    public void setAdopter(Set<Adopter> adopter) {
        this.adopter = adopter;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (!(o instanceof Users)) {
            return false;
        }

        Users u = (Users) o;

        return this.getId().equals(u.getId());
    }
}