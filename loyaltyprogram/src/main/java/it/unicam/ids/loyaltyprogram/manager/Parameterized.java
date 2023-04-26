package it.unicam.ids.loyaltyprogram.manager;

import it.unicam.ids.loyaltyprogram.Module;

public interface Parameterized<M extends Module> {
    M getData();

    void setData(M module);
}
