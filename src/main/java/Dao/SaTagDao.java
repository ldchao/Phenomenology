package Dao;

import POJO.Essay;
import POJO.SaTag;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mm on 2017/5/14.
 */
public interface SaTagDao {
    public List<SaTag> getSaTagsByScientificAchievementId(int scientificAchievementId);

    public void addSaTag_Views(String tagName);

    public List<SaTag> getSaTagsOfTop10();

    public void addRelations(int scientificAchievementId,String tagName);

    public void addRelations(int scientificAchievementId,ArrayList<String> tagNames);

    public void deleteByScientificAchievementIdAndTagName(int scientificAchievementId,String tagName);

    public void deleteByScientificAchievementId(int scientificAchievementId);
}
