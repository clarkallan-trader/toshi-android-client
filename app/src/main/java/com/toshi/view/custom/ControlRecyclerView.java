/*
 * 	Copyright (c) 2017. Toshi Inc
 *
 * 	This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.toshi.view.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class ControlRecyclerView extends RecyclerView {

    public interface OnSizeChangedListener {
        void onSizeChanged(final int height);
    }

    private OnSizeChangedListener listener;

    public ControlRecyclerView(Context context) {
        super(context);
    }

    public ControlRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ControlRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setOnSizedChangedListener(final OnSizeChangedListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        if (listener == null || getHeight() == 0) {
            return;
        }

        listener.onSizeChanged(getHeight());
    }
}
