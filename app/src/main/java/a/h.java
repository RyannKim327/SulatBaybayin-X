package a;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import java.util.Calendar;

public class h extends d {
    public h(Context a){
        super(a);
    }
    public h(Context a,AttributeSet b){
        super(a,b);
    }
    String a(int a){
        if(a >= 20 || a < 5){
            return "ᜋᜉᜌᜉᜅ᜔ ᜉᜄ᜔ᜆᜓᜎᜓᜄ᜔";
        }else if(a >= 5 && a < 10){
            return "ᜋᜄᜈ᜔ᜇᜅ᜔ ᜂᜋᜄ";
        }else if(a >= 10 && a < 13){
            return "ᜃᜁᜈ᜔ ᜆᜌᜓ";
        }else if(a >= 13 && a < 18){
            return "ᜋᜄᜈ᜔ᜇᜅ᜔ ᜑᜉᜓᜈ᜔";
        }else if(a >= 18 && a < 20){
            return "ᜋᜄᜈ᜔ᜇᜅ᜔ ᜄᜊᜒ";
        }else{
            return "";
        }
    }
}
