// Generated by view binder compiler. Do not edit!
package com.aram.mehrabyan.authimpl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.aram.mehrabyan.authimpl.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentRegisterBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final NumberPicker ageNumberPicker;

  @NonNull
  public final AppCompatButton btnRegister;

  @NonNull
  public final TextInputLayout emailInputLayout;

  @NonNull
  public final TextInputEditText etEmailInput;

  @NonNull
  public final TextInputEditText etPasswordInput;

  @NonNull
  public final TextInputLayout passwordInputLayout;

  private FragmentRegisterBinding(@NonNull ConstraintLayout rootView,
      @NonNull NumberPicker ageNumberPicker, @NonNull AppCompatButton btnRegister,
      @NonNull TextInputLayout emailInputLayout, @NonNull TextInputEditText etEmailInput,
      @NonNull TextInputEditText etPasswordInput, @NonNull TextInputLayout passwordInputLayout) {
    this.rootView = rootView;
    this.ageNumberPicker = ageNumberPicker;
    this.btnRegister = btnRegister;
    this.emailInputLayout = emailInputLayout;
    this.etEmailInput = etEmailInput;
    this.etPasswordInput = etPasswordInput;
    this.passwordInputLayout = passwordInputLayout;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_register, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentRegisterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.age_number_picker;
      NumberPicker ageNumberPicker = ViewBindings.findChildViewById(rootView, id);
      if (ageNumberPicker == null) {
        break missingId;
      }

      id = R.id.btn_register;
      AppCompatButton btnRegister = ViewBindings.findChildViewById(rootView, id);
      if (btnRegister == null) {
        break missingId;
      }

      id = R.id.email_input_layout;
      TextInputLayout emailInputLayout = ViewBindings.findChildViewById(rootView, id);
      if (emailInputLayout == null) {
        break missingId;
      }

      id = R.id.et_email_input;
      TextInputEditText etEmailInput = ViewBindings.findChildViewById(rootView, id);
      if (etEmailInput == null) {
        break missingId;
      }

      id = R.id.et_password_input;
      TextInputEditText etPasswordInput = ViewBindings.findChildViewById(rootView, id);
      if (etPasswordInput == null) {
        break missingId;
      }

      id = R.id.password_input_layout;
      TextInputLayout passwordInputLayout = ViewBindings.findChildViewById(rootView, id);
      if (passwordInputLayout == null) {
        break missingId;
      }

      return new FragmentRegisterBinding((ConstraintLayout) rootView, ageNumberPicker, btnRegister,
          emailInputLayout, etEmailInput, etPasswordInput, passwordInputLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
