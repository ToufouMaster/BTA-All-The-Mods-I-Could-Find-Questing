package toufoumaster.ATMTICFQ.chapters;

import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.lang.I18n;
import net.minecraft.core.world.Dimension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sunsetsatellite.vintagequesting.gui.QuestChapterPage;
import sunsetsatellite.vintagequesting.gui.ScreenQuestbook;
import sunsetsatellite.vintagequesting.quest.Quest;
import sunsetsatellite.vintagequesting.quest.template.QuestTemplate;
import sunsetsatellite.vintagequesting.quest.template.TaskTemplate;
import sunsetsatellite.vintagequesting.quest.template.task.ClickTaskTemplate;
import sunsetsatellite.vintagequesting.quest.template.task.VisitDimensionTaskTemplate;
import sunsetsatellite.vintagequesting.util.Logic;
import toufoumaster.ATMTICFQ.ATMTICFQ;
import toufoumaster.ATMTICFQ.VintageQuestingATMTICFQPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static toufoumaster.ATMTICFQ.VintageQuestingATMTICFQPlugin.createRetrievalQuest;
import static toufoumaster.ATMTICFQ.VintageQuestingATMTICFQPlugin.listOf;

public class StorageChapter extends QuestChapterPage {

	public StorageChapter(String id) {
		super(id);
	}

	@Override
	public @NotNull String getName() {
		return I18n.getInstance().translateNameKey("chapter."+ATMTICFQ.MOD_ID+"."+id);
	}

	@Override
	public @NotNull String getDescription() {
		return I18n.getInstance().translateDescKey("chapter."+ATMTICFQ.MOD_ID+"."+id);
	}

	@Override
	public @Nullable IconCoordinate getBackgroundTile(ScreenQuestbook screenQuestbook, int i, Random random, int i1, int i2) {
		return getTextureFromBlock(Blocks.PLANKS_OAK);
	}

	@Override
	public void postProcessBackground(ScreenQuestbook screenQuestbook, Random random, ScreenQuestbook.BGLayer bgLayer, int i, int i1) {

	}

	@Override
	public @NotNull ItemStack getIcon() {
		return Blocks.getBlock(2500).getDefaultStack();
	}

	@Override
	public int backgroundLayers() {
		return 1;
	}

	@Override
	public int backgroundColor() {
		return 0;
	}

	@Override
	public Quest getStartingQuest() {
		return getQuest(VintageQuestingATMTICFQPlugin.getQuest("ironchest"));
	}

	@Override
	public IconCoordinate getQuestBackground(QuestTemplate questTemplate) {
		return TextureRegistry.getTexture(questTemplate.getType().texture);
	}

	@Override
	public int lineColorLocked(boolean isHovered) {
		return 0x010101;
	}

	@Override
	public int lineColorUnlocked(boolean isHovered) {
		return 0xFFFFFF;
	}

	@Override
	public int lineColorCanUnlock(boolean isHovered) {
		return 0x00ff00;
	}

