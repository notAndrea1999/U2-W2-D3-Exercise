package andreademasi.U2W2D3Exercise.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
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

    @OneToMany(mappedBy = "user")
    private Set<Blog> blogs;
    
    @CreationTimestamp
    private Date createdAt;
}
