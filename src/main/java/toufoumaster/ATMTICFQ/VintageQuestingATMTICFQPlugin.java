package toufoumaster.ATMTICFQ;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.core.item.IItemConvertible;
import net.minecraft.core.item.ItemStack;
import sunsetsatellite.vintagequesting.VintageQuesting;
import sunsetsatellite.vintagequesting.quest.Quest;
import sunsetsatellite.vintagequesting.quest.template.QuestTemplate;
import sunsetsatellite.vintagequesting.quest.template.RewardTemplate;
import sunsetsatellite.vintagequesting.quest.template.TaskTemplate;
import sunsetsatellite.vintagequesting.quest.template.reward.ItemRewardTemplate;
import sunsetsatellite.vintagequesting.quest.template.task.RetrievalTaskTemplate;
import sunsetsatellite.vintagequesting.util.Logic;
import toufoumaster.ATMTICFQ.chapters.*;

public class VintageQuestingATMTICFQPlugin {

	public static final TheEarlyGameChapter THE_EARLY_GAME_CHAPTER = new TheEarlyGameChapter("theearlygame");
	public static final StardewFarmingChapter STARDEW_FARMING_CHAPTER = new StardewFarmingChapter("stardewfarming");
	public static final StorageChapter STORAGE_CHAPTER = new StorageChapter("storage");
	public static final ComputerCraftChapter COMPUTER_CRAFT_CHAPTER = new ComputerCraftChapter("computercraft");
	public static final TerraponChapter TERRAPON_CHAPTER = new TerraponChapter("terrapon");

	public void initializePlugin() {
		List<QuestTemplate> theEarlyGameQuests = THE_EARLY_GAME_CHAPTER.getToInitQuests();
		List<QuestTemplate> stardewFarmingQuests = STARDEW_FARMING_CHAPTER.getToInitQuests();
		List<QuestTemplate> storageQuests = STORAGE_CHAPTER.getToInitQuests();
		List<QuestTemplate> computerCraftQuests = COMPUTER_CRAFT_CHAPTER.getToInitQuests();
		List<QuestTemplate> terraponQuests = TERRAPON_CHAPTER.getToInitQuests();

		for (QuestTemplate quest : theEarlyGameQuests) {
			THE_EARLY_GAME_CHAPTER.addQuest(quest);
		}
		for (Quest quest : THE_EARLY_GAME_CHAPTER.getQuests()) {
			quest.setupPrerequisites();
		}

		for (QuestTemplate quest : stardewFarmingQuests) {
			STARDEW_FARMING_CHAPTER.addQuest(quest);
		}
		for (Quest quest : STARDEW_FARMING_CHAPTER.getQuests()) {
			quest.setupPrerequisites();
		}

		for (QuestTemplate quest : storageQuests) {
			STORAGE_CHAPTER.addQuest(quest);
		}
		for (Quest quest : STORAGE_CHAPTER.getQuests()) {
			quest.setupPrerequisites();
		}

		for (QuestTemplate quest : computerCraftQuests) {
			COMPUTER_CRAFT_CHAPTER.addQuest(quest);
		}
		for (Quest quest : COMPUTER_CRAFT_CHAPTER.getQuests()) {
			quest.setupPrerequisites();
		}

		for (QuestTemplate quest : terraponQuests) {
			TERRAPON_CHAPTER.addQuest(quest);
		}
		for (Quest quest : TERRAPON_CHAPTER.getQuests()) {
			quest.setupPrerequisites();
		}
	}

	public static QuestTemplate getQuest(String id){
		QuestTemplate item = VintageQuesting.QUESTS.getItem(ATMTICFQ.MOD_ID + ":" + id);
		if(item == null) {
			throw new NullPointerException("Quest " + id + " not found!");
		}
		return item;
	}

	public static QuestTemplate createRetrievalQuest(String questId, IItemConvertible iconItem, List<ItemStack> itemList, List<QuestTemplate> reliesOn, int posX, int posY) {
		return createRetrievalQuest(questId, iconItem, itemList, reliesOn, posX, posY, Logic.AND, Logic.AND, true);
	}

	public static QuestTemplate createRetrievalQuest(String questId, IItemConvertible iconItem, List<ItemStack> itemList, List<QuestTemplate> reliesOn, int posX, int posY, boolean checkMeta) {
		return createRetrievalQuest(questId, iconItem, itemList, reliesOn, posX, posY, Logic.AND, Logic.AND, checkMeta);
	}
	public static QuestTemplate createRetrievalQuest(String questId, IItemConvertible iconItem, List<ItemStack> itemList, List<QuestTemplate> reliesOn, int posX, int posY, Logic questLogic, Logic taskLogic) {
		return createRetrievalQuest(questId, iconItem, itemList, reliesOn, posX, posY, questLogic, taskLogic, true);
	}

	public static QuestTemplate createRetrievalQuest(String questId, IItemConvertible iconItem, List<ItemStack> itemList, List<QuestTemplate> reliesOn, int posX, int posY, Logic questLogic, Logic taskLogic, boolean checkMeta) {
		QuestTemplate quest = new QuestTemplate(ATMTICFQ.MOD_ID+":"+questId,"quest."+ATMTICFQ.MOD_ID+"."+questId, iconItem, questLogic, taskLogic);

		ArrayList<TaskTemplate> retrievalList = new ArrayList<>();
		for (ItemStack itemstack : itemList) {
			String itemKey = itemstack.getItemKey();
			int idx = itemKey.lastIndexOf(".");
			String taskId = itemKey.substring(idx+1);
			retrievalList.add(new RetrievalTaskTemplate(ATMTICFQ.MOD_ID+":"+questId+"/"+taskId, itemstack));
		}

		quest = quest.setTasks(retrievalList);
		quest = quest.setPreRequisites(reliesOn);
		quest = quest.setX(posX);
		quest = quest.setY(posY);
		return quest;
	}

	public static List<RewardTemplate> createItemReward(QuestTemplate quest, List<ItemStack> itemList) {
		ArrayList<RewardTemplate> itemRewardList = new ArrayList<>();
		for (ItemStack itemstack : itemList) {
			String itemKey = itemstack.getItemKey();
			int idx = itemKey.lastIndexOf(".");
			String taskId = itemKey.substring(idx+1);
			itemRewardList.add(new ItemRewardTemplate(quest.getId()+"/"+taskId, itemstack));
		}
		return itemRewardList;
	}


	@SafeVarargs
	public static <T> List<T> listOf(T... values){
		return new ArrayList<>(Arrays.asList(values));
	}
}
