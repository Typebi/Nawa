package record.log;

public class TestLogger {
	Logger logger;
	TestLogger(){
		logger = Logger.getInstance();
	}
	void run() {
		logger.getLogFile();
		logger.recordLog("�׽�Ʈ���ڿ�", Logger.LOG_INFO);
	}
	public static void main (String argsp[]) {
		new TestLogger().run();
	}
}
