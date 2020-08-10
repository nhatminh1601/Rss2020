package com.example.rss.data;

import com.example.rss.object.News;

import java.util.ArrayList;
import java.util.List;

public class Data {
    ArrayList<News> data;
    ArrayList<News> sub_data1;
    ArrayList<News> sub_data2;
    ArrayList<News> sub_data3;
    public final List<News> LoadData(){
        data = new ArrayList<>();
        sub_data1 = new ArrayList<>();
        sub_data2 = new ArrayList<>();
        sub_data3 = new ArrayList<>();
        // vnExpress
        sub_data1.add(new News(1,"Trang chủ","https://vnexpress.net/rss/tin-moi-nhat.rss",null));
        sub_data1.add(new News(2,"Thế giới","https://vnexpress.net/rss/the-gioi.rss",null));
        sub_data1.add(new News(3,"Thời sự","https://vnexpress.net/rss/thoi-su.rss",null));
        sub_data1.add(new News(4,"Kinh Doanh","https://vnexpress.net/rss/kinh-doanh.rss",null));
        sub_data1.add(new News(5,"Startup","https://vnexpress.net/rss/startup.rss",null));
        sub_data1.add(new News(6,"Giải trí","https://vnexpress.net/rss/giai-tri.rss",null));
        sub_data1.add(new News(7,"Thể thao","https://vnexpress.net/rss/the-thao.rss",null));
        sub_data1.add(new News(8,"Pháp Luật","https://vnexpress.net/rss/phap-luat.rss",null));
        sub_data1.add(new News(9,"Giáo dục","https://vnexpress.net/rss/giao-duc.rss",null));
        sub_data1.add(new News(10,"Tin mới nhất","https://vnexpress.net/rss/tin-moi-nhat.rss",null));
        sub_data1.add(new News(11,"Tin nổi bật","https://vnexpress.net/rss/tin-noi-bat.rss",null));
        sub_data1.add(new News(12,"Sức khỏe","https://vnexpress.net/rss/suc-khoe.rss",null));
        sub_data1.add(new News(13,"Đời sống","https://vnexpress.net/rss/gia-dinh.rss",null));
        sub_data1.add(new News(14,"Du lịch","https://vnexpress.net/rss/du-lich.rss",null));
        sub_data1.add(new News(15,"Khoa học","https://vnexpress.net/rss/khoa-hoc.rss",null));
        sub_data1.add(new News(16,"Số Hóa","https://vnexpress.net/rss/so-hoa.rss",null));
        sub_data1.add(new News(17,"Xe","https://vnexpress.net/rss/oto-xe-may.rss",null));
        sub_data1.add(new News(18,"Ý kiến","https://vnexpress.net/rss/y-kien.rss",null));
        sub_data1.add(new News(19,"Tâm sự","https://vnexpress.net/rss/tam-su.rss",null));
        sub_data1.add(new News(19,"Cười","https://vnexpress.net/rss/cuoi.rss",null));
        sub_data1.add(new News(19,"Tin xem nhiều","https://vnexpress.net/rss/tin-xem-nhieu.rss",null));

        data.add(new News(1,"VNEXPRESS","https://mb.dkn.tv/wp-content/uploads/2015/08/bo-bien-phat-sang-4.jpg",sub_data1));
        data.add(new News(2,"DÂN TRÍ","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcT6_X7wkblCSE6GbfdDx3cjM3Pa7ESGby4sJQ&usqp=CAU",sub_data1));
        data.add(new News(3,"THANH NIÊN","https://www.gocbao.com/wp-content/uploads/2020/04/nhung-hinh-nen-mau-tim-cuc-ki-sinh-dong-cho-powerpoint-1484912706-20-4.jpg",sub_data1));

        return data;
    }
}
