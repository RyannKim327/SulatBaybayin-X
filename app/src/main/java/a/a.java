package a;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class a extends Activity {
	LinearLayout base, scroll, bscroll;
	HorizontalScrollView sv;
	text mode;
	edit edit;
	SharedPreferences pref;
	
	String text = "Saved";
	String size = "Size";
	String theme = "Theme";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		base = new LinearLayout(this);
		scroll = new LinearLayout(this);
		bscroll = new LinearLayout(this);
		sv = new HorizontalScrollView(this);
		mode = new text(this);
		edit = new edit(this);
		pref = PreferenceManager.getDefaultSharedPreferences(this);
		
		extractTheme();
		
		getActionBar().setSubtitle("Developed by MPOP Reverse II");
		
		base.setOrientation(LinearLayout.VERTICAL);
		scroll.setOrientation(LinearLayout.HORIZONTAL);
		bscroll.setOrientation(LinearLayout.HORIZONTAL);
		
		edit.setText(pref.getString(text, utils.assets(this, "help.txt")));
		edit.setTextSize(pref.getInt(size, 13));
		edit.setImeOptions(EditorInfo.IME_FLAG_NO_FULLSCREEN);
		edit.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1f));
		
		edit.addTextChangedListener(new TextWatcher(){
				@Override
				public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4) {}
				@Override
				public void onTextChanged(CharSequence p1, int p2, int p3, int p4) {
					pref.edit().putString(text, edit.getText().toString()).commit();
					commands(edit.getText().toString());
					filter();
				}
				@Override
				public void afterTextChanged(Editable p1) {}
			});
		
		filter();
		
		mode.setTextSize(pref.getInt(size, 13));
		mode.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT));
		
		sv.addView(scroll);
		sv.setPadding(8, 0, 8, 0);
		sv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, 1f));
		
		bscroll.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		bscroll.addView(mode);
		bscroll.addView(sv);
		
		base.addView(edit);
		base.addView(bscroll);
		
		setContentView(base);
	}
	
	void filter(){
		scroll.removeAllViews();
		if(edit.getText().toString().startsWith(commands.prefix)){
			mode.setText("Command list: ");
	    	for(final String str : commands.commands){
	    		if(str.toLowerCase().startsWith(edit.getText().toString().toLowerCase())){
		    		scroll.addView(tv(str.substring(1), new OnClickListener(){
	    				@Override
		    			public void onClick(View v){
			    			edit.setText(str);
	    				}
		    		}));
        		}
	    	}
		     if(edit.getText().toString().startsWith(commands.theme)){
			    scroll.removeAllViews();
	    		mode.setText("List of themes: ");
		    	for(final String str : commands.$theme){
		    		scroll.addView(tv(str, new OnClickListener(){
		    			@Override
		    			public void onClick(View v){
		    				String s = edit.getText().toString();
				    		edit.setText(s + str + commands.postfix);
		    			}
		    		}));
	    		}
	    	}else if(edit.getText().toString().startsWith(commands.size)){
				scroll.removeAllViews();
	    		mode.setText("Available sizes: ");
		    	for(int i = 13; i <= 50; i++){
			    	final int j = i;
	    			scroll.addView(tv(String.valueOf(i), new OnClickListener(){
		    			@Override
		    			public void onClick(View v){
			    			String s = edit.getText().toString();
		    				edit.setText(s + String.valueOf(j) + commands.postfix);
	    				}
	    			}));
	    		}
			}
		}else{
      int w = utils.words(edit.getText().toString());
      if(w == 0){
        mode.setText("No Words");
        return;
      }
			mode.setText(String.format("%d word%s", w, (w > 1) ? "s" : ""));
		}
	}
	
	void commands(String str){
		if(str.equals(commands.help)){
			edit.setText(utils.assets(this, "help.txt"));
		}else if(str.startsWith(commands.theme) && str.endsWith(commands.postfix)){
			str = str.replace(commands.theme, "").replace(commands.postfix, "");
			pref.edit().putString(theme, str).commit();
			extractTheme();
			utils.toast(this, "Theme set into " + str);
			edit.setText("");
		}else if(str.startsWith(commands.size) && str.endsWith(commands.postfix)){
			str = str.replace(commands.size, "").replace(commands.postfix, "");
			if(utils.number(str, 13) >= 13){
			    pref.edit().putInt(size, utils.number(str, 13)).commit();
			    edit.setTextSize(pref.getInt(size, 13));
			    mode.setTextSize(pref.getInt(size, 13));
		        utils.toast(this, "Text size set as " + str);
			}else{
				utils.toast(this, "Request denied");
			}
			edit.setText("");
		}
	}
	
	void extractTheme(){
		String $theme = pref.getString(theme, "Dark").toLowerCase();
		switch($theme){
			case "dark":
				setTheme(android.R.style.Theme_Material);
				getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#151540")));
				getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#131320")));
				edit.setTextColor(Color.WHITE);
				mode.setTextColor(Color.WHITE);
			break;
			case "light":
				setTheme(android.R.style.Theme_Material_Light);
				getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF96A6FD")));
				getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#eeeeff")));
				edit.setTextColor(Color.BLACK);
				mode.setTextColor(Color.BLACK);
			break;
		}
	}
	
	TextView tv(String str, OnClickListener click){
		TextView tv = new TextView(this);
		
		String $theme = pref.getString(theme, "Dark").toLowerCase();
		
		tv.setText("[" + str + "]");
		tv.setPadding(5, 0, 5, 0);
		tv.setTextSize(pref.getInt(size, 13));
		
		switch($theme){
			case "dark":
				tv.setTextColor(Color.WHITE);
			break;
			case "light":
				tv.setTextColor(Color.BLACK);
			break;
		}
		
		tv.setOnClickListener(click);
		
		return tv;
	}
	
}
