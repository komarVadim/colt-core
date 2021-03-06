package codeOrchestra.colt.core.ui.components.inputForms.base

import codeOrchestra.groovyfx.FXBindable
import javafx.scene.layout.AnchorPane

/**
 * @author Dima Kruk
 */
abstract class TitledInputBase extends AnchorPane {
    @FXBindable String title
}
