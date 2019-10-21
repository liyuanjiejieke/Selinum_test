package liantuo.com;

import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class A {

    public static void main(String[] args) throws Exception {
// TODO Auto-generated method stub
        URL url=new URL("http://192.168.19.28:8000/login");//取得资源对象
        URLConnection uc=url.openConnection();//生成连接对象
        uc.connect(); //发出连接
        long ld=uc.getDate(); //取得网站日期时间
        Date date=new Date(ld); //转换为标准时间对象
        //分别取得时间中的小时，分钟和秒，并输出
        System.out.print(date.getHours()+"时"+date.getMinutes()+"分"+date.getSeconds()+"秒");
    }



}
