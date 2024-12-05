Thread safe 해결책
다음과 같이 getInstance 메소드를 동기화하여 다중 쓰레드 환경에서도 사용 가능
public synchronized static Logger getInstance() {
        if (instance == null) instance = new Logger();
        return instance;
}
