package liantuo.com;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;

public class Excel_util {
    public static void main(String[] args) {
        writeExcel();
    }
    public static void writeExcel() {
        String[] titleA = {"会员卡号", "会员等级","姓名","昵称","头像","性别","手机号","电话","Email","身份证号","出生日期","省","市","初始积分","累计积分","领卡时间","最后一次消费时间","所属店铺名称",
        "微信用户标示","支付宝用户标示","会员实充余额","会员赠送余额"};
        //创建Excel文件
        File fileA = new File("D:/TestFile17.xls");
        if (fileA.exists()){
            fileA.delete();
        }
        try {
            fileA.createNewFile();
            //创建工作簿
            WritableWorkbook workbook= Workbook.createWorkbook(fileA);
            //创建shell
            WritableSheet sheetA=workbook.createSheet("sheet1",0);
            Label labelA=null;
            for (int i=0;i<titleA.length;i++){
                    labelA=new Label(i,0,titleA[i]);
                    sheetA.addCell(labelA);
            }
            //获取数据源
            for (int i=1;i<=50000;i++){
                    labelA = new Label(0,i,"20190716000000" + i);
                    sheetA.addCell(labelA);
                    labelA = new Label(2,i,"悟空"+i);
                    sheetA.addCell(labelA);
                    labelA = new Label(5,i,"男");
                    sheetA.addCell(labelA);
                    int i1 = (int) ((Math.random() * 9 + 1) * 1000);
                    int i2 = (int) ((Math.random() * 9 + 1) * 100000);
                    String as1=String.valueOf(i1);
                    String as2=String.valueOf(i2);
                    labelA = new Label(6,i,"1"+as1+as2);
                    sheetA.addCell(labelA);
                    labelA = new Label(8,i,"6666666"+i+"@qq.com");
                    sheetA.addCell(labelA);

                labelA = new Label(17,i,"分账测试账号D");
                sheetA.addCell(labelA);
                }
                //开始写入数据
                workbook.write();
                //关闭连接
                workbook.close();
            }

         catch (Exception e) {
            e.printStackTrace();
        }


    }





}
