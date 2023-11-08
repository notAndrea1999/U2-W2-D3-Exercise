package andreademasi.U2W2D3Exercise.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String surname;
    private String email;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "avatar_url")
    private String avatar;


    @CreationTimestamp
    private Date createdAt;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", avatar='" + avatar + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
