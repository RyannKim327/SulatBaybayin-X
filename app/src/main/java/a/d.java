package a;

import a.util;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class d extends TextView {
	public d(Context a){
		super(a);
		init(a);
	}
	public d(Context a,AttributeSet b){
		super(a,b);
		init(a);
	}
	void init(final Context a){
		setTypeface(util.assets.font(a,"b"));
	}
}
