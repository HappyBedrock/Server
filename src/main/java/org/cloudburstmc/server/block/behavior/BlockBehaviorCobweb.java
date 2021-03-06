package org.cloudburstmc.server.block.behavior;

import org.cloudburstmc.server.block.Block;
import org.cloudburstmc.server.entity.Entity;
import org.cloudburstmc.server.item.behavior.Item;
import org.cloudburstmc.server.item.behavior.ItemIds;
import org.cloudburstmc.server.item.behavior.ItemTool;
import org.cloudburstmc.server.utils.BlockColor;

public class BlockBehaviorCobweb extends FloodableBlockBehavior {

    @Override
    public float getHardness() {
        return 4;
    }

    @Override
    public float getResistance() {
        return 20;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_SWORD;
    }

    @Override
    public void onEntityCollide(Block block, Entity entity) {
        entity.resetFallDistance();
    }

    @Override
    public Item[] getDrops(Block block, Item hand) {
        if (hand.isShears() || hand.isSword()) {
            return new Item[]{
                    Item.get(ItemIds.STRING)
            };
        } else {
            return new Item[0];
        }
    }

    @Override
    public BlockColor getColor(Block block) {
        return BlockColor.CLOTH_BLOCK_COLOR;
    }

    @Override
    public boolean canHarvestWithHand() {
        return false;
    }

    @Override
    public boolean canWaterlogSource() {
        return true;
    }
}
