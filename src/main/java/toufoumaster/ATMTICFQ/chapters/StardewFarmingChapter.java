package toufoumaster.ATMTICFQ.chapters;

import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
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

import static toufoumaster.ATMTICFQ.VintageQuestingATMTICFQPlugin.*;

public class StardewFarmingChapter extends QuestChapterPage {

		public StardewFarmingChapter(String id) {
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
			return getTextureFromBlock(Blocks.getBlock(6037));
		}

		@Override
		public void postProcessBackground(ScreenQuestbook screenQuestbook, Random random, ScreenQuestbook.BGLayer bgLayer, int i, int i1) {

		}

		@Override
		public @NotNull ItemStack getIcon() {
			return Blocks.getBlock(6031).getDefaultStack();
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
			return getQuest(VintageQuestingATMTICFQPlugin.getQuest("fishingrod"));
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
			// Fishing Quests
			QuestTemplate fishingrod = createRetrievalQuest(
				"fishingrod",
				Items.TOOL_FISHINGROD,
				listOf(
					new ItemStack(Items.TOOL_FISHINGROD, 1),
					new ItemStack(22044, 1, 0),
					new ItemStack(22045, 1, 0),
					new ItemStack(22046, 1, 0),
					new ItemStack(22047, 1, 0),
					new ItemStack(22048, 1, 0)
				),
				listOf(),
				0, 0,
				Logic.OR, Logic.OR,
				false
			);
			fishingrod.setRewards(createItemReward(fishingrod, listOf(new ItemStack(22049, 8, 0))));
			questList.add(fishingrod);

			QuestTemplate baitcan = createRetrievalQuest(
				"baitcan",
				Item.getItem(22050),
				listOf(
					new ItemStack(22050, 1, 0)
				),
				listOf(fishingrod),
				-2, 0
			);
			questList.add(baitcan);

			QuestTemplate rawsnapper = createRetrievalQuest(
				"rawsnapper",
				Item.getItem(22038),
				listOf(
					new ItemStack(22038, 1, 0)
				),
				listOf(fishingrod),
				3, -1
			);
			rawsnapper.setRewards(createItemReward(rawsnapper, listOf(new ItemStack(22038, 2, 0))));
			questList.add(rawsnapper);

			QuestTemplate rawbass = createRetrievalQuest(
				"rawbass",
				Item.getItem(22036),
				listOf(
					new ItemStack(22036, 1, 0)
				),
				listOf(fishingrod),
				3, 0
			);
			rawbass.setRewards(createItemReward(rawbass, listOf(new ItemStack(22036, 2, 0))));
			questList.add(rawbass);

			QuestTemplate rawsalmon = createRetrievalQuest(
				"rawsalmon",
				Item.getItem(22034),
				listOf(
					new ItemStack(22034, 1, 0)
				),
				listOf(fishingrod),
				3, 1
			);
			rawsalmon.setRewards(createItemReward(rawsalmon, listOf(new ItemStack(22034, 2, 0))));
			questList.add(rawsalmon);

			QuestTemplate cookedsnapper = createRetrievalQuest(
				"cookedsnapper",
				Item.getItem(22039),
				listOf(
					new ItemStack(22039, 1, 0)
				),
				listOf(rawsnapper),
				4, -1
			);
			questList.add(cookedsnapper);

			QuestTemplate cookedbass = createRetrievalQuest(
				"cookedbass",
				Item.getItem(22037),
				listOf(
					new ItemStack(22037, 1, 0)
				),
				listOf(rawbass),
				4, 0
			);
			questList.add(cookedbass);

			QuestTemplate cookedsalmon = createRetrievalQuest(
				"cookedsalmon",
				Item.getItem(22035),
				listOf(
					new ItemStack(22035, 1, 0)
				),
				listOf(rawsalmon),
				4, 1
			);
			questList.add(cookedsalmon);

			QuestTemplate legendary1 = createRetrievalQuest(
				"legendary1",
				Item.getItem(22040),
				listOf(
					new ItemStack(22040, 1, 0)
				),
				listOf(fishingrod),
				-2, -3
			);
			legendary1.setRewards(createItemReward(legendary1, listOf(new ItemStack(25400, 1, 0))));
			questList.add(legendary1);

			QuestTemplate legendary2 = createRetrievalQuest(
				"legendary2",
				Item.getItem(22041),
				listOf(
					new ItemStack(22041, 1, 0)
				),
				listOf(fishingrod),
				-1, -3
			);
			legendary2.setRewards(createItemReward(legendary2, listOf(new ItemStack(25400, 1, 0))));
			questList.add(legendary2);

			QuestTemplate legendary3 = createRetrievalQuest(
				"legendary3",
				Item.getItem(22042),
				listOf(
					new ItemStack(22042, 1, 0)
				),
				listOf(fishingrod),
				0, -3
			);
			legendary3.setRewards(createItemReward(legendary3, listOf(new ItemStack(25400, 1, 0))));
			questList.add(legendary3);

			QuestTemplate legendary4 = createRetrievalQuest(
				"legendary4",
				Item.getItem(22043),
				listOf(
					new ItemStack(22043, 1, 0)
				),
				listOf(fishingrod),
				1, -3
			);
			legendary4.setRewards(createItemReward(legendary4, listOf(new ItemStack(25400, 1, 0))));
			questList.add(legendary4);

			QuestTemplate pinkrecord = createRetrievalQuest(
				"pinkrecord",
				Item.getItem(21990),
				listOf(
					new ItemStack(21990, 1, 0)
				),
				listOf(legendary1, legendary2, legendary3, legendary4),
				2, -3
			);
			pinkrecord.setRewards(createItemReward(pinkrecord, listOf(new ItemStack(6015, 1, 0), new ItemStack(22051, 1, 0))));
			questList.add(pinkrecord);

			// Farming Quests

			QuestTemplate beehive = createRetrievalQuest(
				"beehive",
				Item.getItem(6031),
				listOf(
					new ItemStack(6031, 1, 0)
				),
				listOf(),
				10, -3
			);
			questList.add(beehive);

			QuestTemplate honey = createRetrievalQuest(
				"honey",
				Item.getItem(22022),
				listOf(
					new ItemStack(22022, 1, 0)
				),
				listOf(beehive),
				12, -3
			);
			questList.add(honey);

			QuestTemplate honeyblock = createRetrievalQuest(
				"honeyblock",
				Item.getItem(6026),
				listOf(
					new ItemStack(6026, 1, 0)
				),
				listOf(honey),
				14, -3
			);
			questList.add(honeyblock);

			QuestTemplate wateringcan = createRetrievalQuest(
				"wateringcan",
				Item.getItem(22030),
				listOf(
					new ItemStack(22030, 1, 0),
					new ItemStack(22031, 1, 0)
				),
				listOf(),
				9, 0,
				Logic.AND, Logic.OR,
				false
			);
			wateringcan.setRewards(createItemReward(wateringcan, listOf(new ItemStack(Items.SEEDS_WHEAT, 8))));
			questList.add(wateringcan);

			// Plants

			QuestTemplate carrot = createRetrievalQuest(
				"carrot",
				Item.getItem(22001),
				listOf(
					new ItemStack(22001, 1, 0)
				),
				listOf(),
				10, -1
			);
			carrot.setRewards(createItemReward(
				carrot, listOf(new ItemStack(22000, 4, 0))
			));
			questList.add(carrot);

			QuestTemplate blueberry = createRetrievalQuest(
				"blueberry",
				Item.getItem(22003),
				listOf(
					new ItemStack(22003, 1, 0)
				),
				listOf(),
				12, -1
			);
			blueberry.setRewards(createItemReward(
				blueberry, listOf(new ItemStack(22002, 4, 0))
			));
			questList.add(blueberry);

			QuestTemplate pineapple = createRetrievalQuest(
				"pineapple",
				Item.getItem(22005),
				listOf(
					new ItemStack(22005, 1, 0)
				),
				listOf(),
				14, -1
			);
			pineapple.setRewards(createItemReward(
				pineapple, listOf(new ItemStack(22004, 4, 0))
			));
			questList.add(pineapple);

			QuestTemplate tomato = createRetrievalQuest(
				"tomato",
				Item.getItem(22007),
				listOf(
					new ItemStack(22007, 1, 0)
				),
				listOf(),
				16, -1
			);
			tomato.setRewards(createItemReward(
				tomato, listOf(new ItemStack(22006, 4, 0))
			));
			questList.add(tomato);

			QuestTemplate potato = createRetrievalQuest(
				"potato",
				Item.getItem(22009),
				listOf(
					new ItemStack(22009, 1, 0)
				),
				listOf(),
				10, 1
			);
			potato.setRewards(createItemReward(
				potato, listOf(new ItemStack(22008, 4, 0))
			));
			questList.add(potato);

			QuestTemplate strawberry = createRetrievalQuest(
				"strawberry",
				Item.getItem(22011),
				listOf(
					new ItemStack(22011, 1, 0)
				),
				listOf(),
				12, 1
			);
			strawberry.setRewards(createItemReward(
				strawberry, listOf(new ItemStack(22010, 4, 0))
			));
			questList.add(strawberry);

			QuestTemplate watermelon = createRetrievalQuest(
				"watermelon",
				Item.getItem(6007),
				listOf(
					new ItemStack(6007, 1, 0)
				),
				listOf(),
				14, 1
			);
			watermelon.setRewards(createItemReward(
				watermelon, listOf(new ItemStack(22012, 4, 0))
			));
			questList.add(watermelon);

			QuestTemplate corn = createRetrievalQuest(
				"corn",
				Item.getItem(22014),
				listOf(
					new ItemStack(22014, 1, 0)
				),
				listOf(),
				16, 1
			);
			corn.setRewards(createItemReward(
				corn, listOf(new ItemStack(22013, 4, 0))
			));
			questList.add(corn);

			QuestTemplate wax = createRetrievalQuest(
				"wax",
				Item.getItem(22032),
				listOf(
					new ItemStack(22032, 1, 0)
				),
				listOf(honey, corn),
				16, -3
			);
			questList.add(wax);

			QuestTemplate grape = createRetrievalQuest(
				"grape",
				Item.getItem(22016),
				listOf(
					new ItemStack(22016, 1, 0)
				),
				listOf(),
				10, 3
			);
			grape.setRewards(createItemReward(
				grape, listOf(new ItemStack(22015, 4, 0))
			));
			questList.add(grape);

			QuestTemplate cauliflower = createRetrievalQuest(
				"cauliflower",
				Item.getItem(6021),
				listOf(
					new ItemStack(6021, 1, 0)
				),
				listOf(),
				12, 3
			);
			cauliflower.setRewards(createItemReward(
				cauliflower, listOf(new ItemStack(22017, 4, 0))
			));
			questList.add(cauliflower);

			QuestTemplate cranberry = createRetrievalQuest(
				"cranberry",
				Item.getItem(22019),
				listOf(
					new ItemStack(22019, 1, 0)
				),
				listOf(),
				14, 3
			);
			cranberry.setRewards(createItemReward(
				cranberry, listOf(new ItemStack(22018, 4, 0))
			));
			questList.add(cranberry);

			QuestTemplate wheat = createRetrievalQuest(
				"wheat",
				Items.WHEAT,
				listOf(
					new ItemStack(Items.WHEAT, 1)
				),
				listOf(),
				16, 3
			);
			wheat.setRewards(createItemReward(
				wheat, listOf(new ItemStack(Items.SEEDS_WHEAT, 4))
			));
			questList.add(wheat);

			// Cooking Quests

			QuestTemplate dough = createRetrievalQuest(
				"dough",
				Item.getItem(22020),
				listOf(
					new ItemStack(22020, 1, 0)
				),
				listOf(),
				20, -3
			);
			questList.add(dough);

			QuestTemplate rawmilk = createRetrievalQuest(
				"rawmilk",
				Items.BUCKET_MILK,
				listOf(
					new ItemStack(Items.BUCKET_MILK, 1)
				),
				listOf(),
				20, -1
			);
			questList.add(rawmilk);

			QuestTemplate cheese = createRetrievalQuest(
				"cheese",
				Item.getItem(22024),
				listOf(
					new ItemStack(22024, 1, 0)
				),
				listOf(rawmilk),
				20, 1
			);
			questList.add(cheese);

			QuestTemplate pizza = createRetrievalQuest(
				"pizza",
				Item.getItem(22033),
				listOf(
					new ItemStack(22033, 1, 0)
				),
				listOf(cheese, dough, tomato),
				20, 3
			);
			questList.add(pizza);

			QuestTemplate bowl = createRetrievalQuest(
				"bowl",
				Items.BOWL,
				listOf(
					new ItemStack(Items.BOWL, 1, 0)
				),
				listOf(),
				22, -5
			);
			questList.add(bowl);

			QuestTemplate vegetablestew = createRetrievalQuest(
				"vegetablestew",
				Item.getItem(22025),
				listOf(
					new ItemStack(22025, 1, 0)
				),
				listOf(carrot, potato, bowl),
				22, -3
			);

			QuestTemplate mushroomstew = createRetrievalQuest(
				"mushroomstew",
				Items.FOOD_STEW_MUSHROOM,
				listOf(
					new ItemStack(Items.FOOD_STEW_MUSHROOM, 1, 0)
				),
				listOf(rawmilk, bowl),
				22, -1
			);
			questList.add(mushroomstew);

			QuestTemplate pumpkinstew = createRetrievalQuest(
				"pumpkinstew",
				Item.getItem(21010),
				listOf(
					new ItemStack(21010, 1, 0)
				),
				listOf(bowl),
				22, 1
			);
			questList.add(pumpkinstew);

			QuestTemplate cauliflowerstew = createRetrievalQuest(
				"cauliflowerstew",
				Item.getItem(22026),
				listOf(
					new ItemStack(22026, 1, 0)
				),
				listOf(cauliflower, cheese, bowl),
				22, 3
			);
			questList.add(cauliflowerstew);

			QuestTemplate egg = createRetrievalQuest(
				"egg",
				Item.getItem(21993),
				listOf(
					new ItemStack(21993, 1, 0),
					new ItemStack(Items.EGG_CHICKEN, 1, 0)
				),
				listOf(),
				24, -1,
				Logic.AND, Logic.OR,
				true
			);
			questList.add(egg);

			QuestTemplate chocolatecake = createRetrievalQuest(
				"chocolatecake",
				Item.getItem(22028),
				listOf(
					new ItemStack(22028, 1, 0)
				),
				listOf(rawmilk, dough, egg),
				24, -3
			);
			questList.add(chocolatecake);

			QuestTemplate jamjar = createRetrievalQuest(
				"jamjar",
				Item.getItem(22023),
				listOf(
					new ItemStack(22023, 1, 0)
				),
				listOf(strawberry, watermelon, pineapple, blueberry, cranberry),
				24, 1,
				Logic.OR, Logic.AND,
				true
			);
			questList.add(jamjar);

			QuestTemplate coffee = createRetrievalQuest(
				"coffee",
				Item.getItem(21992),
				listOf(
					new ItemStack(21992, 1, 0)
				),
				listOf(rawmilk),
				24, 3
			);
			questList.add(coffee);

			QuestTemplate fruitsalad = createRetrievalQuest(
				"fruitsalad",
				Item.getItem(22027),
				listOf(
					new ItemStack(22027, 1, 0)
				),
				listOf(grape, blueberry, pineapple, watermelon, strawberry),
				22, 5
			);
			questList.add(fruitsalad);

			return questList;
		}
}
