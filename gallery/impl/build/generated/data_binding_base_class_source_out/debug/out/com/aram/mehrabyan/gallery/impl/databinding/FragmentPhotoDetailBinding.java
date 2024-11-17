// Generated by view binder compiler. Do not edit!
package com.aram.mehrabyan.gallery.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.aram.mehrabyan.gallery.impl.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentPhotoDetailBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ProgressBar centerProgress;

  @NonNull
  public final AppCompatImageView imgDetail;

  @NonNull
  public final View sectionLine;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final AppCompatTextView tvErrorInfo;

  @NonNull
  public final AppCompatTextView tvImageCommentsInfo;

  @NonNull
  public final AppCompatTextView tvImageCommentsTitle;

  @NonNull
  public final AppCompatTextView tvImageDownloadsInfo;

  @NonNull
  public final AppCompatTextView tvImageDownloadsTitle;

  @NonNull
  public final AppCompatTextView tvImageFavoritesInfo;

  @NonNull
  public final AppCompatTextView tvImageFavoritesTitle;

  @NonNull
  public final AppCompatTextView tvImageLikesInfo;

  @NonNull
  public final AppCompatTextView tvImageLikesTitle;

  @NonNull
  public final AppCompatTextView tvImageSizeInfo;

  @NonNull
  public final AppCompatTextView tvImageSizeTitle;

  @NonNull
  public final AppCompatTextView tvImageTagsInfo;

  @NonNull
  public final AppCompatTextView tvImageTagsTitle;

  @NonNull
  public final AppCompatTextView tvImageTypeInfo;

  @NonNull
  public final AppCompatTextView tvImageTypeTitle;

  @NonNull
  public final AppCompatTextView tvImageUserNameInfo;

  @NonNull
  public final AppCompatTextView tvImageUserNameTitle;

  @NonNull
  public final AppCompatTextView tvImageViewsInfo;

  @NonNull
  public final AppCompatTextView tvImageViewsTitle;

  private FragmentPhotoDetailBinding(@NonNull ConstraintLayout rootView,
      @NonNull ProgressBar centerProgress, @NonNull AppCompatImageView imgDetail,
      @NonNull View sectionLine, @NonNull Toolbar toolbar, @NonNull AppCompatTextView tvErrorInfo,
      @NonNull AppCompatTextView tvImageCommentsInfo,
      @NonNull AppCompatTextView tvImageCommentsTitle,
      @NonNull AppCompatTextView tvImageDownloadsInfo,
      @NonNull AppCompatTextView tvImageDownloadsTitle,
      @NonNull AppCompatTextView tvImageFavoritesInfo,
      @NonNull AppCompatTextView tvImageFavoritesTitle, @NonNull AppCompatTextView tvImageLikesInfo,
      @NonNull AppCompatTextView tvImageLikesTitle, @NonNull AppCompatTextView tvImageSizeInfo,
      @NonNull AppCompatTextView tvImageSizeTitle, @NonNull AppCompatTextView tvImageTagsInfo,
      @NonNull AppCompatTextView tvImageTagsTitle, @NonNull AppCompatTextView tvImageTypeInfo,
      @NonNull AppCompatTextView tvImageTypeTitle, @NonNull AppCompatTextView tvImageUserNameInfo,
      @NonNull AppCompatTextView tvImageUserNameTitle, @NonNull AppCompatTextView tvImageViewsInfo,
      @NonNull AppCompatTextView tvImageViewsTitle) {
    this.rootView = rootView;
    this.centerProgress = centerProgress;
    this.imgDetail = imgDetail;
    this.sectionLine = sectionLine;
    this.toolbar = toolbar;
    this.tvErrorInfo = tvErrorInfo;
    this.tvImageCommentsInfo = tvImageCommentsInfo;
    this.tvImageCommentsTitle = tvImageCommentsTitle;
    this.tvImageDownloadsInfo = tvImageDownloadsInfo;
    this.tvImageDownloadsTitle = tvImageDownloadsTitle;
    this.tvImageFavoritesInfo = tvImageFavoritesInfo;
    this.tvImageFavoritesTitle = tvImageFavoritesTitle;
    this.tvImageLikesInfo = tvImageLikesInfo;
    this.tvImageLikesTitle = tvImageLikesTitle;
    this.tvImageSizeInfo = tvImageSizeInfo;
    this.tvImageSizeTitle = tvImageSizeTitle;
    this.tvImageTagsInfo = tvImageTagsInfo;
    this.tvImageTagsTitle = tvImageTagsTitle;
    this.tvImageTypeInfo = tvImageTypeInfo;
    this.tvImageTypeTitle = tvImageTypeTitle;
    this.tvImageUserNameInfo = tvImageUserNameInfo;
    this.tvImageUserNameTitle = tvImageUserNameTitle;
    this.tvImageViewsInfo = tvImageViewsInfo;
    this.tvImageViewsTitle = tvImageViewsTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentPhotoDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentPhotoDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_photo_detail, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentPhotoDetailBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.center_progress;
      ProgressBar centerProgress = ViewBindings.findChildViewById(rootView, id);
      if (centerProgress == null) {
        break missingId;
      }

      id = R.id.img_detail;
      AppCompatImageView imgDetail = ViewBindings.findChildViewById(rootView, id);
      if (imgDetail == null) {
        break missingId;
      }

      id = R.id.section_line;
      View sectionLine = ViewBindings.findChildViewById(rootView, id);
      if (sectionLine == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.tv_error_info;
      AppCompatTextView tvErrorInfo = ViewBindings.findChildViewById(rootView, id);
      if (tvErrorInfo == null) {
        break missingId;
      }

      id = R.id.tv_image_comments_info;
      AppCompatTextView tvImageCommentsInfo = ViewBindings.findChildViewById(rootView, id);
      if (tvImageCommentsInfo == null) {
        break missingId;
      }

      id = R.id.tv_image_comments_title;
      AppCompatTextView tvImageCommentsTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvImageCommentsTitle == null) {
        break missingId;
      }

      id = R.id.tv_image_downloads_info;
      AppCompatTextView tvImageDownloadsInfo = ViewBindings.findChildViewById(rootView, id);
      if (tvImageDownloadsInfo == null) {
        break missingId;
      }

      id = R.id.tv_image_downloads_title;
      AppCompatTextView tvImageDownloadsTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvImageDownloadsTitle == null) {
        break missingId;
      }

      id = R.id.tv_image_favorites_info;
      AppCompatTextView tvImageFavoritesInfo = ViewBindings.findChildViewById(rootView, id);
      if (tvImageFavoritesInfo == null) {
        break missingId;
      }

      id = R.id.tv_image_favorites_title;
      AppCompatTextView tvImageFavoritesTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvImageFavoritesTitle == null) {
        break missingId;
      }

      id = R.id.tv_image_likes_info;
      AppCompatTextView tvImageLikesInfo = ViewBindings.findChildViewById(rootView, id);
      if (tvImageLikesInfo == null) {
        break missingId;
      }

      id = R.id.tv_image_likes_title;
      AppCompatTextView tvImageLikesTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvImageLikesTitle == null) {
        break missingId;
      }

      id = R.id.tv_image_size_info;
      AppCompatTextView tvImageSizeInfo = ViewBindings.findChildViewById(rootView, id);
      if (tvImageSizeInfo == null) {
        break missingId;
      }

      id = R.id.tv_image_size_title;
      AppCompatTextView tvImageSizeTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvImageSizeTitle == null) {
        break missingId;
      }

      id = R.id.tv_image_tags_info;
      AppCompatTextView tvImageTagsInfo = ViewBindings.findChildViewById(rootView, id);
      if (tvImageTagsInfo == null) {
        break missingId;
      }

      id = R.id.tv_image_tags_title;
      AppCompatTextView tvImageTagsTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvImageTagsTitle == null) {
        break missingId;
      }

      id = R.id.tv_image_type_info;
      AppCompatTextView tvImageTypeInfo = ViewBindings.findChildViewById(rootView, id);
      if (tvImageTypeInfo == null) {
        break missingId;
      }

      id = R.id.tv_image_type_title;
      AppCompatTextView tvImageTypeTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvImageTypeTitle == null) {
        break missingId;
      }

      id = R.id.tv_image_user_name_info;
      AppCompatTextView tvImageUserNameInfo = ViewBindings.findChildViewById(rootView, id);
      if (tvImageUserNameInfo == null) {
        break missingId;
      }

      id = R.id.tv_image_user_name_title;
      AppCompatTextView tvImageUserNameTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvImageUserNameTitle == null) {
        break missingId;
      }

      id = R.id.tv_image_views_info;
      AppCompatTextView tvImageViewsInfo = ViewBindings.findChildViewById(rootView, id);
      if (tvImageViewsInfo == null) {
        break missingId;
      }

      id = R.id.tv_image_views_title;
      AppCompatTextView tvImageViewsTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvImageViewsTitle == null) {
        break missingId;
      }

      return new FragmentPhotoDetailBinding((ConstraintLayout) rootView, centerProgress, imgDetail,
          sectionLine, toolbar, tvErrorInfo, tvImageCommentsInfo, tvImageCommentsTitle,
          tvImageDownloadsInfo, tvImageDownloadsTitle, tvImageFavoritesInfo, tvImageFavoritesTitle,
          tvImageLikesInfo, tvImageLikesTitle, tvImageSizeInfo, tvImageSizeTitle, tvImageTagsInfo,
          tvImageTagsTitle, tvImageTypeInfo, tvImageTypeTitle, tvImageUserNameInfo,
          tvImageUserNameTitle, tvImageViewsInfo, tvImageViewsTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
