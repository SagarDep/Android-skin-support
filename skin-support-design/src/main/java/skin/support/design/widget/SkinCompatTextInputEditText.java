package skin.support.design.widget;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.design.widget.TextInputEditText;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;

import skin.support.widget.SkinCompatBackgroundHelper;
import skin.support.widget.SkinCompatSupportable;
import skin.support.widget.SkinCompatTextHelper;

import static skin.support.widget.SkinCompatHelper.INVALID_ID;

/**
 * Created by ximsfei on 2017/1/10.
 */

public class SkinCompatTextInputEditText extends TextInputEditText implements SkinCompatSupportable {
    private SkinCompatTextHelper mTextHelper;
    private SkinCompatBackgroundHelper mBackgroundTintHelper;

    public SkinCompatTextInputEditText(Context context) {
        this(context, null);
    }

    public SkinCompatTextInputEditText(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.editTextStyle);
    }

    public SkinCompatTextInputEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mBackgroundTintHelper = new SkinCompatBackgroundHelper(this);
        mBackgroundTintHelper.loadFromAttributes(attrs, defStyleAttr);
        mTextHelper = new SkinCompatTextHelper(this);
        mTextHelper.loadFromAttributes(attrs, defStyleAttr);
    }

    @Override
    public void setBackgroundResource(@DrawableRes int resId) {
        super.setBackgroundResource(resId);
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.onSetBackgroundResource(resId);
        }
    }

    @Override
    public void setTextAppearance(Context context, int resId) {
        super.setTextAppearance(context, resId);
        if (mTextHelper != null) {
            mTextHelper.onSetTextAppearance(context, resId);
        }
    }

    public int getTextColorResId() {
        return mTextHelper != null ? mTextHelper.getTextColorResId() : INVALID_ID;
    }

    @Override
    public void applySkin() {
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.applySkin();
        }
        if (mTextHelper != null) {
            mTextHelper.applySkin();
        }
    }

}
