package project.growupsmart.sources.config.token;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.growupsmart.sources.model.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "confirmation_token")
public class ConfirmationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime expiresAt;

    private LocalDateTime confirmedAt;
    private LocalDateTime createAt;


    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    public ConfirmationToken(String token, LocalDateTime expiresAt, User user, LocalDateTime createAt) {
        this.token = token;
        this.expiresAt = expiresAt;
        this.user = user;
        this.createAt=createAt;
    }

}
