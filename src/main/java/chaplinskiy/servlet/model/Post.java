package chaplinskiy.servlet.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Post")
@Table(name = "POST")
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String content;
    @Column(name = "created")
    private LocalDateTime create;
    @Column(name = "updated")
    private LocalDateTime updated;
}
