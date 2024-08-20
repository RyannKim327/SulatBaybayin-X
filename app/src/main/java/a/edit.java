package a;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.EditText;

public class edit extends EditText{
    Paint paint;
	Rect rect;
	public edit(Context a){
		super(a);
		init(a);
	}
	void init(Context a){
		
		paint = new Paint();
		rect = new Rect();
		
		setBackgroundColor(Color.TRANSPARENT);
		setTypeface(Typeface.createFromAsset(a.getAssets(), "baybayin.ttf"));
		setGravity(Gravity.TOP | Gravity.LEFT);
	}
	@Override
	public void onDraw(Canvas canvas){
		
		super.onDraw(canvas);
	}
}
