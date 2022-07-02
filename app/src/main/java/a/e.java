package a;
import a.util;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

public class e extends EditText {
    public e(Context a){
		super (a);
		setBackgroundColor(Color.TRANSPARENT);
		setGravity(Gravity.TOP);
		setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);
		init(a);
	}
	void textcolor(int a){
		switch(a){
			case 0:
				setShadowLayer(3,0,0,Color.WHITE);
				setTextColor(Color.BLACK);
				setHintTextColor(Color.DKGRAY);
				break;
			case 1:
				setShadowLayer(3,0,0,Color.BLACK);
				setTextColor(Color.WHITE);
				setHintTextColor(Color.LTGRAY);
			break;
		}
	}
	String a(){
		return getText().toString();
	}
	void init(final Context a){
		setTypeface(util.assets.font(a,"b"));
	}
}
