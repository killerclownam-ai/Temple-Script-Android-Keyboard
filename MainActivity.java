package com.templescript.keyboard;
import android.app.Activity; import android.os.Bundle; import android.content.Intent; import android.provider.Settings; import android.view.View; import android.widget.*;
public class MainActivity extends Activity {
 public void onCreate(Bundle b){super.onCreate(b); LinearLayout l=new LinearLayout(this); l.setOrientation(LinearLayout.VERTICAL); l.setPadding(32,48,32,32);
 TextView t=new TextView(this); t.setText("TEMPLE SCRIPT\nAndroid Keyboard"); t.setTextSize(28); l.addView(t);
 TextView i=new TextView(this); i.setText("\n1. Tap ENABLE KEYBOARD.\n2. Turn on Temple Script Keyboard.\n3. Choose it as your current keyboard.\n\nThe keyboard uses a familiar QWERTY layout with the Temple Script glyph system."); l.addView(i);
 Button e=new Button(this); e.setText("ENABLE KEYBOARD"); e.setOnClickListener(v->startActivity(new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS))); l.addView(e); setContentView(l);}
}
