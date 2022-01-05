package hello.core.singleton;

public class SingletonService {

    //static 영역에 객체를 딱 1개만 생성
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    //객체 인스턴스가 생성되는 것을 막기 위해 private로 생성자 추가
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
