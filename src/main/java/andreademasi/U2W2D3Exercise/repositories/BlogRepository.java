package andreademasi.U2W2D3Exercise.repositories;

import andreademasi.U2W2D3Exercise.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
}
