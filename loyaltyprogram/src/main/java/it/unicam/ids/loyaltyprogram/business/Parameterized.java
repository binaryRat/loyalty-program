package it.unicam.ids.loyaltyprogram.business;

import it.unicam.ids.loyaltyprogram.core.Module;

public interface Parameterized<M extends Module> {
    M getModule();

    void setModule(M module);
}
