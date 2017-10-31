package com.example.congwiny.constraintlayout;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ConstraintSet constraintSet1;
    private ConstraintSet constraintSet2;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_set);

        constraintSet1 = new ConstraintSet();
        constraintSet2 = new ConstraintSet();
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraint_root);
        //使用ConstraintSet拷贝ConstraintLayout中的约束关系
        constraintSet1.clone(constraintLayout);
        constraintSet2.clone(constraintLayout);
    }

    /**
     * 重置ConstraintLayout
     */
    public void reset(View view) {
        //使用Transition动画，改变布局
        TransitionManager.beginDelayedTransition(constraintLayout);
        constraintSet1.applyTo(constraintLayout);
    }

    public void change(View view) {
        //clear 清除所有的约束关系，包括margin,padding,width,height都设置为0
        //constraintSet2.clear(...);

        TransitionManager.beginDelayedTransition(constraintLayout);
        //清单文件中 supportsRtl,这里设置为start
        constraintSet2.setMargin(R.id.button1, ConstraintSet.START, 30);
        constraintSet2.applyTo(constraintLayout);

    }
}
