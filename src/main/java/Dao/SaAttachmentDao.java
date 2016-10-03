package Dao;

import POJO.SaAttachment;

import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public interface SaAttachmentDao {
    public int pesist(SaAttachment saAttachment);

    public void delete(int id);

    public void update(SaAttachment saAttachment);

    public List<SaAttachment> findAll();
}
