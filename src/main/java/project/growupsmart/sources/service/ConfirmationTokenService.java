package project.growupsmart.sources.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.growupsmart.sources.config.token.ConfirmationToken;
import project.growupsmart.sources.repository.ConfirmationTokenRepository;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
