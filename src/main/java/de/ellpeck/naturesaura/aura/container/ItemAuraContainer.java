package de.ellpeck.naturesaura.aura.container;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemAuraContainer implements IAuraContainer {

    protected final ItemStack stack;
    protected final int maxAura;

    public ItemAuraContainer(ItemStack stack, int maxAura) {
        this.stack = stack;
        this.maxAura = maxAura;
    }

    @Override
    public int storeAura(int amountToStore, boolean simulate) {
        int aura = this.getStoredAura();
        int actual = Math.min(amountToStore, this.getMaxAura() - aura);
        if (!simulate) {
            this.setAura(aura + actual);
        }
        return actual;
    }

    @Override
    public int drainAura(int amountToDrain, boolean simulate) {
        int aura = this.getStoredAura();
        int actual = Math.min(amountToDrain, aura);
        if (!simulate) {
            this.setAura(aura - actual);
        }
        return actual;
    }

    private void setAura(int amount) {
        if (!this.stack.hasTagCompound()) {
            this.stack.setTagCompound(new NBTTagCompound());
        }
        this.stack.getTagCompound().setInteger("aura", amount);
    }

    @Override
    public int getStoredAura() {
        if (this.stack.hasTagCompound()) {
            return this.stack.getTagCompound().getInteger("aura");
        } else {
            return 0;
        }
    }

    @Override
    public int getMaxAura() {
        return this.maxAura;
    }

    @Override
    public int getAuraColor() {
        return 0x42a6bc;
    }
}
