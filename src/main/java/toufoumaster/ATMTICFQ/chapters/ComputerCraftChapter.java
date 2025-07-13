package toufoumaster.ATMTICFQ.chapters;

import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.lang.I18n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sunsetsatellite.vintagequesting.gui.QuestChapterPage;
import sunsetsatellite.vintagequesting.gui.ScreenQuestbook;
import sunsetsatellite.vintagequesting.quest.Quest;
import sunsetsatellite.vintagequesting.quest.template.QuestTemplate;
import sunsetsatellite.vintagequesting.util.Logic;
import toufoumaster.ATMTICFQ.ATMTICFQ;
import toufoumaster.ATMTICFQ.VintageQuestingATMTICFQPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static toufoumaster.ATMTICFQ.VintageQuestingATMTICFQPlugin.createRetrievalQuest;
import static toufoumaster.ATMTICFQ.VintageQuestingATMTICFQPlugin.listOf;

public class ComputerCraftChapter extends QuestChapterPage {

	public ComputerCraftChapter(String id) {
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
		return getTextureFromBlock(Blocks.STONE_POLISHED);
	}

	@Override
	public void postProcessBackground(ScreenQuestbook screenQuestbook, Random random, ScreenQuestbook.BGLayer bgLayer, int i, int i1) {

	}

	@Override
	public @NotNull ItemStack getIcon() {
		return Blocks.getBlock(1801).getDefaultStack();
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
		return getQuest(VintageQuestingATMTICFQPlugin.getQuest("computer"));
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

		QuestTemplate computer = createRetrievalQuest(
			"computer",
			Item.getItem(1800),
			listOf(
				new ItemStack(Item.getItem(1800), 1, 0)
			),
			listOf(),
			1, 0
		);
		questList.add(computer);

		QuestTemplate pocketcomputer = createRetrievalQuest(
			"pocketcomputer",
			Item.getItem(19000),
			listOf(
				new ItemStack(Item.getItem(19000), 1, 0)
			),
			listOf(computer),
			0, 0
		);
		questList.add(pocketcomputer);

		QuestTemplate floppydisk = createRetrievalQuest(
			"floppydisk",
			Item.getItem(19002),
			listOf(
				new ItemStack(Item.getItem(19002), 1, 0)
			),
			listOf(computer),
			0, 1
		);
		questList.add(floppydisk);

		QuestTemplate diskdrive = createRetrievalQuest(
			"diskdrive",
			Item.getItem(1810),
			listOf(
				new ItemStack(Item.getItem(1810), 1, 0)
			),
			listOf(computer),
			0, 2
		);
		questList.add(diskdrive);

		QuestTemplate printer = createRetrievalQuest(
			"printer",
			Item.getItem(1812),
			listOf(
				new ItemStack(Item.getItem(1812), 1, 0)
			),
			listOf(computer),
			0, 3
		);
		questList.add(printer);

		QuestTemplate turtle = createRetrievalQuest(
			"turtle",
			Item.getItem(1802),
			listOf(
				new ItemStack(Item.getItem(1802), 1, 0)
			),
			listOf(computer),
			1, 4
		);
		questList.add(turtle);

		QuestTemplate speaker = createRetrievalQuest(
			"speaker",
			Item.getItem(1811),
			listOf(
				new ItemStack(Item.getItem(1811), 1, 0)
			),
			listOf(computer),
			2, 2
		);
		questList.add(speaker);

		QuestTemplate monitor = createRetrievalQuest(
			"monitor",
			Item.getItem(1808),
			listOf(
				new ItemStack(Item.getItem(1808), 1, 0)
			),
			listOf(computer),
			2, 1
		);
		questList.add(monitor);


		QuestTemplate wirelessmodem = createRetrievalQuest(
			"wirelessmodem",
			Item.getItem(1804),
			listOf(
				new ItemStack(Item.getItem(1804), 1, 0)
			),
			listOf(computer),
			2, -1
		);
		questList.add(wirelessmodem);


		QuestTemplate wiredmodem = createRetrievalQuest(
			"wiredmodem",
			Item.getItem(1806),
			listOf(
				new ItemStack(Item.getItem(1806), 1, 0),
				new ItemStack(Item.getItem(19008), 1, 0)
			),
			listOf(computer),
			1, -1,
			Logic.AND, Logic.OR
		);
		questList.add(wiredmodem);


		QuestTemplate networkingcable = createRetrievalQuest(
			"networkingcable",
			Item.getItem(19007),
			listOf(
				new ItemStack(Item.getItem(19007), 1, 0)
			),
			listOf(wiredmodem),
			0, -1
		);
		questList.add(networkingcable);

		// Advanced Computer

		QuestTemplate advancedcomputer = createRetrievalQuest(
			"advancedcomputer",
			Item.getItem(1801),
			listOf(
				new ItemStack(Item.getItem(1801), 1, 0)
			),
			listOf(computer),
			5, 0
		);
		questList.add(advancedcomputer);

		QuestTemplate advancedpocketcomputer = createRetrievalQuest(
			"advancedpocketcomputer",
			Item.getItem(19001),
			listOf(
				new ItemStack(Item.getItem(19001), 1, 0)
			),
			listOf(advancedcomputer),
			6, 0
		);
		questList.add(advancedpocketcomputer);

		QuestTemplate endermodem = createRetrievalQuest(
			"endermodem",
			Item.getItem(1805),
			listOf(
				new ItemStack(Item.getItem(1805), 1, 0)
			),
			listOf(advancedcomputer),
			5, -1
		);
		questList.add(endermodem);

		QuestTemplate advancedmonitor = createRetrievalQuest(
			"advancedmonitor",
			Item.getItem(1809),
			listOf(
				new ItemStack(Item.getItem(1809), 1, 0)
			),
			listOf(advancedcomputer),
			6, 1
		);
		questList.add(advancedmonitor);

		QuestTemplate advancedturtle = createRetrievalQuest(
			"advancedturtle",
			Item.getItem(1803),
			listOf(
				new ItemStack(Item.getItem(1803), 1, 0)
			),
			listOf(advancedcomputer),
			6, 4
		);
		questList.add(advancedturtle);

		return questList;
	}
}
