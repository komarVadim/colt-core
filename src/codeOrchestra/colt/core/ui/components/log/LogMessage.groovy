package codeOrchestra.colt.core.ui.components.log

import codeOrchestra.colt.core.logging.Level
import groovy.transform.Canonical

/**
 * @author Dima Kruk
 */
@Canonical
class LogMessage {

    long timestamp
    String source
    Level level
    String message
    String stackTrace
    boolean visible = true

    public LogMessage(String source, Level level, String message, long timestamp, String stackTrace) {
        this.timestamp = timestamp
        this.source = source
        this.level = level
        this.message = message
        this.stackTrace = stackTrace
    }

    public boolean filter(LogFilter filter){
        boolean visibleState = visible
        switch (filter){
            case LogFilter.ALL:
                visible = true
                break
            case LogFilter.ERRORS:
                visible = level == Level.ERROR
                break
            case LogFilter.WARNINGS:
                visible = level == Level.WARN
                break
            case LogFilter.INFO:
                visible = level == Level.INFO
                break
            case LogFilter.LOG:
                visible = level == Level.LIVE || level == Level.COMPILATION
                break
        }
        return  visibleState == visible
    }
}
