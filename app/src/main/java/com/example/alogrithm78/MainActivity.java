package com.example.alogrithm78;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private TextView mViewGf;
    int[] nums = {1, 3, 4, 7, 2, 1, 1, 5, 2};
    int Num1, Num2, count, Count2 = 0;
    static int num;
    private TextView mView702;
    OutputStream outputStream;
    private TextView mView801;
    private TextView mHouzi;
    private TextView mHuiwen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewd);
        initView();
    }

    private void initView() {
        mViewGf = (TextView) findViewById(R.id.view_gf);
        mView702 = (TextView) findViewById(R.id.view_702);
        mView801 = (TextView) findViewById(R.id.view_801);
        mHouzi = (TextView) findViewById(R.id.houzi);
        mHuiwen = (TextView) findViewById(R.id.huiwen);
        test701();
        test702(7);
        test703(7);
        int c = fun(10, 70);
        mView801.setText("c = " + c);
        int sum = houzieat(5);
        mHouzi.setText("一共有" + sum + "个桃子");
        huiwen(12321);

    }


    public void test701() {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            Num1 = nums[i];
            count = 0;
            for (int b = 0; b < nums.length; b++) {
                Num2 = nums[b];
                if (Num1 == Num2) {
                    count++;
                }
            }
            if (Count2 <= count) {
                Count2 = count;
                num = Num1;
            }
        }
        mViewGf.setText("Test701出现最多的数字是:" + num + "出现次数:" + Count2);
    }

    public void test702(int n) {
        int num702 = 0;
        for (int i = 1; i < n; i++) {
            if (i % 7 == 0 && i % 3 == 0) {
                num702 += i;
            }
        }
        double num702s = Math.sqrt(num702);
        String te = "" + num702s;
        File file = new File("c:\\新建文件夹\\WriteArr.txt");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(te.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void test703(int a) {
        double s = 0;
        //公比为a的等比数列
        double an = 0;
        for (int i = 0; i < a; i++) {
            an = Math.pow(a, i + 1);
            s += an;
        }
        mView702.setText("s=" + s);
    }

    public int fun(int a, int b) {
        int a_shi = a / 10, a_ge = a % 10, b_shi = b / 10, b_ge = b % 10, c = 0;
        if (b_ge == 0)
            c = b_shi * 100 + a_ge * 10 + a_shi;
        else
            c = b_ge * 1000 + b_shi * 100 + a_ge * 10 + a_shi;
        return c;
    }

    int houzieat(int N) {
        int sum = 1;
        //3
        for (int i = 0; i < N - 1; i++) {
            sum = (sum + 1) * 2;
        }
        return sum;
    }

    void huiwen(int number) {
        int a = number / 10000, b = (number / 1000) % 10, c = (number / 100) % 10, d = (number / 100) % 10, e = number % 10;
        int f = e * 10000 + d * 1000 + c * 100 + b * 10 + a;
        if (number == f) {
            mHuiwen.setText(number+"是回文数");
        }
        else {
            mHuiwen.setText(number+"不是回文数");
        }
    }
}
