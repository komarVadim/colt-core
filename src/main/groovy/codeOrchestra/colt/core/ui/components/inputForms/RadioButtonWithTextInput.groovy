package codeOrchestra.colt.core.ui.components.inputForms

import codeOrchestra.colt.core.ui.components.inputForms.base.InputWithErrorBase
import codeOrchestra.colt.core.ui.components.inputForms.markers.MSelectable
import codeOrchestra.groovyfx.FXBindable
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import javafx.scene.control.RadioButton
import javafx.scene.control.ToggleGroup

/**
 * @author Dima Kruk
 */
class RadioButtonWithTextInput extends InputWithErrorBase implements MSelectable {
    @FXBindable boolean selected

    protected final RadioButton radioButton = new RadioButton()

    RadioButton getRadioButton(){
        return radioButton
    }

    RadioButtonWithTextInput() {
        setLeftAnchor(radioButton, 10)
        setRightAnchor(radioButton, 10)

        radioButton.textProperty().bindBidirectional(title())
        radioButton.selectedProperty().bindBidirectional(selected())

        textField.disableProperty().bind(selected().not())

        children.add(radioButton)
    }

    @Override
    void activateValidation() {
        super.activateValidation()
        selected().addListener({ ObservableValue<? extends Boolean> observableValue, Boolean t, Boolean newValue ->
            if(newValue) {
                validateValue()
            } else {
                error = false
            }
        } as ChangeListener)
    }

    void setToggleGroup(ToggleGroup value) {
        radioButton.toggleGroup = value
    }
}
