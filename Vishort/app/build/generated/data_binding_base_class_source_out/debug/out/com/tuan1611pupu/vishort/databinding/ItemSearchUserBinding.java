// Generated by view binder compiler. Do not edit!
package com.tuan1611pupu.vishort.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tuan1611pupu.vishort.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemSearchUserBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final TextView email;

  @NonNull
  public final ImageView thumbnail;

  @NonNull
  public final LinearLayout userLay;

  @NonNull
  public final TextView username;

  private ItemSearchUserBinding(@NonNull FrameLayout rootView, @NonNull TextView email,
      @NonNull ImageView thumbnail, @NonNull LinearLayout userLay, @NonNull TextView username) {
    this.rootView = rootView;
    this.email = email;
    this.thumbnail = thumbnail;
    this.userLay = userLay;
    this.username = username;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemSearchUserBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemSearchUserBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_search_user, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemSearchUserBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.email;
      TextView email = ViewBindings.findChildViewById(rootView, id);
      if (email == null) {
        break missingId;
      }

      id = R.id.thumbnail;
      ImageView thumbnail = ViewBindings.findChildViewById(rootView, id);
      if (thumbnail == null) {
        break missingId;
      }

      id = R.id.userLay;
      LinearLayout userLay = ViewBindings.findChildViewById(rootView, id);
      if (userLay == null) {
        break missingId;
      }

      id = R.id.username;
      TextView username = ViewBindings.findChildViewById(rootView, id);
      if (username == null) {
        break missingId;
      }

      return new ItemSearchUserBinding((FrameLayout) rootView, email, thumbnail, userLay, username);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
