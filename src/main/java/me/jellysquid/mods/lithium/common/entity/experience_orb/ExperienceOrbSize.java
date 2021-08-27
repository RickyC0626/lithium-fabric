package me.jellysquid.mods.lithium.common.entity.experience_orb;

public enum ExperienceOrbSize {
    LARGEST(2477, 10),
    LARGER_LARGE(1237, 9),
    LARGER(617, 8),
    LARGE(307, 7),
    MEDIUM_LARGE(149, 6),
    MEDIUM(73, 5),
    MEDIUM_SMALL(37, 4),
    SMALL(17, 3),
    SMALLER(7, 2),
    SMALLER_SMALL(3, 1),
    SMALLEST(1, 0);

    private final int amount;
    private final int size;

    ExperienceOrbSize(int amount, int size) {
        this.amount = amount;
        this.size = size;
    }

    public int getAmount() { return amount; }
    public int getSize() { return size; }

    public static ExperienceOrbSize getEnum(int amount) {
        for(ExperienceOrbSize s : ExperienceOrbSize.values()) {
            if(amount >= s.getAmount()) return s;
        }
        return SMALLEST;
    }
}
