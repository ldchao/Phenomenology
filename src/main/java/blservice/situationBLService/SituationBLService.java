package blservice.situationBLService;

import ENUM.UniversalState;

/**
 * Created by lvdechao on 2016/9/30.
 */
public interface SituationBLService {

    //更新本所概况的内容（若没有则创建）
    public UniversalState updateSituation(String html,String uploadUrl,String fileName);

    //获取本所概况的内容
    public String getSituation(String filePath);

}
