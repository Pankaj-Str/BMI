package in.p4n.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ftTxt,inTxt,kgTxt;
    ImageView arrow;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ftTxt=(EditText)findViewById(R.id.editText1);
        inTxt=(EditText)findViewById(R.id.EditText01);
        kgTxt=(EditText)findViewById(R.id.EditText02);
        arrow=(ImageView)findViewById(R.id.imageView1);
        btn=(Button)findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    int ft=Integer.parseInt(ftTxt.getText().toString());
                    int inc=Integer.parseInt(inTxt.getText().toString());
                    int kg=Integer.parseInt(kgTxt.getText().toString());
                    double weight=kg*2.204;
                    double height= (ft*12)+inc;
                    double BMI= (weight/(height*height) *703);

                    if(BMI>20 && BMI<30)
                    {
                        Toast.makeText(getApplicationContext(), "Great You are Healthy and Your BMI is: "+BMI, 1).show();
                    }
                    int angle= (int)(BMI*3.6);
                    RotateAnimation myRotate = new RotateAnimation(0, angle,
                            RotateAnimation.RELATIVE_TO_SELF, 0.9f,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    myRotate.setDuration(5000);
                    myRotate.setFillAfter(true);
                    arrow.startAnimation(myRotate);
                }



        });

    }
}
