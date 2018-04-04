package com.ptp.phamtanphat.random1903;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    Button btnRandom, btnAddArray;
    EditText edtSomin, edtSomax;
    ArrayList<Integer> mangkhoangcachminmax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Mang array => Khong cho phep chinh sua
//        String[] mangten = {"Nguyen Van A","Nguyen Van B","Nguyen Van C"};
        //Cach lay du lieu tu index
//        mangten[0]
//        Mang ArrayList
        //Cap phat bo nho cho mang
//        ArrayList<String> mangten = new ArrayList<>();
//        //Them phan tu
//        mangten.add("Nguyen Van A");
//        //Xoa
//        mangten.remove(0);
//        //Sua
//        mangten.set(0,"Nguyen Van B");

        btnRandom = findViewById(R.id.buttonRandom);
        edtSomin = findViewById(R.id.edittextSoMin);
        edtSomax = findViewById(R.id.edittextSoMax);
        btnAddArray = findViewById(R.id.buttonAddToArray);

        btnAddArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtSomin.getText().length() > 0 && edtSomax.getText().length() > 0) {
                    int Somin = Integer.parseInt(edtSomin.getText().toString());
                    int Somax = Integer.parseInt(edtSomax.getText().toString());

                    if (Somin >= Somax) {
                        Somax = Somin + 1;
                        edtSomax.setText(Somax + "");
                        edtSomin.setText(Somin + "");
                    }
                    mangkhoangcachminmax = new ArrayList<>();
                    for (int i = Somin; i <= Somax; i++) {
                        mangkhoangcachminmax.add(i);
                    }
                    Log.d("BBB",mangkhoangcachminmax.size() + "");
                } else {
                    Toast.makeText(MainActivity.this, "Nhap du gia tri cho max va min", Toast.LENGTH_SHORT).show();
                }
            }
        });


//        1 - Khong cho so min lon hon so max
//        2 - Kiem tra 2 o edittext deu co gia tri
//        3 - So min va so max khong duoc bang nhau
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtSomin.getText().length() > 0 && edtSomax.getText().length() > 0) {
                    int Somin = Integer.parseInt(edtSomin.getText().toString());
                    int Somax = Integer.parseInt(edtSomax.getText().toString());

                    if (Somin >= Somax) {
                        Somax = Somin + 1;
                        edtSomax.setText(Somax + "");
                        edtSomin.setText(Somin + "");
                    }
                    Random random = new Random();

                    if (mangkhoangcachminmax.size() > 0){
                        int index = random.nextInt(mangkhoangcachminmax.size());
                        String ketqua = String.valueOf(mangkhoangcachminmax.get(index));
                        Log.d("BBB",ketqua + "");

                        mangkhoangcachminmax.remove(index);
                    }else {
                        Toast.makeText(MainActivity.this, "Het gia tri de random", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Nhap du gia tri cho max va min", Toast.LENGTH_SHORT).show();
                }


//                Random random = new Random();
////                xuat phat : 0 => 5
//
//                for (int i = 0 ; i<=10 ; i++){
//                    Random trong khoan (max - min + 1 ) + min
//                    int a = random.nextInt(10 - 5 + 1) + 5;
//                    Log.d("BBB","Gia tri " + a);
//                }

            }
        });
    }

    //Cach viet 1 phuong thuc
    //trong cap ngoac tron se la gia tri yeu cau nguoi dung phai truyen de thuc thi hanh dong nay
//    AccessModifier  : public ,private , protected
//    Kieu du lieu tra ve : void , String , Integer ....

}
