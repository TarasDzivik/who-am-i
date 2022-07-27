package com.eleks.academy.whoami.core.impl;

import com.eleks.academy.whoami.core.SynchronousPlayer;
import com.eleks.academy.whoami.core.exception.GameException;
import com.eleks.academy.whoami.model.request.CharacterSuggestion;
import com.eleks.academy.whoami.enums.PlayerState;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@EqualsAndHashCode
public class PersistentPlayer implements SynchronousPlayer {

	private final String name;
	private String nickName;
	private String character;
	private PlayerState playerState;

	public PersistentPlayer(String name) {
		this.name = Objects.requireNonNull(name);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getNickName() {
		return this.nickName;
	}

	@Override
	public String getCharacter() {
		return this.character;
	}

	@Override
	public void setPlayerState(PlayerState playerState) {
		this.playerState = playerState;
	}

	@Override
	public PlayerState getPlayerState() {
		return this.playerState;
	}

	@Override
	public void suggestCharacter(CharacterSuggestion suggestion) {
		this.nickName = suggestion.getNickName();
		this.character = suggestion.getCharacter();
		this.playerState = PlayerState.READY;
	}

}
