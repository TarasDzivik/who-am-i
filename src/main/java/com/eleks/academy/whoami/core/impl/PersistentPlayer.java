package com.eleks.academy.whoami.core.impl;

import com.eleks.academy.whoami.core.SynchronousPlayer;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PersistentPlayer implements SynchronousPlayer {

	@EqualsAndHashCode.Include private final String name;

	private String character;

	public PersistentPlayer(String name) {
		this.name = Objects.requireNonNull(name);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getCharacter() {
		return character;
	}

	@Override
	public String setCharacter(String character) {
		return this.character = character;
	}

}
