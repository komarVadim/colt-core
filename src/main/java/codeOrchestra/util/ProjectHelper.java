package codeOrchestra.util;

import codeOrchestra.colt.core.LiveCodingLanguageHandler;
import codeOrchestra.colt.core.loading.LiveCodingHandlerManager;
import codeOrchestra.colt.core.model.Project;

/**
 * @author Alexander Eliseyev
 */
public final class ProjectHelper {

    public static boolean isLegacyProject(String projectFileContent) {
        String trimmedContent = projectFileContent.trim();
        if (trimmedContent.startsWith("<?xml") || trimmedContent.startsWith("<coltProject") || trimmedContent.startsWith("<xml")) {
            return false;
        }
        return true;
    }

    public static <P extends Project> P getCurrentProject() {
        LiveCodingLanguageHandler currentHandler = LiveCodingHandlerManager.getInstance().getCurrentHandler();
        if (currentHandler == null) {
            return null;
        }
        return (P) currentHandler.getCurrentProject();
    }

}
