package Dao;

import POJO.EssayAttachment;
import POJO.Homepage;

import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public interface EssayAttachmentDao {
    public int pesist(EssayAttachment essayAttachment);

    public void delete(int id);

    public void update(EssayAttachment essayAttachment);

    public List<EssayAttachment> findAll();
}
