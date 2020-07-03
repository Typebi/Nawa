package record.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class Logger {
	private static File logFile;
	private static FileWriter fw;
	private String path = "./"; //로그 저장 경로
	
	public static final String LOG_INFO = "INFO";
	//public static final String LOG_ERROR = "ERROR";
	//private static final String LOG_DEBUG = "DEBUG";
	
	public static Logger getInstance() {
		   return LazyHolder.logger;
		}
	private static class LazyHolder{
		private static final Logger logger = new Logger();
	}
	
	public void getLogFile(){
		Calendar c = Calendar.getInstance();
		String logFileName = buildString("Log_", c.get(Calendar.YEAR),"-",(c.get(Calendar.MONTH)+1),"-",c.get(Calendar.DATE),".log");
		if(logFile==null || !logFile.getName().equals(logFileName))
			logFile= new File(path + logFileName);
		try {
			if (logFile.getParentFile() != null)
				logFile.getParentFile().mkdirs();
			if (!logFile.exists())
				logFile.createNewFile();
			fw = new FileWriter(logFile, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void recordLog(String str, String type) {
		Calendar c = Calendar.getInstance();
		String log = buildString(c.get(Calendar.YEAR), "/", (c.get(Calendar.MONTH) + 1), "/",
				c.get(Calendar.DAY_OF_MONTH), " ", c.get(Calendar.HOUR_OF_DAY), ":", c.get(Calendar.MINUTE), ":",
				c.get(Calendar.SECOND), " [", type, "] ", str, "\r\n");
		System.out.println(log);
		try {
			fw.write(log);
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private String buildString(Object... args) {
        StringBuilder builder = new StringBuilder();
        for (Object arg : args) {
            if (arg == null) {
            	builder.append("null");
            }else {
            	builder.append(arg.toString());
            }
        }
        return builder.toString();
    }
//	public static void main(String args[]) {
//		new Logger().getLogFile();
//		new Logger().recordLog("에러내용","ERROR");
//	}
}
