package andreademasi.U2W2D3Exercise.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "blog_posts")
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String category;
    private String title;
    private String cover;
    private String contenuto;
    @Column(name = "reading_time")
    private int readingTime;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User user;

    public Blog(String category, String title, String cover, String contenuto, int readingTime, User user) {
        this.category = category;
        this.title = title;
        this.cover = cover;
        this.contenuto = contenuto;
        this.readingTime = readingTime;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", title='" + title + '\'' +
                ", cover='" + cover + '\'' +
                ", contenuto='" + contenuto + '\'' +
                ", readingTime=" + readingTime +
                ", user=" + user.getId()
                + user.getName()
                + user.getSurname()
                + user.getEmail()
                + user.getBirthDate()
                + user.getAvatar() +
                '}';
    }
}
