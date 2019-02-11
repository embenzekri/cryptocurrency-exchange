package com.indev.cryptocurrency.exchange;

public class DefaultWaletteBalanceRepresenter implements WaletteRepresenter {
    @Override
    public String getRepresentation(Walette walette) {
        return walette != null ? "," +walette.toString() : "";
    }
}
