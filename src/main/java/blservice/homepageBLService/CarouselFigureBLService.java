package blservice.homepageBLService;

import ENUM.UniversalState;

import java.util.ArrayList;

/**
 * Created by lvdechao on 2016/9/29.
 * 轮播图
 */
public interface CarouselFigureBLService {

    //增加一条轮播图存储记录，返回存储的id
    public String addAPicture(String location);

    //得到所有轮播图的地址列表
    public ArrayList<String> getAllPicture();

    //根据id删除一条轮播图存储记录
    public UniversalState deleteAPicture(int id);


}
