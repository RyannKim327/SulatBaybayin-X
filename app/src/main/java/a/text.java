package a;
import android.widget.TextView;
import android.content.Context;
import android.graphics.Typeface;

public class text extends TextView {
  public text(Context ctx){
    super(ctx);
    setTypeface(Typeface.createFromAsset(ctx.getAssets(), "baybayin.ttf"));
  }
}
