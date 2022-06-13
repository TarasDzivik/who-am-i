package com.eleks.academy.whoami.repository;

import com.eleks.academy.whoami.core.SynchronousGame;
import com.eleks.academy.whoami.core.impl.PersistentGame;
import com.eleks.academy.whoami.model.request.NewGameRequest;
import com.eleks.academy.whoami.repository.impl.GameInMemoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class GameInMemoryRepositoryTest {

	private final NewGameRequest gameRequest = new NewGameRequest();

	@Mock
	private final GameInMemoryRepository gameRepository = new GameInMemoryRepository();

	@BeforeEach
	public void setMockMvc() {
		gameRequest.setMaxPlayers(4);
	}

	@Test
	void save() {
		final String player = "player";
		SynchronousGame game = new PersistentGame(player, gameRequest.getMaxPlayers());

		assertThat(gameRepository.save(game))
				.isEqualTo(gameRepository.save(new PersistentGame("player", 4)));

		verify(gameRepository, times(2)).save(any(SynchronousGame.class));
	}
}
