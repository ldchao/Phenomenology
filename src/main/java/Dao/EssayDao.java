package Dao;

import ENUM.Language;
import ENUM.Type;
import POJO.Essay;
import POJO.EssayAttachment;

import java.util.List;
import java.util.Set;

/**
 * Created by mm on 2016/10/3.
 */
public interface EssayDao {
    public int pesist(Essay essay);

    public void delete(int id);

    public void update(Essay essay);

    public List<Essay> findAll();

    public List<Essay> findTop5(Type type, Language language);

    public List<Essay> find(Type type,Language language);

    public Essay getById(int id);


    public List<Essay> getByEssayTitle(String title);

    public Set<EssayAttachment> getByEssayAttachment(int id);

    public List<Essay> getEssaysByEssayTag(String tagName);


}
