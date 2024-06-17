package inflearn.study.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Setter;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Setter
public class NetworkClient {

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출, url = "+url);


    }

    //서비스 시작 시 호출
    public void connect(){
        System.out.println("connect: "+url);
    }

    public void call(String message){
        System.out.println("call: "+url);
    }

    //서비스 종료 시 호출
    public void disconnect(){
        System.out.println("close: "+url);
    }

    @PostConstruct
    public void init() {
        System.out.println("초기화 콜백");
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close() {
        System.out.println("소멸 전 콜백");
        disconnect();
    }
}
