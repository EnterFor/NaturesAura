package de.ellpeck.naturesaura.blocks.tiles;

import de.ellpeck.naturesaura.aura.container.IAuraContainer;
import de.ellpeck.naturesaura.aura.container.NaturalAuraContainer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;

public class TileEntityAncientLeaves extends TileEntityImpl {

    private final NaturalAuraContainer container = new NaturalAuraContainer(20, 5) {
        @Override
        public int getAuraColor() {
            return 0xc46df9;
        }

        @Override
        public int drainAura(int amountToDrain, boolean simulate) {
            int amount = super.drainAura(amountToDrain, simulate);
            if (amount > 0 && !simulate) {
                TileEntityAncientLeaves.this.sendToClients();
            }
            return amount;
        }
    };

    @Override
    public IAuraContainer getAuraContainer(EnumFacing facing) {
        return this.container;
    }

    @Override
    public void writeNBT(NBTTagCompound compound, boolean syncing) {
        super.writeNBT(compound, syncing);
        this.container.writeNBT(compound);
    }

    @Override
    public void readNBT(NBTTagCompound compound, boolean syncing) {
        super.readNBT(compound, syncing);
        this.container.readNBT(compound);
    }
}
