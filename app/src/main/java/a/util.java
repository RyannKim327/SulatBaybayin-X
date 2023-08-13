package a;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.io.File;
import android.os.Environment;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import android.net.Uri;
import android.util.Log;
public class util {
    
	private static String a = "mpop.revii.sulatbaybayin.x.";
	
	public static String splash_title = "Sulat Baybayin X";
	public static String dev_group = "MPOP Reverse II";
	
	public static String act_title = "Sulat Baybayin 🇵🇭";
	public static String developer = "Ryann Kim Sesgundo";
	public static String hint = "Enter text or command";
	public static String dev_baybayin = "ᜇᜌᜈ᜔ ᜃᜒᜋ᜔ ᜋᜎᜊᜈᜈ᜔ ᜐᜒᜐ᜔ᜄᜓᜈ᜔ᜇᜓ";
	
	public static String folder = ".Sulat Baybayin";
	public static String extension = ".sbx";
	
	public static String website = "https://sulatbaybayin.coolpage.biz";
	public static String fb_message = "https://free.facebook.com/messages/thread/";
	public static String fb_id = fb_message + "114879103482143";

	public static class actions{
		public final static String theme = a + "actions.THEME_CHANGE";
		public final static String font = a + "actions.FONT_CHANGE";
	}
	public static class arrays{
		public final static String[] pre_commands = {
			util.commands.helpdesk,
			util.commands.tnx,
			util.commands.script,
			util.commands.dev,
			util.commands.fb_feedback,
			util.commands.gmail_feedback,
			util.commands.textsize,
			util.commands.theme,
			util.commands.read,
			util.commands.overlay_on,
			util.commands.overlay_off,
			util.commands.copy,
			util.commands.rename,
			util.commands.delete
		};
		public final static String[] space_commands = {
			util.commands.textsize,
			util.commands.theme,
			util.commands.read,
			util.commands.overlay_on,
			util.commands.rename,
			util.commands.delete
		};
		public final static String[] theme = {
			"ᜇᜒᜎᜒᜋ᜔",
			"ᜎᜏᜈᜄ᜔",
			"ᜄᜊᜒ ᜀᜆ᜔ ᜀᜇᜏ᜔"
		};
	}
	public static class assets{
		public final static Typeface font(Context a,String b){
			try{
				return Typeface.createFromAsset(a.getAssets(),b);
			}catch(Exception c){
				return Typeface.SERIF;
			}
		}
		public final static String read(Context p1,String p2){
			try {
				InputStream a = p1.getAssets().open(p2);
				int b = a.available();
				byte[] c = new byte[b];
				a.read(c);
				a.close();
				return new String(c);
			} catch (Throwable e) {
				return e.getMessage();
			}
		}
	}
	public static class commands{
		public final static String initial_command = "᜶";
		public final static String end_command = " ᜉᜃᜒᜂᜐᜉ᜔᜶";
		public final static String helpdesk = initial_command + "ᜄᜊᜌ᜔";
		public final static String tnx = initial_command + "ᜐᜎᜋᜆ᜔";
		public final static String script = initial_command + "ᜊᜌ᜔ᜊᜌᜒᜈ᜔";
		public final static String dev = initial_command + "ᜄᜓᜋᜏ";
		public final static String fb_feedback = initial_command + "ᜉᜒᜌ᜔ᜐ᜔ᜊᜓᜃ᜔";
		public final static String textsize = initial_command + "ᜎᜃ ᜒᜈᜅ᜔ ᜆᜒᜆᜒᜃ᜔ ";
		public final static String theme = initial_command + "ᜊᜄᜓ ᜆᜒᜋ ";
		public final static String read = initial_command + "ᜊᜐ ";
		public final static String overlay_on = initial_command + "ᜎᜊᜐ᜔ ᜎᜓᜆᜅ᜔ ";
		public final static String overlay_off = initial_command + "ᜉᜆᜌ᜔ ᜎᜓᜆᜅ᜔";
		public final static String copy = initial_command + "ᜋᜆᜒᜃ᜔ ᜎᜒᜆᜏ᜔";
		public final static String rename = initial_command + "ᜉᜎᜒᜆ᜔ ᜉᜅᜎᜈ᜔ ";
		public final static String delete = initial_command + "ᜊᜓᜇ ";
		public final static String gmail_feedback = initial_command + "ᜇ᜔ᜌᜒᜋᜒᜌ᜔ᜎ᜔";
	}
	public static class extras{
		public final static String theme = a + "extras.THEME_CHANGE";
		public final static String font = a + "extras.FONT_CHANGE";
	}
	public static class preferences{
		public final static String preference = a + "preferences.ACTIVATION_METHOD";
		public final static String keyboard = a + "preferences.KEYBOARD_CHANGE";
		public final static String font = a + "preferences.FONT_CHANGE";
		public final static String splash = a +  "preferences.SPLASH";
		public final static String savetxt = a + "preferences.SAVED_TEXTS";
		public final static String isCopied = a + "prefeence.IS_COPIED";
		public final static String theme = a + "preferences.THEME_CHANGE";
		public final static String textsize = a + "preference.TEXT_SIZE";
	}
	public static class toast{
		private final static float a = 100f;
		private final static ShapeDrawable drawable = new ShapeDrawable(new RoundRectShape(new float[]{a,a,a,a,a,a,a,a},null,null));
		public final static android.widget.Toast GREEN(Context a, String b){
			android.widget.Toast p1 = new android.widget.Toast(a);
			drawable.getPaint().setColor(Color.parseColor("#9900ffaa"));
			d p2 = new d(a);
			p2.setText(b);
			p2.setTextSize(20);
			p2.setPadding(15,15,15,15);
			p2.setBackgroundDrawable(drawable);
			p2.setTextColor(Color.WHITE);
			p1.setDuration(1);
			p1.setView(p2);
			p1.show();
			return p1;
		}
		public final static android.widget.Toast RED(Context a, String b){
			android.widget.Toast p1 = new android.widget.Toast(a);
			drawable.getPaint().setColor(Color.parseColor("#99b71c1c"));
			d p2 = new d(a);
			p2.setText(b);
			p2.setTextSize(20);
			p2.setPadding(15,15,15,15);
			p2.setBackgroundDrawable(drawable);
			p2.setTextColor(Color.BLACK);
			p1.setDuration(1);
			p1.setView(p2);
			p1.show();
			return p1;
		}
		public final static android.widget.Toast BLUE(Context a, String b){
			android.widget.Toast p1 = new android.widget.Toast(a);
			drawable.getPaint().setColor(Color.parseColor("#9900aaff"));
			d p2 = new d(a);
			p2.setText(b);
			p2.setTextSize(20);
			p2.setPadding(15,15,15,15);
			p2.setBackgroundDrawable(drawable);
			p2.setTextColor(Color.WHITE);
			p1.setDuration(1);
			p1.setView(p2);
			p1.show();
			return p1;
		}
	}
	public static class security{
		private final static String prime_code = "R8yQzJTMgc2szIPNrMyTzLBSzJPMgs2qzaXNn8yvzLJGzYTNjM2tza7NhMyxVc2MzL7Mg8y0zKPNicyrzK3Mn82OMsyazarMg82qzIrMgc2azYfMnVPMv8yKzL/NkM2hzLnNlM2JMsyEzaXNp8yRzIXNi8yKzLXMukPMms2jzJTNrc2eTM2jzaPNnMyXzKTMnM2NzK5GzIbMhcy1zJ3NlMysS8y+zITNisyCzILNm82gzK3Nk8ykzLDNiFbNhsyAzJDMi8yJzZHNjFPMgcyOzaPMqsytzLDNmlfNg82qzaXMmsynzLLMls2OzKzMrs2TQ82FzJ/MlsyfzJbMpMyvTcy5zLLMpcyvzJzNjUvMgMy6zLDNlErMj82rzJPMkc2GzZfNo8ynzZnNlc2FzYnMrEbMnsyxzK3MmUbMjs2XzJHMiMyPza3MosyfzLxVzIfMhc2tzJLMv82pzL3NjcygzLzNmsyeUc2PzYnMrTLNp8y0zKlJzatJzZ3Mqk7MvcyRzYTMv82tzYvMjsyyzKvMrcy6zLPMvEvNks2EzKHNjc2ZzKPNh82NzKvNlkXNkMyazLbMo0fNqc2tzaPNkc2qza/Mmsy4zYXNlVTNq82bzafMg8yHzZDNgsyizKTMn8ywzJjNms2TzKxazInMt8y8zLnNhVfMg82czKTMu0nNosyjzZTMoMypzJ1azKHMrsypzZrNlcydzJ5EzabMms2XzYfMu1XNrs2vzIfNjU3MksyGzZDNkM2mzaDMnc2FUc2lzZlKzJDMvs2azLvMnlXMg82bzYbMt8yYzKPMrMy7zKzNhc2VSsyKzYTNisyHzaTMgM2rzJzMlsytzY7Njk7Nrsy+zKJHzZfMhM2nzIfNmVXNgsy+zJLMvsyAzYvMn1fNhMy/zZHMks2PzKnMmMy7zKXNhc2FVsyNzLpTzIbNpcyMzIvMh8yZzZbNjsydzKPMq1rNis2mzInNkc2CzaJLzIDNnsyWzYnMmcycVs2tzIbMkc2XzazMk8yYzZPMuU3Mi8yMzZPMmM2TzKDMvFbNq82QzJTMjM2tzaDMoM2UScyQzJrNi8yLzJrMqM2ZzK3MmcyjVs2ozIXNg8yEzL7NnsyYzYXMssydQ82kzZ9TzJPNm8yDzI3MkM2rzYPMtcydzLnNjkrMhc2uzabNi8yBzZvMmM2VzZrNjUrMms2qzYTNnM2TzK3MnMykzLtKzJDNhM2EzYzNp8yKzLTNmcyXzLFFUcymzZPNk8ydVc2vzZHMhMyWzJ5DzI/Nk8yZzZbMq82HzYjMpkTNq82kzL3NpsyazJLNncy8zZTMn0vMksyGzaDMrcyszZrMr8yxzJ1SzajNisynzY5CzJrMhs2ozIzMlc2JzJnMllbNkMyazI7NqM2GzYTNjMyvzYXMo8yxQ82GzaXNms2ZzZrMqs2NzKZVzYLMrsyyzZXMmMylzYnNjkPMgMyRzI3Mi82kzZjNlsytzKDMus2HQ8yKzYbNgcylzKbMqsyWzZlKzJLNm82mzajMm82azJ7Nls2VzZNBzJPMv8ySzZTMu82VzJcyzIHNp82rza7NiUbMgcyPzYrNi82bzYrNp8ydzKzMmM2IzJ1FzIXNrc2RzarNkMyMzIXMpcyWzYXMsM2UzLvNjVXMic2WzLzMsMyvzZXMplLNpsyizKtUzYLMis2nzYbMvc2GzLjMsEvMv8yQza/Mg82ZSs2JzJjNicyvzKbMu8yrRs2ORsyRzIDMjc2XVcyAzL7Mh8yPzaTNhsyczLnMqcyzzLrMnVLNpMyOzI7Mj82PzK7MsMyzzLvMqcyrzJZDzYPMicyLzKDMmc2ZzLzNjUnNg8yUzYTMvcyGzLjMsc2WzJjMncy7Sc2tzZLMiM2rzZfMgM2hzZrMn8y6Ts2ezKBLzanMgc2kzYvMgc2izKXMoEXNks2ozIHMosyvzJ3Ml82NzYVHzIvMhM2tzL3Mj8yazJ/MplTMiM2qzYTNpcyJzaLMr8ywzKZazIbMi8y/zYLNhsyBzLRXzZHMvknMvsyUzYzMisyQzITMoVrNr82vzabNpM2GzY3MpcyZzZrNk0TNq8yQzLXNls2JzYfMsM2azLlVzYPNhsyUzarMg8yJzYbNoU3NrMyazIPNksyIzJrMtsydzKbMuc2VUcyDza7MvcyTzITNmsydzLDMoM2VzK9KzIfMgsyszK7Mn1XNicyszZPMlsyuzLHMnkrMlMydzK1OzYvMgs2CzIrMnEfMjM2hzKXMslXNp8yQzazMhMyD0olZzYrNhMyAzJDMtMyWzJbMrM2FzKrMmM2TVsy2zZTMpMyWzK3Mq1PNpMyNzI3NrMyHzL7NrMy3zJ3Mq8yfzK7NlVrNl8y/zYLMjs2pzY7Mo82ZzJxLzJLNhMy3zKRVzYTNgM2OzLMyzJTMk82DzIDMgMy7zZNGzIvNis2kzZDMpMypRc2PzJ7Mr82VzYVVzajMjsyrzK7MssyrzLPMpc2JQ8yGzanMk82qzJnNh82WzYfMpVPMlMyzSs2XzILMvsy+zZ/Nk8ylzLPNmsyySs2tzYPMjMyMza/Mvc2YzZPMpMyWzZXMmUrNrMynzZrNjsylzZXMuUXMk82XzIjNhsyCzI7MhMylzKTMucyfzLpRzajMpc2UzKvMrMyvzYhVzaTNrM2SzL3NrMy8zLnMps2VzKDMvEPMksyFzZjMls2VzJbMsMytzZNEzIfNokvNjMyLzL7Mj82tzZHNpcyyzK7Nlc2TUs2uzInNkMyhzKZCzIvMic2Cza7Mms2uzYDNhcywzLPMplbMicyPzJPNhM2jzYPMqEPNg8yTzJTMi82GzaPNjM2gzK3MrMyszZVUzanMisyBzaXMjM2hzZnMqcyrzZbMu8y5zY4yzI/NrcyMzafMv8y/zYjMnEfNl82XzJLNgc2VzY3Mq0nMjM2QzKPMssyYzKs1za/Mkc2MzILNg82RzKDMu82IzY5EzYTNlsyXRMy+zavNqsy/zZLNqsy8zJ7Ms8yuRcyKzI7MvcyAzJLMrMyYzLFOzIrMuMyvQ82jzKTMo8ydTMyFzIPNi82tza3MjsyazLjMqsymSsyIzJLNoMy5zKPMljXMs82ZzZbMrcytzK1FzIvMjcyXzLzMpFbNksyIzIXNp82mzZvMt1XNpc2GzYXMl82WzLHMr82VzJdXzIjNp8yMzIzNosygzZRLzYfMucytzYdWzITMkM2qzIDMjM2qzLnMqsysTM2QzJPMm8yxzKvNicyvRsyEzabNksy1zZnMoMyyS82bzIPNhsyKzIDNjM2BzJxGzYTNjM2MzZrNmcy6zKTMq8yrUcyTzIbNg8y2zYXMu1XNpcySzJHMmVPMjs2KzInNgsyFza/MlsyvzKbMrcygzKXMs0vNo82SzL3Ni8y+zILNlkvMk82RzLnMoMyZSsymzKvMl8y8Rcy5zJ3Nh8yWzY7Mq82TVcyMzYjMns2UzLzNhc2NzK9RzanMi82RzKtVzJTMj82RzarMv8yUzLzNjkvNrc2nzaTMh82rzYLNl8ylzY3MlsypVc2GzJPNpcyNzYTNrcyNzKjMmcyfzYnNjsyrR8yTzITMiM2CzLjMqsyjzZrMnsykWs2mzIPMv82rzJ/Mss2WzJjNlUXNhMyNzZDNq8ybzZVWzKfMuc2ZU8yKzInMv82lzI7Nncy8zZTMrMyfzJbMrE7MhM2KzL/Nrs2fzYXMpsyczYfMl8ywS82kzaZazaXNks2QzIPNkc2qzabMlcymzK/MqUvMjcyKzL7Np82nzYHMrsyyzLBVza3Nncy7zJzMns2JzZkyzazMhM2ezKzMq8yXzLzMoMyWRsyazaTNmMyqzJ5FzaTMncyszLrMvMyyzY5WzZvNhs2ozITMtcy5zYXMnMytQ8ySzazMvs2pzL7NjsygzYnNmcywzYXMn1PNhMyFzIXMv8yQzZLMlMyezJfNlcy6zY1KzYPMiMyUzL/Mn0rMjc2bzL3NlsyXzYfMu0rMgcyDzI3Mi8yQzIjMkcy0zLrNmcygzJbNjUXMhM2LzJrMk8yMzYTMrM2";
	}
	public static class string{
		public final static String md5(String p1){
			try {
				MessageDigest a = MessageDigest.getInstance("MD5");
				byte[] b = a.digest(p1.getBytes());
				BigInteger c = new BigInteger(1,b);
				String d = c.toString(16);
				while(d.length() < 32){
					d = "0" + d;
				}
				return d;
			} catch (NoSuchAlgorithmException e) {
				throw new RuntimeException(e);
			}
		}
	}
	public static class ints{
		public final static int numberwords(String p1){
			return p1.trim().split("\\s+").length;
		}
		public final static int number(String a){
			try{
				return Integer.parseInt(a);
			}catch(NumberFormatException b){
				return 0;
			}
		}
	}
	public static class encryption{
		private final static String a(String p1){
			byte[] a = new byte[0];
			try {
				a = Base64.decode(p1.getBytes("UTF-8"), 0);
			} catch (UnsupportedEncodingException e) {}
			return new String(a);
		}
		private final static String b(String p1){
			byte[] a = new byte[0];
			a = Base64.encode(p1.getBytes(),0);
			return new String(a);
		}
		public final static String base64tostring(String p1,boolean trueforstring){
			if(trueforstring){
				return a(a(a(a(a(p1)))));
			}else{
				return b(b(b(b(b(p1)))));
			}
		}
	}
	public static class file{
		public final static boolean isHere(String p1){
			return new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + p1).exists();
		}
		public final static void save(String p1,String p2){
			if(!isHere(folder)){
				File a = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + folder);
				a.mkdir();
				a.mkdirs();
			}
			File a = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + folder,p1);
			if(!a.exists()){
				try {
					a.createNewFile();
				} catch (IOException e) {}
			}
			try {
				FileOutputStream b = new FileOutputStream(a, true);
				byte[] c = p2.getBytes();
				try {
					b.write(c);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		public final static void delete(String p1){
			new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + folder + "/" + p1).delete();
		}
		public final static boolean rename(String p1,String p2){
			File a = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + folder + "/" + p1);
			File b = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + folder + "/" + p2);
			return a.renameTo(b);
		}
		public final static String list(String p1){
			String[] a = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + folder).list();
			String b = "File Lists:\n";
			for(String c : a){
				b += c + "\n";
			}
			return b;
		}
		public final static String[] list2(String p1){
			return new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + folder).list();
		}
		public final static String read(Context p1,String p2){
			BufferedReader a = null;
			StringBuilder b = new StringBuilder();
			try {
				a = new BufferedReader(new InputStreamReader(p1.getContentResolver().openInputStream(Uri.fromFile(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + folder + "/" + p2)))));
				String c = "";
				try {
					while ((c = a.readLine()) != null) {
						b.append(c);
						b.append("\n");
					}
				} catch (IOException e) {}finally{
					if(a != null){
						try {
							a.close();
						} catch (IOException e) {}
					}
				}
			} catch (FileNotFoundException e) {}
			return new String(b);
		}
	}
}
