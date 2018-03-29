package cn.com.jerry.androidmvp.model;

import java.util.List;

/**
 * Created by pc on 2018/2/13.
 */

public class NewsEntity {

    /**
     * date : 20180213
     * stories : [{"images":["https://pic4.zhimg.com/v2-4b014f21e851cebcf2068719b6e94e5f.jpg"],"type":0,"id":9668955,"ga_prefix":"021310","title":"为什么很多日漫都给人「格局小」的感觉？"},{"title":"男生有哪些需备的基本款裤子？","ga_prefix":"021309","images":["https://pic1.zhimg.com/v2-879e8e8d76853eae390251ae63b08610.jpg"],"multipic":true,"type":0,"id":9663843},{"images":["https://pic4.zhimg.com/v2-ae8cb2fdbe5a61caffe9a5e177748e83.jpg"],"type":0,"id":9665049,"ga_prefix":"021308","title":"好不容易想好的域名，被别人抢注了怎么办？"},{"images":["https://pic3.zhimg.com/v2-0aba40a6c517218511bfbe75b556b87a.jpg"],"type":0,"id":9664598,"ga_prefix":"021307","title":"同一家公司，管理层的收入怎么会比员工的高那么多？"},{"images":["https://pic3.zhimg.com/v2-51055990cf343680772c1a15a502d9ea.jpg"],"type":0,"id":9670821,"ga_prefix":"021307","title":"《流感下的北京中年》刷屏朋友圈，作为医生我想说\u2026\u2026"},{"images":["https://pic3.zhimg.com/v2-4bd9bf31f90d0abaa56372ad61456eae.jpg"],"type":0,"id":9670235,"ga_prefix":"021307","title":"哪些车在美国买最划算？"},{"images":["https://pic1.zhimg.com/v2-cdf303456b079debafda0531ff488ff4.jpg"],"type":0,"id":9670732,"ga_prefix":"021306","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic3.zhimg.com/v2-6806fd14d60660b0470a42e9d84433a6.jpg","type":0,"id":9670793,"ga_prefix":"021216","title":"今年春节，腾讯的两款「吃鸡」手游和网易要正面对决了"},{"image":"https://pic2.zhimg.com/v2-20bb6292e07d2f434d27864b9b331389.jpg","type":0,"id":9670789,"ga_prefix":"021207","title":"马蓉和王宝强终于离婚了，孩子两人抚养，财产分割没说"},{"image":"https://pic3.zhimg.com/v2-1323685f0f4d5b7bf39704c82e0bf7a2.jpg","type":0,"id":9670235,"ga_prefix":"021307","title":"哪些车在美国买最划算？"},{"image":"https://pic3.zhimg.com/v2-8fcdf1d7bb01df1a715a83aedb70176e.jpg","type":0,"id":9664598,"ga_prefix":"021307","title":"同一家公司，管理层的收入怎么会比员工的高那么多？"},{"image":"https://pic2.zhimg.com/v2-672fd8a5a8faf496cc148bdfdd9b9501.jpg","type":0,"id":9663843,"ga_prefix":"021309","title":"男生有哪些需备的基本款裤子？"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic4.zhimg.com/v2-4b014f21e851cebcf2068719b6e94e5f.jpg"]
         * type : 0
         * id : 9668955
         * ga_prefix : 021310
         * title : 为什么很多日漫都给人「格局小」的感觉？
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic3.zhimg.com/v2-6806fd14d60660b0470a42e9d84433a6.jpg
         * type : 0
         * id : 9670793
         * ga_prefix : 021216
         * title : 今年春节，腾讯的两款「吃鸡」手游和网易要正面对决了
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
