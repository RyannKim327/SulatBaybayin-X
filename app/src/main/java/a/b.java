package a;

import android.content.SharedPreferences;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import mpop.revii.sulatbaybayin.x.R;

public class b extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

	KeyboardView kbv;
	Keyboard qwerty,t9;
	SharedPreferences sp;
	@Override
	public View onCreateInputView() {
		sp = PreferenceManager.getDefaultSharedPreferences(this);
		kbv = (KeyboardView)getLayoutInflater().inflate(R.layout.layout_keyboard,null);
		qwerty = new Keyboard(this,R.xml.bqwerty);
		t9 = new Keyboard(this,R.xml.bt9);
		kbv.setKeyboard(sp.getBoolean("kboard",true) ? qwerty : t9);
		kbv.setOnKeyboardActionListener(this);
		kbv.setPreviewEnabled(false);
		return kbv;
	}
	@Override
	public void onKey(int p1, int[] p2) {
		InputConnection a = getCurrentInputConnection();
		switch(p1){
			case Keyboard.KEYCODE_DELETE:
				a.deleteSurroundingText(1,0);
			break;
			case Keyboard.KEYCODE_DONE:
				a.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN,KeyEvent.KEYCODE_ENTER));
			break;
			case -1903:
				 ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).showInputMethodPicker();
			break;
			case -327:
				kbv.setKeyboard(!sp.getBoolean("kboard", true) ? qwerty : t9);
				sp.edit().putBoolean("kboard",!sp.getBoolean("kboard", true)).commit();
				util.toast.GREEN(this,sp.getBoolean("kboard",true) ? "QWERTY mode" : "T9 mode");
			break;
			default:
				char b = (char)p1;
				a.commitText(String.valueOf(b), 1);
			break;
		}
	}
	@Override
	public void onPress(int p1) {}
	@Override
	public void onRelease(int p1) {}
	@Override
	public void onText(CharSequence p1) {}
	@Override
	public void swipeLeft() {}
	@Override
	public void swipeRight() {}
	@Override
	public void swipeDown() {}
	@Override
	public void swipeUp() {}
	
	
}
