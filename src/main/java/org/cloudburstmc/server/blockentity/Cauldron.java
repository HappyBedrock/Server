package org.cloudburstmc.server.blockentity;

import org.cloudburstmc.server.utils.BlockColor;

public interface Cauldron extends BlockEntity {

    short getPotionId();

    void setPotionId(int potionId);

    short getPotionType();

    void setPotionType(int potionType);

    boolean isSplash();

    void setSplash(boolean splash);

    BlockColor getCustomColor();

    void setCustomColor(BlockColor color);

    boolean hasCustomColor();
}
