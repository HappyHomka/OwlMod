package com.homka.owlmod.sound;

import com.homka.owlmod.OwlMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent OWL_STATUE_USE_ONE = registerSoundEvent("owl_statue_use_one");
    public static final SoundEvent OWL_STATUE_USE_TWO = registerSoundEvent("owl_statue_use_two");
    public static final SoundEvent OWL_STATUE_USE_THREE = registerSoundEvent("owl_statue_use_three");

    public static final SoundEvent OWL_STATUE_BREAK = registerSoundEvent("owl_statue_placement");
    public static final SoundEvent OWL_STATUE_STEP = registerSoundEvent("owl_statue_placement");
    public static final SoundEvent OWL_STATUE_PLACE = registerSoundEvent("owl_statue_placement");
    public static final SoundEvent OWL_STATUE_HIT = registerSoundEvent("owl_statue_placement");
    public static final SoundEvent OWL_STATUE_FALL = registerSoundEvent("owl_statue_placement");

    public static final BlockSoundGroup OWL_STATUE_SOUND = new BlockSoundGroup(1f,1f, OWL_STATUE_BREAK,
            OWL_STATUE_STEP,OWL_STATUE_PLACE,OWL_STATUE_HIT,OWL_STATUE_FALL);

    private static SoundEvent registerSoundEvent(String name){
        Identifier id = Identifier.of(OwlMod.MOD_ID,name);
        return Registry.register(Registries.SOUND_EVENT,id,SoundEvent.of(id));
    }

    public static void registerSound(){
        OwlMod.LOGGER.info("registering sounds " + OwlMod.MOD_ID);
    }
}
