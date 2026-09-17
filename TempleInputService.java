package com.templescript.keyboard;
import android.inputmethodservice.InputMethodService; import android.view.*; import android.graphics.Color; import android.widget.*;
public class TempleInputService extends InputMethodService {
 LinearLayout keys; String[] rows={"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
 public View onCreateInputView(){ keys=new LinearLayout(this); keys.setOrientation(LinearLayout.VERTICAL); keys.setPadding(4,4,4,4); keys.setBackgroundColor(Color.rgb(18,18,18));
 for(String row:rows){LinearLayout r=new LinearLayout(this); r.setGravity(Gravity.CENTER); for(char c:row.toCharArray()) addKey(r,c); keys.addView(r,new LinearLayout.LayoutParams(-1,0,1));}
 LinearLayout r=new LinearLayout(this); addSpecial(r,"?123",v->showNumbers()); addSpecial(r,"SPACE",v->getCurrentInputConnection().commitText(" ",1)); addSpecial(r,"⌫",v->getCurrentInputConnection().deleteSurroundingText(1,0)); addSpecial(r,"↵",v->getCurrentInputConnection().sendKeyEvent(new android.view.KeyEvent(android.view.KeyEvent.ACTION_DOWN,66))); keys.addView(r,new LinearLayout.LayoutParams(-1,0,1)); return keys; }
 void addKey(LinearLayout r,char c){Button b=new Button(this); b.setText(glyph(c)+"\n"+c); b.setTextSize(14); b.setTextColor(Color.rgb(230,190,95)); b.setAllCaps(false); b.setOnClickListener(v->getCurrentInputConnection().commitText(String.valueOf(c),1)); r.addView(b,new LinearLayout.LayoutParams(0,-1,1));}
 void addSpecial(LinearLayout r,String s,View.OnClickListener l){Button b=new Button(this); b.setText(s); b.setOnClickListener(l); r.addView(b,new LinearLayout.LayoutParams(0,-1,1));}
 String glyph(char c){ return "ᚫ"; } // safe placeholder; replace with custom Temple font artwork
 void showNumbers(){Toast.makeText(this,"Numbers/symbols layer ready for expansion.",Toast.LENGTH_SHORT).show();}
}
