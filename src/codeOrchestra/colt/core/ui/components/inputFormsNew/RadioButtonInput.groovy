package codeOrchestra.colt.core.ui.components.inputFormsNew


import codeOrchestra.colt.core.ui.components.inputFormsNew.base.TitledInputBase
import codeOrchestra.colt.core.ui.components.inputFormsNew.markers.MSelectable
import codeOrchestra.colt.core.ui.components.inputFormsNew.markers.MSimple
import codeOrchestra.groovyfx.FXBindable
import javafx.scene.control.RadioButton

/**
 * @author Dima Kruk
 */
class RadioButtonInput extends TitledInputBase implements MSelectable, MSimple {
    @FXBindable boolean selected

    protected final RadioButton radioButton = new RadioButton()

    RadioButtonInput() {
        setLeftAnchor(radioButton, 10)
        setRightAnchor(radioButton, 10)

        radioButton.textProperty().bindBidirectional(title())
        radioButton.selectedProperty().bindBidirectional(selected())

        children.add(radioButton)
    }

    RadioButton getRadioButton(){
        return radioButton
    }
}
