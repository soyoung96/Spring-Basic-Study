package inflearn.study.web;

import inflearn.study.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final ObjectProvider<MyLogger> myLoggerObjectProvider;

    public void logic(){
        MyLogger myLogger = myLoggerObjectProvider.getObject();
        myLogger.log("service test");
    }
}
