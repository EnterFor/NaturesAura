package de.ellpeck.naturesaura.aura.container;

import de.ellpeck.naturesaura.aura.chunk.ISpotDrainable;

public class NaturalAuraContainer extends BasicAuraContainer implements ISpotDrainable {

    private final int drainAmount;

    public NaturalAuraContainer(int aura, int drainAmount) {
        super(aura);
        this.aura = aura;
        this.drainAmount = drainAmount;
    }

    @Override
    public int storeAura(int amountToStore, boolean simulate) {
        return 0;
    }

    @Override
    public int drainAuraPassively(int amountToDrain, boolean simulate) {
        return this.drainAura(Math.min(this.drainAmount, amountToDrain), simulate);
    }
}
