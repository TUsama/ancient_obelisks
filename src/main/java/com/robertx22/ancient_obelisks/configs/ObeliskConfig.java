package com.robertx22.ancient_obelisks.configs;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ObeliskConfig {

    public static final ForgeConfigSpec SPEC;
    public static final ObeliskConfig CONFIG;

    static {
        final Pair<ObeliskConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ObeliskConfig::new);
        SPEC = specPair.getRight();
        CONFIG = specPair.getLeft();
    }

    // todo these could be reused for other mods maybe
    public ForgeConfigSpec.IntValue MAX_OBELISK_TIER;
    public ForgeConfigSpec.IntValue MAX_CHEST_REWARDS;
    public ForgeConfigSpec.DoubleValue MOB_HP_PER_TIER;
    public ForgeConfigSpec.DoubleValue MOB_DMG_PER_TIER;
    public ForgeConfigSpec.DoubleValue LOOT_MULTI_PER_TIER;
    public ForgeConfigSpec.DoubleValue LOOT_MULTI_PER_AFFIX;
    public ForgeConfigSpec.DoubleValue LOOT_CHANCE_PER_MOB_KILL;


    public static ObeliskConfig get() {
        return CONFIG;
    }


    ObeliskConfig(ForgeConfigSpec.Builder b) {
        b.comment("Ancient Obelisk Configs")
                .push("general");

        MAX_OBELISK_TIER = b
                .comment("Each obelisk tier increases the Mob Stats and rewards")
                .defineInRange("MAX_OBELISK_TIER", 10, 1, 1000);

        MAX_CHEST_REWARDS = b
                .comment("Maximum amount of chests that can spawn at end of obelisk fight\n" +
                        "Useful as a safety net in case you set your loot multipliers too high so you don't spawn.. 1000 chests accidentally")
                .defineInRange("MAX_CHEST_REWARDS", 10, 1, 1000);

        MOB_HP_PER_TIER = b
                .comment("Mob hp multiplier per obelisk tier")
                .defineInRange("MOB_HP_PER_TIER", 0.2F, 0, 1000);

        MOB_DMG_PER_TIER = b
                .comment("Mob attack damage multiplier per obelisk tier")
                .defineInRange("MOB_DMG_PER_TIER", 0.05F, 0, 1000);

        LOOT_MULTI_PER_TIER = b
                .comment("Loot Multi x tier for obelisk end of fight reward")
                .defineInRange("LOOT_MULTI_PER_TIER", 0.05F, 0, 1);

        LOOT_MULTI_PER_AFFIX = b
                .comment("Loot Multi x tier for obelisk end of fight reward")
                .defineInRange("LOOT_MULTI_PER_AFFIX", 0.1F, 0, 1);

        LOOT_CHANCE_PER_MOB_KILL = b
                .comment("Every mob you kill inside the obelisk will add x chance to spawn loot chests at the end.\n" +
                        "If the total is say 50, it means 50% chance to spawn a chest. If it's 150, then it's 1 chest + 50% chance for another.\n" +
                        "Make sure this value isn't too big because this chance is multiplied by tier and affix counts")
                .defineInRange("LOOT_CHANCE_PER_MOB_KILL", 1F, 0, 100);


        b.pop();
    }


}
