package Dao;

import POJO.EssayTag;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mm on 2017/5/14.
 */
public interface EssayTagDao {
    public List<EssayTag> getEssayTagsByEssayId(int essayId);

    public void AddEssayTag_Views(String tagName);

    public List<EssayTag> getEssayTagsOfTop10();

    public void addRelations(int essayId,String tagName);

    public void addRelations(int essayId, ArrayList<String> tagNames);

    public void deleteByEssayIdAndTagName(int essayId,String tagName);

    //tagNames are the tags that should be maintained
    public void deleteByEssayId(int essayId);
}
