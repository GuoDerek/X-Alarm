package io.github.loopX.XAlarm.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import io.github.loopX.XAlarm.R;
import io.github.loopX.XAlarm.module.UnlockTypeModule.UnlockTypeEnum;

/**
 * Author UFreedom
 * Date : 2016 六月 10
 */
public class UnlockTypeMenuLayout extends LinearLayout implements View.OnClickListener {

    private View typeLayout;
    private View mathLayout;
    private View paintLayout;
    private View shakeLayout;

    private ImageView ivUnlockType0;
    private ImageView ivUnlockType1;
    private ImageView ivUnlockType2;
    private ImageView ivUnlockType3;
    private int unlockType;
    
    public UnlockTypeMenuLayout(Context context) {
        this(context, null);
    }

    public UnlockTypeMenuLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public UnlockTypeMenuLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.menu_left, this, true);

        typeLayout = findViewById(R.id.normalLayout);
        mathLayout = findViewById(R.id.mathLayout);
        paintLayout = findViewById(R.id.paintLayout);
        shakeLayout = findViewById(R.id.shakeLayout);

        ivUnlockType0 = (ImageView) findViewById(R.id.iv_unlock_type_0);
        ivUnlockType1 = (ImageView) findViewById(R.id.iv_unlock_type_1);
        ivUnlockType2 = (ImageView) findViewById(R.id.iv_unlock_type_2);
        ivUnlockType3 = (ImageView) findViewById(R.id.iv_unlock_type_3);

        typeLayout.setOnClickListener(this);
        mathLayout.setOnClickListener(this);
        paintLayout.setOnClickListener(this);
        shakeLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
         
        UnlockTypeEnum unlockTypeEnum = UnlockTypeEnum.Type;
        
        switch (v.getId()){
            case R.id.normalLayout:
                unlockTypeEnum = UnlockTypeEnum.Type;
                break;
            case R.id.mathLayout:
                unlockTypeEnum = UnlockTypeEnum.Math;
                break;
            case R.id.paintLayout:
                unlockTypeEnum = UnlockTypeEnum.Puzzle;
                break;
            case R.id.shakeLayout:
                unlockTypeEnum = UnlockTypeEnum.Shake;
                break;
        }
        
        if (onUnlockTypeMenuClickListener != null){
            onUnlockTypeMenuClickListener.onClick(unlockTypeEnum,unlockType);
        }
        
    }

    public void setOnUnlockTypeMenuClickListener(OnUnlockTypeMenuClickListener onUnlockTypeMenuClickListener) {
        this.onUnlockTypeMenuClickListener = onUnlockTypeMenuClickListener;
    }

    private  OnUnlockTypeMenuClickListener onUnlockTypeMenuClickListener;
    
    public interface OnUnlockTypeMenuClickListener{
        public void  onClick(UnlockTypeEnum unlockTypeEnum,int currentUnlockType);
    }

    public void setChosenStatue(int i) {
        unlockType = i;
        switch (i) {
            case 0:
                ivUnlockType0.setVisibility(View.VISIBLE);
                break;
            case 1:
                ivUnlockType1.setVisibility(View.VISIBLE);
                break;
            case 2:
                ivUnlockType2.setVisibility(View.VISIBLE);
                break;
            case 3:
                ivUnlockType3.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void resetChosenStatus() {
        ivUnlockType0.setVisibility(View.GONE);
        ivUnlockType1.setVisibility(View.GONE);
        ivUnlockType2.setVisibility(View.GONE);
        ivUnlockType3.setVisibility(View.GONE);
    }
}
