package com.earl.fishshop.serviceImpl;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAspect {

	public static final Logger logger = Logger.getLogger(LogAspect.class);

	@Pointcut("execution(* com.earl.shopping.daoImpl.*.*(..))")
	public void logManager() throws Throwable {
	}

	// @Pointcut("execution(* com.mysoft.manager.impl.TxtFileManager.*(..))")
	public void txtFileManager() {
	}

	// @Pointcut("execution(* com.mysoft.manager.KeywordsChecker.checkNormalKeywords(..))")
	public void checkNormalKeywords() {
	}

	// @Pointcut("execution(* com.mysoft.manager.KeywordsChecker.checkFixKeywords()) && args(text, ..)")
	public void checkFixKeywords(String text) {
	}

	// @Around("propertyManager() || txtFileManager()")
	//两个相同的@Around("logManager()")在两个方法上，
	//@Around
	//invoke()
	//@Around
	//invoke1()
	//执行顺序是，
	//invoke
//		invoke1
//		
//		invoke1
//	  invoke
	@Around("logManager()")
	public Object invoke(ProceedingJoinPoint join) throws Throwable {
		Logger.getLogger(this.getClass()).info("start "+join.getSignature());
		long start = System.currentTimeMillis();
		Object result = join.proceed();
		Signature name = join.getSignature();
		// String name =
		// MethodSignature.class.cast(join.getSignature()).getMethod().getName();
		Object[] args = join.getArgs();
		long time = System.currentTimeMillis() - start;
		StringBuilder builder = new StringBuilder();
		builder.append("MethodSignature:").append(name).append("Args:")
				.append(args).append("毫秒:").append(time).append("秒:")
				.append(time / 1000).append("result:").append(result);
		Logger.getLogger(this.getClass()).info(builder.toString());
		return result;
	}
	@Around("logManager()")
	public Object invoke1(ProceedingJoinPoint join) throws Throwable {
		Logger.getLogger(this.getClass()).info("---->");
		Object result = join.proceed();
		Logger.getLogger(this.getClass()).info("---->");
		return result;
	}

	// @Around("checkNormalKeywords()")
	public String invokeAndReturnString(ProceedingJoinPoint join)
			throws Throwable {
		return "";
	}

	/**
	 * @param text
	 * @return
	 * @throws Throwable
	 */
	// @Around(value = "checkFixKeywords(text)")
	public String invokeCheckFixKeywords(ProceedingJoinPoint join, String text)
			throws Throwable {
		if ("abcflg".equals(text)) {
			return "flg";
		}
		return null;
	}
}