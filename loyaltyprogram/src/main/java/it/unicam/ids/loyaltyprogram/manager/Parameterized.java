package it.unicam.ids.loyaltyprogram.manager;

import it.unicam.ids.loyaltyprogram.core.Module;

public interface Parameterized<M extends Module> {
    M getModule();

    void setModule(M module);
}
