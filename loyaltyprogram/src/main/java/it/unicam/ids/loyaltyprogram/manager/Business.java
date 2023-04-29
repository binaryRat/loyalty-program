package it.unicam.ids.loyaltyprogram.manager;
import it.unicam.ids.loyaltyprogram.Module;
import java.util.List;

public interface Business<M extends Module, S extends Store, P extends Program> extends Parameterized<M>{
    void addStore(S store);

    List<P> getPrograms();

    List<S> getStores();

    void addProgram(P program);
}
