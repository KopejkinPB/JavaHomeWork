package com.pb.kopejkin.hw7;

public enum Size {
    XXS ("Cупер-супер маленький размер", 32),
    XS ("Супер маленький размер", 34),
    S ("Маленький размер", 36),
    M ("Средний размер", 38),
    L ("Большой размер", 40);

    private final String description;
    private final int euroSize;

    Size(String description, int euroSize) {
        this.description = description;
        this.euroSize = euroSize;
    }

    public String getDescription() {
        return description;
    }

    public int getEuroSize() {
        return euroSize;
    }
}
