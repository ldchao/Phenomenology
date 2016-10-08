package Dao;

import ENUM.Language;
import ENUM.Type;
import POJO.Essay;
import POJO.HomepageEssay;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public interface HomepageEssayDao {
    public int pesist(HomepageEssay homepageEssay);

    public void delete(int id);

    public void update(HomepageEssay homepageEssay);

    public List<HomepageEssay> findAll(int i);

    public HomepageEssay getById(int id);

    public void rank(ArrayList<Integer> sequence);

    public List<Essay> findTop5(Type type, Language language);

    public List<Essay> find(Type type, Language language);
}
