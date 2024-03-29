package io.Odyssey.net;

import io.netty.channel.Channel;
import io.Odyssey.model.entity.player.Player;

public class Session {

	private final Channel channel;

	private Player client;

	public Session(Channel channel) {
		this.channel = channel;
	}

	public Player getClient() {
		return client;
	}

	public void setClient(Player client) {
		this.client = client;
	}

}
