package com.packt.webstore.interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class PerformanceMonitorInterceptor implements HandlerInterceptor {

	ThreadLocal<StopWatch> stopWatchLocal = new ThreadLocal<StopWatch>();
	Logger logger = Logger.getLogger(this.getClass());

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
			throws Exception {
		StopWatch stopWatch = new StopWatch(handler.toString());
		stopWatch.start(handler.toString());
		stopWatchLocal.set(stopWatch);
		logger.info("Accessing URL Path " + getURLPath(request));
		logger.info("Request process started on : " + getCurrentTime());
		return true;

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		logger.info("Request processing ended on "+ getCurrentTime());

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception exception) throws Exception {
		StopWatch stopWatch = stopWatchLocal.get();
		stopWatch.stop();
		logger.info("Total time taken for processing: "+stopWatch.getTotalTimeMillis()+ " ms");
		stopWatchLocal.set(null);
		logger.info("---------------------------------------------------------------");
	}

	private String getURLPath(HttpServletRequest request) {
		String currentPath = request.getRequestURI();
		String queryString = request.getQueryString();
		queryString = queryString == null ? "" : "?" + queryString;
		return currentPath + queryString;

	}

	private String getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
	}

}
