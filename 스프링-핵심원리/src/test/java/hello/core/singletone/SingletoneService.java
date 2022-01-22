package hello.core.singletone;

public class SingletoneService {

    //하나만 존재함
    private static final SingletoneService instance = new SingletoneService();

    public static SingletoneService getInstance() {
        return instance;
    }
    //프라이빗을 사용해 무분별한 인스턴스 생성을막음
    private SingletoneService(){
    }

    public void logic() {
        System.out.println("싱글톤 객체 호출 ");
    }

}
