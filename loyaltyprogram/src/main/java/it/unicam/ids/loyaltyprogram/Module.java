package it.unicam.ids.loyaltyprogram;

import java.util.Map;

public interface Module {
    boolean checkParameters(Map<String, String> data);
}
