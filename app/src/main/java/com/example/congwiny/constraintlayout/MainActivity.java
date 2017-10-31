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
        TransitionManager.beginDelayedTransition(constraintLayout);
        //清单文件中 supportsRtl,这里设置为start
//        constraintSet2.setMargin(R.id.button1, ConstraintSet.START, 30);

        //设置button1在constraint_root中居中
//        constraintSet2.setMargin(R.id.button1, ConstraintSet.START, 0);
//        constraintSet2.centerHorizontally(R.id.button1,R.id.constraint_root);

        //connect建立或修改两个View之间约束关系
//        constraintSet2.connect(R.id.button1, ConstraintSet.START, R.id.constraint_root, ConstraintSet.START, 50);

        //建立链条约束关系
        //clear 清除所有的约束关系，包括margin,padding,width,height都设置为0
        constraintSet2.clear(R.id.button1);
        constraintSet2.clear(R.id.button2);
        constraintSet2.clear(R.id.button3);

        constraintSet2.connect(R.id.button1, ConstraintSet.START, R.id.constraint_root, ConstraintSet.START, 0);
        constraintSet2.connect(R.id.button3, ConstraintSet.END, R.id.constraint_root, ConstraintSet.END, 0);

        constraintSet2.connect(R.id.button2, ConstraintSet.START, R.id.button1, ConstraintSet.END, 0);
        constraintSet2.connect(R.id.button2, ConstraintSet.END, R.id.button3, ConstraintSet.START, 0);

        constraintSet2.connect(R.id.button1, ConstraintSet.END, R.id.button2, ConstraintSet.START, 0);
        constraintSet2.connect(R.id.button3, ConstraintSet.START, R.id.button2, ConstraintSet.END, 0);

        constraintSet2.createHorizontalChain(
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                new int[]{R.id.button1,R.id.button2,R.id.button3},
                null,
                ConstraintSet.CHAIN_SPREAD
        );

        //重新设置Button的长和宽
        constraintSet2.constrainWidth(R.id.button1,ConstraintSet.WRAP_CONTENT);
        constraintSet2.constrainWidth(R.id.button2,ConstraintSet.WRAP_CONTENT);
        constraintSet2.constrainWidth(R.id.button3,ConstraintSet.WRAP_CONTENT);

        constraintSet2.constrainHeight(R.id.button1,ConstraintSet.WRAP_CONTENT);
        constraintSet2.constrainHeight(R.id.button2,ConstraintSet.WRAP_CONTENT);
        constraintSet2.constrainHeight(R.id.button3,ConstraintSet.WRAP_CONTENT);

        constraintSet2.applyTo(constraintLayout);
    }
}
