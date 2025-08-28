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
import toufoumaster.ATMTICFQ.ATMTICFQ;
import toufoumaster.ATMTICFQ.VintageQuestingATMTICFQPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static toufoumaster.ATMTICFQ.VintageQuestingATMTICFQPlugin.createRetrievalQuest;
import static toufoumaster.ATMTICFQ.VintageQuestingATMTICFQPlugin.listOf;

public class TerraponChapter extends QuestChapterPage {

	public TerraponChapter(String id) {
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
		return getTextureFromBlock(Blocks.getBlock(4701));
	}

	@Override
	public void postProcessBackground(ScreenQuestbook screenQuestbook, Random random, ScreenQuestbook.BGLayer bgLayer, int i, int i1) {

	}

	@Override
	public @NotNull ItemStack getIcon() {
		return Item.getItem(25453).getDefaultStack();
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
		return getQuest(VintageQuestingATMTICFQPlugin.getQuest("orbofrogmal"));
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

		QuestTemplate orbofrogmal = createRetrievalQuest(
			"orbofrogmal", Item.getItem(25400),
			listOf(
				new ItemStack(Item.getItem(25400), 1, 0)
			),
			listOf(),-2, 0
		); questList.add(orbofrogmal);

		QuestTemplate reinforcedleather = createRetrievalQuest(
			"reinforcedleather", Item.getItem(25412),
			listOf(
				new ItemStack(Item.getItem(25412), 1, 0)
			),
			listOf(orbofrogmal),-2, 1
		); questList.add(reinforcedleather);

		QuestTemplate obsidianalloy = createRetrievalQuest(
			"obsidianalloy", Item.getItem(25406),
			listOf(
				new ItemStack(Item.getItem(25406), 1, 0)
			),
			listOf(orbofrogmal),2, 0
		); questList.add(obsidianalloy);

		QuestTemplate glowstonealloy = createRetrievalQuest(
			"glowstonealloy", Item.getItem(25408),
			listOf(
				new ItemStack(Item.getItem(25408), 1, 0)
			),
			listOf(orbofrogmal),5, 0
		); questList.add(glowstonealloy);

		QuestTemplate redstonealloy = createRetrievalQuest(
			"redstonealloy", Item.getItem(25402),
			listOf(
				new ItemStack(Item.getItem(25402), 1, 0)
			),
			listOf(orbofrogmal),8, 0
		); questList.add(redstonealloy);

		QuestTemplate lapisalloy = createRetrievalQuest(
			"lapisalloy", Item.getItem(25404),
			listOf(
				new ItemStack(Item.getItem(25404), 1, 0)
			),
			listOf(orbofrogmal),11, 0
		); questList.add(lapisalloy);

		QuestTemplate balloflava = createRetrievalQuest(
			"balloflava", Item.getItem(25409),
			listOf(
				new ItemStack(Item.getItem(25409), 1, 0)
			),
			listOf(orbofrogmal),14, -2
		); questList.add(balloflava);

		QuestTemplate lavastar = createRetrievalQuest(
			"lavastar", Item.getItem(25410),
			listOf(
				new ItemStack(Item.getItem(25410), 1, 0)
			),
			listOf(balloflava),14, -1
		); questList.add(lavastar);

		QuestTemplate hellingot = createRetrievalQuest(
			"hellingot", Item.getItem(25411),
			listOf(
				new ItemStack(Item.getItem(25411), 1, 0)
			),
			listOf(lavastar),14, 0
		); questList.add(hellingot);

		QuestTemplate loptfuel = createRetrievalQuest(
			"loptfuel", Item.getItem(25462),
			listOf(
				new ItemStack(Item.getItem(25462), 1, 0)
			),
			listOf(hellingot),15, 1
		); questList.add(loptfuel);

		QuestTemplate seiarilium = createRetrievalQuest(
			"seiarilium", Item.getItem(25418),
			listOf(
				new ItemStack(Item.getItem(25418), 1, 0)
			),
			listOf(glowstonealloy),4, 1
		); questList.add(seiarilium);

		QuestTemplate einvadril = createRetrievalQuest(
			"einvadril", Item.getItem(25429),
			listOf(
				new ItemStack(Item.getItem(25429), 1, 0)
			),
			listOf(redstonealloy),7, 1
		); questList.add(einvadril);

		QuestTemplate hlifintite = createRetrievalQuest(
			"hlifintite", Item.getItem(25440),
			listOf(
				new ItemStack(Item.getItem(25440), 1, 0)
			),
			listOf(lapisalloy),10, 1
		); questList.add(hlifintite);

		QuestTemplate sollogium = createRetrievalQuest(
			"sollogium", Item.getItem(25451),
			listOf(
				new ItemStack(Item.getItem(25451), 1, 0)
			),
			listOf(hellingot),13, 1
		); questList.add(sollogium);

		QuestTemplate redstonealloyrod = createRetrievalQuest(
			"redstonealloyrod", Item.getItem(25403),
			listOf(
				new ItemStack(Item.getItem(25403), 1, 0)
			),
			listOf(redstonealloy),9, 1
		); questList.add(redstonealloyrod);

		QuestTemplate lapisalloyrod = createRetrievalQuest(
			"lapisalloyrod", Item.getItem(25405),
			listOf(
				new ItemStack(Item.getItem(25405), 1, 0)
			),
			listOf(lapisalloy),12, 1
		); questList.add(lapisalloyrod);

		QuestTemplate obsidianalloyrod = createRetrievalQuest(
			"obsidianalloyrod", Item.getItem(25407),
			listOf(
				new ItemStack(Item.getItem(25407), 1, 0)
			),
			listOf(obsidianalloy),3, 1
		); questList.add(obsidianalloyrod);

		QuestTemplate steelrod = createRetrievalQuest(
			"steelrod", Item.getItem(25401),
			listOf(
				new ItemStack(Item.getItem(25401), 1, 0)
			),
			listOf(orbofrogmal),1, 1
		); questList.add(steelrod);

		QuestTemplate eilifligronium = createRetrievalQuest(
			"eilifligronium", Item.getItem(25463),
			listOf(
				new ItemStack(Item.getItem(25463), 1, 0)
			),
			listOf(seiarilium, einvadril, hlifintite),1, 3
		); questList.add(eilifligronium);

		QuestTemplate seialiriumtools = createRetrievalQuest(
			"seialiriumtools", Item.getItem(25420),
			listOf(
				new ItemStack(Item.getItem(25420), 1, 0),
				new ItemStack(Item.getItem(25421), 1, 0),
				new ItemStack(Item.getItem(25422), 1, 0),
				new ItemStack(Item.getItem(25423), 1, 0),
				new ItemStack(Item.getItem(25424), 1, 0)
			),
			listOf(seiarilium, steelrod),4, 4, false
		); questList.add(seialiriumtools);

		QuestTemplate seialiriumarmor = createRetrievalQuest(
			"seialiriumarmor", Item.getItem(25426),
			listOf(
				new ItemStack(Item.getItem(25425), 1, 0),
				new ItemStack(Item.getItem(25426), 1, 0),
				new ItemStack(Item.getItem(25427), 1, 0),
				new ItemStack(Item.getItem(25428), 1, 0)
			),
			listOf(seiarilium),4, 5, false
		); questList.add(seialiriumarmor);

		QuestTemplate einvadriltools = createRetrievalQuest(
			"einvadriltools", Item.getItem(25431),
			listOf(
				new ItemStack(Item.getItem(25431), 1, 0),
				new ItemStack(Item.getItem(25432), 1, 0),
				new ItemStack(Item.getItem(25433), 1, 0),
				new ItemStack(Item.getItem(25434), 1, 0),
				new ItemStack(Item.getItem(25435), 1, 0)
			),
			listOf(einvadril, lapisalloyrod),7, 4, false
		); questList.add(einvadriltools);

		QuestTemplate einvadrilarmor = createRetrievalQuest(
			"einvadrilarmor", Item.getItem(25437),
			listOf(
				new ItemStack(Item.getItem(25436), 1, 0),
				new ItemStack(Item.getItem(25437), 1, 0),
				new ItemStack(Item.getItem(25438), 1, 0),
				new ItemStack(Item.getItem(25439), 1, 0)
			),
			listOf(einvadril),7, 5, false
		); questList.add(einvadrilarmor);

		QuestTemplate hlifintitetools = createRetrievalQuest(
			"hlifintitetools", Item.getItem(25442),
			listOf(
				new ItemStack(Item.getItem(25442), 1, 0),
				new ItemStack(Item.getItem(25443), 1, 0),
				new ItemStack(Item.getItem(25444), 1, 0),
				new ItemStack(Item.getItem(25445), 1, 0),
				new ItemStack(Item.getItem(25446), 1, 0)
			),
			listOf(hlifintite, redstonealloyrod),10, 4, false
		); questList.add(hlifintitetools);

		QuestTemplate hlifintitearmor = createRetrievalQuest(
			"hlifintitearmor", Item.getItem(25448),
			listOf(
				new ItemStack(Item.getItem(25447), 1, 0),
				new ItemStack(Item.getItem(25448), 1, 0),
				new ItemStack(Item.getItem(25449), 1, 0),
				new ItemStack(Item.getItem(25450), 1, 0)
			),
			listOf(hlifintite, reinforcedleather),10, 5, false
		); questList.add(hlifintitearmor);

		QuestTemplate sollogiumtools = createRetrievalQuest(
			"sollogiumtools", Item.getItem(25453),
			listOf(
				new ItemStack(Item.getItem(25453), 1, 0),
				new ItemStack(Item.getItem(25454), 1, 0),
				new ItemStack(Item.getItem(25455), 1, 0),
				new ItemStack(Item.getItem(25456), 1, 0),
				new ItemStack(Item.getItem(25457), 1, 0)
			),
			listOf(sollogium, obsidianalloyrod),13, 4, false
		); questList.add(sollogiumtools);

		QuestTemplate sollogiumarmor = createRetrievalQuest(
			"sollogiumarmor", Item.getItem(25459),
			listOf(
				new ItemStack(Item.getItem(25458), 1, 0),
				new ItemStack(Item.getItem(25459), 1, 0),
				new ItemStack(Item.getItem(25460), 1, 0),
				new ItemStack(Item.getItem(25461), 1, 0)
			),
			listOf(sollogium, obsidianalloy),13, 5, false
		); questList.add(sollogiumarmor);

		QuestTemplate eilifligroniumtools = createRetrievalQuest(
			"eilifligroniumtools", Item.getItem(25464),
			listOf(
				new ItemStack(Item.getItem(25464), 1, 0),
				new ItemStack(Item.getItem(25465), 1, 0),
				new ItemStack(Item.getItem(25466), 1, 0),
				new ItemStack(Item.getItem(25467), 1, 0),
				new ItemStack(Item.getItem(25468), 1, 0)
			),
			listOf(eilifligronium),1, 4, false
		); questList.add(eilifligroniumtools);

		QuestTemplate eilifligroniumarmor = createRetrievalQuest(
			"eilifligroniumarmor", Item.getItem(25470),
			listOf(
				new ItemStack(Item.getItem(25469), 1, 0),
				new ItemStack(Item.getItem(25470), 1, 0),
				new ItemStack(Item.getItem(25471), 1, 0),
				new ItemStack(Item.getItem(25472), 1, 0)
			),
			listOf(eilifligronium),1, 5, false
		); questList.add(eilifligroniumarmor);

		return questList;
	}
}
