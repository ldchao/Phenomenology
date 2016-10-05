package bl.situationBL;

import ENUM.UniversalState;
import bl.helper.FileManager;
import blservice.situationBLService.SituationBLService;

/**
 * Created by lvdechao on 2016/10/4.
 */
public class SituationBL implements SituationBLService{

    public UniversalState updateSituation(String html, String uploadUrl,String fileName) {

        FileManager.WriteFile(html,uploadUrl,fileName,false);
        return UniversalState.SUCCEED;
    }

    public String getSituation( String filePath) {
        return FileManager.ReadFile(filePath);
    }
}
