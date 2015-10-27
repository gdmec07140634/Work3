package com.example.administrator.work3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button calculator;
    private EditText weight;
    private CheckBox manCheckbox;
    private CheckBox womenCheckbox;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculator= (Button) findViewById(R.id.button);
        weight= (EditText) findViewById(R.id.tz);
        manCheckbox= (CheckBox) findViewById(R.id.man);
        womenCheckbox= (CheckBox) findViewById(R.id.women);
        result= (TextView) findViewById(R.id.result);
    }

   public  void  yunsuan(View v){
       if (!weight.getText().toString().trim().equals("")){
           if (manCheckbox.isChecked()||womenCheckbox.isChecked()){
               Double wei=Double.parseDouble(weight.getText().toString());
               StringBuffer sb=new StringBuffer();
               sb.append(" 结果为： \n");
               if (manCheckbox.isChecked()){
                   sb.append("男性的标准身高：");
                   double result1=170-(62-wei)/0.6;
                   sb.append((int)result1+"(厘米)");
               }
               if (womenCheckbox.isChecked()){
                   sb.append("女性的标准身高：");
                   double result1=158-(52-wei)/0.5;
                   sb.append((int)result1+"(厘米)");
               }
               result.setText(sb.toString());
           }else {
               showMessage("请选择性别！");
           }
       }else{
           showMessage("请输入体重！");
       }
   }

    private void showMessage(String message) {
        AlertDialog alert=new AlertDialog.Builder(this).create();
        alert.setTitle("系统信息");
        alert.setMessage(message);
        alert.setButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alert.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(Menu.NONE,1,Menu.NONE,"退出");
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case 1:
                finish();
                break;
        }
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
