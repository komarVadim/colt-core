package codeOrchestra.colt.core.tasks;

import javafx.concurrent.Task;

/**
 * @author Alexander Eliseyev
 */
public abstract class COLTTask<R> extends Task<R> {

    protected abstract String getName();



}