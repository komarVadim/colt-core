package codeOrchestra.colt.core.ui

import codeOrchestra.colt.core.model.monitor.ChangingMonitor
import codeOrchestra.colt.core.ui.dialog.ColtDialogs
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.scene.layout.StackPane
import javafx.stage.Stage

/**
 * @author Dima Kruk
 */
class ProjectStage extends Stage {

    Pane root

    ProjectStage() {
        root = new StackPane()

        setTitle("COLT — Code Orchestra Livecoding Tool (1.2)")
        scene = new Scene(root, 506, 820)

        setOnCloseRequest({windowEvent ->
            if (ChangingMonitor.getInstance().isChanged()) {
                ColtDialogs.showCloseProjectDialog(this, windowEvent)
            }

            if (!windowEvent.isConsumed()) {
                dispose()
            }
        } as EventHandler);
    }

    private void dispose() {
        //todo: implement
    }
}
