
package net.mcreator.hyblockmc.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.Component;

import net.mcreator.hyblockmc.procedures.Summonrevenantbosst2Procedure;

import java.util.List;

public class RevenantkeystonetabletT2Item extends Item {
	public RevenantkeystonetabletT2Item() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON));
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0f;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A78Used for spawing the \u00A7eTier 2 Revenant Horror"));
		list.add(Component.literal("\u00A7r\u00A78slayer boss at a keystone"));
		list.add(Component.literal("\u00A70."));
		list.add(Component.literal("\u00A74\u00A7l\u00A7k0\u00A74\u00A7lSummoning Tablet\u00A74\u00A7l\u00A7k0"));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		Summonrevenantbosst2Procedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}
