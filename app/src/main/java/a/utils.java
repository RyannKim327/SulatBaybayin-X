package a;

import android.content.Context;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import android.widget.TextView;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.Color;
import android.graphics.Typeface;

public class utils {
    public static int number(String str, int defaults){
		try{
			return Integer.parseInt(str);
		}catch(NumberFormatException e){
			return defaults;
		}
	}
	public static int words(String str){
		return (str.length() > 0) ? str.split("([\\s\\n]+)").length : 0;
	}
	public static String assets(Context a, String b){
		String str = "";
		try{
			StringBuilder builder = new StringBuilder();
			InputStream c = a.getAssets().open(b);
			Reader d = new BufferedReader(new InputStreamReader(c));
			char[] e = new char[1024];
			while(true){
				int f = d.read(e, 0, e.length);
				if(f <= 0 ){
					break;
				}
				builder.append(e, 0, f);
			}
			str = new String(builder);
		}catch(Exception e){
			e.printStackTrace();
		}
		return str;
	}
	public static Toast toast(Context ctx, String str){
		Toast t = new Toast(ctx);
		TextView v = new TextView(ctx);
		float e = 10f;
		float[] f = {e, e, e, e, e, e, e, e};
		ShapeDrawable d = new ShapeDrawable(new RoundRectShape(f, null, null));
		
		d.getPaint().setColor(Color.parseColor("#3F51B5"));
		
		v.setText(str);
		v.setPadding(8, 5, 8, 5);
		v.setBackgroundDrawable(d);
		v.setTypeface(Typeface.createFromAsset(ctx.getAssets(), "KGPrimaryPenmanshipAlt.ttf"));
		v.setTextSize(18);
		
		t.setView(v);
		t.setDuration(Toast.LENGTH_SHORT);
		t.show();
		
		return t;
	}
}
