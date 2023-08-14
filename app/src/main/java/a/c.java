package a;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Handler;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import java.util.Calendar;

public class c extends Service {

	LinearLayout base;
	g left,right;
	h txt;
	WindowManager wm;
	LayoutParams params;
	@Override
	public void onCreate() {
		super.onCreate();
		wm = (WindowManager) getSystemService(WINDOW_SERVICE);
		params = new LayoutParams();
		
		params.width = LayoutParams.WRAP_CONTENT;
		params.height = LayoutParams.WRAP_CONTENT;
		params.type = LayoutParams.TYPE_SYSTEM_OVERLAY;
		params.flags = LayoutParams.FLAG_NOT_FOCUSABLE | LayoutParams.FLAG_NOT_TOUCH_MODAL | LayoutParams.FLAG_LAYOUT_IN_SCREEN;
		params.format = PixelFormat.TRANSPARENT;
		params.gravity = Gravity.BOTTOM;
		params.y = 25;
		
		init();
		a();
		wm.addView(base,params);
		
	}
	void init(){
		float a = 100;
		ShapeDrawable bg = new ShapeDrawable(new RoundRectShape(new float[]{a,a,a,a,a,a,a,a},null,null));
		int  b = getSharedPreferences(util.preferences.preference,MODE_PRIVATE).getInt("overlaytxt",12);
		int c = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		
		base = new LinearLayout(this);
		left = new g(this);
		right = new g(this);
		txt = new h(this);
		
		bg.getPaint().setColor(Color.argb(100,33,33,33));
		
		base.setOrientation(LinearLayout.HORIZONTAL);
		base.setBackgroundDrawable(bg);
		base.setGravity(Gravity.CENTER);
		
		left.setLayoutParams(new LinearLayout.LayoutParams(b, b));
		left.setPadding(10,0,5,0);
		right.setLayoutParams(new LinearLayout.LayoutParams(b, b));
		right.setPadding(5,0,10,0);
		txt.setTextSize(b);
		txt.setTextColor(Color.rgb(255,255,255));
		
		left.setBackgroundDrawable(left.a(c));
		right.setBackgroundDrawable(right.a(c));
		txt.setText(txt.a(c));
		
		base.addView(left);
		base.addView(txt);
		base.addView(right);
		
	}
	void a(){
		new Handler().postDelayed(new Runnable(){
			@Override
			public void run() {
				int a = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
				left.setBackgroundDrawable(left.a(a));
				right.setBackgroundDrawable(right.a(a));
				txt.setText(txt.a(a));
			}
		}, 1000);
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		stopSelf();
		wm.removeView(base);
	}
	@Override
	public IBinder onBind(Intent p1) {
		return null;
	}
}
