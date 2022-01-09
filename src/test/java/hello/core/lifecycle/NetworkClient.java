package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작 시 호출
    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + ", message : " + message);
    }

    //서비스 종료 시 호출
    public void disconnect() {
        System.out.println("disconnect : " + url);
    }

    @PostConstruct
    public void init() { //의존관계 주입이 끝나면 실행
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() { //스프링 빈이 소멸 직전 실행
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
