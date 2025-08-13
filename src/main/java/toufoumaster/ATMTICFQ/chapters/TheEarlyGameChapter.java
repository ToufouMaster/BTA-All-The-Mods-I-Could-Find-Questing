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
import static toufoumaster.ATMTICFQ.VintageQuestingATMTICFQPlugin.createRetrievalQuest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static toufoumaster.ATMTICFQ.VintageQuestingATMTICFQPlugin.listOf;

public class TheEarlyGameChapter extends QuestChapterPage {

	public TheEarlyGameChapter(String id) {
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
		return getTextureFromBlock(Blocks.DIRT);
	}

	@Override
	public void postProcessBackground(ScreenQuestbook screenQuestbook, Random random, ScreenQuestbook.BGLayer bgLayer, int i, int i1) {

	}

	@Override
	public @NotNull ItemStack getIcon() {
		return Blocks.GRASS.getDefaultStack();
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
		return getQuest(VintageQuestingATMTICFQPlugin.getQuest("welcome"));
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

		QuestTemplate welcome = new QuestTemplate(ATMTICFQ.MOD_ID+":welcome","quest."+ATMTICFQ.MOD_ID+".welcome", Blocks.GRASS, Logic.AND, Logic.AND)
			.setTasks(listOf(new ClickTaskTemplate(ATMTICFQ.MOD_ID+":welcome/click")));
		questList.add(welcome);

		QuestTemplate gatherwood = createRetrievalQuest(
			"gatherwood",
			Blocks.LOG_OAK,
			listOf(
				new ItemStack(Blocks.LOG_OAK, 8),
				new ItemStack(Blocks.LOG_BIRCH, 8),
				new ItemStack(Blocks.LOG_CHERRY, 8),
				new ItemStack(Blocks.LOG_EUCALYPTUS, 8),
				new ItemStack(Blocks.LOG_PALM, 8),
				new ItemStack(Blocks.LOG_OAK_MOSSY, 8),
				new ItemStack(Blocks.LOG_PINE, 8),
				new ItemStack(Blocks.LOG_THORN, 8)
			),
			listOf(welcome),
			1, 0,
			Logic.AND, Logic.OR
		);
		questList.add(gatherwood);

		QuestTemplate workbench = createRetrievalQuest(
			"workbench",
			Blocks.WORKBENCH,
			listOf(
				new ItemStack(Blocks.WORKBENCH, 1),
				new ItemStack(Item.getItem(11547), 1)
			),
			listOf(gatherwood),
			2, 0,
			Logic.AND, Logic.OR, false
		);
		questList.add(workbench);

		QuestTemplate portable_workbench = createRetrievalQuest(
			"portable_workbench",
			Item.getItem(19554),
			listOf(
				new ItemStack(Item.getItem(19554), 1)
			),
			listOf(workbench),
			2, 1
		);
		questList.add(portable_workbench);

		QuestTemplate woodentools = createRetrievalQuest(
			"woodentools", Items.TOOL_PICKAXE_WOOD,
			listOf(
				new ItemStack(Items.TOOL_PICKAXE_WOOD, 1),
				new ItemStack(Items.TOOL_AXE_WOOD, 1),
				new ItemStack(Items.TOOL_SWORD_WOOD, 1)
			),
			listOf(workbench),
			3, 0, Logic.AND, Logic.OR, false
		);
		questList.add(woodentools);

		QuestTemplate bonetools = createRetrievalQuest(
			"bonetools",
			Items.BONE,
			listOf(
				new ItemStack(Items.TOOL_PICKAXE_STONE, 1)
			),
			listOf(woodentools),
			4, 0
		);
		questList.add(bonetools);


		QuestTemplate furnace = createRetrievalQuest(
			"furnace",
			Blocks.FURNACE_STONE_IDLE,
			listOf(
				new ItemStack(Blocks.FURNACE_STONE_IDLE, 1)
			),
			listOf(woodentools),
			3, 1
		);
		questList.add(furnace);


		QuestTemplate iron = createRetrievalQuest(
			"iron",
			Items.INGOT_IRON,
			listOf(
				new ItemStack(Items.INGOT_IRON, 1)
			),
			listOf(furnace),
			4, 2
		);
		questList.add(iron);

		QuestTemplate gold = createRetrievalQuest(
			"gold",
			Items.INGOT_GOLD,
			listOf(
				new ItemStack(Items.INGOT_GOLD, 1)
			),
			listOf(furnace),
			3, 2
		);
		questList.add(gold);

		QuestTemplate lead = createRetrievalQuest(
			"lead",
			Item.getItem(28067),
			listOf(
				new ItemStack(28067, 1, 0)
			),
			listOf(furnace),
			2, 2
		);
		questList.add(lead);

		QuestTemplate silver = createRetrievalQuest(
			"silver",
			Item.getItem(28055),
			listOf(
				new ItemStack(28055, 1, 0)
			),
			listOf(furnace),
			1, 2
		);
		questList.add(silver);

		QuestTemplate diamond = createRetrievalQuest(
			"diamond",
			Items.DIAMOND,
			listOf(
				new ItemStack(Items.DIAMOND, 1)
			),
			listOf(bonetools),
			5, 0
		);
		questList.add(diamond);

		QuestTemplate diamondtool = createRetrievalQuest(
			"diamondtool",
			Items.TOOL_PICKAXE_DIAMOND,
			listOf(
				new ItemStack(Items.TOOL_PICKAXE_DIAMOND, 1)
			),
			listOf(diamond),
			5, -2, false
		);
		questList.add(diamondtool);

		QuestTemplate diamondtool2 = createRetrievalQuest(
			"diamondtool2",
			Item.getItem(19572),
			listOf(
				new ItemStack(19572, 1, 0)
			),
			listOf(diamond),
			4, -2, false
		);
		questList.add(diamondtool2);

		QuestTemplate gotonether = createRetrievalQuest(
			"gotonether",
			Blocks.OBSIDIAN,
			listOf(
				new ItemStack(Blocks.OBSIDIAN, 12),
				new ItemStack(Items.TOOL_FIRESTRIKER_IRON, 1)
			),
			listOf(diamondtool),
			6, -2
		);
		List<TaskTemplate> gotonetherTasks = gotonether.getTasks();
		gotonetherTasks.add(new VisitDimensionTaskTemplate(ATMTICFQ.MOD_ID+":"+gotonether.getId()+"/netherdimension", Dimension.NETHER));
		gotonether.setTasks(gotonetherTasks);
		questList.add(gotonether);

		QuestTemplate nethercoal = createRetrievalQuest(
			"nethercoal",
			Items.NETHERCOAL,
			listOf(
				new ItemStack(Items.NETHERCOAL, 1)
			),
			listOf(gotonether),
			7, -2
		);
		questList.add(nethercoal);

		QuestTemplate steelingot = createRetrievalQuest(
			"steelingot",
			Items.INGOT_STEEL,
			listOf(
				new ItemStack(Items.INGOT_STEEL_CRUDE, 1),
				new ItemStack(Items.INGOT_STEEL, 1)
			),
			listOf(nethercoal, iron),
			8, -1
		);
		questList.add(steelingot);

		QuestTemplate signalindustries = createRetrievalQuest(
			"signalindustries",
			Item.getItem(9908),
			listOf(
				new ItemStack(9908, 1, 0)
			),
			listOf(steelingot),
			8, -3
		);
		questList.add(signalindustries);

		QuestTemplate ironfurnace = createRetrievalQuest(
			"ironfurnace",
			Item.getItem(664),
			listOf(
				new ItemStack(664, 1, 0)
			),
			listOf(iron, furnace),
			4, 1
		);
		questList.add(ironfurnace);

		QuestTemplate goldfurnace = createRetrievalQuest(
			"goldfurnace",
			Item.getItem(666),
			listOf(
				new ItemStack(666, 1, 0)
			),
			listOf(gold, ironfurnace),
			5, 1
		);
		questList.add(goldfurnace);

		QuestTemplate diamondfurnace = createRetrievalQuest(
			"diamondfurnace",
			Item.getItem(668),
			listOf(
				new ItemStack(668, 1, 0)
			),
			listOf(diamond, goldfurnace),
			6, 1
		);
		questList.add(diamondfurnace);

		QuestTemplate steelfurnace = createRetrievalQuest(
			"steelfurnace",
			Item.getItem(674),
			listOf(
				new ItemStack(674, 1, 0)
			),
			listOf(steelingot, goldfurnace),
			6, 2
		);
		questList.add(steelfurnace);


		QuestTemplate glowstone = createRetrievalQuest(
			"glowstone",
			Blocks.GLOWSTONE,
			listOf(
				new ItemStack(Items.DUST_GLOWSTONE, 64, 0)
			),
			listOf(gotonether),
			6, -3
		);
		questList.add(glowstone);

		QuestTemplate terrapon = createRetrievalQuest(
			"terrapon",
			Item.getItem(25400),
			listOf(
				new ItemStack(25400, 1, 0)
			),
			listOf(steelingot, diamond, glowstone),
			10, -1
		);
		questList.add(terrapon);

		QuestTemplate storage = createRetrievalQuest(
			"storage",
			Blocks.CHEST_PLANKS_OAK,
			listOf(
				new ItemStack(Blocks.CHEST_PLANKS_OAK, 1, 0),
				new ItemStack(Blocks.CHEST_PLANKS_OAK_PAINTED, 1, 0)
			),
			listOf(workbench),
			2, -1,
			Logic.AND, Logic.OR,
			false
		);
		questList.add(storage);


		return questList;
	}
}
