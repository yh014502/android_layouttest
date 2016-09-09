package iii.org.tw.layouttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private View guess;
    private EditText input;
    private TextView info;
    private String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answer=creatAnswer(3);

        input=(EditText)findViewById(R.id.input);
        info=(TextView)findViewById(R.id.infoText);
        guess=findViewById(R.id.guess);
        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doguess();
            }
        });
    }
    private void doguess(){
        String strInput=input.getText().toString();
        String result=checkAB(answer,strInput);
        info.append(strInput+":"+result+"\n");
        input.setText("");

    }
    static String creatAnswer(int n) {
        int[] poker = new int[n];
        for (int i = 0; i < poker.length; i++) {
            int temp;

            // 檢查機制(是否重複)
            boolean isRepeat;
            do {
                temp = (int) (Math.random() * 10);
                isRepeat = false;
                for (int j = 0; j < i; j++) {
                    if (temp == poker[j]) {
                        isRepeat = true;
                        break;
                    }
                }
            } while (isRepeat);
            poker[i] = temp;
        }
        String ret = "";
        for (int v : poker) {
            ret += v;
        }
        return ret;
    }

    static String checkAB(String a, String g) {
        int A, B;
        A = B = 0;
        for (int i = 0; i < g.length(); i++) {
            if (g.charAt(i) == a.charAt(i)) {
                A++;
            } else if (a.indexOf(g.charAt(i)) != -1) {
                B++;
            }
        }
        return A + "A" + B + "B";
    }
}
