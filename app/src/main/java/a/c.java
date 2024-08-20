package a;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.inputmethodservice.Keyboard.Key;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;
import java.util.List;

public class c extends KeyboardView{
  int color = Color.parseColor("#FF412202");
  
	public c(Context a, AttributeSet b){
		super(a, b);
    setBackgroundColor(color);
	}

	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		final Paint paint = new Paint();
		try{
			paint.setTypeface(Typeface.create(Typeface.createFromAsset(getContext().getAssets(), "baybayin.ttf"), Typeface.BOLD_ITALIC));
			paint.setTextSize(25);
			paint.setTextAlign(Paint.Align.CENTER);
      paint.setShadowLayer(3, 0, 0, color);
			paint.setColor(color);
			List<Key> list = getKeyboard().getKeys();
			for(Key k : list){
				if(k.label != null){
					String s = k.label.toString();
          if(isShifted()){
              s = s.toUpperCase();
          }
					canvas.drawText(s, k.x + (k.width  / 2f), k.y + (k.height / 1.5f), paint);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
