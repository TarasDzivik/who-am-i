package com.eleks.academy.whoami.repository;

import com.eleks.academy.whoami.core.SynchronousGame;
import com.eleks.academy.whoami.core.impl.PersistentGame;
import com.eleks.academy.whoami.model.request.NewGameRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameInMemoryRepositoryTest {

	@Mock
	private final Map<String, SynchronousGame> games = new ConcurrentHashMap<>();

	private final NewGameRequest gameRequest = new NewGameRequest();

	@BeforeEach
	public void setMockMvc() {
		gameRequest.setMaxPlayers(5);
	}

	@Test
	void save() {
		final String player = "player";
		SynchronousGame game = new PersistentGame(player, gameRequest.getMaxPlayers());

		when(games.put(any(), any())).thenReturn(game);

		var savedGame = this.games.put(game.getId(), game);

		assertNotNull(savedGame);
		assertNotNull(savedGame.getId());
		assertNotNull(savedGame.getStatus());
		assertNotNull(savedGame.getPlayersInGame());

		verify(games, times(1)).put(any(), any());
	}
}
