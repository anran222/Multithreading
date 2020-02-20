package Thread;

/**
 * @Author:xiang
 * @Date:2020/2/20 16:31
 */
public class TDownLoader extends Thread {
    private String url;
    private String name;

    public TDownLoader(String url,String name){
        this.url=url;
        this.name=name;
    }
    @Override
    public void run() {
        WebDownLoader wdl=new WebDownLoader();
        wdl.downLader(url,name);
    }

    public static void main(String[] args) {
        TDownLoader td1=new TDownLoader("https://hbimg.huabanimg.com/b665c0945e242d1ecea497dbc74dcb8e9ff80c942147c-9csH1K_fw658","dog.jpg");
        TDownLoader td2=new TDownLoader("https://hbimg.huabanimg.com/baf5ca3d74415633901bbaf543bb75ecbd4be50e1edc1-OZl6Xv_fw658","cat.jpg");
        TDownLoader td3=new TDownLoader("https://hbimg.huabanimg.com/43c97b10e19b191881715cbc636fdc0a8fbac43dcec3-ja4YB9_fw658","pig.jpg");
        td1.start();
        td2.start();
        td3.start();
    }
}