	public List<QuestTemplate> getToInitQuests() {
		ArrayList<QuestTemplate> questList = new ArrayList<>();

		// Iron Chests

		QuestTemplate ironchest = createRetrievalQuest(
			"ironchest",
			Blocks.getBlock(2500),
			listOf(
				new ItemStack(Blocks.getBlock(2500), 1, 0)
			),
			listOf(),
			0, 0
		);
		questList.add(ironchest);

		QuestTemplate goldchest = createRetrievalQuest(
			"goldchest",
			Blocks.getBlock(2501),
			listOf(
				new ItemStack(Blocks.getBlock(2501), 1, 0)
			),
			listOf(ironchest),
			1, 0
		);
		questList.add(goldchest);
		questList.add(goldchest);

		QuestTemplate diamondchest = createRetrievalQuest(
			"diamondchest",
			Blocks.getBlock(2502),
			listOf(
				new ItemStack(Blocks.getBlock(2502), 1, 0)
			),
			listOf(goldchest),
			2, 0
		);
		questList.add(diamondchest);

		QuestTemplate steelchest = createRetrievalQuest(
			"steelchest",
			Blocks.getBlock(2503),
			listOf(
				new ItemStack(Blocks.getBlock(2503), 1, 0)
			),
			listOf(goldchest),
			2, 1
		);
		questList.add(steelchest);

		// Storage Containers

		QuestTemplate prototypestoragecontainer = createRetrievalQuest(
			"prototypestoragecontainer",
			Blocks.getBlock(9970),
			listOf(
				new ItemStack(Blocks.getBlock(9970), 1, 0)
			),
			listOf(VintageQuestingATMTICFQPlugin.getQuest("signalindustries"), VintageQuestingATMTICFQPlugin.getQuest("storage")),
			4, 0
		);
		questList.add(prototypestoragecontainer);

		QuestTemplate basicstoragecontainer = createRetrievalQuest(
			"basicstoragecontainer",
			Blocks.getBlock(9972),
			listOf(
				new ItemStack(Blocks.getBlock(9972), 1, 0)
			),
			listOf(prototypestoragecontainer),
			4, 1
		);
		questList.add(basicstoragecontainer);

		QuestTemplate reinforcedcompressedstoragecontainer = createRetrievalQuest(
			"reinforcedcompressedstoragecontainer",
			Blocks.getBlock(9973),
			listOf(
				new ItemStack(Blocks.getBlock(9973), 1, 0)
			),
			listOf(basicstoragecontainer),
			4, 2
		);
		questList.add(reinforcedcompressedstoragecontainer);

		// Signal Industries Backpack

		QuestTemplate basicbackpack = createRetrievalQuest(
			"basicbackpack",
			Item.getItem(17164),
			listOf(
				new ItemStack(Item.getItem(17164), 1, 0)
			),
			listOf(VintageQuestingATMTICFQPlugin.getQuest("signalindustries"), VintageQuestingATMTICFQPlugin.getQuest("storage")),
			4, 4
		);
		questList.add(basicbackpack);

		QuestTemplate reinforcedbackpack = createRetrievalQuest(
			"reinforcedbackpack",
			Item.getItem(17165),
			listOf(
				new ItemStack(Item.getItem(17165), 1, 0)
			),
			listOf(basicbackpack),
			3, 5
		);
		questList.add(reinforcedbackpack);

		// Cupboard

		QuestTemplate cupboard = createRetrievalQuest(
			"cupboard",
			Item.getItem(1900),
			listOf(
				new ItemStack(Item.getItem(1900), 1, 0),
				new ItemStack(Item.getItem(1901), 1, 0),
				new ItemStack(Item.getItem(1901), 1, 16),
				new ItemStack(Item.getItem(1901), 1, 32),
				new ItemStack(Item.getItem(1901), 1, 48),
				new ItemStack(Item.getItem(1901), 1, 64),
				new ItemStack(Item.getItem(1901), 1, 80),
				new ItemStack(Item.getItem(1901), 1, 96),
				new ItemStack(Item.getItem(1901), 1, 112),
				new ItemStack(Item.getItem(1901), 1, 128),
				new ItemStack(Item.getItem(1901), 1, 144),
				new ItemStack(Item.getItem(1901), 1, 160),
				new ItemStack(Item.getItem(1901), 1, 176),
				new ItemStack(Item.getItem(1901), 1, 192),
				new ItemStack(Item.getItem(1901), 1, 208),
				new ItemStack(Item.getItem(1901), 1, 224),
				new ItemStack(Item.getItem(1901), 1, 240)
			),
			listOf(VintageQuestingATMTICFQPlugin.getQuest("storage")),
			6, 0,
			Logic.AND, Logic.OR, false
		);
		questList.add(cupboard);

		// Backpacks

		QuestTemplate leatherbackpack = createRetrievalQuest(
			"leatherbackpack",
			Item.getItem(21370),
			listOf(
				new ItemStack(Item.getItem(21370), 1, 0)
			),
			listOf(VintageQuestingATMTICFQPlugin.getQuest("storage")),
			0, 2
		);
		questList.add(leatherbackpack);

		QuestTemplate ironbackpack = createRetrievalQuest(
			"ironbackpack",
			Item.getItem(21371),
			listOf(
				new ItemStack(Item.getItem(21371), 1, 0)
			),
			listOf(leatherbackpack),
			0, 3
		);
		questList.add(ironbackpack);

		QuestTemplate goldbackpack = createRetrievalQuest(
			"goldbackpack",
			Item.getItem(21372),
			listOf(
				new ItemStack(Item.getItem(21372), 1, 0)
			),
			listOf(leatherbackpack),
			0, 4
		);
		questList.add(goldbackpack);

		QuestTemplate diamondbackpack = createRetrievalQuest(
			"diamondbackpack",
			Item.getItem(21373),
			listOf(
				new ItemStack(Item.getItem(21373), 1, 0)
			),
			listOf(goldbackpack),
			0, 5
		);
		questList.add(diamondbackpack);

		QuestTemplate moonsteelbackpack = createRetrievalQuest(
			"moonsteelbackpack",
			Item.getItem(21413),
			listOf(
				new ItemStack(Item.getItem(21413), 1, 0)
			),
			listOf(goldbackpack),
			1, 4
		);
		questList.add(moonsteelbackpack);

		QuestTemplate crate = createRetrievalQuest(
			"crate",
			Item.getItem(4222),
			listOf(
				new ItemStack(Item.getItem(4222), 1, 0),
				new ItemStack(Item.getItem(4223), 1, 0)
			),
			listOf(VintageQuestingATMTICFQPlugin.getQuest("storage")),
			6, 5,
			Logic.AND, Logic.OR,
			false
		);
		questList.add(crate);

		return questList;
	}
}
