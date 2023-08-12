package a;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard.Key;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.List;
import android.graphics.drawable.ColorDrawable;

public class f extends KeyboardView{
    public f(Context a,AttributeSet b){
		super(a,b);
		try {
			setBackgroundDrawable(Drawable.createFromStream(getContext().getAssets().open("i"), null));
		} catch (IOException e) {
			setBackgroundDrawable(new ColorDrawable(Color.rgb(33,33,33)));
		}
	}
	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		final Paint a = new Paint();
		a.setTypeface(util.assets.font(getContext(),"b"));
		a.setColor(Color.rgb(255, 255, 255));
		a.setShadowLayer(5,0,0,Color.WHITE);
		a.setTextSize(35);
		a.setTextAlign(Paint.Align.CENTER);
		List<Key> c = getKeyboard().getKeys();
		for(Key d : c){
			if(d.label != null){
				String e = d.label.toString();
				canvas.drawText(e, d.x + (d.width / 2), d.y + (d.height / 1.25f), a);
			}
		}
	}
}
