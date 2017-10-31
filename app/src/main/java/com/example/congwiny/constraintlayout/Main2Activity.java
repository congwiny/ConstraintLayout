package com.example.congwiny.constraintlayout;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    private ConstraintSet constraintSet1;
    private ConstraintSet constraintSet2;
    private ConstraintLayout constraintLayout;
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_constraint_anim1);

        constraintSet1 = new ConstraintSet();
        constraintSet2 = new ConstraintSet();
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraint_anim_root);
        //使用ConstraintSet拷贝ConstraintLayout中的约束关系
        constraintSet1.clone(constraintLayout);
        //从布局中加载约束关系，两个布局文件中的id是一致的
        constraintSet2.load(this, R.layout.layout_constraint_anim2);
    }

    public void change(View view) {
        TransitionManager.beginDelayedTransition(constraintLayout);
        flag = !flag;
        if (flag) {
            constraintSet1.applyTo(constraintLayout);
        } else {
            constraintSet2.applyTo(constraintLayout);
        }
    }
}
