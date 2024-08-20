package a;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.inputmethodservice.KeyboardView.OnKeyboardActionListener;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import mpop.revii.sbx.R;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.view.KeyEvent;
import android.widget.Toast;

public class b extends InputMethodService implements OnKeyboardActionListener {

	c ᜆᜒᜉᜀᜈ᜔;
	Keyboard ᜊᜌ᜔ᜊᜌᜒᜈ᜔, ᜀᜎ᜔ᜉᜊᜒᜆᜓ, symbol;
	boolean ᜀ = true, ᜊ = true;
  boolean shift = false, caps = false;
  TextView t;
	@Override
	public View onCreateInputView() {
    // ᜉᜐᜒᜋᜓᜎ ᜂᜉᜅ᜔ ᜋᜄᜃᜇᜓᜂᜈ᜔ ᜈᜅ᜔ ᜎᜎᜄᜓᜌᜈ᜔
    
		View v = getLayoutInflater().inflate(R.layout.keyboard_view, null);
		ᜆᜒᜉᜀᜈ᜔ = v.findViewById(R.id.keyboard); // getLayoutInflater().inflate(R.layout.keyboard_view, null);
		t = v.findViewById(R.id.words);
    ᜊᜌ᜔ᜊᜌᜒᜈ᜔ = new Keyboard(this, R.xml.baybayin_keyboard);
		ᜀᜎ᜔ᜉᜊᜒᜆᜓ = new Keyboard(this, R.xml.alpha_keyboard);
		symbol = new Keyboard(this, R.xml.symbols);
		
		ᜆᜒᜉᜀᜈ᜔.setKeyboard(ᜊᜌ᜔ᜊᜌᜒᜈ᜔);
		ᜆᜒᜉᜀᜈ᜔.setOnKeyboardActionListener(this);
		ᜆᜒᜉᜀᜈ᜔.setPreviewEnabled(false);
    
		return v; // ᜆᜒᜉᜀᜈ᜔;
	}
	
	@Override
	public void onKey(int p1, int[] p2) {
		
		InputConnection input = getCurrentInputConnection();
		switch(p1){
			
			case Keyboard.KEYCODE_DELETE:
				if(input.getSelectedText(1) != null){
					input.commitText("", 1);
				}else{
					input.deleteSurroundingText(1, 0);
				}
        if(t.getText().toString().length() > 0){
          t.setText(t.getText().toString().substring(0, t.getText().toString().length() - 1));
        }
			break;
			case Keyboard.KEYCODE_DONE:
				switch(getCurrentInputEditorInfo().imeOptions & EditorInfo.IME_MASK_ACTION){
					case EditorInfo.IME_ACTION_DONE:
						case EditorInfo.IME_ACTION_GO:
							sendDefaultEditorAction(true);
					break;
					default:
						input.commitText(String.valueOf((char) 10), 1);
				}
			break;
      case Keyboard.KEYCODE_SHIFT:
        if(shift && !caps){
          caps = true;
        }else if(shift && caps){
          caps = false;
          shift = false;
        }else{
          shift = true;
        }
        ᜀᜎ᜔ᜉᜊᜒᜆᜓ.setShifted(shift || caps);
        ᜆᜒᜉᜀᜈ᜔.setShifted(shift || caps);
        ᜆᜒᜉᜀᜈ᜔.invalidate();
        ᜆᜒᜉᜀᜈ᜔.invalidateAllKeys();
      break;
      case -327:
        ᜆᜒᜉᜀᜈ᜔.setKeyboard(ᜀ ? ᜊᜌ᜔ᜊᜌᜒᜈ᜔ : ᜀᜎ᜔ᜉᜊᜒᜆᜓ);
        ᜀ = !ᜀ;
      break;
			default:
				String s = String.valueOf((char) p1);
				input.commitText((shift || caps) ? s.toUpperCase() : s.toLowerCase(), 1);
        if(!caps){
          shift = false;
        }
        String txt = t.getText().toString();
        if(p1 == 32){
          txt = "";
        }
        t.setText(txt + s);
        ᜀᜎ᜔ᜉᜊᜒᜆᜓ.setShifted(shift || caps);
        ᜆᜒᜉᜀᜈ᜔.setShifted(shift || caps);
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

  @Override
  public boolean onKeyLongPress(int keyCode, KeyEvent event) {
    Toast.makeText(this, "haha", 1).show();
    switch(keyCode){
      case Keyboard.KEYCODE_DONE:
        if(!ᜀ){
          ᜊ = !ᜊ;
          ᜆᜒᜉᜀᜈ᜔.setKeyboard(ᜊ ? ᜀᜎ᜔ᜉᜊᜒᜆᜓ : symbol);
        }
      break;
    }
    return super.onKeyLongPress(keyCode, event);
  }
  
  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    t.setText("");
    return super.onKeyDown(keyCode, event);
  }
}
