package com.prasant.binapani.presentation.view.screens.unauthenticated.login.state

import com.prasant.binapani.R
import com.prasant.binapani.presentation.state.ErrorState

val emailOrMobileEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.login_error_msg_empty_email_mobile
)

val passwordEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.login_error_msg_empty_password
)