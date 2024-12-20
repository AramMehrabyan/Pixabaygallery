// Generated by view binder compiler. Do not edit!
package com.aram.mehrabyan.gallery.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.aram.mehrabyan.gallery.impl.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentPhotosBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final FrameLayout bottomProgress;

  @NonNull
  public final ProgressBar centerProgress;

  @NonNull
  public final RecyclerView rvPhotos;

  @NonNull
  public final Toolbar toolbar;

  private FragmentPhotosBinding(@NonNull ConstraintLayout rootView,
      @NonNull FrameLayout bottomProgress, @NonNull ProgressBar centerProgress,
      @NonNull RecyclerView rvPhotos, @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.bottomProgress = bottomProgress;
    this.centerProgress = centerProgress;
    this.rvPhotos = rvPhotos;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentPhotosBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentPhotosBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_photos, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentPhotosBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bottom_progress;
      FrameLayout bottomProgress = ViewBindings.findChildViewById(rootView, id);
      if (bottomProgress == null) {
        break missingId;
      }

      id = R.id.center_progress;
      ProgressBar centerProgress = ViewBindings.findChildViewById(rootView, id);
      if (centerProgress == null) {
        break missingId;
      }

      id = R.id.rv_photos;
      RecyclerView rvPhotos = ViewBindings.findChildViewById(rootView, id);
      if (rvPhotos == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new FragmentPhotosBinding((ConstraintLayout) rootView, bottomProgress, centerProgress,
          rvPhotos, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
