package a;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Service;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import mpop.revii.sulatbaybayin.x.R;

public class a extends Activity {
    RelativeLayout base;
	LinearLayout main,basescroll,background,scrollbase;
	e etxt;
	d num;
	SharedPreferences sp;
	ValueCallback <Uri> call;
	ValueCallback<Uri[]> Call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        base = new RelativeLayout(this);
		sp = getSharedPreferences(util.preferences.preference, MODE_PRIVATE);
		getActionBar().setIcon(R.mipmap.ic_launcher);
		background();
        main();
		theme(sp.getInt(util.preferences.theme, 0));
		getActionBar().setSubtitle("By: " + util.developer);
        int x = 1 + sp.getInt("Feedback", 0);
        sp.edit().putInt("Feedback", x).commit();

		setContentView(base);
    }
	void background() {
		background = new LinearLayout(this);
		TextView baybayintitle = new TextView(this);
		TextView baybayinsubtitle = new TextView(this);

		background.setBackgroundColor(Color.rgb(33, 33, 33));
		background.setOrientation(LinearLayout.VERTICAL);
		background.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

		baybayintitle.setText("ᜐᜓᜎᜆ᜔ ᜊᜌ᜔ᜊᜌᜒᜈ᜔");
		baybayintitle.setTextColor(Color.rgb(100, 100, 100));
		baybayintitle.setTextSize(50);
		baybayintitle.setTextScaleX(1.5f);
		baybayintitle.setPadding(10, 10, 10, 10);
		baybayintitle.setGravity(Gravity.RIGHT | Gravity.TOP);
		baybayintitle.setTypeface(util.assets.font(a.this, "a"));
		baybayintitle.setAlpha(0.1f);

		baybayinsubtitle.setText("Sulat Baybayin");
		baybayinsubtitle.setTextColor(Color.rgb(100, 100, 100));
		baybayinsubtitle.setTextSize(25);
		baybayinsubtitle.setTextScaleX(1.5f);
		baybayinsubtitle.setPadding(10, 10, 10, 10);
		baybayinsubtitle.setGravity(Gravity.BOTTOM | Gravity.RIGHT);
		baybayinsubtitle.setTypeface(util.assets.font(a.this, "b"));
		baybayinsubtitle.setAlpha(0.1f);

		background.addView(baybayintitle);
		background.addView(baybayinsubtitle);

		base.addView(background);
	}
	void main() {
		main = new LinearLayout(this);
		etxt = new e(this);
		scrollbase = new LinearLayout(this);
		HorizontalScrollView scroll = new HorizontalScrollView(this);
		basescroll = new LinearLayout(this);
		num = new d(this);

		main.setOrientation(LinearLayout.VERTICAL);
		main.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		main.setVisibility(View.VISIBLE);

		etxt.setHint(util.hint);
		etxt.setTextScaleX(1.5f);
		etxt.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 0.8f));
		etxt.setTextSize(sp.getInt(util.preferences.textsize, 15));
		if (sp.getBoolean(util.preferences.isCopied, false)) {
            feedxxx();
			ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
			if (cm.hasText()) {
				etxt.setText(cm.getText().toString());
			} else {
				etxt.setText(sp.getString(util.preferences.savetxt, plus_sign.a_comp));
			}
		} else {
			etxt.setText(sp.getString(util.preferences.savetxt, plus_sign.a_comp));
		}

		scrollbase.setOrientation(LinearLayout.HORIZONTAL);
		scrollbase.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 0.01f));
		basescroll.setOrientation(LinearLayout.HORIZONTAL);
		basescroll.setGravity(Gravity.CENTER);

		num.setPadding(3, 5, 3, 5);
		num.setGravity(Gravity.CENTER);
		num.setTextSize(19);
		filter(etxt.a());
        commands(etxt.a());
		num.setGravity(Gravity.CENTER);

		txtchanged();
		scroll.addView(basescroll);

		scrollbase.addView(num);
		scrollbase.addView(scroll);

		main.addView(etxt);
		main.addView(scrollbase);
		base.addView(main);
		registerForContextMenu(etxt);
	}
	TextView add(String p1, OnClickListener p2) {
		final d a = new d(this);
		a.setText(p1);
		a.setPadding(3, 5, 3, 5);
		a.setTextSize(19);
		switch (sp.getInt(util.preferences.theme, 0)) {
			case 0:
				a.setTextColor(Color.rgb(255, 255, 255));
				break;
			case 1:
				a.setTextColor(Color.rgb(0, 0, 0));
				break;
			case 2:
				final int cal = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
				new Handler().postDelayed(new Runnable(){
						@Override
						public void run() {
							if (cal >= 6 && cal <= 18) {
								a.setTextColor(Color.rgb(0, 0, 0));
							} else {
								a.setTextColor(Color.rgb(255, 255, 255));
							}
						}
					}, 500);
				break;
		}
		registerReceiver(new BroadcastReceiver(){
				@Override
				public void onReceive(Context p1, Intent p2) {
					switch (p2.getIntExtra(util.extras.theme, 0)) {
						case 0:
							a.setTextColor(Color.rgb(255, 255, 255));
							break;
						case 1:
							a.setTextColor(Color.rgb(0, 0, 0));
							break;
						case 2:
							final int cal = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
							new Handler().postDelayed(new Runnable(){
									@Override
									public void run() {
										if (cal >= 6 && cal <= 18) {
											a.setTextColor(Color.rgb(0, 0, 0));
										} else {
											a.setTextColor(Color.rgb(255, 255, 255));
										}
									}
								}, 500);
							break;
					}
				}
			}, new IntentFilter(util.actions.theme));
		a.setOnClickListener(p2);
		a.setOnTouchListener(new OnTouchListener(){
				@Override
				public boolean onTouch(View p1, MotionEvent p2) {
					if (a.isFocused() || a.isHovered() || a.isPressed()) {
						a.setBackgroundColor(Color.rgb(100, 100, 100));
					} else {
						a.setBackgroundColor(Color.TRANSPARENT);
					}
					return false;
				}
			});
		return a;
	}
	void removetxtclick(final LinearLayout p1, String p2) {
		p1.removeAllViews();
		for (int a = 0; a < util.arrays.pre_commands.length;a++) {
			final String b = util.arrays.pre_commands[a];
			if (b.contains(p2) && b.startsWith(p2)) {
				p1.addView(add("[ " + b.replace(util.commands.initial_command, "") + " ]", new OnClickListener(){
								   @Override
								   public void onClick(View p1) {
									   etxt.setText(b);
								   }
							   }));
			}
		}
		if (p2.startsWith(util.commands.theme)) {
			p1.removeAllViews();
			num.setText("List of themes: ");
			for (int a = 0; a < util.arrays.theme.length; a++) {
				final String b = util.arrays.theme[a];
				p1.addView(add("[ " + b + " ]", new OnClickListener(){
								   @Override
								   public void onClick(View p1) {
									   etxt.setText(util.commands.theme + b + util.commands.end_command);
								   }
							   }));
			}
		} else if (p2.startsWith(util.commands.textsize)) {
			p1.removeAllViews();
			num.setText("List of sizes: ");
			for (int a = 12; a <= 50; a++) {
				final int b = a;
				p1.addView(add("[ " + a + " ]", new OnClickListener(){
								   @Override
								   public void onClick(View p1) {
									   etxt.setText(util.commands.textsize + b + util.commands.end_command);
								   }
							   }));
			}
		} else if (p2.startsWith(util.commands.read)) {
			p1.removeAllViews();
			num.setText("List of files: ");
			if (util.file.list2(util.folder).length > 0) {
				for (final String a : util.file.list2(util.folder)) {
					p1.addView(add("[ " + a.replace(util.extension, "") + " ]", new OnClickListener(){
									   @Override
									   public void onClick(View p1) {
										   etxt.setText(util.encryption.base64tostring(util.file.read(a.this, a), true));
										   util.toast.GREEN(a.this, a.replace(util.extension, "") + "'s content is now on screen");
									   }
								   }));
				}
			} else {
				etxt.setText("");
				util.toast.BLUE(this, "There's no existing files here");
				filter(etxt.getText().toString());
			}
		} else if (p2.startsWith(util.commands.overlay_on)) {
            p1.removeAllViews();
            num.setText("Available text size: ");
            for (int a = 12; a <= 50; a++) {
                final int b = a;
                p1.addView(add("[ " + b + " ]", new OnClickListener(){
								   @Override
								   public void onClick(View p1) {
									   etxt.setText(util.commands.overlay_on + b + util.commands.end_command);
								   }
							   }));
            }
        } else if (p2.startsWith(util.commands.rename)) {
			p1.removeAllViews();
			num.setText("List of files: ");
			if (util.file.list2(util.folder).length > 0) {
				for (final String a : util.file.list2(util.folder)) {
					p1.addView(add("[ " + a.replace(util.extension, "") + " ]", new OnClickListener(){
									   @Override
									   public void onClick(View p1) {
										   etxt.setText(util.commands.rename + a.replace(util.extension, "") + " : ");
									   }
								   }));
				}
			} else {
				etxt.setText("");
				util.toast.BLUE(this, "There's no existing files here");
				filter(etxt.getText().toString());
			}
		} else if (p2.startsWith(util.commands.delete)) {
			p1.removeAllViews();
			num.setText("List of Files: ");
			if (util.file.list2(util.folder).length > 0) {
				for (final String a : util.file.list2(util.folder)) {
					p1.addView(add("[ " + a.replace(util.extension, "") + " ]", new OnClickListener(){
									   @Override
									   public void onClick(View p1) {
										   delete(a.replace(util.extension, ""));
									   }
								   }));
				}
			} else {
				etxt.setText("");
				util.toast.BLUE(this, "There's no existing files here");
				filter(etxt.getText().toString());
			}
		}
		for (int a = 0; a < util.arrays.space_commands.length;a++) {
			final String b = util.arrays.space_commands[a];
			if (p2.startsWith(b)) {
				p1.addView(add("[ Please Command ]", new OnClickListener(){
								   @Override
								   public void onClick(View px) {
									   String c = etxt.getText().toString();
									   if (c.endsWith(" ")) {
										   etxt.setText(c + util.commands.end_command.replace(" ", ""));
									   } else {
										   etxt.setText(c + util.commands.end_command);
									   }
								   }
							   }));
			}
		}
	}
	void txtchanged() {
		etxt.addTextChangedListener(new TextWatcher(){
				@Override
				public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4) {}
				@Override
				public void onTextChanged(CharSequence p1, int p2, int p3, int p4) {
					filter(etxt.a());
					commands(etxt.a());
					sp.edit().putString(util.preferences.savetxt, etxt.getText().toString()).commit();
				}
				@Override
				public void afterTextChanged(Editable p1) {}
			});
	}
	void filter(String p1) {
		if (p1.startsWith(util.commands.initial_command) && !p1.endsWith(util.commands.end_command)) {
			num.setText("Command list: ");
			num.setGravity(Gravity.LEFT);
			removetxtclick(basescroll, p1);
		} else {
			basescroll.removeAllViews();
			if (!etxt.getText().toString().isEmpty()) {
				if (util.ints.numberwords(etxt.a()) == 1 && util.ints.numberwords(etxt.a()) > 0) {
					num.setText("There is a word inserted");
				} else {
					num.setText("There are " + util.ints.numberwords(etxt.a()) + " words inserted");
				}
			} else {
				num.setText("No words inserted");
			}
			num.setGravity(Gravity.CENTER);
		}
	}
	void theme(int p1) {
		switch (p1) {
			case 0:
				setTheme(android.R.style.Theme_DeviceDefault);
				etxt.textcolor(0);
				background.setBackgroundColor(Color.rgb(20, 20, 20));
				num.setTextColor(Color.rgb(255, 255, 255));
				getActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(33, 33, 33)));
				break;
			case 1:
				setTheme(android.R.style.Theme_DeviceDefault_Light);
				etxt.textcolor(1);
				background.setBackgroundColor(Color.rgb(200, 200, 200));
				num.setTextColor(Color.rgb(0, 0, 0));
				getActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(175, 175, 175)));
				break;
            case 2:
				final int cal = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
				new Handler().postDelayed(new Runnable(){
						@Override
						public void run() {
							if (cal >= 6 && cal <= 18) {
								setTheme(android.R.style.Theme_DeviceDefault_Light);
								etxt.textcolor(1);
								background.setBackgroundColor(Color.rgb(200, 200, 200));
								num.setTextColor(Color.rgb(0, 0, 0));
								getActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(175, 175, 175)));
							} else {
								setTheme(android.R.style.Theme_DeviceDefault);
								etxt.textcolor(0);
								background.setBackgroundColor(Color.rgb(20, 20, 20));
								num.setTextColor(Color.rgb(255, 255, 255));
								getActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(33, 33, 33)));
							}
						}
					}, 500);
				break;
		}
		sp.edit().putInt(util.preferences.theme, p1).commit();
		Intent intent = new Intent(util.actions.theme);
		intent.setAction(util.actions.theme);
		intent.putExtra(util.extras.theme, p1);
		sendBroadcast(intent);
	}
	void commands(String p1) {
		if (p1.startsWith(util.commands.initial_command)) {
			if (p1.equals(util.commands.helpdesk)) {
				//etxt.setText(util.assets.read(a.this,"j"));
				etxt.setText(plus_sign.a_comp);
			} else if (p1.equals(util.commands.tnx)) {
				etxt.setText(util.assets.read(a.this, "k"));
			} else if (p1.equals(util.commands.script)) {
				etxt.setText(util.assets.read(a.this, "l"));
			} else if (p1.startsWith(util.commands.read) && p1.endsWith(util.commands.end_command)) {
				String a = etxt.getText().toString().replace(util.commands.read, "").replace(util.commands.end_command, "");
				etxt.setText(util.encryption.base64tostring(util.file.read(this, a + util.extension), true));
				util.toast.GREEN(this, a + "'s content is now on screen");
			} else if (p1.equals(util.commands.copy)) {
				sp.edit().putBoolean(util.preferences.isCopied, !sp.getBoolean(util.preferences.isCopied, false)).commit();
				etxt.setText("");
                util.toast.GREEN(this, "Auto copy: " + sp.getBoolean(util.preferences.isCopied, false));
			} else if (p1.startsWith(util.commands.theme) && p1.endsWith(util.commands.end_command)) {
				theme(p1.replace(util.commands.theme, "").replace(util.commands.end_command, ""));
                recreate();
			} else if (p1.startsWith(util.commands.textsize) && p1.endsWith(util.commands.end_command)) {
				int a = util.ints.number(etxt.getText().toString().replace(util.commands.textsize, "").replace(util.commands.end_command, ""));
				if (a >= 12 && a <= 50 && a != 0) {
					etxt.setTextSize(a);
					sp.edit().putInt(util.preferences.textsize, a).commit();
					etxt.setText("");
				}
			} else if (p1.startsWith(util.commands.rename) && p1.endsWith(util.commands.end_command)) {
				rename();
				etxt.setText("");
			} else if (p1.startsWith(util.commands.delete) && p1.endsWith(util.commands.end_command)) {
				delete(p1.replace(util.extension, "").replace(util.commands.delete, "").replace(util.commands.end_command, ""));
			} else if (p1.equals(util.commands.gmail_feedback)) {
                gmail();
                etxt.setText("");
            } else if (p1.equals(util.commands.dev)) {
                etxt.setText(util.assets.read(this, "m"));
            } else if (p1.equals(util.commands.fb_feedback)) {
                fb();
                etxt.setText("");
            } else if (p1.startsWith(util.commands.overlay_on) && p1.endsWith(util.commands.end_command)) {
                if (!isActive(c.class)) {
					int a = util.ints.number(etxt.getText().toString().replace(util.commands.overlay_on, "").replace(util.commands.end_command, ""));
					if (a  >= 12 && a <= 50 && a != 0) {
						sp.edit().putInt("overlaytxt", a).commit();
						startService(new Intent(this, c.class));
						etxt.setText("");
					}
				} else {
					stopService(new Intent(this, c.class));
					int a = util.ints.number(etxt.getText().toString().replace(util.commands.overlay_on, "").replace(util.commands.end_command, ""));
					if (a  >= 12 && a <= 50 && a != 0) {
						sp.edit().putInt("overlaytxt", a).commit();
						startService(new Intent(this, c.class));
					}
					etxt.setText("");
				}
            } else if (p1.equals(util.commands.overlay_off)) {
				if (isActive(c.class)) {}
				stopService(new Intent(this, c.class));
				etxt.setText("");
			}
		}
	}
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		menu.add(0,0,0,"Save as file").setIcon(android.R.drawable.ic_menu_save).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		menu.add(1,1,1,"Share app").setIcon(android.R.drawable.ic_menu_share);
		menu.add(2,2,2,"Share text").setIcon(android.R.drawable.ic_menu_send);
		menu.add(3,3,3,"Select keyboard");
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
			case 0:
				savefile();
			break;
            case 1:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"Download Sulat Baybayin X at " + util.website);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Download Sulat BaybayinX at " + util.website);
                intent.setType("text/plain");
                startActivity(intent);
            break;
            case 2:
                Intent intent1 = new Intent(Intent.ACTION_SEND);
                intent1.putExtra(Intent.EXTRA_TEXT, etxt.getText().toString());
                intent1.putExtra(Intent.EXTRA_SUBJECT,etxt.getText().toString());
                intent1.setType("text/plain");
				if(etxt.getText().toString().isEmpty()){
					util.toast.RED(this,"Text must not be empty");
				}else{
					startActivity(intent1);
				}
            break;
            case 3:
				((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).showInputMethodPicker();
            break;
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
		menu.setHeaderTitle("Sulat Baybayin text menu");
		menu.setHeaderIcon(R.mipmap.ic_launcher);
		menu.add(0,0,0,"Clear the field");
		menu.add(1,1,1,"Copy texts");
		menu.add(2,2,2,"Paste texts");
		menu.add(3,3,3,"Select keyboard");
		super.onCreateContextMenu(menu, v, menuInfo);
	}
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch(item.getItemId()){
			case 0:
				etxt.setText("");
				util.toast.GREEN(a.this,"Field cleared successfully");
			break;
			case 1:
				((ClipboardManager)getSystemService(CLIPBOARD_SERVICE)).setText(etxt.getText().toString());
				util.toast.GREEN(a.this,"Texts copied");
			break;
			case 2:
				if(((ClipboardManager)getSystemService(CLIPBOARD_SERVICE)).hasText()){
					etxt.setText(((ClipboardManager)getSystemService(CLIPBOARD_SERVICE)).getText());
					util.toast.GREEN(a.this,"Texts paste in the field");
				}else{
					util.toast.RED(a.this,"There\'s no copied texts yet");
				}
			break;
            case 3:
                ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).showInputMethodPicker();
            break;
		}
		return super.onContextItemSelected(item);
	}
	void savefile(){
		AlertDialog.Builder a = new AlertDialog.Builder(this);
		final e b = new e(this);
		a.setIcon(android.R.drawable.ic_menu_save);
		a.setTitle("Save as file:");
		b.setSingleLine();
		b.setHint("File name");
		a.setView(b);
		a.setPositiveButton("Save", new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface p1, int p2) {
					if(util.file.isHere(util.folder + "/" + b.getText().toString() + util.extension)){
						overwrite(b.getText().toString());
					}else if(b.getText().toString().isEmpty() || b.getText().toString().equalsIgnoreCase("")){
						util.toast.RED(a.this,"File name must not be empty");
					}else{
						util.file.save(b.getText().toString() + util.extension,util.encryption.base64tostring(etxt.getText().toString(),false));
						util.toast.GREEN(a.this,"File saved");
					}
				}
			});
		a.setNegativeButton("Cancel",null);
		a.setCancelable(false);
		if(etxt.getText().toString().isEmpty() || etxt.getText().toString().equalsIgnoreCase("")){
			util.toast.RED(a.this,"File content must not be empty");
		}else{
			a.show();
		}
	}
	void overwrite(final String p1){
		AlertDialog.Builder a = new AlertDialog.Builder(this);
		d b = new d(this);
		a.setIcon(android.R.drawable.ic_dialog_alert);
		a.setTitle("Confirmation:");
		b.setText("Are you sure, you want to overwrite " + p1 + " file?");
		b.setTextColor(Color.rgb(255,255,255));
		b.setPadding(5,5,5,5);
		b.setTextSize(19);
		a.setView(b);
		a.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface px, int p2) {
					util.file.delete(p1 + util.extension);
					util.file.save(p1 + util.extension,util.encryption.base64tostring(etxt.getText().toString(),false));
					util.toast.GREEN(a.this,"File content replaced successfully");
				}
			});
		a.setNegativeButton("No",null);
		a.setCancelable(false);
		a.show();
	}
	void theme(String p1){
		switch(p1){
			case "ᜇᜒᜎᜒᜋ᜔":
				theme(0);
			break;
			case "ᜎᜏᜈᜄ᜔":
				theme(1);
			break;
            case "ᜄᜊᜒ ᜀᜆ᜔ ᜀᜍᜏ᜔":
                theme(2);
            break;
		}
		etxt.setText("");
	}
	void rename(){
		String[] a = etxt.getText().toString().replace(util.commands.rename,"").replace(util.commands.end_command,"").split(" : ");
		if(util.file.isHere(util.folder + "/" + a[0] + util.extension)){
			if(util.file.isHere(util.folder + "/" + a[1] + util.extension)){
				util.toast.RED(a.this,"File " + a[1] + " already existed");
			}else{
				if(a[0].equals(a[1])){
					util.toast.BLUE(a.this,"Same file name");
				}else{
					if(util.file.rename(a[0] + util.extension,a[1] + util.extension)){
						util.toast.GREEN(a.this,"Renamed successfully");
					}else{
						util.toast.RED(a.this,"Something went wrong");
					}
				}
			}
		}else{
			util.toast.RED(a.this,"File not found");
		}
	}
	void font(String p1){
		String a = "";
		switch(p1){
			case "Sans":
				a = "a";
			break;
			case "Serif":
				a = "b";
			break;
			case "Monospace":
				a = "c";
			break;
			case "Cursive":
				a = "d";
			break;
			default:
				a = "b";
			break;
		}
		Intent b = new Intent(util.actions.font);
		b.putExtra(util.extras.font,a);
		sendBroadcast(b);
		sp.edit().putString(util.preferences.font,a).commit();
	}
	void delete(final String g1){
		AlertDialog.Builder a = new AlertDialog.Builder(this);
		d b = new d(this);
		a.setTitle("Confirmation");
		a.setIcon(android.R.drawable.ic_menu_info_details);
		b.setText("Are you sure you want to delete " + g1 + " file?");
		b.setTextColor(Color.rgb(255,255,255));
		b.setTextSize(19);
		b.setPadding(5,5,5,5);
		a.setView(b);
		a.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface p1, int p2) {
					util.file.delete(g1 + util.extension);
					util.toast.GREEN(a.this,"File deleted successfully");
					etxt.setText("");
				}
			});
		a.setNegativeButton("No", new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface p1, int p2) {
					etxt.setText("");
				}
			});
		a.setCancelable(false);
		if(util.file.isHere(util.folder + "/" + g1 + util.extension)){
			a.show();
		}else{
			util.toast.RED(a.this,"File not found");
		}
	}
    void deleteAll(final String g1){
        AlertDialog.Builder a = new AlertDialog.Builder(this);
        a.setTitle("Confirmation");
        a.setIcon(android.R.drawable.ic_menu_info_details);
        a.setMessage("Are you sure you want to delete all files?");
        a.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface p1, int p2) {
                    util.file.delete(g1 + util.extension);
                    etxt.setText("");
                }
            });
        a.setNegativeButton("No", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface p1, int p2) {
                    etxt.setText("");
                }
            });
        a.setCancelable(false);
        if(util.file.isHere(util.folder + "/" + g1 + util.extension)){
            a.show();
        }else{
            util.toast.RED(a.this,"File not found");
		}
    }
    void gmail(){
        Intent a = new Intent(Intent.ACTION_SEND);
        a.setAction(Intent.ACTION_SEND);
        a.putExtra(Intent.EXTRA_SUBJECT,getTitle() + " " + getPackageName());
        a.setType("text/html");
        a.putExtra(Intent.EXTRA_EMAIL, new String[]{"weryses19@gmail.com"});
        a.setPackage("com.google.android.gm");
        startActivity(a);
    }
    void fb(){
        AlertDialog.Builder a = new AlertDialog.Builder(a.this);
        WebView b = new WebView(this){
            @Override
            public boolean onCheckIsTextEditor(){
                return true;
            }
        };
        b.getSettings().setJavaScriptEnabled(true);
        b.getSettings().setAppCacheEnabled(true);
        b.setFocusable(true);
        b.setFocusableInTouchMode(true);
        b.requestFocus();
        b.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView wv,String url){
                wv.loadUrl(url);
                return true;
            }
        });
		b.setWebChromeClient(new WebChromeClient(){
			public void openFileChooser(ValueCallback<Uri> vc){
				call = vc;
				Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
				intent.addCategory(Intent.CATEGORY_OPENABLE);
				intent.setType("image/*");
				startActivityForResult(intent,0);
			}
			public void openFileChooser(ValueCallback<Uri> vc, String act){
				call = vc;
				Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
				intent.addCategory(Intent.CATEGORY_OPENABLE);
				intent.setType("*/*");
				startActivityForResult(Intent.createChooser(Intent.createChooser(intent,"Choose image"),"Choose Image"),0);
			}
			public void openFileChooser(ValueCallback<Uri> vc,String act,String capt){
				call = vc;
				Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
				intent.addCategory(Intent.CATEGORY_OPENABLE);
				intent.setType("image/*");
				startActivityForResult(Intent.createChooser(intent,"Choose image"),0);
			}
			public boolean onShowFileChooser(WebView wv, ValueCallback<Uri[]> vc, FileChooserParams pars){
				if(Call != null){
					Call.onReceiveValue(null);
					Call = null;
				}
				Call = vc;
				Intent intent = pars.createIntent();
				try{
					startActivityForResult(intent,1);
				}catch(ActivityNotFoundException  ex){
					Call = null;
					util.toast.RED(a.this,"Can't open file chooser");
					return false;
				}
				return true;
			}
			@Override
			public boolean onJsAlert(WebView wv,String str1,String str2, JsResult jsr){
				return super.onJsAlert(wv, str1, str2, jsr);
			}
			@Override
			public boolean onJsConfirm(WebView wv,String str1,String str2, JsResult jsr){
				return super.onJsConfirm(wv, str1, str2, jsr);
			}
			@Override
			public boolean onJsPrompt(WebView wv,String str1,String str2,String str3, JsPromptResult jsr){
				return super.onJsPrompt(wv, str1, str2, str3, jsr);
			}
		});
        b.loadUrl(util.fb_id);
        a.setTitle("Facebook Feedback");
        a.setView(b);
        a.setPositiveButton("Done",null);
        a.setCancelable(true);
        a.show();
    }
    void feedxxx(){
        if(new Random().nextInt(100)%10 == 0){
            AlertDialog.Builder a = new AlertDialog.Builder(this);
            a.setTitle("Are you enjoying this app?");
            a.setMessage("Send us a feedback about your experience in using this app by using the commands or clicking any in the buttons below.");
            a.setPositiveButton("Facebook", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface p1, int p2) {
                        fb();
                    }
                });
            a.setNegativeButton("Gmail", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface p1, int p2) {
                        gmail();
                    }
                });
            a.setNeutralButton("Cancel",null);
            a.setCancelable(false);
            a.show();
        }
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch(requestCode){
			case 0:
				if(call == null){
					return;
				}
				Uri result = data == null || requestCode != RESULT_OK ? null : data.getData();
				call.onReceiveValue(result);
				call = null;
			break;
			case 1:
				if(Call == null){
                    return;
                }
				Call.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(resultCode,data));
				Call = null;
			break;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
	boolean isActive(Class<? extends Service> a){
		ActivityManager manager = (ActivityManager)getSystemService(ACTIVITY_SERVICE);
		for(ActivityManager.RunningServiceInfo run : manager.getRunningServices(Integer.MAX_VALUE)){
			if(a.getName().equals(run)){
				return true;
			}
		}
		return false;
	}
}
