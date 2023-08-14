package a;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.ImageView;
import java.io.IOException;
import java.util.Calendar;

public class g extends ImageView{
	public g(Context a){
		super(a);
	}
	public Drawable a(int a){
		if(a >= 17 || a < 5){ 
			try {
				return Drawable.createFromStream(getContext().getAssets().open("e"), null);
			} catch (IOException e) {
				return null;
			}
		}else if(a >= 5 && a < 10){
			try {
				return Drawable.createFromStream(getContext().getAssets().open("f"), null);
			} catch (IOException e) {
				return null;
			}
		}else if(a >= 10 && a < 13){
			try {
				return Drawable.createFromStream(getContext().getAssets().open("g"), null);
			} catch (IOException e) {
				return null;
			}
		}else if(a >= 13 && a < 17){
			try {
				return Drawable.createFromStream(getContext().getAssets().open("h"), null);
			} catch (IOException e) {
				return null;
			}
		}else{
			return null;
		}
	}
}
