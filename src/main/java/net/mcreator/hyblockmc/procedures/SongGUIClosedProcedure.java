package net.mcreator.hyblockmc.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.hyblockmc.network.HyblockModVariables;
import net.mcreator.hyblockmc.HyblockMod;

public class SongGUIClosedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		HyblockMod.queueServerWork(1, () -> {
			{
				double _setval = 0;
				entity.getCapability(HyblockModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.current_song_falling_tickrate = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/kill @e[type=item,distance=0..5]");
		});
	}
}
