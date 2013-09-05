package codeOrchestra.colt.core.ui.components.inputForms.group

import codeOrchestra.colt.core.ui.components.fileset.FilesetInput
import codeOrchestra.colt.core.ui.components.inputForms.*
import javafx.collections.ListChangeListener
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.geometry.Insets
import javafx.scene.Node as FXNode
import javafx.scene.control.Label
import javafx.scene.layout.VBox

/**
 * @author Dima Kruk
 */
class FormGroup extends VBox {
    private static final Insets TITLED = new Insets(26, 0, 23, 0)
    private static final Insets NOT_TITLED = new Insets(3, 0, 23, 0)

    private static final int SPASING = 22

    @FXML protected Label label

    String title

    /*
    <fx:root type="javafx.scene.layout.VBox" styleClass="fieldset" maxWidth="640.0" xmlns:fx="http://javafx.com/fxml">
      <Label fx:id="label" styleClass="legend">
        <VBox.margin>
          <Insets bottom="-2" left="19" />
        </VBox.margin>
      </Label>
    </fx:root>
     */

    FormGroup() {
        FXMLLoader fxmlLoader = new FXMLLoader(FormGroup.class.getResource("form_group.fxml"))
        fxmlLoader.root = this
        fxmlLoader.controller = this

        try {
            fxmlLoader.load()
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        makeTitled(false)

        setSpacing(SPASING)

        initListener()
    }

    private void initListener() {
        children.addListener({ ListChangeListener.Change<? extends javafx.scene.Node> change ->
            change.next()
            if (change.from == 1) {
                if (!title) {
                    setMargin(change.addedSubList[0], new Insets(SPASING, 0, 0, 0))
                }
            } else {
                FXNode prev = change.list[change.from - 1]
                FXNode cur = change.addedSubList[0]
                if (prev instanceof ITypedForm && cur instanceof ITypedForm) {
                    if (cur instanceof CTBForm) {
                        if (prev instanceof CTBForm) {
                            if (prev.type == FormType.SIMPLE) {
                                setMargin(cur, new Insets(18 - SPASING, 0, 0, 0))
                            } else {
                                setMargin(cur, new Insets(25 - SPASING, 0, 0, 0))
                            }
                        } else if (prev.type != FormType.SIMPLE) {
                            setMargin(cur, new Insets(22 - SPASING, 0, 0, 0))
                        }
                        if (prev instanceof CBForm) {
                            setMargin(cur, new Insets(24 - SPASING, 0, 0, 0))
                        }
                    }
                    if (cur instanceof RTBForm) {
                        if (prev instanceof RTBForm) {
                            if (prev.type == FormType.SIMPLE) {
                                setMargin(cur, new Insets(18 - SPASING, 0, 0, 0))
                            } else {
                                setMargin(cur, new Insets(25 - SPASING, 0, 0, 0))
                            }
                        }
                    }
                    if (cur instanceof LTBForm) {
                        if (prev.type == FormType.SIMPLE) {
                            setMargin(cur, new Insets(18 - SPASING, 0, 0, 0))
                        } else {
                            setMargin(cur, new Insets(26 - SPASING, 0, 0, 0))
                        }
                    }
                    if (cur instanceof FilesetInput) {
                       //todo:
                    }
                    if (cur instanceof CBForm) {
                        setMargin(cur, new Insets(23 - SPASING, 0, 0, 0))
                    }
                }
            }
        } as ListChangeListener)
    }

    private void makeTitled(boolean b) {
        label.visible = label.managed = b
        setPadding(b ? TITLED : NOT_TITLED)
        if(children.size() > 1) {
            setMargin(children[1], b ? null : new Insets(SPASING, 0, 0, 0))
        }
    }


    void setTitle(String value) {
        title = value
        if (title) {
            label.text = title
            makeTitled(true)
        } else {
            makeTitled(false)
        }
    }
}
