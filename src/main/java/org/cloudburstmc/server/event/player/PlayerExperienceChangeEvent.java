package org.cloudburstmc.server.event.player;

import org.cloudburstmc.server.event.Cancellable;
import org.cloudburstmc.server.player.Player;

public class PlayerExperienceChangeEvent extends PlayerEvent implements Cancellable {

    protected final int oldLevel;
    protected final float oldProgress;
    protected int newLevel;
    protected float newProgress;

    public PlayerExperienceChangeEvent(Player player, int oldLevel, float oldProgress, int newLevel, float newProgress) {
        super(player);
        this.oldLevel = oldLevel;
        this.oldProgress = oldProgress;
        this.newLevel = newLevel;
        this.newProgress = newProgress;
    }

    public int getOldLevel() {
        return oldLevel;
    }

    public float getOldProgress() {
        return oldProgress;
    }

    public int getNewLevel() {
        return newLevel;
    }

    public float getNewProgress() {
        return newProgress;
    }

    public void setNewLevel(int newLevel) {
        this.newLevel = newLevel;
    }

    public void setNewProgress(float newProgress) {
        this.newProgress = newProgress;
    }
}
