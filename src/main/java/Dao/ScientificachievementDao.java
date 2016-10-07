package Dao;

import ENUM.Language;
import ENUM.Type;
import POJO.SaAttachment;
import POJO.Scientificachievement;

import java.util.List;
import java.util.Set;

/**
 * Created by mm on 2016/10/3.
 */
public interface ScientificachievementDao {
    public int pesist(Scientificachievement scientificachievement);

    public void delete(int id);

    public void update(Scientificachievement scientificachievement);

    public List<Scientificachievement> findAll();


    public List<Scientificachievement> find(Type type, Language language);

    public Scientificachievement getById(int id);

    public List<Scientificachievement> getBySaTitle(String title);

    public Set<SaAttachment> getSaAttachment(int id);
}
