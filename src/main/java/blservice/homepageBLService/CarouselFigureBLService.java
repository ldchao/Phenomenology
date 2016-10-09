package blservice.homepageBLService;

import ENUM.UniversalState;
import vo.PictureVO;

import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/9/29.
 * 轮播图
 */
public interface CarouselFigureBLService {

    //增加一条轮播图存储记录，返回存储的id
    public int addAPicture(PictureVO pictureVO);

    //得到所有轮播图的地址列表
    public ArrayList<PictureVO> getAllPicture();

    //根据id删除一条轮播图存储记录
    public UniversalState deleteAPicture(int id);

    //根据id获取一条轮播图对象
    public PictureVO getPicture(int id);


}
