package app;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

import javafx.scene.control.ContextMenu;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

import org.fxmisc.richtext.PopupAlignment;
import org.fxmisc.richtext.StyleSpans;
import org.fxmisc.richtext.StyleSpansBuilder;
import org.fxmisc.richtext.StyledTextArea;

public class TextArea extends StyledTextArea<Boolean> {
	
	private static final int NUM_COMPLETIONS = 6;
	private static final int NUM_SUGGESTIONS = 6;

	// track auto complete and spelling suggestion states
	private boolean autoCompleteOn = false;
	private boolean spellingOn = false;

	// boolean to see if style needs update on plain text change
	private boolean needUpdate = true;

	// matches case of user typing for auto complete and ss
	// turn off if handling caps
	private boolean matchCase = true;

	// indices which contain word, set by getWordAtIndex
	private int startIndex;
	private int endIndex;

	// current autocomplete options
	private List<String> options;

	// popup to display/select entry
	private ContextMenu entriesPopup;

//	private spelling.AutoComplete ac;
//	private spelling.Dictionary dic;
//	private spelling.SpellingSuggest ss;

	// set up reflection for spelling suggest
	private static Method mHit;
	private static Method mGetCharacterIndex;
	private static Object styledView;

	static {
		try {
			mHit = Class.forName("org.fxmisc.richtext.skin.StyledTextAreaView").getDeclaredMethod("hit", double.class,
					double.class);
			mGetCharacterIndex = Class.forName("org.fxmisc.richtext.skin.CharacterHit")
					.getDeclaredMethod("getCharacterIndex");

		} catch (ClassNotFoundException | NoSuchMethodException ex) {
			throw new RuntimeException(ex);
		}

		mHit.setAccessible(true);
		mGetCharacterIndex.setAccessible(true);
	}

	
	public TextArea() {
		super(true, (textNode, correct) -> {
			// define boolean Text node style
			if (!correct) {
				textNode.setUnderline(true);
				textNode.setBackgroundFill(Color.TOMATO);
			}
		});

		// save objects passed in
//		this.ac = ac;
//		this.ss = ss;

		// dictionary used in spelling suggestions
//		this.dic = dic;

		// SPELLING SUGGESTIONS

		// register mouse click for correcting misspelled words
//		this.setOnMouseClicked(e -> {
//			if ((e.getButton() == MouseButton.SECONDARY) && spellingOn) {
//				// get StyledTextAreaView object
//				styledView = getChildrenUnmodifiable().get(0);
//
//				// get character hit on click and index
//				Object chHit = invoke(mHit, styledView, e.getX(), e.getY());
//				OptionalInt opInt = (OptionalInt) invoke(mGetCharacterIndex, chHit);
//
//				// valid index clicked
//				if (opInt.isPresent()) {
//					int index = opInt.getAsInt();
//
//					// check if index corresponds to misspelled word
//					if (!getStyleOfChar(index)) {
//						String possibleWord = getWordAtIndex(index);
//						showSuggestions(possibleWord, e);
//					}
//				}
//
//			}
//
//		});

//		// keep track of text changes, update spell check if needed
//		this.plainTextChanges().subscribe(change -> {
//			// could make more efficient
//			if (spellingOn && needUpdate) {
//				this.setStyleSpans(0, checkSpelling());
//			}
//		});

		// AUTOCOMPLETE

		// initialize list and options menu for autoComplete
//		options = new ArrayList<String>();
//		entriesPopup = new ContextMenu();
//		setPopupWindow(entriesPopup);
//		setPopupAlignment(PopupAlignment.CARET_BOTTOM);
//
//		// observe caretPosition property for auto complete functionality
//		this.caretPositionProperty().addListener((obs, oldPosition, newPosition) -> {
//			if (autoCompleteOn) {
//				// listen to textProperty to only
//				String prefix = getWordAtIndex(newPosition.intValue());
//				showCompletions(prefix);
//			}
//
//		});
	}

}
