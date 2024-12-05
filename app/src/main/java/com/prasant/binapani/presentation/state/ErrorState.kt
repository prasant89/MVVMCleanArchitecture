package com.prasant.binapani.presentation.state

import androidx.annotation.StringRes
import com.prasant.binapani.R

/**
 * Error state holding values for error ui
 */
data class ErrorState(
    val hasError: Boolean = false,
    @StringRes val errorMessageStringResource: Int = R.string.empty_string
)