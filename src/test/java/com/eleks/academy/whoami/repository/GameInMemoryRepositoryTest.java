package com.eleks.academy.whoami.repository;

import com.eleks.academy.whoami.core.SynchronousGame;
import com.eleks.academy.whoami.core.impl.PersistentGame;
import com.eleks.academy.whoami.model.request.NewGameRequest;
import com.eleks.academy.whoami.repository.impl.GameInMemoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class GameInMemoryRepositoryTest {

	private final NewGameRequest gameRequest = new NewGameRequest();

	private final GameInMemoryRepository gameRepository = new GameInMemoryRepository();

	@BeforeEach
	public void setMockMvc() {
		gameRequest.setMaxPlayers(4);
	}

	@Test
	void saveTest() {
		final String player = "player";

		SynchronousGame game = new PersistentGame(player, gameRequest.getMaxPlayers());

		assertThat(gameRepository.save(game))
				.isEqualTo(new PersistentGame(player, 4));
	}
}
