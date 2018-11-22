package com.navercorp.pinpoint.web.alarm;

/**
 * alarm message constants
 *
 * @author: zhao qingyuan
 * @date: 2018-11-22 17:22
 */
public interface AlarmMessageConstant {

    /**
     * AlarmChecker
     */
    String ALARM_CHECKER_SMS = "[PINPOINT Alarm - %s] %s is %s%s (Threshold : %s%s)";
    String ALARM_CHECKER_EMAIL = "%s value is %s%s during the past 5 mins.(Threshold : %s%s)<br>";

    /**
     * AgentChecker
     */
    String AGENT_CHECKER_SMS = "[PINPOINT Alarm - %s] %s is %s%s (Threshold : %s%s)";
    String AGENT_CHECKER_EMAIL = " Value of agent(%s) is %s%s during the past 5 mins.(Threshold : %s%s)";

    /**
     * DataSourceConnectionUsageRateChecker
     */
    String DATA_SOURCE_CONNECTION_USAGE_RATE_CHECKER_SMS = "[PINPOINT Alarm - %s] DataSource %s connection pool usage %s%s (Threshold : %s%s)";
    String DATA_SOURCE_CONNECTION_USAGE_RATE_CHECKER_EMAIL = " Value of agent(%s) has %s%s(DataSource %s connection pool usage) during the past 5 mins.(Threshold : %s%s";

    /**
     * DeadlockChecker
     */
    String DEAD_LOCK_CHECKER_SMS = "[PINPOINT Alarm - %s] Deadlock thread detected";
    String DEAD_LOCK_CHECKER_EMAIL = " Value of agent(%s) has deadlocked thread during the past 5 mins.";

    /**
     * ErrorCountToCalleeChecker
     */
    String ERROR_COUNT_TO_CALLEE_CHECKER_SMS = "";
    String ERROR_COUNT_TO_CALLEE_CHECKER_EMAIL = "%s value is %s%s during the past 5 mins.(Threshold : %s%s) %s For From '%s' To '%s'.<br>";

    /**
     * ErrorRateToCalleeChecker
     */
    String ERROR_RATE_TO_CALLEE_CHECKER_SMS = "";
    String ERROR_RATE_TO_CALLEE_CHECKER_EMAIL = "%s value is %s%s during the past 5 mins.(Threshold : %s%s) %s For From '%s' To '%s'.<br>";

    /**
     * SlowCountToCalleeChecker
     */
    String SLOW_COUNT_TO_CALLEE_CHECKER_SMS = "";
    String SLOW_COUNT_TO_CALLEE_CHECKER_EMAIL = "%s value is %s%s during the past 5 mins.(Threshold : %s%s) %s For From '%s' To '%s'.<br>";

    /**
     * SlowRateToCalleeChecker
     */
    String SLOW_RATE_TO_CALLEE_CHECKER_SMS = "";
    String SLOW_RATE_TO_CALLEE_CHECKER_EMAIL = "%s value is %s%s during the past 5 mins.(Threshold : %s%s) %s For From '%s' To '%s'.<br>";
}
