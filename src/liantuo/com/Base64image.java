package liantuo.com;

import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class Base64image {

    public static void main(String[] args) {
        String imagepath="C:\\Users\\user\\Pictures\\Saved Pictures\\20181031190143.png";
        ImageToBase64(imagepath);

    }


    public static String  ImageToBase64(String imgPath) {
        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        // 返回Base64编码过的字节数组字符串
        String codebase="data:image/jpeg;base64,"+encoder.encode(Objects.requireNonNull(data)).replaceAll("\r|\n","");
//        System.out.println("data:image/jpeg;base64,"+encoder.encode(Objects.requireNonNull(data)).replaceAll("\r|\n",""));
         return codebase;

    }

}
