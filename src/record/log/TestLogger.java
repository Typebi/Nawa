package record.log;

public class TestLogger {
	Logger logger;
	TestLogger(){
		logger = Logger.getInstance();
	}
	void run() {
		logger.getLogFile();
		logger.recordLog("테스트문자열", Logger.LOG_INFO);
	}
	public static void main (String argsp[]) {
		new TestLogger().run();
	}
}
