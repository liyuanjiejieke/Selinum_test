package liantuo.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class TestA {

    public static WebDriver driver;
    public static void main(String[] args) throws Exception{
        server_one();//启动chromedriver服务,打开指定网站，登陆该网站
        Business_houtai_jiance(); //检测商户后台所有二级菜单显示是否正常
        System.setProperty("webdriver.chrome.driver","D:\\soft\\chromdriver\\chromedriver.exe");//chromedriver服务地址
        WebDriver driver =new ChromeDriver(); //新建一个WebDriver 的对象
        driver.get("http://192.168.19.28:8000/login");//打开指定的网站
        driver.manage().window().maximize(); //窗口最大化
    }



    public static void server_one(){
        System.setProperty("webdriver.chrome.driver","D:\\soft\\chromdriver\\chromedriver.exe");//chromedriver服务地址
        driver =new ChromeDriver(); //新建一个WebDriver 的对象
        driver.get("http://192.168.19.28:8000/login");//打开指定的网站
        driver.manage().window().maximize(); //窗口最大化


        //输入用户名密码，点击登录
        WebElement uname=driver.findElement(By.name("userName"));
        WebElement pwd=driver.findElement(By.name("passWord"));
        WebElement login=driver.findElement(By.className("login-btn"));
        uname.sendKeys("SHkeshangcs");
        uname.click();
        pwd.sendKeys("111qqq");
        pwd.click();
        login.click();
    }

    public static void Business_houtai_jiance() throws Exception{
//概览统计页面检测
        Thread.sleep(1000);
        driver.switchTo().frame("mainBox");
        Thread.sleep(1000);
        boolean result =verifyElementIsPresent("fc-index-consume-total", "classname");
        System.out.println("概览统计页面：" + result);
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        Thread.sleep(3000);

        //点击订单管理
        Click_Spinner("//*[@id=\"sidebar-menu\"]/ul/li[2]/a");
        //调用方法，检测每个界面
        Detection_element("快速收款","//*[@id=\"sidebar-menu\"]/ul/li[2]/ul/li[1]/a","/html/body/div/div[1]/div/ol/li[2]");
        Detection_element("收银流水","//*[@id=\"sidebar-menu\"]/ul/li[2]/ul/li[2]/a","/html/body/div/div[1]/div/ol/li[2]");
        Detection_element("充值流水","//*[@id=\"sidebar-menu\"]/ul/li[2]/ul/li[3]/a","/html/body/div/div[1]/div/ol/li[2]");
        Detection_element("押金流水","//*[@id=\"sidebar-menu\"]/ul/li[2]/ul/li[4]/a","/html/body/div/div[1]/div/ol/li[2]");
        Detection_element("订单评价","//*[@id=\"sidebar-menu\"]/ul/li[2]/ul/li[5]/a","/html/body/div/div[1]/div/ol/li[2]");

        //点击数据报表
        Click_Spinner("//*[@id=\"sidebar-menu\"]/ul/li[3]/a");
        Detection_element("营业报表","//*[@id=\"sidebar-menu\"]/ul/li[3]/ul/li[1]/a","/html/body/div/div[1]/div/ol/li[2]");
        Detection_element("财务报表","//*[@id=\"sidebar-menu\"]/ul/li[3]/ul/li[2]/a","/html/body/div/div[1]/div/ol/li[2]");
        Detection_element("会员报表","//*[@id=\"sidebar-menu\"]/ul/li[3]/ul/li[3]/a","/html/body/div/div[1]/div/ol/li[2]");
        Detection_element("优惠报表","//*[@id=\"sidebar-menu\"]/ul/li[3]/ul/li[4]/a","/html/body/div/div[1]/div/ol/li[2]");
        Detection_element("交班报表","//*[@id=\"sidebar-menu\"]/ul/li[3]/ul/li[5]/a","/html/body/div/div[1]/div/ol/li[2]");
        Detection_element("评价报表","//*[@id=\"sidebar-menu\"]/ul/li[3]/ul/li[6]/a","/html/body/div/div[1]/div/ol/li[2]");

        //点击商城管理
        Click_Spinner("//*[@id=\"sidebar-menu\"]/ul/li[4]/a");
        Detection_element("商品分类","//*[@id=\"sidebar-menu\"]/ul/li[4]/ul/li[1]/a","//*[@id=\"app\"]/section/section/main/div/div[1]/span[2]/span[1]");
        Detection_element("商品列表","//*[@id=\"sidebar-menu\"]/ul/li[4]/ul/li[2]/a","//*[@id=\"app\"]/section/section/main/div/div[1]/span[2]/span[1]");
        Detection_element("门店设置","//*[@id=\"sidebar-menu\"]/ul/li[4]/ul/li[3]/a","//*[@id=\"app\"]/section/section/main/div/div[1]/span[2]/span[1]");
        Detection_element("配送订单","//*[@id=\"sidebar-menu\"]/ul/li[4]/ul/li[4]/a","//*[@id=\"app\"]/section/section/main/div/div[1]/span[2]/span[1]");
        Detection_element("配送设置","//*[@id=\"sidebar-menu\"]/ul/li[4]/ul/li[5]/a","//*[@id=\"app\"]/section/section/main/div/div[1]/span[2]/span[1]");

        //点击扫码点餐
        Click_Spinner("//*[@id=\"sidebar-menu\"]/ul/li[5]/a");
        Detection_element("门店设置","//*[@id=\"sidebar-menu\"]/ul/li[5]/ul/li[1]/a","/html/body/div[1]/div[1]/div/ol/li[2]");
        Detection_element("点餐订单","//*[@id=\"sidebar-menu\"]/ul/li[5]/ul/li[2]/a","/html/body/div[1]/div[1]/div/ol/li[2]");
        Detection_element("菜品管理","//*[@id=\"sidebar-menu\"]/ul/li[5]/ul/li[3]/a","/html/body/div[1]/div[1]/div/ol/li[2]");
        Detection_element("菜品报表","//*[@id=\"sidebar-menu\"]/ul/li[5]/ul/li[4]/a","/html/body/div[1]/div[1]/div/ol/li[2]");
        Detection_element("桌台管理","//*[@id=\"sidebar-menu\"]/ul/li[5]/ul/li[5]/a","/html/body/div[1]/div[1]/div/ol/li[2]");
        Detection_element("打印管理","//*[@id=\"sidebar-menu\"]/ul/li[5]/ul/li[6]/a","/html/body/div[1]/div[1]/div/ol/li[2]");


        //点击门店管理
        Click_Spinner("//*[@id=\"sidebar-menu\"]/ul/li[6]/a");
        Detection_element("门店列表","//*[@id=\"sidebar-menu\"]/ul/li[6]/ul/li[1]/a","/html/body/div[1]/div[1]/div/ol/li[2]");
        Detection_element("门店分组","//*[@id=\"sidebar-menu\"]/ul/li[6]/ul/li[2]/a","/html/body/div[1]/div[1]/div/ol/li[2]");

        //员工列表
        Click_Spinner("//*[@id=\"sidebar-menu\"]/ul/li[7]/a");
        Detection_element("门店列表","//*[@id=\"sidebar-menu\"]/ul/li[7]/ul/li[1]/a","/html/body/div[1]/div[1]/div/ol/li[2]");
        Detection_element("门店分组","//*[@id=\"sidebar-menu\"]/ul/li[7]/ul/li[2]/a","/html/body/div[1]/div[1]/div/ol/li[2]");


        //会员管理
        Click_Spinner("//*[@id=\"sidebar-menu\"]/ul/li[8]/a");
        Detection_element("会员列表","//*[@id=\"sidebar-menu\"]/ul/li[8]/ul/li[1]/a","/html/body/div[1]/div[1]/div/ol/li[2]");
        Detection_element("会员等级","//*[@id=\"sidebar-menu\"]/ul/li[8]/ul/li[2]/a","/html/body/div[1]/div[1]/div/ol/li[2]");
        Detection_element("会员分层","//*[@id=\"sidebar-menu\"]/ul/li[8]/ul/li[3]/a","/html/body/div[1]/div[1]/div/ol/li[2]");
        Detection_element("会员画像","//*[@id=\"sidebar-menu\"]/ul/li[8]/ul/li[4]/a","/html/body/div[1]/div[1]/div/ol/li[2]");
        Detection_element("会员分析","//*[@id=\"sidebar-menu\"]/ul/li[8]/ul/li[5]/a","/html/body/div[1]/div[1]/div/ol/li[2]");
        Detection_element("会员分布","//*[@id=\"sidebar-menu\"]/ul/li[8]/ul/li[6]/a","/html/body/div[1]/div[1]/div/ol/li[2]");

        //资金管理
        Click_Spinner("//*[@id=\"sidebar-menu\"]/ul/li[9]/a");
        Detection_element("客商提现","//*[@id=\"sidebar-menu\"]/ul/li[9]/ul/li/a","/html/body/div/div[1]/div/ol/li[2]");


        //系统设置             //*[@id="sidebar-menu"]/ul/li[9]/a
        Click_Spinner("//*[@id=\"sidebar-menu\"]/ul/li[10]/a");
        Detection_element("商户设置","//*[@id=\"sidebar-menu\"]/ul/li[10]/ul/li[1]/a","//*[@id=\"wrap\"]/h2");
        Detection_element("接口配置","//*[@id=\"sidebar-menu\"]/ul/li[10]/ul/li[2]/a","/html/body/div/div[1]/div/ol/li[2]");
        Detection_element("公众号设置","//*[@id=\"sidebar-menu\"]/ul/li[10]/ul/li[3]/a","/html/body/div/div[1]/div/ol/li[2]");
        Detection_element("支付小程序","//*[@id=\"sidebar-menu\"]/ul/li[10]/ul/li[4]/a","/html/body/div/div[1]/div/ol/li[2]");
        Detection_element("外卖小程序","//*[@id=\"sidebar-menu\"]/ul/li[10]/ul/li[5]/a","/html/body/div/div[1]/div/ol/li[2]");
        Detection_element("商城小程序","//*[@id=\"sidebar-menu\"]/ul/li[10]/ul/li[6]/a","/html/body/div/div[1]/div/ol/li[2]");

        //营销中心
        Click_Spinner("//*[@id=\"sidebar-menu\"]/ul/li[12]/a");
        Detection_element("会员营销","//*[@id=\"sidebar-menu\"]/ul/li[12]/ul/li[1]/a","//*[@id=\"sub_title\"]");
        Detection_element("拓客营销","//*[@id=\"sidebar-menu\"]/ul/li[12]/ul/li[2]/a","/html/body/div[1]/div[1]/div/ol/li[2]");
        Detection_element("口碑营销","//*[@id=\"sidebar-menu\"]/ul/li[12]/ul/li[3]/a","//*[@id=\"error_text\"]");
        Detection_element("活动营销","//*[@id=\"sidebar-menu\"]/ul/li[12]/ul/li[4]/a","//*[@id=\"activityForm\"]/section[1]/div/div/div/button[2]");
        Detection_element("短信营销","//*[@id=\"sidebar-menu\"]/ul/li[12]/ul/li[5]/a","/html/body/div[1]/div/div/div/div/div[1]/div[2]/a");
        Detection_element("互动营销","//*[@id=\"sidebar-menu\"]/ul/li[12]/ul/li[6]/a","//*[@id=\"createInteractive\"]/span");
//        Detection_element("红包营销","//*[@id=\"sidebar-menu\"]/ul/li[12]/ul/li[7]/a","//*[@id=\"createRedpack\"]");
        Detection_element("营销小程序","//*[@id=\"sidebar-menu\"]/ul/li[12]/ul/li[8]/a","/html/body/div/div[1]/div/ol/li[2]");


        //营销礼包
        Click_Spinner("//*[@id=\"sidebar-menu\"]/ul/li[13]/a");
        Detection_element("礼包管理","//*[@id=\"sidebar-menu\"]/ul/li[13]/ul/li[1]/a","/html/body/div[1]/div[1]/div/ol/li[2]");
        Detection_element("礼包报表","//*[@id=\"sidebar-menu\"]/ul/li[13]/ul/li[2]/a","/html/body/div/div[1]/div/ol/li[2]");
        Detection_element("礼包二维码","//*[@id=\"sidebar-menu\"]/ul/li[13]/ul/li[3]/a","/html/body/div[1]/div[1]/div/ol/li[2]");


        //会员卡管理
        Click_Spinner("//*[@id=\"sidebar-menu\"]/ul/li[14]/a");
        Detection_element("会员卡设置","//*[@id=\"sidebar-menu\"]/ul/li[14]/ul/li[1]/a","/html/body/div/div/div/ol/li[2]");
        Detection_element("微信会员卡","//*[@id=\"sidebar-menu\"]/ul/li[14]/ul/li[2]/a","/html/body/div/div[1]/div/ol/li[2]");
        Detection_element("支付宝会员卡","//*[@id=\"sidebar-menu\"]/ul/li[14]/ul/li[3]/a","//*[@id=\"error_text\"]");

        //优惠券管理
        Click_Spinner("//*[@id=\"sidebar-menu\"]/ul/li[15]/a");
        Detection_element("优惠券列表","//*[@id=\"sidebar-menu\"]/ul/li[15]/ul/li[1]/a","/html/body/div[1]/div[1]/div/ol/li[2]");
        Detection_element("优惠券海报","//*[@id=\"sidebar-menu\"]/ul/li[15]/ul/li[2]/a","/html/body/div[1]/div[1]/div/ol/li[2]");
        Detection_element("优惠券商品","//*[@id=\"sidebar-menu\"]/ul/li[15]/ul/li[3]/a","/html/body/div[1]/div[1]/div/ol/li[2]");
        Detection_element("兑换券验证","//*[@id=\"sidebar-menu\"]/ul/li[15]/ul/li[4]/a","/html/body/div/div[1]/div/ol/li[2]");


        //计次卡管理
        Click_Spinner("//*[@id=\"sidebar-menu\"]/ul/li[16]/a");
        Detection_element("计次卡列表","//*[@id=\"sidebar-menu\"]/ul/li[16]/ul/li[1]/a","/html/body/div[1]/div[1]/div/ol/li[2]");
        Detection_element("计次卡报表","//*[@id=\"sidebar-menu\"]/ul/li[16]/ul/li[2]/a","/html/body/div[1]/div[1]/div/ol/li[2]");
        Detection_element("计次卡核销","//*[@id=\"sidebar-menu\"]/ul/li[16]/ul/li[3]/a","/html/body/div[1]/div[1]/div/ol/li[2]");

    }


    public static void Detection_element(String strA,String str,String elementxpath) throws Exception {

        driver.switchTo().defaultContent();//从frame中切回主文档
        Thread.sleep(5000);
        WebElement A2=driver.findElement(By.xpath(str));
        A2.click();
        driver.switchTo().frame("mainBox");
        //检查页面元素
        Thread.sleep(9000);
        boolean shouyinliushui =verifyElementIsPresent(elementxpath, "xpath");
        System.out.println(strA+"--------------"+ shouyinliushui);
    }


    public static void Click_Spinner(String xpath) throws Exception{
        driver.switchTo().defaultContent();
        WebElement ss=driver.findElement(By.xpath(xpath));
        ss.click();
        Thread.sleep(5000);
    }


    public static boolean verifyElementIsPresent(String locator, String type) {
        type = type.toLowerCase();
        List<WebElement> els = getElementsList(locator, type);
        if (!els.isEmpty()) {
            System.out.println("页面元素存在");
            return true;
        } else {
            System.out.println("页面元素不存在");
            return false;
        }

    }



    public static List<WebElement> getElementsList(String locator, String type) {
        // 传入查找元素的方法，转为小写，if条件判断通过什么方法查找元素
        type = type.toLowerCase();
        // 使用集合框架，list接收多个元素，最后进行封装
        List<WebElement> element = new ArrayList<WebElement>();
        if (type.equals("id")) {
            element = driver.findElements(By.id(locator));
        } else if (type.equals("name")) {
            element = driver.findElements(By.name(locator));
        } else if (type.equals("xpath")) {
            element = driver.findElements(By.xpath(locator));
        } else if (type.equals("css")) {
            element = driver.findElements(By.cssSelector(locator));
        } else if (type.equals("classname")) {
            element = driver.findElements(By.className(locator));
        } else if (type.equals("tagname")) {
            element = driver.findElements(By.tagName(locator));
        } else if (type.equals("linktext")) {
            element = driver.findElements(By.linkText(locator));
        } else if (type.equals("partiallinktext")) {
            element = driver.findElements(By.partialLinkText(locator));
        } else {
            System.out.println("方法不存在！");
            return null;
        }
        return element;

    }

}
